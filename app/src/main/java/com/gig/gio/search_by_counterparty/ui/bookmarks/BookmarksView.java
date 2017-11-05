package com.gig.gio.search_by_counterparty.ui.bookmarks;

import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;

import java.util.List;

/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

public interface BookmarksView {
    void showProgress();
    void hideProgress();
    void showMessage(int message, @ToastType int type);
    void openDetailActivity(String jsonSuggestResponseString);
    void setDataInAdapter(List<SuggestResponse> suggestResponseList);
}
