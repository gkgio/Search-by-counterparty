package com.gig.gio.search_by_counterparty.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by georgy on 01.11.2017.
 * Gig
 */

public class ResponseData extends RealmObject implements Serializable {

    /** id */
    @PrimaryKey
    private long id;

    @SerializedName("suggestions")
    private RealmList<SuggestResponse> suggestions;


    public long getId() {
        return id;
    }

    public RealmList<SuggestResponse> getSuggestions() {
        return suggestions;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSuggestions(RealmList<SuggestResponse> suggestions) {
        this.suggestions = suggestions;
    }
}
