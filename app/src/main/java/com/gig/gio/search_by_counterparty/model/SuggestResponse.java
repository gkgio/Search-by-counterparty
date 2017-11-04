package com.gig.gio.search_by_counterparty.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SuggestResponse extends RealmObject implements Serializable {

    /** id */
    @PrimaryKey
    private long id;

    private String value;

    private String unrestricted_value;

    @SerializedName("data")
    private Data data;

    private String inn;

    private String ogrn;

    @SerializedName("address")
    private Address address;
}