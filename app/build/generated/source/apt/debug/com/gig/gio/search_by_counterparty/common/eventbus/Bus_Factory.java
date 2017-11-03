package com.gig.gio.search_by_counterparty.common.eventbus;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Bus_Factory implements Factory<Bus> {
  private static final Bus_Factory INSTANCE = new Bus_Factory();

  @Override
  public Bus get() {
    return new Bus();
  }

  public static Factory<Bus> create() {
    return INSTANCE;
  }
}
