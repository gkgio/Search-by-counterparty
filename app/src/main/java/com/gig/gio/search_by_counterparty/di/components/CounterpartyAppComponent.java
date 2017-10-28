package com.gig.gio.search_by_counterparty.di.components;

import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.app.CounterpartyApp;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.di.ActivityScope;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule;
import com.gig.gio.search_by_counterparty.ui.splash.SplashPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

@ActivityScope
@Component(modules = {CounterpartyAppModule.class})
public interface CounterpartyAppComponent {

    Bus eventBus();

    SharedPreferences sharedPreferences();

    SplashPresenter createSplashPresenter();

    void inject(CounterpartyApp counterpartyApp);
}
