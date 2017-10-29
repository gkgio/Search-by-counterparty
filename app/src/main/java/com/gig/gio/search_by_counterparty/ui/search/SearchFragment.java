package com.gig.gio.search_by_counterparty.ui.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseFragment;
import com.gig.gio.search_by_counterparty.common.adapters.DaDataArrayAdapter;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.realm.Realm;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public class SearchFragment extends BaseFragment implements SearchFragmentView {

    @Inject
    SearchFragmentPresenter presenter;

    private ProgressBar progress;
    private Realm realm;
    private Disposable disposable;
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

        progress = (ProgressBar) view.findViewById(R.id.progressBar);
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
    public void onResume() {
        realm = Realm.getDefaultInstance();
        presenter.init(this);
        presenter.onAttachView(bus, networkService);

        super.onResume();
    }

    @Override
    public void onPause() {
        presenter.onDetachView();
        disposable.dispose();
        super.onPause();
    }


    //=======--------- SplashView impelement metod START ---------=========

    @Override
    public void hideProgress() {
        progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(int message, @ToastType int type) {
        showToast(message, type);
    }

    @Override
    public synchronized void onSuggestionsReady(List<String> suggestions) {
        // Clear current suggestions
        adapter.clear();

        adapter.addAll(suggestions);

        if(suggestions.size() > 1)
            tvSuggests.showDropDown();
        else
            tvSuggests.dismissDropDown();

        // Notify about the change
        adapter.notifyDataSetChanged();
    }


   /* @Override
    public void renderResponse(ArrayList<String> response) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_dropdown_item_1line, response);
        addressText.setAdapter(adapter);
        if(response.size() > 1)
            addressText.showDropDown();
        else
            addressText.dismissDropDown();
    }*/

    //=======--------- SplashView impelement metod END ---------=========

}
