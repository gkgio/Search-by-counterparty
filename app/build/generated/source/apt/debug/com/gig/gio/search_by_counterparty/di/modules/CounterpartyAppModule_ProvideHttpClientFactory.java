package com.gig.gio.search_by_counterparty.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CounterpartyAppModule_ProvideHttpClientFactory implements Factory<OkHttpClient> {
  private final CounterpartyAppModule module;

  public CounterpartyAppModule_ProvideHttpClientFactory(CounterpartyAppModule module) {
    this.module = module;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(CounterpartyAppModule module) {
    return new CounterpartyAppModule_ProvideHttpClientFactory(module);
  }

  public static OkHttpClient proxyProvideHttpClient(CounterpartyAppModule instance) {
    return instance.provideHttpClient();
  }
}
