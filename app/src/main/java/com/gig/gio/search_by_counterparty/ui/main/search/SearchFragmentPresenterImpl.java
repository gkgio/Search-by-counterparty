package com.gig.gio.search_by_counterparty.ui.main.search;

import com.gig.gio.search_by_counterparty.BuildConfig;
import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.search.ListSuggestResponseEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.search.ResponseDataEvent;
import com.gig.gio.search_by_counterparty.common.rx.RxUtil;
import com.gig.gio.search_by_counterparty.model.RequestData;
import com.gig.gio.search_by_counterparty.model.ResponseData;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.gig.gio.search_by_counterparty.network.NetworkService;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.realm.Realm;
import retrofit2.Response;

/**
 * Created by georgy on 03.11.2017.
 * Gig
 */

public class SearchFragmentPresenterImpl implements SearchFragmentPresenter {

    private SearchFragmentView view;

    private Bus bus;
    private NetworkService networkService;
    private Realm realm;

    private CompositeDisposable disposables;

    private final static int COUNT_RESPONSE_OBJECT = 10;

    @Inject
    public SearchFragmentPresenterImpl() {
    }

    @Override
    public void init(SearchFragmentView view) {
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
                    if (event instanceof ListSuggestResponseEvent) {
                        final List<SuggestResponse> suggestResponseList = ((ListSuggestResponseEvent) event).getSuggestResponseList();
                        final SuggestResponse suggestResponse = ((ListSuggestResponseEvent) event).getSuggestResponse();
                        saveNewItemInRealm(suggestResponseList, suggestResponse);
                    } else if (event instanceof ResponseDataEvent) {
                        final ResponseData responseData = ((ResponseDataEvent) event).getResponseData();
                        prepareSuggestsList(responseData);
                    } else if (event instanceof HttpErrorEvent) {
                        view.showMessage(R.string.toast_error, SnackBarType.ERROR);
                    } else if (event instanceof ThrowableEvent) {
                        view.showMessage(R.string.toast_error, SnackBarType.ERROR);
                    }
                });
    }


    @Override
    public void requestSuggestions(String query) {
        view.showProgress();

        final RequestData requestData = new RequestData();
        requestData.setCount(COUNT_RESPONSE_OBJECT);
        requestData.setQuery(query);

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

    private void prepareSuggestsList(ResponseData responseData) {
        final List<SuggestResponse> suggestions = responseData.getSuggestions();

        final int listSize = suggestions.size();

        final List<String> helperValuesList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            helperValuesList.add(suggestions.get(i).getValue());
        }

        view.onSuggestionsReady(helperValuesList, responseData);
    }

    @Override
    public void saveSelectedSuggest(ResponseData responseData, String selectedItem, Realm realm) {
        view.showProgress();
        this.realm = realm;
        SuggestResponse suggestResponse = null;

        for (SuggestResponse suggest : responseData.getSuggestions()) {
            if (suggest.getValue().equals(selectedItem)) {
                suggestResponse = suggest;
                break;
            }
        }

        List<SuggestResponse> suggestResponseList = realm.copyFromRealm(realm.where(SuggestResponse.class).findAll());
        if (suggestResponseList != null) {
            bus.send(new ListSuggestResponseEvent(suggestResponseList, suggestResponse));
        } else {
            bus.send(new ThrowableEvent(new Throwable()));
        }
    }

    private void saveNewItemInRealm(List<SuggestResponse> suggestResponseList, SuggestResponse suggestResponse) {
        boolean isInHistory = false;

        for (Iterator<SuggestResponse> iter = suggestResponseList.listIterator(); iter.hasNext(); ) {
            SuggestResponse suggest = iter.next();
            if (suggest.getValue().equals(suggestResponse.getValue())) {
                iter.remove();
                isInHistory = true;
            }
        }

        if (isInHistory)
            realm.executeTransaction(transaction ->
                    transaction.where(SuggestResponse.class).
                            equalTo("value", suggestResponse.getValue()).findFirst().deleteFromRealm()
            );

        realm.executeTransaction(transaction -> {
            // increment index
            Number currentIdNum = transaction.where(SuggestResponse.class).max("id");
            int nextId;
            if (currentIdNum == null) {
                nextId = 1;
            } else {
                nextId = currentIdNum.intValue() + 1;
            }

            suggestResponse.setId(nextId);
            suggestResponse.getData().setId(nextId);
            suggestResponse.getData().getAddress().setId(nextId);
            if (suggestResponse.getData().getAddress().getAddressData() != null)
                suggestResponse.getData().getAddress().getAddressData().setId(nextId);
            if (suggestResponse.getData().getManagement() != null)
                suggestResponse.getData().getManagement().setId(nextId);
            if (suggestResponse.getData().getOpf() != null)
                suggestResponse.getData().getOpf().setId(nextId);
            if (suggestResponse.getData().getState() != null)
                suggestResponse.getData().getState().setId(nextId);

            transaction.copyToRealmOrUpdate(suggestResponse);
        });

        view.startDetailActivity(suggestResponse.getId());

        view.hideProgress();
    }
}
