package com.gig.gio.search_by_counterparty.di.modules;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CounterpartyAppModule_ProvideGsonFactory implements Factory<Gson> {
  private final CounterpartyAppModule module;

  public CounterpartyAppModule_ProvideGsonFactory(CounterpartyAppModule module) {
    this.module = module;
  }

  @Override
  public Gson get() {
    return Preconditions.checkNotNull(
        module.provideGson(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Gson> create(CounterpartyAppModule module) {
    return new CounterpartyAppModule_ProvideGsonFactory(module);
  }

  public static Gson proxyProvideGson(CounterpartyAppModule instance) {
    return instance.provideGson();
  }
}
