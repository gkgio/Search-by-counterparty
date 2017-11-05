package com.gig.gio.search_by_counterparty.ui.bookmarks;

import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;

import io.realm.Realm;

/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

public interface BookmarksPresenter {
    void onCreateView(Bus bus, Gson gson);
    void onAttachView();
    void onDetachView();
    void loadDataForAdapter(Realm realm);
}
