package com.gig.gio.search_by_counterparty.ui.detail;

import javax.inject.Inject;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

public class DetailPresenterImpl implements DetailPresenter{

    private DetailView view;

    @Inject
    public DetailPresenterImpl(DetailView view) {
        this.view = view;
    }
}
