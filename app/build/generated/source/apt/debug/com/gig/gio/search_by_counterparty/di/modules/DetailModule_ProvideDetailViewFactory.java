package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.detail.DetailView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DetailModule_ProvideDetailViewFactory implements Factory<DetailView> {
  private final DetailModule module;

  public DetailModule_ProvideDetailViewFactory(DetailModule module) {
    this.module = module;
  }

  @Override
  public DetailView get() {
    return Preconditions.checkNotNull(
        module.provideDetailView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DetailView> create(DetailModule module) {
    return new DetailModule_ProvideDetailViewFactory(module);
  }

  public static DetailView proxyProvideDetailView(DetailModule instance) {
    return instance.provideDetailView();
  }
}
