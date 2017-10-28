package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.about.AboutFragmentPresenter;
import com.gig.gio.search_by_counterparty.ui.main.MainActivity;
import com.gig.gio.search_by_counterparty.ui.main.MainPresenter;
import com.gig.gio.search_by_counterparty.ui.main.MainPresenterImpl;
import com.gig.gio.search_by_counterparty.ui.main.MainView;
import com.tbruyelle.rxpermissions.RxPermissions;

import dagger.Module;
import dagger.Provides;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

@Module
public class MainModule {

    private MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    /** Provide MainView */
    @Provides
    MainView provideMainView() {
        return activity;
    }

    /** Provide MainPresenterImpl */
    @Provides
    MainPresenter provideMainPresenterImpl(MainView view) {
        return new MainPresenterImpl(view);
    }

    /** Provide AboutFragmentPresenter */
   /* @Provides
    AboutFragmentPresenter provideAboutFragmentPresenter() {
        return new AboutFragmentPresenter();
    }*/

    @Provides
    RxPermissions provideRxPermissions() {
        return new RxPermissions(activity);
    }
}
