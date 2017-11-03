package com.gig.gio.search_by_counterparty.ui.about;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AboutFragmentPresenterImpl_Factory
    implements Factory<AboutFragmentPresenterImpl> {
  private static final AboutFragmentPresenterImpl_Factory INSTANCE =
      new AboutFragmentPresenterImpl_Factory();

  @Override
  public AboutFragmentPresenterImpl get() {
    return new AboutFragmentPresenterImpl();
  }

  public static Factory<AboutFragmentPresenterImpl> create() {
    return INSTANCE;
  }
}
