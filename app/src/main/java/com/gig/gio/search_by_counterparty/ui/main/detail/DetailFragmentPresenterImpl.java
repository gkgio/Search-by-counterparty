package com.gig.gio.search_by_counterparty.ui.main.detail;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;
import com.gig.gio.search_by_counterparty.network.NetworkService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by georgy on 04.11.2017.
 * Gig
 */

public class DetailFragmentPresenterImpl implements DetailFragmentPresenter {

    private DetailFragmentView view;

    private Bus bus;
    private NetworkService networkService;

    private CompositeDisposable disposables;


    @Inject
    public DetailFragmentPresenterImpl() {
    }

    @Override
    public void init(DetailFragmentView view) {
        this.view = view;
    }

    @Override
    public void onAttachView(Bus bus, NetworkService networkService) {
        this.bus = bus;
        this.networkService = networkService;
        disposables = new CompositeDisposable(
                subscribeToBus()
        );
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
}
