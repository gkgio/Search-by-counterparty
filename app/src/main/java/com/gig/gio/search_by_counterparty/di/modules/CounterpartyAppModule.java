package com.gig.gio.search_by_counterparty.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.BuildConfig;
import com.gig.gio.search_by_counterparty.app.CounterpartyApp;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.network.NetworkService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        builder.interceptors().add(interceptor);
        return builder.build();
    }

    @Provides
    @Named("no_cached")
    @Singleton
    NetworkService provideService(Gson gson, OkHttpClient client) {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Config.API_URL)
                .client(client)
                .build();

        return retrofit.create(NetworkService.class);
    }
}