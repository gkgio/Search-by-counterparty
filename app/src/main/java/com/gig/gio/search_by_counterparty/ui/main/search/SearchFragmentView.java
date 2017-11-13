package com.gig.gio.search_by_counterparty.ui.main.search;

import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;
import com.gig.gio.search_by_counterparty.model.ResponseData;

import java.util.List;

/**
 * Created by georgy on 03.11.2017.
 * Gig
 */

public interface SearchFragmentView {
    void showProgress();
    void hideProgress();
    void showMessage(int message, @SnackBarType int type);
    void onSuggestionsReady(List<String> suggestions, ResponseData responseData);
    void startDetailActivity(String jsonSuggestResponseString);
}
