package com.gig.gio.search_by_counterparty.ui.map;


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
    void setMarkers(List<MarkerOptions> markerOptionsList);
    void setMapZoom();
}
