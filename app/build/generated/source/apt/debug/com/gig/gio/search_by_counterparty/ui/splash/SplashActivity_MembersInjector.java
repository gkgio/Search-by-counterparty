package com.gig.gio.search_by_counterparty.ui.splash;

import android.content.SharedPreferences;
import com.gig.gio.search_by_counterparty.app.BaseActivity_MembersInjector;
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
public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
  private final Provider<Gson> gsonProvider;

  private final Provider<SharedPreferences> preferencesProvider;

  private final Provider<Bus> busProvider;

  private final Provider<NetworkService> cachedNetworkServiceProvider;

  private final Provider<NetworkService> networkServiceProvider;

  private final Provider<SplashPresenterImpl> presenterProvider;

  public SplashActivity_MembersInjector(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> cachedNetworkServiceProvider,
      Provider<NetworkService> networkServiceProvider,
      Provider<SplashPresenterImpl> presenterProvider) {
    this.gsonProvider = gsonProvider;
    this.preferencesProvider = preferencesProvider;
    this.busProvider = busProvider;
    this.cachedNetworkServiceProvider = cachedNetworkServiceProvider;
    this.networkServiceProvider = networkServiceProvider;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<SplashActivity> create(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> cachedNetworkServiceProvider,
      Provider<NetworkService> networkServiceProvider,
      Provider<SplashPresenterImpl> presenterProvider) {
    return new SplashActivity_MembersInjector(
        gsonProvider,
        preferencesProvider,
        busProvider,
        cachedNetworkServiceProvider,
        networkServiceProvider,
        presenterProvider);
  }

  @Override
  public void injectMembers(SplashActivity instance) {
    BaseActivity_MembersInjector.injectGson(instance, gsonProvider.get());
    BaseActivity_MembersInjector.injectPreferences(instance, preferencesProvider.get());
    BaseActivity_MembersInjector.injectBus(instance, busProvider.get());
    BaseActivity_MembersInjector.injectCachedNetworkService(
        instance, cachedNetworkServiceProvider.get());
    BaseActivity_MembersInjector.injectNetworkService(instance, networkServiceProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectPresenter(SplashActivity instance, SplashPresenterImpl presenter) {
    instance.presenter = presenter;
  }
}
