package com.gig.gio.search_by_counterparty.ui.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.gig.gio.search_by_counterparty.R;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public class SearchFragment extends MvpAppCompatFragment implements SearchFragmentView {

    private ProgressBar progress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        progress = (ProgressBar) view.findViewById(R.id.progressBar);

    }
}
