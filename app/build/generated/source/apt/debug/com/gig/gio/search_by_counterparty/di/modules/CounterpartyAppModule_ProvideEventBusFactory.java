package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CounterpartyAppModule_ProvideEventBusFactory implements Factory<Bus> {
  private final CounterpartyAppModule module;

  public CounterpartyAppModule_ProvideEventBusFactory(CounterpartyAppModule module) {
    this.module = module;
  }

  @Override
  public Bus get() {
    return Preconditions.checkNotNull(
        module.provideEventBus(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Bus> create(CounterpartyAppModule module) {
    return new CounterpartyAppModule_ProvideEventBusFactory(module);
  }

  public static Bus proxyProvideEventBus(CounterpartyAppModule instance) {
    return instance.provideEventBus();
  }
}
