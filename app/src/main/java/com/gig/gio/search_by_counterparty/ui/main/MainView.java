package com.gig.gio.search_by_counterparty.ui.main;

import com.gig.gio.search_by_counterparty.common.enums.ToastType;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public interface MainView {
    void showProgress();
    void hideProgress();
    void showMessage(int message, @ToastType int type);
}
