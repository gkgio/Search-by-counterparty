package com.gig.gio.search_by_counterparty.di.components;

import com.gig.gio.search_by_counterparty.app.BaseActivity_MembersInjector;
import com.gig.gio.search_by_counterparty.di.modules.DetailModule;
import com.gig.gio.search_by_counterparty.di.modules.DetailModule_ProvideDetailViewFactory;
import com.gig.gio.search_by_counterparty.ui.detail.DetailActivity;
import com.gig.gio.search_by_counterparty.ui.detail.DetailActivity_MembersInjector;
import com.gig.gio.search_by_counterparty.ui.detail.DetailPresenterImpl;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerDetailComponent implements DetailComponent {
  private CounterpartyAppComponent counterpartyAppComponent;

  private DetailModule detailModule;

  private DaggerDetailComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.counterpartyAppComponent = builder.counterpartyAppComponent;
    this.detailModule = builder.detailModule;
  }

  @Override
  public void inject(DetailActivity detailActivity) {
    injectDetailActivity(detailActivity);
  }

  private DetailActivity injectDetailActivity(DetailActivity instance) {
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
    DetailActivity_MembersInjector.injectPresenter(
        instance,
        new DetailPresenterImpl(
            Preconditions.checkNotNull(
                DetailModule_ProvideDetailViewFactory.proxyProvideDetailView(detailModule),
                "Cannot return null from a non-@Nullable @Provides method")));
    return instance;
  }

  public static final class Builder {
    private DetailModule detailModule;

    private CounterpartyAppComponent counterpartyAppComponent;

    private Builder() {}

    public DetailComponent build() {
      if (detailModule == null) {
        throw new IllegalStateException(DetailModule.class.getCanonicalName() + " must be set");
      }
      if (counterpartyAppComponent == null) {
        throw new IllegalStateException(
            CounterpartyAppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerDetailComponent(this);
    }

    public Builder detailModule(DetailModule detailModule) {
      this.detailModule = Preconditions.checkNotNull(detailModule);
      return this;
    }

    public Builder counterpartyAppComponent(CounterpartyAppComponent counterpartyAppComponent) {
      this.counterpartyAppComponent = Preconditions.checkNotNull(counterpartyAppComponent);
      return this;
    }
  }
}
