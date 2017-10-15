package com.gig.gio.search_by_counterparty.di.components;

import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.app.CounterpartyApp;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

@Singleton
@Component(modules = {CounterpartyAppModule.class})
public interface CounterpartyAppComponent {

    void inject(CounterpartyApp counterpartyApp);

    SharedPreferences sharedPreferences();
    Bus eventBus();
}
