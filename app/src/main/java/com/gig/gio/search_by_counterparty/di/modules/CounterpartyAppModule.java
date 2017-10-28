package com.gig.gio.search_by_counterparty.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.gig.gio.search_by_counterparty.app.CounterpartyApp;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.di.ActivityScope;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
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
    @ActivityScope
    Application provideApplication() {
        return app;
    }

    @Provides
    @ActivityScope
    SharedPreferences provideSharedPreferences() {
        return app.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @ActivityScope
    Bus provideEventBus() {
        return new Bus();
    }

    @Provides
    @ActivityScope
    Cache provideOkHttpCache() {
        File httpCacheDirectory = new File(app.getApplicationContext().getCacheDir(), Config.CACHE_FILE_NAME);
        return new Cache(httpCacheDirectory, Config.CACHE_FILE_SIZE);
    }

    @Provides
    @Named("cached")
    @ActivityScope
    NetworkService provideCachedMobukService(Cache cache, Gson gson) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        // включаем нужные хэдеры в ответе
        builder.interceptors().add(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Accept", "application/json")
                    .cacheControl(new CacheControl.Builder()
                            .maxStale(Config.CACHE_TIME, TimeUnit.MINUTES) // кэш
                            .build())
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        });

        // logging для http клиента TODO закомментировать в продакшен
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.interceptors().add(interceptor);

        // устанавливаем кэш
        builder.cache(cache);

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Config.apiURL)
                .client(builder.build())
                .build();

        return retrofit.create(NetworkService.class);
    }
}
