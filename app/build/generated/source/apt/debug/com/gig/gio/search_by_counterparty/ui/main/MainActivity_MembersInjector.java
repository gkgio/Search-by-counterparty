package com.gig.gio.search_by_counterparty.ui.main;

import android.content.SharedPreferences;
import com.gig.gio.search_by_counterparty.app.BaseActivity_MembersInjector;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;
import com.tbruyelle.rxpermissions.RxPermissions;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<Gson> gsonProvider;

  private final Provider<SharedPreferences> preferencesProvider;

  private final Provider<Bus> busProvider;

  private final Provider<NetworkService> cachedNetworkServiceProvider;

  private final Provider<NetworkService> networkServiceProvider;

  private final Provider<MainPresenterImpl> presenterProvider;

  private final Provider<RxPermissions> rxPermissionsProvider;

  public MainActivity_MembersInjector(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> cachedNetworkServiceProvider,
      Provider<NetworkService> networkServiceProvider,
      Provider<MainPresenterImpl> presenterProvider,
      Provider<RxPermissions> rxPermissionsProvider) {
    this.gsonProvider = gsonProvider;
    this.preferencesProvider = preferencesProvider;
    this.busProvider = busProvider;
    this.cachedNetworkServiceProvider = cachedNetworkServiceProvider;
    this.networkServiceProvider = networkServiceProvider;
    this.presenterProvider = presenterProvider;
    this.rxPermissionsProvider = rxPermissionsProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> cachedNetworkServiceProvider,
      Provider<NetworkService> networkServiceProvider,
      Provider<MainPresenterImpl> presenterProvider,
      Provider<RxPermissions> rxPermissionsProvider) {
    return new MainActivity_MembersInjector(
        gsonProvider,
        preferencesProvider,
        busProvider,
        cachedNetworkServiceProvider,
        networkServiceProvider,
        presenterProvider,
        rxPermissionsProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    BaseActivity_MembersInjector.injectGson(instance, gsonProvider.get());
    BaseActivity_MembersInjector.injectPreferences(instance, preferencesProvider.get());
    BaseActivity_MembersInjector.injectBus(instance, busProvider.get());
    BaseActivity_MembersInjector.injectCachedNetworkService(
        instance, cachedNetworkServiceProvider.get());
    BaseActivity_MembersInjector.injectNetworkService(instance, networkServiceProvider.get());
    injectPresenter(instance, presenterProvider.get());
    injectRxPermissions(instance, rxPermissionsProvider.get());
  }

  public static void injectPresenter(MainActivity instance, MainPresenterImpl presenter) {
    instance.presenter = presenter;
  }

  public static void injectRxPermissions(MainActivity instance, RxPermissions rxPermissions) {
    instance.rxPermissions = rxPermissions;
  }
}
