package com.gig.gio.search_by_counterparty.app;

import android.app.Application;
import android.content.Context;

import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerCounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class CounterpartyApp extends Application {

    private CounterpartyAppComponent counterpartyAppComponent;

    public static CounterpartyApp get(Context context) {
        return (CounterpartyApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        buildObjectGraphAndInject();
       // Fabric.with(this, new Crashlytics());
    }

    public void buildObjectGraphAndInject() {
        counterpartyAppComponent = DaggerCounterpartyAppComponent.builder()
                .counterpartyAppModule(new CounterpartyAppModule(this))
                .build();
    }

    public CounterpartyAppComponent getAppComponent() {
        return counterpartyAppComponent;
    }
}
