package com.gig.gio.search_by_counterparty.ui.detail;

import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

public interface DetailView {
    void showProgress();
    void hideProgress();
    void showMessage(int message, @ToastType int type);
    void startMapActivity(String jsonSuggestResponseString, String jsonLocationSting);
    void shareData();
    void sendData(String messageBody);
}
