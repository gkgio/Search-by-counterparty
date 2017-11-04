package com.gig.gio.search_by_counterparty.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by georgy on 04.11.2017.
 * Gig
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class State extends RealmObject implements Serializable {

    /** id */
    @PrimaryKey
    private String id;

    private String status;

    private String registration_date;
}
