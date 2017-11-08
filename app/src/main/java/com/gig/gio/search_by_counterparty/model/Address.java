package com.gig.gio.search_by_counterparty.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

public class Address extends RealmObject implements Serializable {

    /** id */
    @PrimaryKey
    private long id;

    private String value;

    @SerializedName("data")
    private AddressData AddressData;


    public long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public com.gig.gio.search_by_counterparty.model.AddressData getAddressData() {
        return AddressData;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setAddressData(com.gig.gio.search_by_counterparty.model.AddressData addressData) {
        AddressData = addressData;
    }
}
