package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.detail.DetailPresenter;
import com.gig.gio.search_by_counterparty.ui.detail.DetailView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DetailModule_ProvideDetailPresenterImplFactory
    implements Factory<DetailPresenter> {
  private final DetailModule module;

  private final Provider<DetailView> viewProvider;

  public DetailModule_ProvideDetailPresenterImplFactory(
      DetailModule module, Provider<DetailView> viewProvider) {
    this.module = module;
    this.viewProvider = viewProvider;
  }

  @Override
  public DetailPresenter get() {
    return Preconditions.checkNotNull(
        module.provideDetailPresenterImpl(viewProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DetailPresenter> create(
      DetailModule module, Provider<DetailView> viewProvider) {
    return new DetailModule_ProvideDetailPresenterImplFactory(module, viewProvider);
  }

  public static DetailPresenter proxyProvideDetailPresenterImpl(
      DetailModule instance, DetailView view) {
    return instance.provideDetailPresenterImpl(view);
  }
}
