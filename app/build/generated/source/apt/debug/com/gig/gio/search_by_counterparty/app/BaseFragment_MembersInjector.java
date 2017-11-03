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
public final class BaseFragment_MembersInjector implements MembersInjector<BaseFragment> {
  private final Provider<Gson> gsonProvider;

  private final Provider<SharedPreferences> preferencesProvider;

  private final Provider<Bus> busProvider;

  private final Provider<NetworkService> networkServiceProvider;

  private final Provider<NetworkService> cachedNetworkServiceProvider;

  public BaseFragment_MembersInjector(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> networkServiceProvider,
      Provider<NetworkService> cachedNetworkServiceProvider) {
    this.gsonProvider = gsonProvider;
    this.preferencesProvider = preferencesProvider;
    this.busProvider = busProvider;
    this.networkServiceProvider = networkServiceProvider;
    this.cachedNetworkServiceProvider = cachedNetworkServiceProvider;
  }

  public static MembersInjector<BaseFragment> create(
      Provider<Gson> gsonProvider,
      Provider<SharedPreferences> preferencesProvider,
      Provider<Bus> busProvider,
      Provider<NetworkService> networkServiceProvider,
      Provider<NetworkService> cachedNetworkServiceProvider) {
    return new BaseFragment_MembersInjector(
        gsonProvider,
        preferencesProvider,
        busProvider,
        networkServiceProvider,
        cachedNetworkServiceProvider);
  }

  @Override
  public void injectMembers(BaseFragment instance) {
    injectGson(instance, gsonProvider.get());
    injectPreferences(instance, preferencesProvider.get());
    injectBus(instance, busProvider.get());
    injectNetworkService(instance, networkServiceProvider.get());
    injectCachedNetworkService(instance, cachedNetworkServiceProvider.get());
  }

  public static void injectGson(BaseFragment instance, Gson gson) {
    instance.gson = gson;
  }

  public static void injectPreferences(BaseFragment instance, SharedPreferences preferences) {
    instance.preferences = preferences;
  }

  public static void injectBus(BaseFragment instance, Bus bus) {
    instance.bus = bus;
  }

  public static void injectNetworkService(BaseFragment instance, NetworkService networkService) {
    instance.networkService = networkService;
  }

  public static void injectCachedNetworkService(
      BaseFragment instance, NetworkService cachedNetworkService) {
    instance.cachedNetworkService = cachedNetworkService;
  }
}
