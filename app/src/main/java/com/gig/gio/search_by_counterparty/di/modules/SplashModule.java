package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.splash.SplashActivity;
import com.gig.gio.search_by_counterparty.ui.splash.SplashPresenter;
import com.gig.gio.search_by_counterparty.ui.splash.SplashPresenterImpl;
import com.gig.gio.search_by_counterparty.ui.splash.SplashView;

import dagger.Module;
import dagger.Provides;


/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

@Module
public class SplashModule {

    private SplashActivity activity;

    public SplashModule(SplashActivity activity) {
        this.activity = activity;
    }

    /** Provide SplashView */
    @Provides
    SplashView provideSplashView() {
        return activity;
    }

    /** Provide SplashPresenterImpl */
    @Provides
    SplashPresenter provideSplashPresenterImpl(SplashView view) {
        return new SplashPresenterImpl(view);
    }
}
