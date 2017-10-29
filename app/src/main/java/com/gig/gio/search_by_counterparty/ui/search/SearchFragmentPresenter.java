package com.gig.gio.search_by_counterparty.ui.search;

import com.gig.gio.search_by_counterparty.app.BaseFragmentPresenter;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.network.NetworkService;

import org.reactivestreams.Subscription;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

public interface SearchFragmentPresenter extends BaseFragmentPresenter<SearchFragmentView> {

    void onAttachView(Bus bus, NetworkService networkService);
    void onDetachView();
    void requestSuggestions(String text);
}
