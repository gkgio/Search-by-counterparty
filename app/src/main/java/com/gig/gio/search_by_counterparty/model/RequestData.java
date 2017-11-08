package com.gig.gio.search_by_counterparty.model;

/**
 * Created by georgy on 30.10.2017.
 * Gig
 */

public class RequestData {

    /** Request string */
    private String query;

    /** Count of response object */
    private int count;


    public String getQuery() {
        return query;
    }

    public int getCount() {
        return count;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
