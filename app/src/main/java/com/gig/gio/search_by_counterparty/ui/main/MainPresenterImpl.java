package com.gig.gio.search_by_counterparty.ui.main;

import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.BuildConfig;
import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.main.ResponseDataEvent;
import com.gig.gio.search_by_counterparty.common.rx.RxUtil;
import com.gig.gio.search_by_counterparty.model.RequestData;
import com.gig.gio.search_by_counterparty.model.ResponseData;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.gig.gio.search_by_counterparty.network.NetworkService;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.realm.Realm;
import retrofit2.Response;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView view;

    private Bus bus;
    private CompositeDisposable disposables;

    @Inject
    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void logout(SharedPreferences preferences, Realm realm) {
        realm.executeTransaction(transaction -> transaction.deleteAll());
        preferences.edit()
                .remove(Config.IS_FIRST_START)
                .apply();
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
                    if (event instanceof HttpErrorEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    } else if (event instanceof ThrowableEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    }
                });
    }

    @Override
    public boolean isFirstStart(SharedPreferences preferences){
        return preferences.getBoolean(Config.IS_FIRST_START, true);
    }

    @Override
    public void setIsFirstStart(SharedPreferences preferences){
         preferences.edit().putBoolean(Config.IS_FIRST_START, false).apply();
    }
}
