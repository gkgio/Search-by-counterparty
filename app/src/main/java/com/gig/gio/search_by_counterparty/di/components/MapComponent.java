package com.gig.gio.search_by_counterparty.di.components;

import com.gig.gio.search_by_counterparty.di.ActivityScope;
import com.gig.gio.search_by_counterparty.di.modules.MapModule;
import com.gig.gio.search_by_counterparty.ui.map.MapActivity;

import dagger.Component;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

@ActivityScope
@Component(
        dependencies = CounterpartyAppComponent.class,
        modules = MapModule.class
)
public interface MapComponent {
    void inject(MapActivity mapActivity);
}
