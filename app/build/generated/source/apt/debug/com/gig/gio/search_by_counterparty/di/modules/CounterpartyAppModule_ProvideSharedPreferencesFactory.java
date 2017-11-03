package com.gig.gio.search_by_counterparty.di.modules;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CounterpartyAppModule_ProvideSharedPreferencesFactory
    implements Factory<SharedPreferences> {
  private final CounterpartyAppModule module;

  public CounterpartyAppModule_ProvideSharedPreferencesFactory(CounterpartyAppModule module) {
    this.module = module;
  }

  @Override
  public SharedPreferences get() {
    return Preconditions.checkNotNull(
        module.provideSharedPreferences(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SharedPreferences> create(CounterpartyAppModule module) {
    return new CounterpartyAppModule_ProvideSharedPreferencesFactory(module);
  }

  public static SharedPreferences proxyProvideSharedPreferences(CounterpartyAppModule instance) {
    return instance.provideSharedPreferences();
  }
}
