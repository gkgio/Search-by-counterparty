package com.gig.gio.search_by_counterparty.common.eventbus.events.search;

import com.gig.gio.search_by_counterparty.model.ResponseData;

/**
 * Created by georgy on 01.11.2017.
 * Gig
 */

public class ResponseDataEvent {
    private final ResponseData responseData;

    public ResponseDataEvent(ResponseData responseData) {
        this.responseData = responseData;
    }

    public ResponseData getResponseData() {
        return responseData;
    }
}
