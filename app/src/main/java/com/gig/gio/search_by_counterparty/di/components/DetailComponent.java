package com.gig.gio.search_by_counterparty.di.components;

import com.gig.gio.search_by_counterparty.di.ActivityScope;
import com.gig.gio.search_by_counterparty.di.modules.DetailModule;
import com.gig.gio.search_by_counterparty.ui.detail.DetailActivity;

import dagger.Component;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

@ActivityScope
@Component(
        dependencies = CounterpartyAppComponent.class,
        modules = DetailModule.class
)
public interface DetailComponent {
    void inject(DetailActivity detailActivity);
}
