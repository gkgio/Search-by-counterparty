package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.detail.DetailActivity;
import com.gig.gio.search_by_counterparty.ui.detail.DetailPresenter;
import com.gig.gio.search_by_counterparty.ui.detail.DetailPresenterImpl;
import com.gig.gio.search_by_counterparty.ui.detail.DetailView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

@Module
public class DetailModule {
    private DetailActivity activity;

    public DetailModule(DetailActivity activity) {
        this.activity = activity;
    }

    /** Provide DetailView */
    @Provides
    DetailView provideDetailView() {
        return activity;
    }

    /** Provide DetailPresenterImpl */
    @Provides
    DetailPresenter provideDetailPresenterImpl(DetailView view) {
        return new DetailPresenterImpl(view);
    }
}
