package com.gig.gio.search_by_counterparty.ui.map;

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
public final class MapActivity_MembersInjector implements MembersInjector<MapActivity> {
  private final Provider<Gson> gsonProvider;

  private final Provider<SharedPreferences> preferencesProvider;

  private final Provider<Bus> busProvider;

  private final Provider<NetworkService> cachedNetworkServiceProvider;

  private final Provider<NetworkService> networkServiceProvider;

  private final Provider<MapPresenterImpl> presenterProvider;

  public MapActivity_MembersInjector(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> cachedNetworkServiceProvider,
      Provider<NetworkService> networkServiceProvider,
      Provider<MapPresenterImpl> presenterProvider) {
    this.gsonProvider = gsonProvider;
    this.preferencesProvider = preferencesProvider;
    this.busProvider = busProvider;
    this.cachedNetworkServiceProvider = cachedNetworkServiceProvider;
    this.networkServiceProvider = networkServiceProvider;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<MapActivity> create(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> cachedNetworkServiceProvider,
      Provider<NetworkService> networkServiceProvider,
      Provider<MapPresenterImpl> presenterProvider) {
    return new MapActivity_MembersInjector(
        gsonProvider,
        preferencesProvider,
        busProvider,
        cachedNetworkServiceProvider,
        networkServiceProvider,
        presenterProvider);
  }

  @Override
  public void injectMembers(MapActivity instance) {
    BaseActivity_MembersInjector.injectGson(instance, gsonProvider.get());
    BaseActivity_MembersInjector.injectPreferences(instance, preferencesProvider.get());
    BaseActivity_MembersInjector.injectBus(instance, busProvider.get());
    BaseActivity_MembersInjector.injectCachedNetworkService(
        instance, cachedNetworkServiceProvider.get());
    BaseActivity_MembersInjector.injectNetworkService(instance, networkServiceProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectPresenter(MapActivity instance, MapPresenterImpl presenter) {
    instance.presenter = presenter;
  }
}
