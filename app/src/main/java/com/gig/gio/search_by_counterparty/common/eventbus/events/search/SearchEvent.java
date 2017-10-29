package com.gig.gio.search_by_counterparty.common.eventbus.events.search;

import com.gig.gio.search_by_counterparty.model.SuggestResponse;

import java.util.List;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

public class SearchEvent {
    private final List<SuggestResponse> suggests;

    public SearchEvent(List<SuggestResponse> suggests) {
        this.suggests = suggests;
    }

    public List<SuggestResponse> getSuggests() {
        return suggests;
    }
}
