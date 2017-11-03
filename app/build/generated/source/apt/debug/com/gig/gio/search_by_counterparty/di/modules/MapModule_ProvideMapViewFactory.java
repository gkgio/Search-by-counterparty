package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.map.MapView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MapModule_ProvideMapViewFactory implements Factory<MapView> {
  private final MapModule module;

  public MapModule_ProvideMapViewFactory(MapModule module) {
    this.module = module;
  }

  @Override
  public MapView get() {
    return Preconditions.checkNotNull(
        module.provideMapView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MapView> create(MapModule module) {
    return new MapModule_ProvideMapViewFactory(module);
  }

  public static MapView proxyProvideMapView(MapModule instance) {
    return instance.provideMapView();
  }
}
