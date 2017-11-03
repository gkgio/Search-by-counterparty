package com.gig.gio.search_by_counterparty.ui.map;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MapPresenterImpl_Factory implements Factory<MapPresenterImpl> {
  private final Provider<MapView> viewProvider;

  public MapPresenterImpl_Factory(Provider<MapView> viewProvider) {
    this.viewProvider = viewProvider;
  }

  @Override
  public MapPresenterImpl get() {
    return new MapPresenterImpl(viewProvider.get());
  }

  public static Factory<MapPresenterImpl> create(Provider<MapView> viewProvider) {
    return new MapPresenterImpl_Factory(viewProvider);
  }
}
