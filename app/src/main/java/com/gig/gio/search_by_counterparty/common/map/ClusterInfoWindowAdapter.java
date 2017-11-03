package com.gig.gio.search_by_counterparty.common.map;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.gig.gio.search_by_counterparty.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.Cluster;

import java.util.Collection;


/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class ClusterInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private Activity activity;
    private Cluster<MapItem> selectedCluster;

    public ClusterInfoWindowAdapter(Cluster<MapItem> selectedCluster, Activity activity) {
        this.activity = activity;
        this.selectedCluster = selectedCluster;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        if (selectedCluster != null) {
            View view = View.inflate(activity, R.layout.map_info_window, null);
            TextView info = (TextView) view.findViewById(R.id.tvMapInfo);

            StringBuilder stringBuilder = new StringBuilder();
            Collection<MapItem> items = selectedCluster.getItems();
            for (MapItem mapItem : items) {
                stringBuilder.append(mapItem.getTitle());
                stringBuilder.append("\n");
            }
            info.setText(stringBuilder.toString());
            return view;
        }
        return null;
    }
}
