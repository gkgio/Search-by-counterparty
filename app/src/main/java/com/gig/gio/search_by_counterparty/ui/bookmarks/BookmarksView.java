package com.gig.gio.search_by_counterparty.ui.bookmarks;

import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;

import java.util.List;

/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

public interface BookmarksView {
    void showProgress();
    void hideProgress();
    void showMessage(int message, @SnackBarType int type);
    void startDetailActivity(String jsonSuggestResponseString);
    void setDataInAdapter(List<SuggestResponse> suggestResponseList);
    void onSuggestionsReady(List<String> suggestions);
}
