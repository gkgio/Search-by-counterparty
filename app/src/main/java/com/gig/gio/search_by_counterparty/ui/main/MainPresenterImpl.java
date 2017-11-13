package com.gig.gio.search_by_counterparty.ui.main;

import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.realm.Realm;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView view;

    private Bus bus;
    private SharedPreferences preferences;
    private CompositeDisposable disposables;

    @Inject
    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void logout(SharedPreferences preferences, Realm realm) {
        //realm.executeTransaction(transaction -> transaction.deleteAll());
        preferences.edit()
                .remove(Config.CURRENT_FRAGMENT_TAG)
                .apply();
    }

    @Override
    public void onCreateView(Bus bus, SharedPreferences preferences) {
        this.bus = bus;
        this.preferences = preferences;
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
                        view.showMessage(R.string.toast_error, SnackBarType.ERROR);
                    } else if (event instanceof ThrowableEvent) {
                        view.showMessage(R.string.toast_error, SnackBarType.ERROR);
                    }
                });
    }

    @Override
    public void putCurrentPageTag(String tag){
        preferences.edit().putString(Config.CURRENT_FRAGMENT_TAG, tag).apply();
    }

    @Override
    public String getCurrentPageTag(){
        return preferences.getString(Config.CURRENT_FRAGMENT_TAG, null);
    }
}
