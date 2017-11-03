package com.gig.gio.search_by_counterparty.di.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CounterpartyAppModule_ProvideApplicationFactory implements Factory<Application> {
  private final CounterpartyAppModule module;

  public CounterpartyAppModule_ProvideApplicationFactory(CounterpartyAppModule module) {
    this.module = module;
  }

  @Override
  public Application get() {
    return Preconditions.checkNotNull(
        module.provideApplication(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Application> create(CounterpartyAppModule module) {
    return new CounterpartyAppModule_ProvideApplicationFactory(module);
  }

  public static Application proxyProvideApplication(CounterpartyAppModule instance) {
    return instance.provideApplication();
  }
}
