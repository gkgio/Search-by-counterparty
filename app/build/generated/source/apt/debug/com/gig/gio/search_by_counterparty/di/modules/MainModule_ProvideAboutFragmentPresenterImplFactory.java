package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.about.AboutFragmentPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainModule_ProvideAboutFragmentPresenterImplFactory
    implements Factory<AboutFragmentPresenter> {
  private final MainModule module;

  public MainModule_ProvideAboutFragmentPresenterImplFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public AboutFragmentPresenter get() {
    return Preconditions.checkNotNull(
        module.provideAboutFragmentPresenterImpl(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AboutFragmentPresenter> create(MainModule module) {
    return new MainModule_ProvideAboutFragmentPresenterImplFactory(module);
  }

  public static AboutFragmentPresenter proxyProvideAboutFragmentPresenterImpl(MainModule instance) {
    return instance.provideAboutFragmentPresenterImpl();
  }
}
