package com.gig.gio.search_by_counterparty.common.eventbus;

import javax.inject.Inject;

import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class Bus extends SerializedSubject<Object, Object> {

    @Inject
    public Bus() {
        super(PublishSubject.create());
    }

    public void send(Object o) {
        this.onNext(o);
    }
}
