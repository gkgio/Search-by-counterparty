package com.gig.gio.search_by_counterparty.ui.detail;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DetailPresenterImpl_Factory implements Factory<DetailPresenterImpl> {
  private final Provider<DetailView> viewProvider;

  public DetailPresenterImpl_Factory(Provider<DetailView> viewProvider) {
    this.viewProvider = viewProvider;
  }

  @Override
  public DetailPresenterImpl get() {
    return new DetailPresenterImpl(viewProvider.get());
  }

  public static Factory<DetailPresenterImpl> create(Provider<DetailView> viewProvider) {
    return new DetailPresenterImpl_Factory(viewProvider);
  }
}
