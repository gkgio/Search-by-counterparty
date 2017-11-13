package com.gig.gio.search_by_counterparty.app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.SnackBarType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.di.HasComponent;
import com.gig.gio.search_by_counterparty.network.NetworkService;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class BaseFragment extends Fragment {

    @Inject
    public Gson gson;
    @Inject
    public SharedPreferences preferences;
    @Inject
    public Bus bus;
    @Inject
    @Named("no_cached")
    public NetworkService networkService;

    @SuppressWarnings("unchecked")
    protected <T> T getComponent(Class<T> componentType) {
        return componentType.cast(((HasComponent<T>) getActivity()).getComponent());
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
                R.drawable.ic_report_problem_white : R.drawable.ic_info_outline_white, 0, 0, 0);
        textView.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.snackbar_icon_padding));
        snackbar.show();
    }
}
