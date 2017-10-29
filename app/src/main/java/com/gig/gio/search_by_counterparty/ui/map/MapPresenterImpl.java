package com.gig.gio.search_by_counterparty.ui.map;

import javax.inject.Inject;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

public class MapPresenterImpl implements MapPresenter {

    private MapView view;

    @Inject
    public MapPresenterImpl(MapView view) {
        this.view = view;
    }

}
