package com.gig.gio.search_by_counterparty.ui.main.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseFragment;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.adapters.AutoCompleteAdapter;
import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;
import com.gig.gio.search_by_counterparty.di.components.MainComponent;
import com.gig.gio.search_by_counterparty.model.ResponseData;
import com.gig.gio.search_by_counterparty.ui.bookmarks.BookmarksActivity;
import com.gig.gio.search_by_counterparty.ui.detail.DetailActivity;
import com.gig.gio.search_by_counterparty.ui.main.MainActivity;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxAutoCompleteTextView;
import com.jakewharton.rxbinding2.widget.RxTextView;


import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.realm.Realm;

/**
 * Created by georgy on 03.11.2017.
 * Gig
 */

public class SearchFragment extends BaseFragment implements SearchFragmentView, MainActivity.OnBackPressedListener {

    @Inject
    SearchFragmentPresenter presenter;

    private Realm realm;
    private ProgressBar progressBar;
    private AutoCompleteTextView etSuggests;

    private AutoCompleteAdapter<String> adapter;

    private ResponseData responseData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            progressBar = mainActivity.findViewById(R.id.progressBar);
            mainActivity.setOnBackPressedListener(this);
        }

        etSuggests = view.findViewById(R.id.etAutoComplete);
        adapter = new AutoCompleteAdapter<>(getActivity(), android.R.layout.simple_list_item_1, Config.EMPTY);

        etSuggests.setAdapter(adapter);

        RxTextView.textChanges(etSuggests)
                .debounce(200, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .filter(str -> !str.toString().trim().isEmpty())
                .subscribe(a -> presenter.requestSuggestions(a.toString()));

        RxAutoCompleteTextView.itemClickEvents(etSuggests)
                .subscribe(a -> {
                    presenter.saveSelectedSuggest(responseData, etSuggests.getText().toString(), realm);
                    etSuggests.getText().clear();
                    hideProgress();
                });

        final Button btnOpenBookmarks = view.findViewById(R.id.btnOpenBookmarks);
        RxView.clicks(btnOpenBookmarks).subscribe(aVoid -> openBookmarksActivity());
    }

    @Override
    public void doBack() {
        final MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            mainActivity.finish();
            AnimationUtils.loadAnimation(mainActivity, R.anim.fragment_close);
        }
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
        adapter.clear();

        super.onResume();
    }

    @Override
    public void onPause() {
        if (realm != null) realm.close();
        presenter.onDetachView();

        super.onPause();
    }

    private void openBookmarksActivity() {
        Intent intent = new Intent(getActivity(), BookmarksActivity.class);
        startActivity(intent);

        final Activity activity = getActivity();
        if (activity != null)
            activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }


    //=======--------- SearchView implement method START ---------=========

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(int message, @SnackBarType int type) {
        final Activity activity = getActivity();
        if (activity != null)
            showSnackBar(getActivity().getWindow().getDecorView().getRootView(), message, type);
    }

    @Override
    public synchronized void onSuggestionsReady(List<String> suggestions, ResponseData responseData) {
        this.responseData = responseData;
        adapter.clear();
        adapter.addAll(suggestions);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void startDetailActivity(long id) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.BUNDLE_SUGGEST, id);
        startActivity(intent);

        final Activity activity = getActivity();
        if (activity != null)
            activity.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }
    //=======--------- SearchView implement method END -----------=========

}
