package com.gig.gio.search_by_counterparty.ui.main;

import android.content.SharedPreferences;

import io.realm.Realm;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public interface MainPresenter {
    void logout(SharedPreferences preferences, Realm realm);
}
