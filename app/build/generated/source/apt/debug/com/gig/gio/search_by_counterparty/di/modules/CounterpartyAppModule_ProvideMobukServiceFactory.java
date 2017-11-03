package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CounterpartyAppModule_ProvideMobukServiceFactory
    implements Factory<NetworkService> {
  private final CounterpartyAppModule module;

  private final Provider<Gson> gsonProvider;

  private final Provider<OkHttpClient> clientProvider;

  public CounterpartyAppModule_ProvideMobukServiceFactory(
      CounterpartyAppModule module,
      Provider<Gson> gsonProvider,
      Provider<OkHttpClient> clientProvider) {
    this.module = module;
    this.gsonProvider = gsonProvider;
    this.clientProvider = clientProvider;
  }

  @Override
  public NetworkService get() {
    return Preconditions.checkNotNull(
        module.provideMobukService(gsonProvider.get(), clientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<NetworkService> create(
      CounterpartyAppModule module,
      Provider<Gson> gsonProvider,
      Provider<OkHttpClient> clientProvider) {
    return new CounterpartyAppModule_ProvideMobukServiceFactory(
        module, gsonProvider, clientProvider);
  }

  public static NetworkService proxyProvideMobukService(
      CounterpartyAppModule instance, Gson gson, OkHttpClient client) {
    return instance.provideMobukService(gson, client);
  }
}
