package com.gig.gio.search_by_counterparty.app;

import android.content.SharedPreferences;
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
public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
  private final Provider<Gson> gsonProvider;

  private final Provider<SharedPreferences> preferencesProvider;

  private final Provider<Bus> busProvider;

  private final Provider<NetworkService> cachedNetworkServiceProvider;

  private final Provider<NetworkService> networkServiceProvider;

  public BaseActivity_MembersInjector(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> cachedNetworkServiceProvider,
      Provider<NetworkService> networkServiceProvider) {
    this.gsonProvider = gsonProvider;
    this.preferencesProvider = preferencesProvider;
    this.busProvider = busProvider;
    this.cachedNetworkServiceProvider = cachedNetworkServiceProvider;
    this.networkServiceProvider = networkServiceProvider;
  }

  public static MembersInjector<BaseActivity> create(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> cachedNetworkServiceProvider,
      Provider<NetworkService> networkServiceProvider) {
    return new BaseActivity_MembersInjector(
        gsonProvider,
        preferencesProvider,
        busProvider,
        cachedNetworkServiceProvider,
        networkServiceProvider);
  }

  @Override
  public void injectMembers(BaseActivity instance) {
    injectGson(instance, gsonProvider.get());
    injectPreferences(instance, preferencesProvider.get());
    injectBus(instance, busProvider.get());
    injectCachedNetworkService(instance, cachedNetworkServiceProvider.get());
    injectNetworkService(instance, networkServiceProvider.get());
  }

  public static void injectGson(BaseActivity instance, Gson gson) {
    instance.gson = gson;
  }

  public static void injectPreferences(BaseActivity instance, SharedPreferences preferences) {
    instance.preferences = preferences;
  }

  public static void injectBus(BaseActivity instance, Bus bus) {
    instance.bus = bus;
  }

  public static void injectCachedNetworkService(
      BaseActivity instance, NetworkService cachedNetworkService) {
    instance.cachedNetworkService = cachedNetworkService;
  }

  public static void injectNetworkService(BaseActivity instance, NetworkService networkService) {
    instance.networkService = networkService;
  }
}
