package com.gig.gio.search_by_counterparty.common.map;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class MapItem implements ClusterItem {

    private final LatLng position;
    private final String title;
    private final String snippetId;

    public MapItem(double lat, double lng, String title, String snippetId) {
        this.title = title;
        position = new LatLng(lat, lng);
        this.snippetId = snippetId;
    }

    @Override
    public LatLng getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getSnippet() {
        return snippetId;
    }
}
