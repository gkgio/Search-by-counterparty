package com.gig.gio.search_by_counterparty.ui.bookmarks;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.bookmarks.ListSuggestResponseEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.bookmarks.SuggestResponseAdapterEvent;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.realm.Realm;

/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

public class BookmarksPresenterImpl implements BookmarksPresenter {

    private BookmarksView view;

    private Gson gson;
    private Bus bus;

    private CompositeDisposable disposables;

    @Inject
    public BookmarksPresenterImpl(BookmarksView view) {
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
                        final List<SuggestResponse> suggestResponseList =
                                ((ListSuggestResponseEvent) event).getSuggestResponseList();
                        view.setDataInAdapter(suggestResponseList);
                    } else if (event instanceof SuggestResponseAdapterEvent) {
                        final SuggestResponse suggestResponse = ((SuggestResponseAdapterEvent) event).getSuggestResponse();
                        final String jsonSuggestResponseString = gson.toJson(suggestResponse, SuggestResponse.class);
                        view.openDetailActivity(jsonSuggestResponseString);
                    } else if (event instanceof HttpErrorEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    } else if (event instanceof ThrowableEvent) {
                        view.showMessage(R.string.toast_error, ToastType.ERROR);
                    }
                });
    }

    @Override
    public void loadDataForAdapter(Realm realm) {
        realm.where(SuggestResponse.class).findAll().asObservable()
                .first()
                .subscribe(suggestResponse -> {
                    List<SuggestResponse> suggestResponseList = realm.copyFromRealm(suggestResponse);

                    // если данные в базе есть, то отправляем их в адаптер
                    // иначе выводим сообщение об ошибке,
                    bus.send((suggestResponseList.size() > 0) ?
                            new ListSuggestResponseEvent(suggestResponseList) : new ThrowableEvent(new Throwable()));
                }, dbThrowable -> {
                    bus.send(new ThrowableEvent(new Throwable()));
                });

    }
}