package com.gig.gio.search_by_counterparty.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by georgy on 04.11.2017.
 * Gig
 */


public class Opf extends RealmObject implements Serializable {

    /** id */
    @PrimaryKey
    private long id;

    private String code;

    private String full;

    @SerializedName("short")
    private String shortOfp;


    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getFull() {
        return full;
    }

    public String getShortOfp() {
        return shortOfp;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public void setShortOfp(String shortOfp) {
        this.shortOfp = shortOfp;
    }
}
