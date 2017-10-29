package com.gig.gio.search_by_counterparty.ui.about;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseFragment;

import javax.inject.Inject;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public class AboutFragment  extends BaseFragment implements AboutFragmentView {

    @Inject
    AboutFragmentPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
}