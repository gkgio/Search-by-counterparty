package com.gig.gio.search_by_counterparty.ui.splash;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SplashView extends MvpView{
    void startMain();

    void finishActivity();
}
