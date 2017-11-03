package com.gig.gio.search_by_counterparty.di.components;

import android.app.Application;
import android.content.SharedPreferences;
import com.gig.gio.search_by_counterparty.app.CounterpartyApp;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule_ProvideApplicationFactory;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule_ProvideCachedMobukServiceFactory;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule_ProvideEventBusFactory;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule_ProvideGsonFactory;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule_ProvideHttpClientFactory;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule_ProvideMobukServiceFactory;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule_ProvideOkHttpCacheFactory;
import com.gig.gio.search_by_counterparty.di.modules.CounterpartyAppModule_ProvideSharedPreferencesFactory;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerCounterpartyAppComponent implements CounterpartyAppComponent {
  private Provider<Application> provideApplicationProvider;

  private Provider<SharedPreferences> provideSharedPreferencesProvider;

  private Provider<Bus> provideEventBusProvider;

  private Provider<Gson> provideGsonProvider;

  private Provider<Cache> provideOkHttpCacheProvider;

  private Provider<NetworkService> provideCachedMobukServiceProvider;

  private Provider<OkHttpClient> provideHttpClientProvider;

  private Provider<NetworkService> provideMobukServiceProvider;

  private DaggerCounterpartyAppComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideApplicationProvider =
        DoubleCheck.provider(
            CounterpartyAppModule_ProvideApplicationFactory.create(builder.counterpartyAppModule));
    this.provideSharedPreferencesProvider =
        DoubleCheck.provider(
            CounterpartyAppModule_ProvideSharedPreferencesFactory.create(
                builder.counterpartyAppModule));
    this.provideEventBusProvider =
        DoubleCheck.provider(
            CounterpartyAppModule_ProvideEventBusFactory.create(builder.counterpartyAppModule));
    this.provideGsonProvider =
        DoubleCheck.provider(
            CounterpartyAppModule_ProvideGsonFactory.create(builder.counterpartyAppModule));
    this.provideOkHttpCacheProvider =
        DoubleCheck.provider(
            CounterpartyAppModule_ProvideOkHttpCacheFactory.create(builder.counterpartyAppModule));
    this.provideCachedMobukServiceProvider =
        DoubleCheck.provider(
            CounterpartyAppModule_ProvideCachedMobukServiceFactory.create(
                builder.counterpartyAppModule, provideOkHttpCacheProvider, provideGsonProvider));
    this.provideHttpClientProvider =
        DoubleCheck.provider(
            CounterpartyAppModule_ProvideHttpClientFactory.create(builder.counterpartyAppModule));
    this.provideMobukServiceProvider =
        DoubleCheck.provider(
            CounterpartyAppModule_ProvideMobukServiceFactory.create(
                builder.counterpartyAppModule, provideGsonProvider, provideHttpClientProvider));
  }

  @Override
  public void inject(CounterpartyApp counterpartyApp) {}

  @Override
  public Application app() {
    return provideApplicationProvider.get();
  }

  @Override
  public SharedPreferences sharedPreferences() {
    return provideSharedPreferencesProvider.get();
  }

  @Override
  public Bus eventBus() {
    return provideEventBusProvider.get();
  }

  @Override
  public Gson gson() {
    return provideGsonProvider.get();
  }

  @Override
  public Cache cache() {
    return provideOkHttpCacheProvider.get();
  }

  @Override
  public NetworkService mobukCachedService() {
    return provideCachedMobukServiceProvider.get();
  }

  @Override
  public NetworkService mobukNoCachedService() {
    return provideMobukServiceProvider.get();
  }

  public static final class Builder {
    private CounterpartyAppModule counterpartyAppModule;

    private Builder() {}

    public CounterpartyAppComponent build() {
      if (counterpartyAppModule == null) {
        throw new IllegalStateException(
            CounterpartyAppModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerCounterpartyAppComponent(this);
    }

    public Builder counterpartyAppModule(CounterpartyAppModule counterpartyAppModule) {
      this.counterpartyAppModule = Preconditions.checkNotNull(counterpartyAppModule);
      return this;
    }
  }
}
