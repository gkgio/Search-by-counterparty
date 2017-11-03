package com.gig.gio.search_by_counterparty.ui.splash;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashPresenterImpl_Factory implements Factory<SplashPresenterImpl> {
  private final Provider<SplashView> viewProvider;

  public SplashPresenterImpl_Factory(Provider<SplashView> viewProvider) {
    this.viewProvider = viewProvider;
  }

  @Override
  public SplashPresenterImpl get() {
    return new SplashPresenterImpl(viewProvider.get());
  }

  public static Factory<SplashPresenterImpl> create(Provider<SplashView> viewProvider) {
    return new SplashPresenterImpl_Factory(viewProvider);
  }
}
