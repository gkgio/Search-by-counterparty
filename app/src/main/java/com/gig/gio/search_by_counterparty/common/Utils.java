package com.gig.gio.search_by_counterparty.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public class Utils {

    //скрывать клавиатуру при переходе из одного фрагмента в другой
    public static void hideKeyboard(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) ctx).getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public static Intent buildEmailIntent(String email) {
        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:" + email));
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        return intent;
    }
}
