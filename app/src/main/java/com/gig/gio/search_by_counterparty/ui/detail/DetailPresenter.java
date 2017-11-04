package com.gig.gio.search_by_counterparty.ui.detail;

import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

public interface DetailPresenter {
    void onCreateView(Bus bus, NetworkService networkService);
    void onAttachView();
    void onDetachView();
    void provideLocationForMap(SuggestResponse suggestResponse, Gson gson);
}
