package com.gig.gio.search_by_counterparty.di.components;

import com.gig.gio.search_by_counterparty.app.BaseActivity_MembersInjector;
import com.gig.gio.search_by_counterparty.di.modules.MapModule;
import com.gig.gio.search_by_counterparty.di.modules.MapModule_ProvideMapViewFactory;
import com.gig.gio.search_by_counterparty.ui.map.MapActivity;
import com.gig.gio.search_by_counterparty.ui.map.MapActivity_MembersInjector;
import com.gig.gio.search_by_counterparty.ui.map.MapPresenterImpl;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMapComponent implements MapComponent {
  private CounterpartyAppComponent counterpartyAppComponent;

  private MapModule mapModule;

  private DaggerMapComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.counterpartyAppComponent = builder.counterpartyAppComponent;
    this.mapModule = builder.mapModule;
  }

  @Override
  public void inject(MapActivity mapActivity) {
    injectMapActivity(mapActivity);
  }

  private MapActivity injectMapActivity(MapActivity instance) {
    BaseActivity_MembersInjector.injectGson(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.gson(),
            "Cannot return null from a non-@Nullable component method"));
    BaseActivity_MembersInjector.injectPreferences(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.sharedPreferences(),
            "Cannot return null from a non-@Nullable component method"));
    BaseActivity_MembersInjector.injectBus(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.eventBus(),
            "Cannot return null from a non-@Nullable component method"));
    BaseActivity_MembersInjector.injectCachedNetworkService(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.mobukCachedService(),
            "Cannot return null from a non-@Nullable component method"));
    BaseActivity_MembersInjector.injectNetworkService(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.mobukNoCachedService(),
            "Cannot return null from a non-@Nullable component method"));
    MapActivity_MembersInjector.injectPresenter(
        instance,
        new MapPresenterImpl(
            Preconditions.checkNotNull(
                MapModule_ProvideMapViewFactory.proxyProvideMapView(mapModule),
                "Cannot return null from a non-@Nullable @Provides method")));
    return instance;
  }

  public static final class Builder {
    private MapModule mapModule;

    private CounterpartyAppComponent counterpartyAppComponent;

    private Builder() {}

    public MapComponent build() {
      if (mapModule == null) {
        throw new IllegalStateException(MapModule.class.getCanonicalName() + " must be set");
      }
      if (counterpartyAppComponent == null) {
        throw new IllegalStateException(
            CounterpartyAppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerMapComponent(this);
    }

    public Builder mapModule(MapModule mapModule) {
      this.mapModule = Preconditions.checkNotNull(mapModule);
      return this;
    }

    public Builder counterpartyAppComponent(CounterpartyAppComponent counterpartyAppComponent) {
      this.counterpartyAppComponent = Preconditions.checkNotNull(counterpartyAppComponent);
      return this;
    }
  }
}
