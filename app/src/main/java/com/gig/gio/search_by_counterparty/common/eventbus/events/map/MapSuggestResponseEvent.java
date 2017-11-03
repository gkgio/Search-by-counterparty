package com.gig.gio.search_by_counterparty.common.eventbus.events.map;

import com.gig.gio.search_by_counterparty.model.SuggestResponse;

import java.util.List;

/**
 * Created by georgy on 03.11.2017.
 * Gig
 */

public class MapSuggestResponseEvent {
    private final List<SuggestResponse> suggestResponseList;

    public MapSuggestResponseEvent(List<SuggestResponse> suggestResponseList) {
        this.suggestResponseList = suggestResponseList;
    }

    public List<SuggestResponse> getSuggestResponseList() {
        return suggestResponseList;
    }
}
