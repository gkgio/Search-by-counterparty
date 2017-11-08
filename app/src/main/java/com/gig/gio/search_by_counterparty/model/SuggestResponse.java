package com.gig.gio.search_by_counterparty.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

public class SuggestResponse extends RealmObject implements Serializable {

    /** id */
    @PrimaryKey
    private long id;

    private String value;

    private String unrestricted_value;

    @SerializedName("data")
    private Data data;

    private boolean isBookmark;


    public long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getUnrestricted_value() {
        return unrestricted_value;
    }

    public Data getData() {
        return data;
    }

    public boolean isBookmark() {
        return isBookmark;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setUnrestricted_value(String unrestricted_value) {
        this.unrestricted_value = unrestricted_value;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setBookmark(boolean bookmark) {
        isBookmark = bookmark;
    }
}
