package com.gig.gio.search_by_counterparty.ui.main.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseFragment;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.adapters.DaDataArrayAdapter;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.di.components.MainComponent;
import com.gig.gio.search_by_counterparty.model.ResponseData;
import com.gig.gio.search_by_counterparty.ui.detail.DetailActivity;
import com.gig.gio.search_by_counterparty.ui.main.MainActivity;
import com.gig.gio.search_by_counterparty.ui.main.detail.DetailFragment;

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

    private ResponseData responseData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);

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

        tvSuggests.setOnItemClickListener((p, v, pos, id) -> {
            presenter.saveSelectedSuggest(responseData, tvSuggests.getText().toString(), realm);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.getComponent(MainComponent.class).inject(this);
    }

    @Override
    public void onResume() {
        realm = Realm.getDefaultInstance();
        presenter.init(this);
        presenter.onAttachView(bus, networkService);

        super.onResume();
    }

    @Override
    public void onPause() {
        if (realm != null) realm.close();
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
    public synchronized void onSuggestionsReady(List<String> suggestions, ResponseData responseData) {
        this.responseData = responseData;
        adapter.clear();
        adapter.addAll(suggestions);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void startDetailFragment(String jsonSuggestResponseString) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.BUNDLE_SUGGEST, jsonSuggestResponseString);
        startActivity(intent);

        tvSuggests.getText().clear();
        hideProgress();
    }
    //=======--------- SearchView impelement metod END -----------=========

}
