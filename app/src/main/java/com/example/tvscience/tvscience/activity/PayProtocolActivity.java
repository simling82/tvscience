package com.example.tvscience.tvscience.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import com.example.tvscience.tvscience.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import reco.frame.tv.view.TvButton;

public class PayProtocolActivity extends AppCompatActivity {

    private Unbinder unbinder;
    @BindView(R.id.cb)
    CheckBox cb;
    @BindView(R.id.tv_btn_consent)
    TvButton tvBtnConsent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_protocol);
        unbinder = ButterKnife.bind(this);

        tvBtnConsent.setFocusable(true);
        tvBtnConsent.setFocusableInTouchMode(true);
        tvBtnConsent.requestFocus();
        tvBtnConsent.requestFocusFromTouch();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
