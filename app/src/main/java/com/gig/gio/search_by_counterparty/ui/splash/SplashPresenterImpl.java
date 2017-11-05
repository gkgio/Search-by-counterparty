package com.gig.gio.search_by_counterparty.ui.splash;

import android.os.Handler;

import com.gig.gio.search_by_counterparty.common.Config;

import javax.inject.Inject;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class SplashPresenterImpl implements SplashPresenter {

    private SplashView view;

    @Inject
    public SplashPresenterImpl(SplashView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {

        // запускаем соответствующую активити после задержки
        new Handler().postDelayed(() -> {
            view.startMain();
            view.finishActivity();
        }, Config.SHOW_SPLASH_DELAY_MILLIS);
    }
}
