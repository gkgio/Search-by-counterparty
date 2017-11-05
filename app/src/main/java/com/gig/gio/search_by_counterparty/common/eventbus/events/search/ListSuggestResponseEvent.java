package com.gig.gio.search_by_counterparty.common.eventbus.events.search;

import com.gig.gio.search_by_counterparty.model.SuggestResponse;

import java.util.List;

/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

public class ListSuggestResponseEvent {
    private final List<SuggestResponse> suggestResponseList;
    private final SuggestResponse suggestResponse;

    public ListSuggestResponseEvent(List<SuggestResponse> suggestResponseList, final SuggestResponse suggestResponse) {
        this.suggestResponseList = suggestResponseList;
        this.suggestResponse = suggestResponse;
    }

    public List<SuggestResponse> getSuggestResponseList() {
        return suggestResponseList;
    }

    public SuggestResponse getSuggestResponse() {
        return suggestResponse;
    }
}
