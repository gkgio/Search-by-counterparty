package com.gig.gio.search_by_counterparty.common.rx;

import android.support.annotation.NonNull;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by g.gigauri on 20.09.2017.
 * Gig
 */

public class RetryWithDelay implements Function<Observable<? extends Throwable>, Observable<?>> {

    private final int maxRetries;
    private final int retryDelayMillis;
    private int retryCount;

    /**
     * @param maxRetries количество повторов
     * @param retryDelayMillis время между повторами в миллисекундах
     * */
    public RetryWithDelay(final int maxRetries, final int retryDelayMillis) {
        this.maxRetries = maxRetries;
        this.retryDelayMillis = retryDelayMillis;
        this.retryCount = 0;
    }

    @Override
    public Observable<?> apply(@NonNull Observable<? extends Throwable> attempts) throws Exception {
        return attempts
                .flatMap(throwable -> {
                    if (++retryCount < maxRetries && (throwable instanceof ConnectException || throwable instanceof SocketTimeoutException)) {
                        return Observable.timer(retryDelayMillis, TimeUnit.MILLISECONDS);
                    }else {
                        return Observable.error(throwable);
                    }
                });
    }
}
