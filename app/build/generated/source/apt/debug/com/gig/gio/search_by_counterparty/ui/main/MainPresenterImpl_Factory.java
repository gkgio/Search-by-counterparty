package com.gig.gio.search_by_counterparty.ui.main;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainPresenterImpl_Factory implements Factory<MainPresenterImpl> {
  private final Provider<MainView> viewProvider;

  public MainPresenterImpl_Factory(Provider<MainView> viewProvider) {
    this.viewProvider = viewProvider;
  }

  @Override
  public MainPresenterImpl get() {
    return new MainPresenterImpl(viewProvider.get());
  }

  public static Factory<MainPresenterImpl> create(Provider<MainView> viewProvider) {
    return new MainPresenterImpl_Factory(viewProvider);
  }
}
