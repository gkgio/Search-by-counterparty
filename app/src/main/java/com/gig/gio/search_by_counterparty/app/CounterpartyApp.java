package com.gig.gio.search_by_counterparty.app;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerCounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule;

import io.fabric.sdk.android.Fabric;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class CounterpartyApp extends Application {

    private CounterpartyAppComponent counterpartyAppComponent;

    public static CounterpartyAppComponent getComponent(Context context) {
        return ((CounterpartyApp) context.getApplicationContext()).counterpartyAppComponent;
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
}
