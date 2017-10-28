package com.gig.gio.search_by_counterparty.di.components;

import com.gig.gio.search_by_counterparty.di.ActivityScope;
import com.gig.gio.search_by_counterparty.di.modules.SplashModule;
import com.gig.gio.search_by_counterparty.ui.splash.SplashActivity;

import dagger.Component;


/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

@ActivityScope
@Component(
        dependencies = CounterpartyAppComponent.class,
        modules = SplashModule.class
)
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}
