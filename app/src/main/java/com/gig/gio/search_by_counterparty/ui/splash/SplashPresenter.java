package com.gig.gio.search_by_counterparty.ui.splash;

import android.os.Handler;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.gig.gio.search_by_counterparty.common.Config;

import javax.inject.Inject;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {


    @Inject
    SplashPresenter() {

    }

    void startWithDelay() {
        // запускаем соответствующую активити после задержки
        new Handler().postDelayed((() -> {
            getViewState().startMain();
            getViewState().finishActivity();
        }), Config.SHOW_SPLASH_DELAY_MILLIS);
    }
}
