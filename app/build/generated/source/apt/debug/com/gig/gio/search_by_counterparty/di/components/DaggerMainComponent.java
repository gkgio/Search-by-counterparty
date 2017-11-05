package com.gig.gio.search_by_counterparty.di.components;

import com.gig.gio.search_by_counterparty.app.BaseActivity_MembersInjector;
import com.gig.gio.search_by_counterparty.app.BaseFragment_MembersInjector;
import com.gig.gio.search_by_counterparty.di.modules.MainModule;
import com.gig.gio.search_by_counterparty.di.modules.MainModule_ProvideAboutFragmentPresenterImplFactory;
import com.gig.gio.search_by_counterparty.di.modules.MainModule_ProvideMainViewFactory;
import com.gig.gio.search_by_counterparty.di.modules.MainModule_ProvideRxPermissionsFactory;
import com.gig.gio.search_by_counterparty.di.modules.MainModule_ProvideSearchFragmentPresenterImplFactory;
import com.gig.gio.search_by_counterparty.ui.main.MainActivity;
import com.gig.gio.search_by_counterparty.ui.main.MainActivity_MembersInjector;
import com.gig.gio.search_by_counterparty.ui.main.MainPresenterImpl;
import com.gig.gio.search_by_counterparty.ui.main.about.AboutFragment;
import com.gig.gio.search_by_counterparty.ui.main.about.AboutFragment_MembersInjector;
import com.gig.gio.search_by_counterparty.ui.main.search.SearchFragment;
import com.gig.gio.search_by_counterparty.ui.main.search.SearchFragment_MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMainComponent implements MainComponent {
  private CounterpartyAppComponent counterpartyAppComponent;

  private MainModule mainModule;

  private DaggerMainComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.counterpartyAppComponent = builder.counterpartyAppComponent;
    this.mainModule = builder.mainModule;
  }

  @Override
  public void inject(MainActivity mainActivity) {
    injectMainActivity(mainActivity);
  }

  @Override
  public void inject(AboutFragment aboutFragment) {
    injectAboutFragment(aboutFragment);
  }

  @Override
  public void inject(SearchFragment searchFragment) {
    injectSearchFragment(searchFragment);
  }

  private MainActivity injectMainActivity(MainActivity instance) {
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
    MainActivity_MembersInjector.injectPresenter(
        instance,
        new MainPresenterImpl(
            Preconditions.checkNotNull(
                MainModule_ProvideMainViewFactory.proxyProvideMainView(mainModule),
                "Cannot return null from a non-@Nullable @Provides method")));
    MainActivity_MembersInjector.injectRxPermissions(
        instance,
        Preconditions.checkNotNull(
            MainModule_ProvideRxPermissionsFactory.proxyProvideRxPermissions(mainModule),
            "Cannot return null from a non-@Nullable @Provides method"));
    return instance;
  }

  private AboutFragment injectAboutFragment(AboutFragment instance) {
    BaseFragment_MembersInjector.injectGson(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.gson(),
            "Cannot return null from a non-@Nullable component method"));
    BaseFragment_MembersInjector.injectPreferences(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.sharedPreferences(),
            "Cannot return null from a non-@Nullable component method"));
    BaseFragment_MembersInjector.injectBus(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.eventBus(),
            "Cannot return null from a non-@Nullable component method"));
    BaseFragment_MembersInjector.injectNetworkService(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.mobukNoCachedService(),
            "Cannot return null from a non-@Nullable component method"));
    BaseFragment_MembersInjector.injectCachedNetworkService(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.mobukCachedService(),
            "Cannot return null from a non-@Nullable component method"));
    AboutFragment_MembersInjector.injectPresenter(
        instance,
        Preconditions.checkNotNull(
            MainModule_ProvideAboutFragmentPresenterImplFactory
                .proxyProvideAboutFragmentPresenterImpl(mainModule),
            "Cannot return null from a non-@Nullable @Provides method"));
    return instance;
  }

  private SearchFragment injectSearchFragment(SearchFragment instance) {
    BaseFragment_MembersInjector.injectGson(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.gson(),
            "Cannot return null from a non-@Nullable component method"));
    BaseFragment_MembersInjector.injectPreferences(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.sharedPreferences(),
            "Cannot return null from a non-@Nullable component method"));
    BaseFragment_MembersInjector.injectBus(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.eventBus(),
            "Cannot return null from a non-@Nullable component method"));
    BaseFragment_MembersInjector.injectNetworkService(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.mobukNoCachedService(),
            "Cannot return null from a non-@Nullable component method"));
    BaseFragment_MembersInjector.injectCachedNetworkService(
        instance,
        Preconditions.checkNotNull(
            counterpartyAppComponent.mobukCachedService(),
            "Cannot return null from a non-@Nullable component method"));
    SearchFragment_MembersInjector.injectPresenter(
        instance,
        Preconditions.checkNotNull(
            MainModule_ProvideSearchFragmentPresenterImplFactory
                .proxyProvideSearchFragmentPresenterImpl(mainModule),
            "Cannot return null from a non-@Nullable @Provides method"));
    return instance;
  }

  public static final class Builder {
    private MainModule mainModule;

    private CounterpartyAppComponent counterpartyAppComponent;

    private Builder() {}

    public MainComponent build() {
      if (mainModule == null) {
        throw new IllegalStateException(MainModule.class.getCanonicalName() + " must be set");
      }
      if (counterpartyAppComponent == null) {
        throw new IllegalStateException(
            CounterpartyAppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerMainComponent(this);
    }

    public Builder mainModule(MainModule mainModule) {
      this.mainModule = Preconditions.checkNotNull(mainModule);
      return this;
    }

    public Builder counterpartyAppComponent(CounterpartyAppComponent counterpartyAppComponent) {
      this.counterpartyAppComponent = Preconditions.checkNotNull(counterpartyAppComponent);
      return this;
    }
  }
}
