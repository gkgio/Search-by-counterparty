package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CounterpartyAppModule_ProvideCachedMobukServiceFactory
    implements Factory<NetworkService> {
  private final CounterpartyAppModule module;

  private final Provider<Cache> cacheProvider;

  private final Provider<Gson> gsonProvider;

  public CounterpartyAppModule_ProvideCachedMobukServiceFactory(
      CounterpartyAppModule module, Provider<Cache> cacheProvider, Provider<Gson> gsonProvider) {
    this.module = module;
    this.cacheProvider = cacheProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public NetworkService get() {
    return Preconditions.checkNotNull(
        module.provideCachedMobukService(cacheProvider.get(), gsonProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<NetworkService> create(
      CounterpartyAppModule module, Provider<Cache> cacheProvider, Provider<Gson> gsonProvider) {
    return new CounterpartyAppModule_ProvideCachedMobukServiceFactory(
        module, cacheProvider, gsonProvider);
  }

  public static NetworkService proxyProvideCachedMobukService(
      CounterpartyAppModule instance, Cache cache, Gson gson) {
    return instance.provideCachedMobukService(cache, gson);
  }
}
