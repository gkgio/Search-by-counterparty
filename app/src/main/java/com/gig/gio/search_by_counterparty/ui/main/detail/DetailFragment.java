package com.gig.gio.search_by_counterparty.ui.main.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gig.gio.search_by_counterparty.R;
import com.gig.gio.search_by_counterparty.app.BaseActivity;
import com.gig.gio.search_by_counterparty.app.BaseFragment;
import com.gig.gio.search_by_counterparty.common.enums.ToastType;
import com.gig.gio.search_by_counterparty.di.components.MainComponent;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;
import com.google.gson.Gson;


import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by georgy on 04.11.2017.
 * Gig
 */

public class DetailFragment extends BaseFragment implements DetailFragmentView {

    @Inject
    DetailFragmentPresenterImpl presenter;

    private Realm realm;

    private ProgressBar progressBar;

    private SuggestResponse suggestResponse;

    public static final String BUNDLE_SUGGEST = "BUNDLE_SUGGEST";

    public static DetailFragment newInstance(String suggestResponse) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_SUGGEST, suggestResponse);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null && getArguments().containsKey(BUNDLE_SUGGEST)) {
            Gson localGson = new Gson();

            this.suggestResponse = localGson.fromJson(getArguments().getString(BUNDLE_SUGGEST), SuggestResponse.class);
        } else {
            throw new IllegalArgumentException("Must be created through newInstance(String suggestResponse)");
        }

        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getResources().getString(R.string.detail_fragment_title));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progressBar);
        final TextView tvNameManagement = (TextView) view.findViewById(R.id.tvNameManagement);
        final TextView tvPostManagement = (TextView) view.findViewById(R.id.tvPostManagement);
        final TextView tvOpfFull = (TextView) view.findViewById(R.id.tvOpfFull);
        final TextView tvValue = (TextView) view.findViewById(R.id.tvValue);
        final TextView tvKpp = (TextView) view.findViewById(R.id.tvKpp);
        final TextView tvInn = (TextView) view.findViewById(R.id.tvInn);
        final TextView tvOgrn = (TextView) view.findViewById(R.id.tvOgrn);
        final TextView tvStatus = (TextView) view.findViewById(R.id.tvStatus);
        final TextView tvAddress = (TextView) view.findViewById(R.id.tvAddress);

        tvNameManagement.setText(suggestResponse.getData().getManagement().getName());
        tvPostManagement.setText(suggestResponse.getData().getManagement().getPost());
        tvOpfFull.setText(suggestResponse.getData().getOpf().getFull());
        tvValue.setText(getString(R.string.value_name_filter, suggestResponse.getValue()));
        tvKpp.setText(getString(R.string.kpp_name_filter, suggestResponse.getData().getKpp()));
        tvInn.setText(getString(R.string.inn_name_filter, suggestResponse.getData().getInn()));
        tvOgrn.setText(getString(R.string.ogrn_name_filter, suggestResponse.getData().getOgrn()));
        tvStatus.setText(getString(R.string.status_name_filter,
                suggestResponse.getData().getState().getStatus()));
        tvAddress.setText(getString(R.string.address_name_filter,
                suggestResponse.getData().getAddress().getValue()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.getComponent(MainComponent.class).inject(this);
    }

    @Override
    public void onResume() {
        realm = Realm.getDefaultInstance();
        presenter.init(this);
        presenter.onAttachView(bus, networkService);

        super.onResume();
    }

    @Override
    public void onPause() {
        if (realm != null) realm.close();
        presenter.onDetachView();

        super.onPause();
    }

    //=======--------- DetailView impelement metod START ---------=========

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


    //=======--------- DetailView impelement metod END -----------=========

}
