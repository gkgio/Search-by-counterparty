package com.gig.gio.search_by_counterparty.ui.main.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseFragment;
import com.gig.gio.search_by_counterparty.common.adapters.DaDataArrayAdapter;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.di.components.MainComponent;
import com.gig.gio.search_by_counterparty.ui.main.about.AboutFragmentPresenter;
import com.gig.gio.search_by_counterparty.ui.main.about.AboutFragmentView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by georgy on 03.11.2017.
 * Gig
 */

public class SearchFragment extends BaseFragment implements SearchFragmentView {

    @Inject
    SearchFragmentPresenter presenter;

    private Realm realm;

    private ProgressBar progressBar;

    private AutoCompleteTextView tvSuggests;
    private static final List<String> EMPTY = new ArrayList<>();
    private DaDataArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        progressBar = (ProgressBar)  getActivity().findViewById(R.id.progressBar);

        tvSuggests = (AutoCompleteTextView) view.findViewById(R.id.tvAutoComplete);
        adapter = new DaDataArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, EMPTY);

        tvSuggests.setAdapter(adapter);

        tvSuggests.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.requestSuggestions(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.getComponent(MainComponent.class).inject(this);
    }

    @Override
    public void onResume() {
        presenter.init(this);
        presenter.onAttachView(bus, networkService);

        super.onResume();
    }

    @Override
    public void onPause() {
        presenter.onDetachView();
        super.onPause();
    }

    //=======--------- SearchView impelement metod START ---------=========

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(int message, @ToastType int type) {
        showToast(message, type);
    }

    @Override
    public synchronized void onSuggestionsReady(List<String> suggestions) {
        adapter.clear();
        adapter.addAll(suggestions);
        adapter.notifyDataSetChanged();
    }

    //=======--------- SearchView impelement metod END -----------=========

}
