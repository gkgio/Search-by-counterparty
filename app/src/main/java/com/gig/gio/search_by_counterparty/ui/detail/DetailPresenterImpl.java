package com.gig.gio.search_by_counterparty.ui.detail;

import android.location.Location;
import android.location.LocationManager;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.detail.ListSuggestResponseEvent;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.realm.Realm;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

public class DetailPresenterImpl implements DetailPresenter {

    private DetailView view;

    private Bus bus;
    private Gson gson;
    private Realm realm;

    private CompositeDisposable disposables;

    @Inject
    public DetailPresenterImpl(DetailView view) {
        this.view = view;
    }

    @Override
    public void onCreateView(Bus bus, Gson gson) {
        this.bus = bus;
        this.gson = gson;
    }

    @Override
    public void onAttachView() {
        disposables = new CompositeDisposable(subscribeToBus());
    }

    @Override
    public void onDetachView() {
        disposables.clear();
    }

    private Disposable subscribeToBus() {
        return bus.toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(event -> {
                    view.hideProgress();
                    if (event instanceof ListSuggestResponseEvent) {
                        final List<SuggestResponse> suggestResponseList = ((ListSuggestResponseEvent) event).getSuggestResponseList();
                        final SuggestResponse suggestResponse = ((ListSuggestResponseEvent) event).getSuggestResponse();
                        changeSelectedValue(suggestResponseList, suggestResponse);
                    } else if (event instanceof HttpErrorEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    } else if (event instanceof ThrowableEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    }
                });
    }

    @Override
    public void provideLocationForMap(SuggestResponse suggestResponse) {
        Location location = new Location(LocationManager.GPS_PROVIDER);
        location.setLatitude(suggestResponse.getData().getAddress().getAddressData().getGeo_lat());
        location.setLongitude(suggestResponse.getData().getAddress().getAddressData().getGeo_lon());

        final String jsonLocationString = gson.toJson(location, Location.class);

        view.startMapActivity(jsonLocationString);
    }

    @Override
    synchronized public void saveChangedInRealm(SuggestResponse suggestResponse, Realm realm) {
        this.realm = realm;
        realm.where(SuggestResponse.class).findAll().asObservable()
                .first()
                .subscribe(suggestResponseResult -> {
                    List<SuggestResponse> suggestResponseList = realm.copyFromRealm(suggestResponseResult);
                    // если данные в базе есть, то открываем Seller активити, иначе выводим сообщение об ошибке
                    bus.send(suggestResponseList.size() > 0 ?
                            new ListSuggestResponseEvent(suggestResponseList, suggestResponse) : new ThrowableEvent(new Throwable()));
                }, dbThrowable -> bus.send(new ThrowableEvent(new Throwable())));
        realm.executeTransaction(transaction -> transaction.deleteAll());
    }

    private void changeSelectedValue(List<SuggestResponse> suggestResponseList, SuggestResponse suggestResponse){
        // кэшируем данные в realm, обновив одно значение
        realm.executeTransaction(transaction -> {
            for (SuggestResponse suggest : suggestResponseList){
                if(suggest.getValue().equals(suggestResponse.getValue())){
                    suggest.setBookmark(!suggest.isBookmark());
                }
                transaction.copyToRealmOrUpdate(suggest);
            }
        });
    }
}
