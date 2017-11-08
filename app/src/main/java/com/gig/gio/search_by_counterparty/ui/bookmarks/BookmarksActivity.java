package com.gig.gio.search_by_counterparty.ui.bookmarks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseActivity;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.adapters.AutoCompleteAdapter;
import com.gig.gio.search_by_counterparty.common.adapters.BookMarksRecyclerAdapter;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.di.HasComponent;
import com.gig.gio.search_by_counterparty.di.components.BookmarksComponent;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerBookmarksComponent;
import com.gig.gio.search_by_counterparty.di.modules.BookmarksModule;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.gig.gio.search_by_counterparty.ui.detail.DetailActivity;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by georgy on 05.11.2017.
 * Gig
 */

public class BookmarksActivity extends BaseActivity implements HasComponent<BookmarksComponent>, BookmarksView {

    @Inject
    public BookmarksPresenterImpl presenter;

    private BookmarksComponent component;

    private ProgressBar progressBar;
    private Toolbar toolbar;
    private AutoCompleteTextView etSearch;
    private Realm realm;
    private List<SuggestResponse> suggestResponseList;

    private AutoCompleteAdapter<String> adapter;
    private BookMarksRecyclerAdapter bookMarksRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);

        // toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        presenter.onCreateView(bus, gson);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        final RecyclerView rvBookMarks = (RecyclerView) findViewById(R.id.rvBookmarks);

        bookMarksRecyclerAdapter = new BookMarksRecyclerAdapter(this, bus);

        rvBookMarks.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvBookMarks.setItemAnimator(new DefaultItemAnimator());
        rvBookMarks.setLayoutManager(new LinearLayoutManager(this));
        rvBookMarks.setAdapter(bookMarksRecyclerAdapter);

        etSearch = (AutoCompleteTextView) findViewById(R.id.etSearch);
        adapter = new AutoCompleteAdapter<>(this, android.R.layout.simple_list_item_1, Config.EMPTY);

        etSearch.setAdapter(adapter);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (suggestResponseList != null)
                    presenter.searchByBookmarks(s.toString(), suggestResponseList);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etSearch.setOnItemClickListener((p, v, pos, id) -> {
            if (suggestResponseList != null)
                presenter.findSuggestForDetailActivity(etSearch.getText().toString(), suggestResponseList);
        });

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toolbar.setTitle(getResources().getString(R.string.bookmarks_activity_title));
    }

    @Override
    public void onResume() {
        realm = Realm.getDefaultInstance();
        presenter.onAttachView();
        presenter.loadDataForAdapter(realm);

        super.onResume();
    }

    @Override
    public void onPause() {
        if (!realm.isEmpty()) {
            realm.close();
        }
        presenter.onDetachView();

        super.onPause();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // при нажатии на кнопку Назад - закрываем  текущую активити
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //=======--------- BookmarksView implement method START ---------=========

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
    public void startDetailActivity(String jsonSuggestResponseString) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.BUNDLE_SUGGEST, jsonSuggestResponseString);
        startActivity(intent);
        finish();
    }

    @Override
    public void setDataInAdapter(List<SuggestResponse> suggestResponseList) {
        bookMarksRecyclerAdapter.setValues(suggestResponseList);
        this.suggestResponseList = suggestResponseList;
    }

    @Override
    public synchronized void onSuggestionsReady(List<String> suggestions) {
        adapter.clear();
        adapter.addAll(suggestions);
        adapter.notifyDataSetChanged();
    }

    //=======--------- BookmarksView implement method END ---------=========

    // BaseActivity extended method =========
    @Override
    protected void setupComponent(CounterpartyAppComponent appComponent) {
        component = DaggerBookmarksComponent.builder()
                .counterpartyAppComponent(appComponent)
                .bookmarksModule(new BookmarksModule(this))
                .build();
        component.inject(this);
    }

    // HasComponent implement method =========
    @Override
    public BookmarksComponent getComponent() {
        return component;
    }
}
