package com.gig.gio.search_by_counterparty.ui.main;

import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.common.eventbus.Bus;

import io.realm.Realm;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public interface MainPresenter {
    void logout(Realm realm);
    void onAttachView();
    void onDetachView();
    void putCurrentPageTag(String tag);
    String getCurrentPageTag();
}
