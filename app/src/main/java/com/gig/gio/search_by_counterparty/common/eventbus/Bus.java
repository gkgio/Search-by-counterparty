package com.gig.gio.search_by_counterparty.common.eventbus;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class Bus {

    private final PublishSubject<Object> bus;

    @Inject
    public Bus() {
        this.bus = PublishSubject.create();
    }

    public Observable<Object> toObservable() {
        return bus;
    }

    public void send(final Object event) {
        bus.onNext(event);
    }
}
