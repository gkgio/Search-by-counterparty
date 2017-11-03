package com.gig.gio.search_by_counterparty.di.components;

import com.gig.gio.search_by_counterparty.app.BaseActivity_MembersInjector;
import com.gig.gio.search_by_counterparty.di.modules.SplashModule;
import com.gig.gio.search_by_counterparty.di.modules.SplashModule_ProvideSplashViewFactory;
import com.gig.gio.search_by_counterparty.ui.splash.SplashActivity;
import com.gig.gio.search_by_counterparty.ui.splash.SplashActivity_MembersInjector;
import com.gig.gio.search_by_counterparty.ui.splash.SplashPresenterImpl;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerSplashComponent implements SplashComponent {
  private CounterpartyAppComponent counterpartyAppComponent;

  private SplashModule splashModule;

  private DaggerSplashComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.counterpartyAppComponent = builder.counterpartyAppComponent;
    this.splashModule = builder.splashModule;
  }

  @Override
  public void inject(SplashActivity splashActivity) {
    injectSplashActivity(splashActivity);
  }

  private SplashActivity injectSplashActivity(SplashActivity instance) {
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
    SplashActivity_MembersInjector.injectPresenter(
        instance,
        new SplashPresenterImpl(
            Preconditions.checkNotNull(
                SplashModule_ProvideSplashViewFactory.proxyProvideSplashView(splashModule),
                "Cannot return null from a non-@Nullable @Provides method")));
    return instance;
  }

  public static final class Builder {
    private SplashModule splashModule;

    private CounterpartyAppComponent counterpartyAppComponent;

    private Builder() {}

    public SplashComponent build() {
      if (splashModule == null) {
        throw new IllegalStateException(SplashModule.class.getCanonicalName() + " must be set");
      }
      if (counterpartyAppComponent == null) {
        throw new IllegalStateException(
            CounterpartyAppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerSplashComponent(this);
    }

    public Builder splashModule(SplashModule splashModule) {
      this.splashModule = Preconditions.checkNotNull(splashModule);
      return this;
    }

    public Builder counterpartyAppComponent(CounterpartyAppComponent counterpartyAppComponent) {
      this.counterpartyAppComponent = Preconditions.checkNotNull(counterpartyAppComponent);
      return this;
    }
  }
}
