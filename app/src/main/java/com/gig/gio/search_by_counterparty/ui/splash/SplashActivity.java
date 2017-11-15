package com.gig.gio.search_by_counterparty.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.ui.main.MainActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        //overridePendingTransition(R.anim.fade_in_activity, R.anim.fade_out_activity);
    }
}