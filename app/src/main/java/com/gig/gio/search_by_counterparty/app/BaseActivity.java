package com.gig.gio.search_by_counterparty.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    public Gson gson;
    @Inject
    public SharedPreferences preferences;
    @Inject
    public Bus bus;
    @Inject
    @Named("no_cached")
    public NetworkService networkService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(CounterpartyApp.get(this).getAppComponent());
    }

    public void showToast(int message, @ToastType int type) {

        LayoutInflater inflater = getLayoutInflater();

        View toastView = inflater.inflate(R.layout.toast, findViewById(R.id.toast_layout_root));
        toastView.setBackgroundResource(type == ToastType.ERROR ?
                R.drawable.toast_error_bg : R.drawable.toast_info_bg);

        TextView tvToast = toastView.findViewById(R.id.tvToast);
        tvToast.setText(message);
        tvToast.setCompoundDrawablesWithIntrinsicBounds(type == ToastType.ERROR ?
                R.drawable.ic_report_problem_white : R.drawable.ic_info_outline_white, 0, 0, 0);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 64);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastView);
        toast.show();
    }

    protected abstract void setupComponent(CounterpartyAppComponent appComponent);
}
