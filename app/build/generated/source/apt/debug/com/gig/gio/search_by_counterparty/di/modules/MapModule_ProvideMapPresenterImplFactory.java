package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.map.MapPresenter;
import com.gig.gio.search_by_counterparty.ui.map.MapView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MapModule_ProvideMapPresenterImplFactory implements Factory<MapPresenter> {
  private final MapModule module;

  private final Provider<MapView> viewProvider;

  public MapModule_ProvideMapPresenterImplFactory(
      MapModule module, Provider<MapView> viewProvider) {
    this.module = module;
    this.viewProvider = viewProvider;
  }

  @Override
  public MapPresenter get() {
    return Preconditions.checkNotNull(
        module.provideMapPresenterImpl(viewProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MapPresenter> create(MapModule module, Provider<MapView> viewProvider) {
    return new MapModule_ProvideMapPresenterImplFactory(module, viewProvider);
  }

  public static MapPresenter proxyProvideMapPresenterImpl(MapModule instance, MapView view) {
    return instance.provideMapPresenterImpl(view);
  }
}
