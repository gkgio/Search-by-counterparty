package com.gig.gio.search_by_counterparty.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.Cache;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CounterpartyAppModule_ProvideOkHttpCacheFactory implements Factory<Cache> {
  private final CounterpartyAppModule module;

  public CounterpartyAppModule_ProvideOkHttpCacheFactory(CounterpartyAppModule module) {
    this.module = module;
  }

  @Override
  public Cache get() {
    return Preconditions.checkNotNull(
        module.provideOkHttpCache(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Cache> create(CounterpartyAppModule module) {
    return new CounterpartyAppModule_ProvideOkHttpCacheFactory(module);
  }

  public static Cache proxyProvideOkHttpCache(CounterpartyAppModule instance) {
    return instance.provideOkHttpCache();
  }
}
