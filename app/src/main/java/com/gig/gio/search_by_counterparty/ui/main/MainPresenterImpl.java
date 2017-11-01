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

    private final static int COUNT_RESPONSE_OBJECT = 10;

    private NetworkService networkService;
    private Bus bus;
    private CompositeDisposable disposables;

    @Inject
    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void logout(SharedPreferences preferences, Realm realm) {
        realm.executeTransaction(transaction -> transaction.deleteAll());
       /* preferences.edit()
                .remove(Config.PREF_ACCOUNT_TYPE)
                .apply();*/
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
                    if (event instanceof ResponseDataEvent) {
                        final ResponseData responseData = ((ResponseDataEvent) event).getResponseData();
                        prepareSuggestsList(responseData);
                    } else if (event instanceof HttpErrorEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    } else if (event instanceof ThrowableEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    }
                });
    }


    @Override
    public void requestSuggestions(String query) {
        String queryFromUser = query.replaceAll("\\s+", " ").trim();

        if (!queryFromUser.isEmpty()) {
            view.showProgress();

            final RequestData requestData = new RequestData();
            requestData.setCount(COUNT_RESPONSE_OBJECT);
            requestData.setQuery(queryFromUser);

            Observable<Response<ResponseData>> responseObservable =
                    networkService.getSuggestion("Token ".concat(BuildConfig.API_KEY), requestData);
            responseObservable.compose(RxUtil.applySchedulersAndRetry())
                    .subscribe(response -> {
                        final int responseCode = response.code();
                        switch (responseCode) {
                            case HttpURLConnection.HTTP_OK:
                                bus.send(new ResponseDataEvent(response.body()));
                                break;
                            default:
                                bus.send(new HttpErrorEvent(responseCode));
                                break;
                        }
                    }, throwable -> {
                        throwable.printStackTrace();
                        bus.send(new ThrowableEvent(throwable));
                    });
        }
    }

    private void prepareSuggestsList(ResponseData responseData) {
        final List<SuggestResponse> suggestions = responseData.getSuggestions();

        final int listSize = suggestions.size();

        final List<String> helperValuesList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            helperValuesList.add(suggestions.get(i).getValue());
        }

        view.onSuggestionsReady(helperValuesList);
    }
}
