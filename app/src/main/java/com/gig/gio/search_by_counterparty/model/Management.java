package com.gig.gio.search_by_counterparty.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by georgy on 01.11.2017.
 * Gig
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Management extends RealmObject implements Serializable {

    /** id */
    @PrimaryKey
    private long id;

    private String name;

    private String post;
}
