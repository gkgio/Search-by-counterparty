package com.gig.gio.search_by_counterparty.common.eventbus.events;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class HttpErrorEvent {

    private final int code;

    public HttpErrorEvent(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
