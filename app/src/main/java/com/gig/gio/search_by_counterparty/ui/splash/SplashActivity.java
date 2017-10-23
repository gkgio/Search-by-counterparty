package com.gig.gio.search_by_counterparty.ui.splash;

import android.content.Intent;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseActivity;
import com.gig.gio.search_by_counterparty.app.CounterpartyApp;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.ui.main.MainActivity;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class SplashActivity extends MvpAppCompatActivity implements SplashView{

    @InjectPresenter
    SplashPresenter splashPresenter;

   /* @ProvidePresenter
    SplashPresenter providePresenter() {
        return CounterpartyApp.get(this).createSplashPresenter();
    }*/


    //=======--------- SplashView impelement metod START ---------=========

    @Override
    public void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void finishActivity() {
        finish();
        // включаем анимацию при закрытии заставки - исчезновение
        //overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
        overridePendingTransition(R.anim.fade_in_activity, R.anim.fade_out_activity);
    }

    //=======--------- SplashView impelement metod END ---------=========
}
