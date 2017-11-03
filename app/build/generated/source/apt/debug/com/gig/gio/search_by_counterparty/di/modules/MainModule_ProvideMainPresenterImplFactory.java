package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.main.MainPresenter;
import com.gig.gio.search_by_counterparty.ui.main.MainView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainModule_ProvideMainPresenterImplFactory implements Factory<MainPresenter> {
  private final MainModule module;

  private final Provider<MainView> viewProvider;

  public MainModule_ProvideMainPresenterImplFactory(
      MainModule module, Provider<MainView> viewProvider) {
    this.module = module;
    this.viewProvider = viewProvider;
  }

  @Override
  public MainPresenter get() {
    return Preconditions.checkNotNull(
        module.provideMainPresenterImpl(viewProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MainPresenter> create(MainModule module, Provider<MainView> viewProvider) {
    return new MainModule_ProvideMainPresenterImplFactory(module, viewProvider);
  }

  public static MainPresenter proxyProvideMainPresenterImpl(MainModule instance, MainView view) {
    return instance.provideMainPresenterImpl(view);
  }
}
