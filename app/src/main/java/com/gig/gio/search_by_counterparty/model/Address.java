package com.gig.gio.search_by_counterparty.model;

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
    private String id;
}
