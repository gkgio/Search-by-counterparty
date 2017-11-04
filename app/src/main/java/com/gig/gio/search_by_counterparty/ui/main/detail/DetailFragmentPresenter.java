package com.gig.gio.search_by_counterparty.ui.main.detail;

import com.gig.gio.search_by_counterparty.app.BaseFragmentPresenter;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.network.NetworkService;

/**
 * Created by georgy on 04.11.2017.
 * Gig
 */

public interface DetailFragmentPresenter extends BaseFragmentPresenter<DetailFragmentView> {
    void onAttachView(Bus bus, NetworkService networkService);
    void onDetachView();
}
