package com.gig.gio.search_by_counterparty.ui.main.detail;

import com.gig.gio.search_by_counterparty.common.enums.ToastType;

/**
 * Created by georgy on 04.11.2017.
 * Gig
 */

public interface DetailFragmentView {
    void showProgress();
    void hideProgress();
    void showMessage(int message, @ToastType int type);
}
