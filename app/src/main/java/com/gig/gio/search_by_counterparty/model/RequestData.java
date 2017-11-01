package com.gig.gio.search_by_counterparty.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by georgy on 30.10.2017.
 * Gig
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RequestData {

    /** Request string */
    private String query;

    /** Count of response object */
    private int count;
}
