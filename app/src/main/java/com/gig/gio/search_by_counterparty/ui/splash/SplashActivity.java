package com.gig.gio.search_by_counterparty.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseActivity;
import com.gig.gio.search_by_counterparty.di.HasComponent;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerSplashComponent;
import com.gig.gio.search_by_counterparty.di.components.SplashComponent;
import com.gig.gio.search_by_counterparty.di.modules.SplashModule;
import com.gig.gio.search_by_counterparty.ui.main.MainActivity;

import javax.inject.Inject;


public class SplashActivity extends BaseActivity implements HasComponent<SplashComponent>, SplashView {

    @Inject
    public SplashPresenterImpl presenter;

    private SplashComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter.onCreate();
    }

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
        overridePendingTransition(R.anim.fade_in_activity, R.anim.fade_out_activity);
    }

    //=======--------- SplashView impelement metod END ---------=========

    // BaseActivity extended method =========
    @Override
    protected void setupComponent(CounterpartyAppComponent appComponent) {
        component = DaggerSplashComponent.builder()
                .counterpartyAppComponent(appComponent)
                .splashModule(new SplashModule(this))
                .build();
        component.inject(this);
    }

    // HasComponent implement method =========
    @Override
    public SplashComponent getComponent() {
        return component;
    }
}
