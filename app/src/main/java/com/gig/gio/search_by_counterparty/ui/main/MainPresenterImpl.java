package com.gig.gio.search_by_counterparty.ui.main;

import android.content.SharedPreferences;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView view;

    @Inject
    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void logout(SharedPreferences preferences, Realm realm) {
        realm.executeTransaction(transaction -> transaction.deleteAll());
       /* preferences.edit()
                .remove(Config.PREF_ACCOUNT_TYPE)
                .apply();*/
    }
}
