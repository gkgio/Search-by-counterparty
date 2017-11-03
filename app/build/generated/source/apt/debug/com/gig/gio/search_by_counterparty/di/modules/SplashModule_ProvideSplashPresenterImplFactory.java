package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.splash.SplashPresenter;
import com.gig.gio.search_by_counterparty.ui.splash.SplashView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashModule_ProvideSplashPresenterImplFactory
    implements Factory<SplashPresenter> {
  private final SplashModule module;

  private final Provider<SplashView> viewProvider;

  public SplashModule_ProvideSplashPresenterImplFactory(
      SplashModule module, Provider<SplashView> viewProvider) {
    this.module = module;
    this.viewProvider = viewProvider;
  }

  @Override
  public SplashPresenter get() {
    return Preconditions.checkNotNull(
        module.provideSplashPresenterImpl(viewProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SplashPresenter> create(
      SplashModule module, Provider<SplashView> viewProvider) {
    return new SplashModule_ProvideSplashPresenterImplFactory(module, viewProvider);
  }

  public static SplashPresenter proxyProvideSplashPresenterImpl(
      SplashModule instance, SplashView view) {
    return instance.provideSplashPresenterImpl(view);
  }
}
