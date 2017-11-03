package com.gig.gio.search_by_counterparty.di.modules;

import com.tbruyelle.rxpermissions.RxPermissions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainModule_ProvideRxPermissionsFactory implements Factory<RxPermissions> {
  private final MainModule module;

  public MainModule_ProvideRxPermissionsFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public RxPermissions get() {
    return Preconditions.checkNotNull(
        module.provideRxPermissions(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RxPermissions> create(MainModule module) {
    return new MainModule_ProvideRxPermissionsFactory(module);
  }

  public static RxPermissions proxyProvideRxPermissions(MainModule instance) {
    return instance.provideRxPermissions();
  }
}
