package com.gig.gio.search_by_counterparty.ui.search;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.search.SearchEvent;
import com.gig.gio.search_by_counterparty.common.rx.RxUtil;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.gig.gio.search_by_counterparty.network.NetworkService;

import org.reactivestreams.Subscription;

import java.net.HttpURLConnection;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public class SearchFragmentPresenterImpl implements SearchFragmentPresenter {

    private SearchFragmentView view;
    private Bus bus;
    private CompositeDisposable disposables;
    private NetworkService networkService;

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
                .subscribe(event ->{
                        view.hideProgress();
                    if (event instanceof SearchEvent) {
                        final List<SuggestResponse> suggestsList = ((SearchEvent) event).getSuggests();
                        prepareSuggestsList(suggestsList);
                    } else if (event instanceof HttpErrorEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    } else if (event instanceof ThrowableEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    }
                });
    }


    @Override
    public void requestSuggestions(String text) {
        if (text.length() > 2) {
            view.showProgress();
            Observable<Response<List<SuggestResponse>>> responseObservable = networkService.getSuggestion(text);
            responseObservable.compose(RxUtil.applySchedulersAndRetry())
                    .subscribe(response -> {
                        final int responseCode = response.code();
                        switch (responseCode) {
                            case HttpURLConnection.HTTP_OK:
                                bus.send(new SearchEvent(response.body()));
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

    private void  prepareSuggestsList(List<SuggestResponse> suggestList){
        List<SuggestResponse> d= suggestList;
    }
}
