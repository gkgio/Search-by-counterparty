package com.gig.gio.search_by_counterparty.common.eventbus.events.bookmarks;

import com.gig.gio.search_by_counterparty.model.SuggestResponse;

import java.util.List;

/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

public class ListSuggestResponseEvent {
    private final List<SuggestResponse> suggestResponseList;

    public ListSuggestResponseEvent(List<SuggestResponse> suggestResponseList) {
        this.suggestResponseList = suggestResponseList;
    }

    public List<SuggestResponse> getSuggestResponseList() {
        return suggestResponseList;
    }
}
