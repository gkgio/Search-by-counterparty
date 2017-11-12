package com.gig.gio.search_by_counterparty.di.components;

import android.app.Application;
import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.app.CounterpartyApp;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;

import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import okhttp3.Cache;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

@Singleton
@Component(modules = {CounterpartyAppModule.class})
public interface CounterpartyAppComponent {

    void inject(CounterpartyApp counterpartyApp);

    Application app();

    SharedPreferences sharedPreferences();
    Bus eventBus();
    Gson gson();
    @Named("no_cached")
    NetworkService noCachedService();
}
