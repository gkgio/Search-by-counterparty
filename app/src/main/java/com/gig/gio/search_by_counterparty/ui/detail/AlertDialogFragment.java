package com.gig.gio.search_by_counterparty.ui.detail;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.common.eventbus.Bus;
import com.gig.gio.search_by_counterparty.common.eventbus.events.detail.ShareDataEvent;

/**
 * Created by georgy on 12.11.2017.
 * GIG
 */
public class AlertDialogFragment extends DialogFragment {

    private Bus bus;

    public final static String ALERT_DIALOG_FRAGMENT_TAG = "ALERT_DIALOG_FRAGMENT";

    public AlertDialogFragment() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.share_fragment_title);
        builder.setMessage(R.string.share_fragment_message);

        builder.setPositiveButton(R.string.dialog_button_ok, (dialog, which) -> {
                bus.send(new ShareDataEvent());
        });
        builder.setNegativeButton(R.string.dialog_button_cancel, (dialog, which) -> dialog.dismiss());

        return builder.create();
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
