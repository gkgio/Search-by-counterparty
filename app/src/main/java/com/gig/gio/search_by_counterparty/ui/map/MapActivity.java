package com.gig.gio.search_by_counterparty.ui.map;

import android.os.Bundle;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseActivity;
import com.gig.gio.search_by_counterparty.di.HasComponent;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerMapComponent;
import com.gig.gio.search_by_counterparty.di.components.MapComponent;
import com.gig.gio.search_by_counterparty.di.modules.MapModule;

import javax.inject.Inject;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public class MapActivity extends BaseActivity implements HasComponent<MapComponent>, MapView{

    @Inject
    public MapPresenterImpl presenter;

    private MapComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

    }

    //=======--------- MapView impelement metod START ---------=========




    //=======--------- MapView impelement metod END ---------=========

    // BaseActivity extended method =========
    @Override
    protected void setupComponent(CounterpartyAppComponent appComponent) {
        component = DaggerMapComponent.builder()
                .counterpartyAppComponent(appComponent)
                .mapModule(new MapModule(this))
                .build();
        component.inject(this);
    }

    // HasComponent implement method =========
    @Override
    public MapComponent getComponent() {
        return component;
    }
}
