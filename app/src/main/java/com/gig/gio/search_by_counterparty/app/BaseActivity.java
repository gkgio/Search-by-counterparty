package com.gig.gio.search_by_counterparty.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;
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

    public void showSnackBar(View view, int message, @SnackBarType int type) {

        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        View snackBarView = snackbar.getView();
        snackBarView.setAlpha(0.95f);
        snackBarView.setBackgroundResource(type == SnackBarType.ERROR ?
                R.drawable.toast_error_bg : R.drawable.toast_info_bg);
        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        textView.setCompoundDrawablesWithIntrinsicBounds(type == SnackBarType.ERROR ?
                R.drawable.ic_report_problem : R.drawable.ic_info_outline, 0, 0, 0);
        textView.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.snackBar_icon_padding));
        snackbar.show();
    }

    protected abstract void setupComponent(CounterpartyAppComponent appComponent);
}
