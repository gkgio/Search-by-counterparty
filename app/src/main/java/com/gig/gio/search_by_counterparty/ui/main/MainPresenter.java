package com.gig.gio.search_by_counterparty.ui.main;

import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.network.NetworkService;

import io.realm.Realm;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public interface MainPresenter {
    void onCreateView(Bus bus);
    void logout(SharedPreferences preferences, Realm realm);
    void onAttachView();
    void onDetachView();
    boolean isFirstStart(SharedPreferences preferences);
    void setIsFirstStart(SharedPreferences preferences);
}
