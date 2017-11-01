package com.gig.gio.search_by_counterparty.ui.main;

import com.gig.gio.search_by_counterparty.common.enums.ToastType;

import java.util.List;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public interface MainView {

   // void replaceOnMainFragment();
    void changeItemNavigationViewHomeChecked();
    void closeDrawerMenu();
    void showProgress();
    void hideProgress();
    void showMessage(int message, @ToastType int type);
    void onSuggestionsReady(List<String> suggestions);
}
