package com.gig.gio.search_by_counterparty.common.eventbus.events.bookmarks;

import com.gig.gio.search_by_counterparty.model.SuggestResponse;

/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

public class SuggestResponseAdapterEvent {
    private final SuggestResponse suggestResponse;

    public SuggestResponseAdapterEvent(final SuggestResponse suggestResponse) {
        this.suggestResponse = suggestResponse;
    }

    public SuggestResponse getSuggestResponse() {
        return suggestResponse;
    }
}
