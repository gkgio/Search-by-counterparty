package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.main.MainView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainModule_ProvideMainViewFactory implements Factory<MainView> {
  private final MainModule module;

  public MainModule_ProvideMainViewFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public MainView get() {
    return Preconditions.checkNotNull(
        module.provideMainView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MainView> create(MainModule module) {
    return new MainModule_ProvideMainViewFactory(module);
  }

  public static MainView proxyProvideMainView(MainModule instance) {
    return instance.provideMainView();
  }
}
