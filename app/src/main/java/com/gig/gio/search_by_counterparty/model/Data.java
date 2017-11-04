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
public class Data extends RealmObject implements Serializable {

    /**
     * id
     */
    @PrimaryKey
    private String id;

    private String kpp;

    @SerializedName("management")
    private Management management;

    private String inn;

    private String ogrn;

    @SerializedName("opf")
    private Opf opf;

    @SerializedName("state")
    private State state;

    @SerializedName("address")
    private Address address;
}
