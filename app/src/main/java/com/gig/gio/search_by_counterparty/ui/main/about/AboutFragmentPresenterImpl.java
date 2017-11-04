package com.gig.gio.search_by_counterparty.ui.main.about;

import javax.inject.Inject;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

public class AboutFragmentPresenterImpl implements AboutFragmentPresenter {

    private AboutFragmentView view;

    @Inject
    public AboutFragmentPresenterImpl() {
    }

    @Override
    public void init(AboutFragmentView view) {
        this.view = view;
    }
}
