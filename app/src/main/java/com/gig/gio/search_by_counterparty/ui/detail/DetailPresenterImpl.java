package com.gig.gio.search_by_counterparty.ui.detail;

import android.location.Location;
import android.location.LocationManager;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

public class DetailPresenterImpl implements DetailPresenter {

    private DetailView view;

    private Bus bus;
    private Gson gson;

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
                    if (event instanceof HttpErrorEvent) {
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
}
