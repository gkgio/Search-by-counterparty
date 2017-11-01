package com.gig.gio.search_by_counterparty.di.components;

import com.gig.gio.search_by_counterparty.di.ActivityScope;
import com.gig.gio.search_by_counterparty.di.modules.MainModule;
import com.gig.gio.search_by_counterparty.ui.about.AboutFragment;
import com.gig.gio.search_by_counterparty.ui.main.MainActivity;

import dagger.Component;


/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

@ActivityScope
@Component(
        dependencies = CounterpartyAppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {
    void inject(MainActivity mainActivity);

    void inject(AboutFragment aboutFragment);
}
