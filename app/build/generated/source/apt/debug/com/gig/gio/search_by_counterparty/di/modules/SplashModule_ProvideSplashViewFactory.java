package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.splash.SplashView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashModule_ProvideSplashViewFactory implements Factory<SplashView> {
  private final SplashModule module;

  public SplashModule_ProvideSplashViewFactory(SplashModule module) {
    this.module = module;
  }

  @Override
  public SplashView get() {
    return Preconditions.checkNotNull(
        module.provideSplashView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SplashView> create(SplashModule module) {
    return new SplashModule_ProvideSplashViewFactory(module);
  }

  public static SplashView proxyProvideSplashView(SplashModule instance) {
    return instance.provideSplashView();
  }
}
