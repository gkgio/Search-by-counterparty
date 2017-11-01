package com.gig.gio.search_by_counterparty.ui.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseActivity;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.Utils;
import com.gig.gio.search_by_counterparty.common.adapters.DaDataArrayAdapter;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.di.HasComponent;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerMainComponent;
import com.gig.gio.search_by_counterparty.di.components.MainComponent;
import com.gig.gio.search_by_counterparty.di.modules.MainModule;
import com.gig.gio.search_by_counterparty.ui.about.AboutFragment;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent>, MainView,
        NavigationView.OnNavigationItemSelectedListener {

    private static final String ABOUT_FRAGMENT_TAG = "ABOUT_FRAGMENT";

    @Inject
    public MainPresenterImpl presenter;

    @Inject
    RxPermissions rxPermissions;

    private MainComponent component;

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ProgressBar progressBar;

    private FrameLayout fragmentContainer;
    private LinearLayout contentMain;

    private Realm realm;

    private AutoCompleteTextView tvSuggests;
    private static final List<String> EMPTY = new ArrayList<>();
    private DaDataArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_dehaze);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        // Navigation Drawer
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                Utils.hideKeyboard(drawerView.getContext());
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.addDrawerListener(toggle);

        // отключаем системную иконку меню
        toggle.setDrawerIndicatorEnabled(false);
        // применяем свой листенер для кнопки меню
        toggle.setToolbarNavigationClickListener(view -> drawer.openDrawer(GravityCompat.START));
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        presenter.onCreateView(bus, networkService);

        tvSuggests = (AutoCompleteTextView) findViewById(R.id.tvAutoComplete);
        adapter = new DaDataArrayAdapter<>(this, android.R.layout.simple_list_item_1, EMPTY);

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

        fragmentContainer = (FrameLayout)findViewById(R.id.fragment_container);
        contentMain = (LinearLayout)findViewById(R.id.contentMain);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_item_home:
                removeAboutFragment();
                item.setChecked(true);
                break;
            case R.id.navigation_item_email:
                Intent intent = Utils.buildEmailIntent(Config.AUTHOR_EMAIL);
                startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_email_chooser_title)));
                item.setChecked(true);
                break;
            case R.id.navigation_item_info:
                replaceOnAboutFragment();
                item.setChecked(true);
                break;
            case R.id.navigation_item_logout:
                presenter.logout(preferences, realm);
                item.setChecked(true);
                finish();
                break;
        }
        //  закрываем меню
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onResume() {
        presenter.onAttachView();
        super.onResume();
    }

    @Override
    public void onPause() {
        presenter.onDetachView();
        super.onPause();
    }

    private void replaceOnAboutFragment() {
        fragmentContainer.setVisibility(View.VISIBLE);
        contentMain.setVisibility(View.GONE);
        // Заменяем на фрагмент - about контейнер
        FragmentManager fragmentManager = getSupportFragmentManager();
        AboutFragment aboutFragment = (AboutFragment) fragmentManager.findFragmentByTag(ABOUT_FRAGMENT_TAG);
        if (aboutFragment == null) {
            aboutFragment = new AboutFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, aboutFragment, ABOUT_FRAGMENT_TAG)
                    .commit();
        }
    }

    private void removeAboutFragment(){
        fragmentContainer.setVisibility(View.GONE);
        contentMain.setVisibility(View.VISIBLE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        AboutFragment aboutFragment = (AboutFragment) fragmentManager.findFragmentByTag(ABOUT_FRAGMENT_TAG);
        if(aboutFragment != null)
            fragmentManager.beginTransaction().remove(aboutFragment).commit();
    }



    //=======--------- MainView impelement metod START ---------=========

    @Override
    public void changeItemNavigationViewHomeChecked() {
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void closeDrawerMenu() {
        drawer.closeDrawer(GravityCompat.START);
    }

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

    //=======--------- MainView impelement metod END -----------=========

    // BaseActivity extended method =========
    @Override
    protected void setupComponent(CounterpartyAppComponent appComponent) {
        component = DaggerMainComponent.builder()
                .counterpartyAppComponent(appComponent)
                .mainModule(new MainModule(this))
                .build();
        component.inject(this);
    }

    // HasComponent implement method =========
    @Override
    public MainComponent getComponent() {
        return component;
    }
}
