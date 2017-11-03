package com.gig.gio.search_by_counterparty.ui.detail;

import android.os.Bundle;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseActivity;
import com.gig.gio.search_by_counterparty.di.HasComponent;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerDetailComponent;
import com.gig.gio.search_by_counterparty.di.components.DetailComponent;
import com.gig.gio.search_by_counterparty.di.modules.DetailModule;

import javax.inject.Inject;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

public class DetailActivity extends BaseActivity implements HasComponent<DetailComponent>, DetailView{

    @Inject
    public DetailPresenterImpl presenter;

    private DetailComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    }

    //=======--------- DetailView impelement metod START ---------=========




    //=======--------- DetailView impelement metod END ---------=========

    // BaseActivity extended method =========
    @Override
    protected void setupComponent(CounterpartyAppComponent appComponent) {
        component = DaggerDetailComponent.builder()
                .counterpartyAppComponent(appComponent)
                .detailModule(new DetailModule(this))
                .build();
        component.inject(this);
    }

    // HasComponent implement method =========
    @Override
    public DetailComponent getComponent() {
        return component;
    }
}

