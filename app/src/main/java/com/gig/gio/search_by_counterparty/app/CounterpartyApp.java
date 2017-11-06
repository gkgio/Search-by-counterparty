package com.gig.gio.search_by_counterparty.app;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerCounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;

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
        Fabric.with(this, new Crashlytics());
        buildObjectGraphAndInject();
       // Fabric.with(this, new Crashlytics());

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
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
