package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.map.MapActivity;
import com.gig.gio.search_by_counterparty.ui.map.MapPresenter;
import com.gig.gio.search_by_counterparty.ui.map.MapPresenterImpl;
import com.gig.gio.search_by_counterparty.ui.map.MapView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

@Module
public class MapModule {
    private MapActivity activity;

    public MapModule(MapActivity activity) {
        this.activity = activity;
    }

    /** Provide MapView */
    @Provides
    MapView provideMapView() {
        return activity;
    }

    /** Provide MapPresenterImpl */
    @Provides
    MapPresenter provideMapPresenterImpl(MapView view) {
        return new MapPresenterImpl(view);
    }
}
