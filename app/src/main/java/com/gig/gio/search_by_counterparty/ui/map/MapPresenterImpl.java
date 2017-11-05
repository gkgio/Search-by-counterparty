package com.gig.gio.search_by_counterparty.ui.map;


import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.map.MapSuggestResponseEvent;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.realm.Realm;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

public class MapPresenterImpl implements MapPresenter {

    private MapView view;

    private NetworkService networkService;
    private Bus bus;
    private CompositeDisposable disposables;

    @Inject
    public MapPresenterImpl(MapView view) {
        this.view = view;
    }

    @Override
    public void onCreateView(Bus bus, NetworkService networkService) {
        this.bus = bus;
        this.networkService = networkService;
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
                    if (event instanceof MapSuggestResponseEvent) {
                        final List<SuggestResponse> suggestResponseList =
                                ((MapSuggestResponseEvent) event).getSuggestResponseList();
                        createMarkerOptions(suggestResponseList);
                    } else if (event instanceof HttpErrorEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    } else if (event instanceof ThrowableEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    }
                });
    }

    @Override
    public void initMap(boolean isReadyMap) {
        if (isReadyMap) view.setMapZoom();
    }

    @Override
    public void getCounterPartyFromRealm(Bus bus, Realm realm) {
        view.showProgress();

        realm.where(SuggestResponse.class).findAll().asObservable()
                .first()
                .subscribe(suggestResponse -> {
                    List<SuggestResponse> suggestResponseList = realm.copyFromRealm(suggestResponse);

                    // если данные в базе есть, то отправляем их на обработку,
                    // иначе выводим сообщение об ошибке
                    bus.send((suggestResponseList.size() > 0) ?
                            new MapSuggestResponseEvent(suggestResponseList) : new ThrowableEvent(new Throwable()));
                }, dbThrowable -> {
                    bus.send(new ThrowableEvent(new Throwable()));
                    view.hideProgress();
                });
    }

    private void createMarkerOptions(final List<SuggestResponse> suggestResponseList) {
        List<MarkerOptions> markerOptionsList = new ArrayList<>();

        Observable.just(suggestResponseList)
                .flatMapIterable(list -> list)
                .map(suggestResponse -> {
                    final LatLng position = new LatLng(
                            suggestResponse.getData().getAddress().getAddressData().getGeo_lat(),
                            suggestResponse.getData().getAddress().getAddressData().getGeo_lon());
                    final String title = suggestResponse.getValue();
                    final String snippetId = suggestResponse.getId();
                    return new MarkerOptions().position(position).title(title).snippet(snippetId);
                })
                .toList()
                .subscribe((Consumer<List<MarkerOptions>>) markerOptionsList::addAll);

        view.hideProgress();

        view.setMarkers(markerOptionsList);
    }
}
