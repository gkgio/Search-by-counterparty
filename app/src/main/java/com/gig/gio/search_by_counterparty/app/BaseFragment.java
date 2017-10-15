package com.gig.gio.search_by_counterparty.app;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;

import javax.inject.Inject;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class BaseFragment extends Fragment {

    @Inject
    public SharedPreferences preferences;
    @Inject
    public Bus bus;

    public void showToast(int message, @ToastType int type) {
        Toast toast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        View toastView = toast.getView();
        toastView.setBackgroundResource(type == ToastType.ERROR ? R.drawable.toast_error_bg : R.drawable.toast_info_bg);
        toast.show();
    }
}
