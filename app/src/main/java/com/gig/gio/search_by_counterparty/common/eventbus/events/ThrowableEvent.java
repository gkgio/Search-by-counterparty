package com.gig.gio.search_by_counterparty.common.eventbus.events;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class ThrowableEvent {

    private final Throwable trowable;

    public ThrowableEvent(Throwable trowable) {
        this.trowable = trowable;
    }

    public Throwable getTrowable() {
        return trowable;
    }
}
