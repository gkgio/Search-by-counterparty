package com.gig.gio.search_by_counterparty.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.BuildConfig;
import com.gig.gio.search_by_counterparty.app.CounterpartyApp;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.LongWrapper;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;

import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import java.lang.reflect.Type;

import dagger.Module;
import dagger.Provides;
import io.realm.RealmList;
import io.realm.RealmObject;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
        Type token = new TypeToken<RealmList<LongWrapper>>() {
        }.getType();
        return new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .registerTypeAdapter(token, new TypeAdapter<RealmList<LongWrapper>>() {

                    @Override
                    public void write(JsonWriter out, RealmList<LongWrapper> value) throws IOException {
                        out.beginArray();
                        for (LongWrapper longWrapper : value) {
                            out.value(longWrapper.getValue());
                        }
                        out.endArray();
                    }

                    @Override
                    public RealmList<LongWrapper> read(JsonReader in) throws IOException {
                        RealmList<LongWrapper> list = new RealmList<>();

                        in.beginArray();
                        while (in.hasNext()) {
                            list.add(new LongWrapper(in.nextLong()));
                        }
                        in.endArray();
                        return list;
                    }
                })
                .create();
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