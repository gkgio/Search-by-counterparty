package com.gig.gio.search_by_counterparty.ui.detail;

import android.location.Location;
import android.location.LocationManager;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.detail.ShareDataEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.detail.SuggestDeleteBookmarkEvent;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.google.gson.Gson;

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

    @Inject
    public Gson gson;

    private DetailView view;

    private Bus bus;

    private CompositeDisposable disposables;

    @Inject
    public DetailPresenterImpl(DetailView view) {
        this.view = view;
    }

    @Override
    public void onCreateView(Bus bus) {
        this.bus = bus;
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
                    if (event instanceof ShareDataEvent) {
                        view.shareData();
                    } else if (event instanceof SuggestDeleteBookmarkEvent) {
                        view.showMessage(R.string.success_delete_from_bookmark, SnackBarType.INFO);
                    } else if (event instanceof HttpErrorEvent) {
                        view.showMessage(R.string.toast_error, SnackBarType.ERROR);
                    } else if (event instanceof ThrowableEvent) {
                        view.showMessage(R.string.toast_error, SnackBarType.ERROR);
                    }
                });
    }

    @Override
    public void provideLocationForMap(SuggestResponse suggestResponse) {
        Location location = new Location(LocationManager.GPS_PROVIDER);
        if (suggestResponse.getData().getAddress().getAddressData() != null) {
            location.setLatitude(suggestResponse.getData().getAddress().getAddressData().getGeo_lat());
            location.setLongitude(suggestResponse.getData().getAddress().getAddressData().getGeo_lon());

            final String jsonLocationString = gson.toJson(location, Location.class);
            final String jsonSuggestResponseString = gson.toJson(suggestResponse, SuggestResponse.class);

            view.startMapActivity(jsonSuggestResponseString, jsonLocationString);
        } else view.startMapActivity(null, null);
    }

    @Override
    synchronized public void saveChangedInRealm(SuggestResponse suggestResponse, Realm realm) {

        final SuggestResponse lastSuggestResponse = realm.where(SuggestResponse.class).
                equalTo("value", suggestResponse.getValue()).findFirst();

        if (lastSuggestResponse != null) {
            SuggestResponse newSuggestResponse = realm.copyFromRealm(lastSuggestResponse);
            newSuggestResponse.setBookmark(suggestResponse.isBookmark());
            realm.executeTransaction(transaction -> transaction.copyToRealmOrUpdate(newSuggestResponse));
        } else bus.send(new ThrowableEvent(new Throwable()));
    }

    @Override
    public void deleteFromLatest(SuggestResponse suggestResponse, Realm realm) {
        final SuggestResponse historySuggestResponse = realm.where(SuggestResponse.class).
                equalTo("id", suggestResponse.getId()).findFirst();

        if (historySuggestResponse != null)
            realm.executeTransaction(transaction ->
                    transaction.where(SuggestResponse.class).
                            equalTo("id", suggestResponse.getId()).findFirst().deleteFromRealm()
            );

        bus.send(new SuggestDeleteBookmarkEvent());
    }

    @Override
    public SuggestResponse getSuggestResponseFromRealm(long id) {

        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            SuggestResponse suggestResponse = realm.where(SuggestResponse.class).
                    equalTo("id", id).findFirst();
            if (suggestResponse == null) {
                realm.cancelTransaction();
                return null;
            }
            realm.commitTransaction();
            return realm.copyFromRealm(suggestResponse);
        } catch (Throwable e) {
            if (realm != null && realm.isInTransaction()) {
                realm.cancelTransaction();
            }
            throw e;
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public void prepareDateForSend(String nameManagement,
                                   String postManagement,
                                   String opfFull,
                                   String value,
                                   String kpp,
                                   String inn,
                                   String ogrn,
                                   String status,
                                   String address) {
        StringBuilder messageBodyBuilder = new StringBuilder();
        if (nameManagement != null)
            messageBodyBuilder.append(nameManagement).append("\n");
        if (postManagement != null)
            messageBodyBuilder.append(postManagement).append("\n");
        messageBodyBuilder.append(opfFull).append("\n");
        messageBodyBuilder.append(value).append("\n");
        messageBodyBuilder.append(kpp).append("\n");
        messageBodyBuilder.append(inn).append("\n");
        messageBodyBuilder.append(ogrn).append("\n");
        messageBodyBuilder.append(status).append("\n");
        if (address != null)
            messageBodyBuilder.append(address).append("\n");
        view.sendData(messageBodyBuilder.toString());
    }
}
