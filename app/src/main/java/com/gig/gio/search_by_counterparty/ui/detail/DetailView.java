package com.gig.gio.search_by_counterparty.ui.detail;

import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

public interface DetailView {
    void showProgress();
    void hideProgress();
    void showMessage(int message, @SnackBarType int type);
    void startMapActivity(String jsonSuggestResponseString, String jsonLocationSting);
    void shareData();
    void sendData(String messageBody);
}
