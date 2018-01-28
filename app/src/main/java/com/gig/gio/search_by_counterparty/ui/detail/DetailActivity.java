package com.gig.gio.search_by_counterparty.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseActivity;
import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.di.HasComponent;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerDetailComponent;
import com.gig.gio.search_by_counterparty.di.components.DetailComponent;
import com.gig.gio.search_by_counterparty.di.modules.DetailModule;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.gig.gio.search_by_counterparty.ui.map.MapActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jakewharton.rxbinding2.view.RxView;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by georgy on 02.11.2017.
 * Gig
 */

public class DetailActivity extends BaseActivity implements HasComponent<DetailComponent>, DetailView, OnMapReadyCallback {

    @Inject
    public DetailPresenterImpl presenter;

    @Inject
    public Bus bus;

    private DetailComponent component;

    private Realm realm;

    private ProgressBar progressBar;
    private Toolbar toolbar;
    private SuggestResponse suggestResponse;

    public static final String BUNDLE_SUGGEST = "BUNDLE_SUGGEST";

    private TextView tvNameManagement;
    private TextView tvPostManagement;
    private TextView tvOpfFull;
    private TextView tvValue;
    private TextView tvKpp;
    private TextView tvInn;
    private TextView tvOgrn;
    private TextView tvStatus;
    private TextView tvAddress;

    private boolean isDeleted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        final long id = getIntent().getLongExtra(BUNDLE_SUGGEST, -1);
        if (id != -1) suggestResponse = presenter.getSuggestResponseFromRealm(id);

        // toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        presenter.onCreateView(bus);

        progressBar = findViewById(R.id.progressBar);

        tvNameManagement = findViewById(R.id.tvNameManagement);
        tvPostManagement = findViewById(R.id.tvPostManagement);
        tvOpfFull = findViewById(R.id.tvOpfFull);
        tvValue = findViewById(R.id.tvValue);
        tvKpp = findViewById(R.id.tvKpp);
        tvInn = findViewById(R.id.tvInn);
        tvOgrn = findViewById(R.id.tvOgrn);
        tvStatus = findViewById(R.id.tvStatus);
        tvAddress = findViewById(R.id.tvAddress);

        if (suggestResponse.getData().getManagement() != null) {
            tvNameManagement.setText(suggestResponse.getData().getManagement().getName());
            tvPostManagement.setText(suggestResponse.getData().getManagement().getPost());
        }
        if (suggestResponse.getData().getOpf() != null)
            tvOpfFull.setText(suggestResponse.getData().getOpf().getFull());


        tvValue.setText(getString(R.string.value_name_filter, suggestResponse.getValue()));
        tvKpp.setText(getString(R.string.kpp_name_filter, suggestResponse.getData().getKpp()));
        tvInn.setText(getString(R.string.inn_name_filter, suggestResponse.getData().getInn()));
        tvOgrn.setText(getString(R.string.ogrn_name_filter, suggestResponse.getData().getOgrn()));

        if (suggestResponse.getData().getState().getStatus() != null)
            tvStatus.setText(getString(R.string.status_name_filter,
                    suggestResponse.getData().getState().getStatus()));
        tvAddress.setText(getString(R.string.address_name_filter,
                suggestResponse.getData().getAddress().getValue()));

        final Button btnOpenMap = findViewById(R.id.btnOpenMap);
        RxView.clicks(btnOpenMap).subscribe(aVoid -> presenter.provideLocationForMap(suggestResponse));

        final Button btnDeleteFromLatest = findViewById(R.id.btnDeleteFromLatest);
        RxView.clicks(btnDeleteFromLatest).subscribe(aVoid -> {
            presenter.deleteFromLatest(suggestResponse, realm);
            isDeleted = true;
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toolbar.setTitle(getResources().getString(R.string.detail_activity_title));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu);
        if (suggestResponse.isBookmark()) {
            menu.findItem(R.id.action_bookmark).setVisible(true);
            menu.findItem(R.id.action_unbookmark).setVisible(false);
        } else {
            menu.findItem(R.id.action_bookmark).setVisible(false);
            menu.findItem(R.id.action_unbookmark).setVisible(true);
        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // при нажатии на кнопку Назад - закрываем  текущую активити
                finish();
                overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
                break;
            case R.id.action_unbookmark:
                suggestResponse.setBookmark(true);
                invalidateOptionsMenu();
                presenter.saveChangedInRealm(suggestResponse, realm);
                break;
            case R.id.action_bookmark:
                suggestResponse.setBookmark(false);
                invalidateOptionsMenu();
                presenter.saveChangedInRealm(suggestResponse, realm);
                break;
            case R.id.action_share:
                openDialog();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        realm = Realm.getDefaultInstance();
        presenter.onAttachView();

        super.onResume();
    }

    @Override
    protected void onPause() {
        if (realm != null) {
            realm.close();
        }
        presenter.onDetachView();

        super.onPause();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        UiSettings settings = googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        settings.setMapToolbarEnabled(false);
        if (suggestResponse.getData().getAddress().getAddressData() != null) {
            final LatLng location = new LatLng(suggestResponse.getData().getAddress().getAddressData().getGeo_lat(),
                    suggestResponse.getData().getAddress().getAddressData().getGeo_lon());
            final String title = suggestResponse.getValue();
            googleMap.addMarker(new MarkerOptions()
                    .position(location))
                    .setTitle(title);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 15.0f));
        }
    }

    private void openDialog() {
        final AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        alertDialogFragment.setBus(bus);
        alertDialogFragment.show(getSupportFragmentManager(), AlertDialogFragment.ALERT_DIALOG_FRAGMENT_TAG);
    }


    //=======--------- DetailView implement method START ---------=========

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
        showSnackBar(getWindow().getDecorView().getRootView(), message, type);
    }

    @Override
    public void startMapActivity(String jsonSuggestResponseString, String jsonLocationSting) {
        Intent intent = new Intent(this, MapActivity.class);
        if (isDeleted)
            intent.putExtra(MapActivity.BUNDLE_SUGGEST_RESPONSE, jsonSuggestResponseString);
        intent.putExtra(MapActivity.BUNDLE_LOCATION, jsonLocationSting);
        startActivity(intent);

        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    @Override
    public void shareData() {
        presenter.prepareDateForSend(tvNameManagement.getText().toString(),
                tvPostManagement.getText().toString(),
                tvOpfFull.getText().toString(),
                tvValue.getText().toString(),
                tvKpp.getText().toString(),
                tvInn.getText().toString(),
                tvOgrn.getText().toString(),
                tvStatus.getText().toString(),
                tvAddress.getText().toString());
    }

    @Override
    public void sendData(String messageBody) {
        final Intent sendIntent = new Intent(android.content.Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.sending_date_title));
        sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, messageBody);
        // Проверяем, что существует приложение, способное обработать этот intent
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(sendIntent, "Sending..."));
        }
    }

    //=======--------- DetailView implement method END ---------=========

    // BaseActivity extended method =========
    @Override
    protected void setupComponent(CounterpartyAppComponent appComponent) {
        component = DaggerDetailComponent.builder()
                .counterpartyAppComponent(appComponent)
                .detailModule(new DetailModule(this))
                .build();
        component.inject(this);
    }

    // HasComponent implement method =========
    @Override
    public DetailComponent getComponent() {
        return component;
    }
}

