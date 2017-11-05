package com.gig.gio.search_by_counterparty.di.modules;

import com.gig.gio.search_by_counterparty.ui.bookmarks.BookmarksActivity;
import com.gig.gio.search_by_counterparty.ui.bookmarks.BookmarksPresenter;
import com.gig.gio.search_by_counterparty.ui.bookmarks.BookmarksPresenterImpl;
import com.gig.gio.search_by_counterparty.ui.bookmarks.BookmarksView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

@Module
public class BookmarksModule {
    private BookmarksActivity activity;

    public BookmarksModule(BookmarksActivity activity) {
        this.activity = activity;
    }

    /**
     * Provide BookmarksView
     */
    @Provides
    BookmarksView provideMapView() {
        return activity;
    }

    /**
     * Provide BookmarksPresenterImpl
     */
    @Provides
    BookmarksPresenter provideMapPresenterImpl(BookmarksView view) {
        return new BookmarksPresenterImpl(view);
    }
}