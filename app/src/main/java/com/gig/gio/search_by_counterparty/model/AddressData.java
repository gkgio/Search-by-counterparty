package com.gig.gio.search_by_counterparty.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by georgy on 03.11.2017.
 * Gig
 */

public class AddressData extends RealmObject implements Serializable {

    /** id */
    @PrimaryKey
    private long id;

    private double geo_lat;

    private double geo_lon;


    public long getId() {
        return id;
    }

    public double getGeo_lat() {
        return geo_lat;
    }

    public double getGeo_lon() {
        return geo_lon;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGeo_lat(double geo_lat) {
        this.geo_lat = geo_lat;
    }

    public void setGeo_lon(double geo_lon) {
        this.geo_lon = geo_lon;
    }
}
