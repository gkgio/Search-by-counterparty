package com.gig.gio.search_by_counterparty.common;

import io.realm.RealmObject;

/**
 * Created by g.gigauri on 20.09.2017.
 * Gig
 */

public class LongWrapper extends RealmObject {

    private long value;

    public LongWrapper(long value) {
        this.value = value;
    }

    public LongWrapper() {

    }

    public long getValue() {
        return value;
    }
}
