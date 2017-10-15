package com.gig.gio.search_by_counterparty.common.enums;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 * Тип сообщения
 */

@IntDef({ToastType.INFO, ToastType.ERROR})
@Retention(RetentionPolicy.SOURCE)
public @interface ToastType {
    int INFO = 0;
    int ERROR = 1;
}
