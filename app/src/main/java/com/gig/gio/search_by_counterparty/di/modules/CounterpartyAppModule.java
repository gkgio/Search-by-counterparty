package com.gig.gio.search_by_counterparty.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.app.CounterpartyApp;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

@Module
public class CounterpartyAppModule {

    private final CounterpartyApp app;
    private static final String PREF_NAME = "preferences";

    public CounterpartyAppModule(CounterpartyApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return app.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Bus provideEventBus() {
        return new Bus();
    }
}
