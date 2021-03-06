package com.gig.gio.search_by_counterparty.ui.main.search;

import com.gig.gio.search_by_counterparty.app.BaseFragmentPresenter;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.model.ResponseData;
import com.gig.gio.search_by_counterparty.network.NetworkService;

import io.realm.Realm;

/**
 * Created by georgy on 03.11.2017.
 * Gig
 */

public interface SearchFragmentPresenter extends BaseFragmentPresenter<SearchFragmentView> {
    void requestSuggestions(String text);
    void onAttachView(Bus bus, NetworkService networkService);
    void onDetachView();
    void saveSelectedSuggest(ResponseData responseData, String selectedItem, Realm realm);
}
