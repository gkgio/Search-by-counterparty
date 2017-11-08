package com.gig.gio.search_by_counterparty.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by georgy on 04.11.2017.
 * Gig
 */

public class State extends RealmObject implements Serializable {

    /** id */
    @PrimaryKey
    private long id;

    private String status;

    private String registration_date;


    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
}
