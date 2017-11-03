package com.gig.gio.search_by_counterparty.ui.map;


import android.location.Location;

import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public interface MapView{
    void showProgress();
    void hideProgress();
    void showMessage(int message, @ToastType int type);
    void setCurrentPosition(Location location);
    void setMarkers(List<MarkerOptions> markerOptionses);
    void setMapZoom();
}
