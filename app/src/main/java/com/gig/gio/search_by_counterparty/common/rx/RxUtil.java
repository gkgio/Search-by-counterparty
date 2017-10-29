package com.gig.gio.search_by_counterparty.common.rx;

import android.support.annotation.NonNull;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by g.gigauri on 20.09.2017.
 * Gig
 */

public class RxUtil {

    @NonNull
    public static <T> ObservableTransformer<T, T> applySchedulersAndRetry() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retryWhen(new RetryWithDelay(3, 1000));
    }
}
