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
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseActivity;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.Utils;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.di.HasComponent;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerMainComponent;
import com.gig.gio.search_by_counterparty.di.components.MainComponent;
import com.gig.gio.search_by_counterparty.di.modules.MainModule;
import com.gig.gio.search_by_counterparty.ui.main.about.AboutFragment;
import com.gig.gio.search_by_counterparty.ui.main.search.SearchFragment;
import com.tbruyelle.rxpermissions.RxPermissions;

import javax.inject.Inject;

import io.realm.Realm;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent>, MainView,
        NavigationView.OnNavigationItemSelectedListener {

    @Inject
    public MainPresenterImpl presenter;

    @Inject
    RxPermissions rxPermissions;

    private MainComponent component;

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ProgressBar progressBar;

    private Realm realm;

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

        presenter.onCreateView(bus, preferences);

        if (getLastActiveFragmentTag() == null) {
            addSearchFragment();
            presenter.putCurrentPageTag(Config.SEARCH_FRAGMENT_TAG);
        }

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
                presenter.putCurrentPageTag(Config.SEARCH_FRAGMENT_TAG);
                removeFragmentsStack();
                addSearchFragment();
                item.setChecked(true);
                break;
            case R.id.navigation_item_email:
                Intent intent = Utils.buildEmailIntent(Config.AUTHOR_EMAIL);
                startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_email_chooser_title)));
                //item.setChecked(true);
                break;
            case R.id.navigation_item_info:
                presenter.putCurrentPageTag(Config.ABOUT_FRAGMENT_TAG);
                removeFragmentsStack();
                addAboutFragment();
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
        realm = Realm.getDefaultInstance();
        presenter.onAttachView();
        super.onResume();
    }

    @Override
    public void onPause() {
        presenter.onDetachView();
        super.onPause();
    }

    private void addSearchFragment() {
        // Добавляем фрагмент - search
        FragmentManager fragmentManager = getSupportFragmentManager();
        SearchFragment searchFragment = (SearchFragment) fragmentManager.findFragmentByTag(Config.SEARCH_FRAGMENT_TAG);
        if (searchFragment == null) {
            searchFragment = new SearchFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, searchFragment, Config.SEARCH_FRAGMENT_TAG)
                    .addToBackStack(Config.SEARCH_FRAGMENT_TAG)
                    .commit();
        }
    }

    private void addAboutFragment() {
        // Добавляем фрагмент - about
        FragmentManager fragmentManager = getSupportFragmentManager();
        AboutFragment aboutFragment = (AboutFragment) fragmentManager.findFragmentByTag(Config.ABOUT_FRAGMENT_TAG);
        if (aboutFragment == null) {
            aboutFragment = new AboutFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, aboutFragment, Config.ABOUT_FRAGMENT_TAG)
                    .addToBackStack(Config.ABOUT_FRAGMENT_TAG)
                    .commit();
        }
    }

    public String getLastActiveFragmentTag() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            return null;
        }
        return getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();

    }

    private void removeFragmentsStack() {
        if (!getLastActiveFragmentTag().equals(presenter.getCurrentPageTag()))
            getSupportFragmentManager().popBackStack();
    }


    //=======--------- MainView implement method START ---------=========

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

    //=======--------- MainView implement method  END -----------=========

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
