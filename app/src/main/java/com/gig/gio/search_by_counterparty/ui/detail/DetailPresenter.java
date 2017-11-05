package com.gig.gio.search_by_counterparty.ui.detail;

import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.google.gson.Gson;

import io.realm.Realm;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

public interface DetailPresenter {
    void onCreateView(Bus bus,  Gson gson);
    void onAttachView();
    void onDetachView();
    void provideLocationForMap(SuggestResponse suggestResponse);
    void saveChangedInRealm(SuggestResponse suggestResponse, Realm realm);
}
