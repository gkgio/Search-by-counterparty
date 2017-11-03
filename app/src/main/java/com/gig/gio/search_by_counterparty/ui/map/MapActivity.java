package com.gig.gio.search_by_counterparty.ui.map;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.support.v7.widget.Toolbar;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseActivity;
import com.gig.gio.search_by_counterparty.common.Config;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.common.map.ClusterInfoWindowAdapter;
import com.gig.gio.search_by_counterparty.common.map.MapClusterRenderer;
import com.gig.gio.search_by_counterparty.common.map.MapItem;
import com.gig.gio.search_by_counterparty.di.HasComponent;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.di.components.DaggerMapComponent;
import com.gig.gio.search_by_counterparty.di.components.MapComponent;
import com.gig.gio.search_by_counterparty.di.modules.MapModule;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.realm.Realm;

/**
 * Created by georgy on 28.10.2017.
 * Gig
 */

public class MapActivity extends BaseActivity implements HasComponent<MapComponent>, MapView, OnMapReadyCallback {

    @Inject
    public MapPresenterImpl presenter;

    private MapComponent component;

    private ProgressBar progressBar;
    private Toolbar toolbar;
    private GoogleMap map;
    private ClusterManager<MapItem> clusterManager;

    private Disposable updateDisposable;

    private Realm realm;

    private Location currentMarkerLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        presenter.onCreateView(bus, networkService);

        currentMarkerLocation = gson.fromJson(getIntent().getStringExtra("LocationObject"), Location.class);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toolbar.setTitle(getResources().getString(R.string.map_activty_title));
    }

    @Override
    public void onResume() {
        presenter.onAttachView();
        presenter.initMap(map != null);
        presenter.getCounterPartyFromRealm(bus, realm);
        setCurrentMarkerPosition(currentMarkerLocation);
        super.onResume();
    }

    @Override
    public void onPause() {
        if(!realm.isEmpty()) {
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

    public void setCurrentMarkerPosition(Location location) {
        final LatLng position = new LatLng(location.getLatitude(), location.getLongitude());
        if (map != null) map.animateCamera(CameraUpdateFactory.newLatLng(position));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        clusterManager = new ClusterManager<>(this, googleMap);
        clusterManager.setOnClusterClickListener(cluster -> {
            clusterManager.getClusterMarkerCollection().
                    setOnInfoWindowAdapter(new ClusterInfoWindowAdapter(cluster, this));
            return false;
        });
        googleMap.setOnMarkerClickListener(clusterManager);
        clusterManager.setRenderer(new MapClusterRenderer(this, googleMap, clusterManager));
        googleMap.setOnCameraIdleListener(clusterManager);

        UiSettings settings = googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        settings.setMapToolbarEnabled(false);
        this.map = googleMap;
        setMapZoom();
    }

    //=======--------- MapView impelement metod START ---------=========

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
    public void setMarkers(List<MarkerOptions> markerOptionses) {
        if (map != null) {
            clusterManager.clearItems();
            for (MarkerOptions markerOptions : markerOptionses) {
                LatLng position = markerOptions.getPosition();
                clusterManager.addItem(new MapItem(position.latitude, position.longitude,
                        markerOptions.getTitle(), markerOptions.getSnippet()));
            }

            map.setInfoWindowAdapter(clusterManager.getMarkerManager());
            clusterManager.cluster();
        }
    }

    @Override
    public void setMapZoom() {
        map.moveCamera(CameraUpdateFactory.zoomTo(Config.MAP_ZOOM));
    }

    //=======--------- MapView impelement metod END ---------=========

    // BaseActivity extended method =========
    @Override
    protected void setupComponent(CounterpartyAppComponent appComponent) {
        component = DaggerMapComponent.builder()
                .counterpartyAppComponent(appComponent)
                .mapModule(new MapModule(this))
                .build();
        component.inject(this);
    }

    // HasComponent implement method =========
    @Override
    public MapComponent getComponent() {
        return component;
    }
}
