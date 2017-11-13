package com.gig.gio.search_by_counterparty.ui.bookmarks;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.HttpErrorEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.ThrowableEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.bookmarks.ListEmptyInfoEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.bookmarks.ListSuggestResponseEvent;
import com.gig.gio.search_by_counterparty.common.eventbus.events.bookmarks.SuggestResponseAdapterEvent;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
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
                        view.startDetailActivity(jsonSuggestResponseString);
                    } else if (event instanceof ListEmptyInfoEvent) {
                        view.showMessage(R.string.bookmarks_list_empty, SnackBarType.INFO);
                    } else if (event instanceof HttpErrorEvent) {
                        view.showMessage(R.string.toast_error, SnackBarType.ERROR);
                    } else if (event instanceof ThrowableEvent) {
                        view.showMessage(R.string.toast_error, SnackBarType.ERROR);
                    }
                });
    }

    @Override
    public void loadDataForAdapter(Realm realm) {
        List<SuggestResponse> suggestResponseList = realm.copyFromRealm(
                realm.where(SuggestResponse.class).findAll());

        // если данные в базе есть, то отправляем их в адаптер
        // иначе выводим сообщение об ошибке,
        if (suggestResponseList.size() > 0) {
            //предварительно сортируем
            Collections.sort(suggestResponseList, (o1, o2) -> {
                int first = o1.isBookmark() ? 1 : 0;
                int second = o2.isBookmark() ? 1 : 0;
                return second - first;
            });
            bus.send(new ListSuggestResponseEvent(suggestResponseList));
        } else bus.send(new ListEmptyInfoEvent());
    }

    @Override
    public void searchByBookmarks(String searchValue, List<SuggestResponse> suggestResponseList) {
        final String queryFromUser = searchValue.replaceAll("\\s+", " ").trim();

        view.showProgress();

        final List<String> helperValuesList = new ArrayList<>();

        if (!queryFromUser.isEmpty()) {
            for (SuggestResponse suggest : suggestResponseList) {
                if (suggest.getValue().toLowerCase().startsWith(queryFromUser.toLowerCase()))
                    helperValuesList.add(suggest.getValue());
            }
        }

        if (helperValuesList.size() > 0)
            view.onSuggestionsReady(helperValuesList);

        view.hideProgress();
    }

    @Override
    public void findSuggestForDetailActivity(String selectedItem, List<SuggestResponse> suggestResponseList) {
        SuggestResponse suggestResponse = null;

        for (SuggestResponse suggest : suggestResponseList) {
            if (suggest.getValue().equals(selectedItem)) {
                suggestResponse = suggest;
                break;
            }
        }

        final String jsonSuggestResponse = gson.toJson(suggestResponse, SuggestResponse.class);
        view.startDetailActivity(jsonSuggestResponse);
    }
}
