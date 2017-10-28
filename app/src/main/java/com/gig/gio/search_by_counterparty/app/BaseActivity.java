package com.gig.gio.search_by_counterparty.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.di.components.CounterpartyAppComponent;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public abstract class BaseActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setupComponent(CounterpartyApp.get(this).getAppComponent());
    }

    public void showToast(int message, @ToastType int type) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        View toastView = toast.getView();
        toastView.setBackgroundResource(type == ToastType.ERROR ? R.drawable.toast_error_bg : R.drawable.toast_info_bg);
        toast.show();
    }

    protected abstract void setupComponent(CounterpartyAppComponent appComponent);
}
