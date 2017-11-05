package com.gig.gio.search_by_counterparty.di.components;

import com.gig.gio.search_by_counterparty.di.ActivityScope;
import com.gig.gio.search_by_counterparty.di.modules.BookmarksModule;
import com.gig.gio.search_by_counterparty.ui.bookmarks.BookmarksActivity;

import dagger.Component;

/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

@ActivityScope
@Component(
        dependencies = CounterpartyAppComponent.class,
        modules = BookmarksModule.class
)
public interface BookmarksComponent {
    void inject(BookmarksActivity bookMarksActivity);
}
