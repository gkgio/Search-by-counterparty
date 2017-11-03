package com.gig.gio.search_by_counterparty.ui.about;

import android.content.SharedPreferences;
import com.gig.gio.search_by_counterparty.app.BaseFragment_MembersInjector;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AboutFragment_MembersInjector implements MembersInjector<AboutFragment> {
  private final Provider<Gson> gsonProvider;

  private final Provider<SharedPreferences> preferencesProvider;

  private final Provider<Bus> busProvider;

  private final Provider<NetworkService> networkServiceProvider;

  private final Provider<NetworkService> cachedNetworkServiceProvider;

  private final Provider<AboutFragmentPresenter> presenterProvider;

  public AboutFragment_MembersInjector(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> networkServiceProvider,
      Provider<NetworkService> cachedNetworkServiceProvider,
      Provider<AboutFragmentPresenter> presenterProvider) {
    this.gsonProvider = gsonProvider;
    this.preferencesProvider = preferencesProvider;
    this.busProvider = busProvider;
    this.networkServiceProvider = networkServiceProvider;
    this.cachedNetworkServiceProvider = cachedNetworkServiceProvider;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<AboutFragment> create(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> networkServiceProvider,
      Provider<NetworkService> cachedNetworkServiceProvider,
      Provider<AboutFragmentPresenter> presenterProvider) {
    return new AboutFragment_MembersInjector(
        gsonProvider,
        preferencesProvider,
        busProvider,
        networkServiceProvider,
        cachedNetworkServiceProvider,
        presenterProvider);
  }

  @Override
  public void injectMembers(AboutFragment instance) {
    BaseFragment_MembersInjector.injectGson(instance, gsonProvider.get());
    BaseFragment_MembersInjector.injectPreferences(instance, preferencesProvider.get());
    BaseFragment_MembersInjector.injectBus(instance, busProvider.get());
    BaseFragment_MembersInjector.injectNetworkService(instance, networkServiceProvider.get());
    BaseFragment_MembersInjector.injectCachedNetworkService(
        instance, cachedNetworkServiceProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectPresenter(AboutFragment instance, AboutFragmentPresenter presenter) {
    instance.presenter = presenter;
  }
}
