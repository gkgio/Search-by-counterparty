package com.gig.gio.search_by_counterparty.ui.map;


import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.network.NetworkService;

import io.realm.Realm;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */


public interface MapPresenter {
    void onCreateView(Bus bus, NetworkService networkService);
    void onAttachView();
    void onDetachView();
    void initMap(boolean isReadyMap);
    void getCounterPartyFromRealm(Bus bus, Realm realm);
}