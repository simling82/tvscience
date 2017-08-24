package com.example.tvscience.tvscience.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.example.tvscience.tvscience.R;
import com.example.tvscience.tvscience.fragment.FragmentA;
import com.example.tvscience.tvscience.fragment.FragmentB;
import com.example.tvscience.tvscience.fragment.FragmentC;
import com.example.tvscience.tvscience.global.GlobalConfig;
import com.example.tvscience.tvscience.utils.T;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.vov.vitamio.widget.VideoView;
import okhttp3.Call;
import reco.frame.tv.view.TvButton;
import reco.frame.tv.view.TvTabHost;
import timber.log.Timber;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private Unbinder unbinder;
    @BindView(R.id.uvv_vido)VideoView upVideoView;
    @BindViews({R.id.tv_btn_science,R.id.tv_btn_dance,R.id.tv_btn_song,R.id.tv_btn_enlightenment
    ,R.id.tiv_image1,R.id.tiv_image2,R.id.tiv_image3,R.id.tiv_image4,R.id.tiv_image5,R.id.tiv_image6})
    List<TvButton> tvButtonList;
    @BindViews({R.id.iv_home,R.id.iv_home_monk,R.id.iv_home_cate_one,R.id.iv_home_go_home,R.id.iv_home_cate_two})
    List<TvButton> buttonList;
    private static Activity mActivity;
    String path = "http://gdsc.cmshop.net/kpmh/uploads/file/20170420/20170420054804.mp4 ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        mActivity = this;

//        upVideoView.setFocusable(false);
//        upVideoView.setFocusableInTouchMode(false);
//        buttonList.get(0).setFocusable(true);
//        buttonList.get(0).setFocusableInTouchMode(true);

        buttonList.get(0).setFocusable(true);
        buttonList.get(0).setFocusableInTouchMode(true);
        buttonList.get(0).requestFocus();
        buttonList.get(0).requestFocusFromTouch();

        upVideoView.setOnClickListener(this);
        tvButtonList.get(0).setOnClickListener(this);
        tvButtonList.get(1).setOnClickListener(this);
        tvButtonList.get(2).setOnClickListener(this);
        tvButtonList.get(3).setOnClickListener(this);
        tvButtonList.get(4).setOnClickListener(this);
        tvButtonList.get(5).setOnClickListener(this);
        tvButtonList.get(6).setOnClickListener(this);
        tvButtonList.get(7).setOnClickListener(this);
        tvButtonList.get(8).setOnClickListener(this);
        tvButtonList.get(9).setOnClickListener(this);
        buttonList.get(0).setOnClickListener(this);
        buttonList.get(1).setOnClickListener(this);
        buttonList.get(2).setOnClickListener(this);
        buttonList.get(3).setOnClickListener(this);
        buttonList.get(4).setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        upVideoView.setVideoPath(path);
//        upVideoView.start();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode){
            case KeyEvent.KEYCODE_1:
                Intent intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","22");
                startActivity(intent);
                break;

            case KeyEvent.KEYCODE_2:
//                T.showShort(mActivity,"你按下2键");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","32");
                startActivity(intent);
                break;

            case KeyEvent.KEYCODE_3:
//                T.showShort(mActivity,"你按下3键");
                intent = new Intent(mActivity, PayProtocolActivity.class);
//                intent.putExtra("category","30");
                startActivity(intent);
                break;

            case KeyEvent.KEYCODE_4:
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","31");
                startActivity(intent);
                break;

            case KeyEvent.KEYCODE_5:
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","21");
                startActivity(intent);
                break;
            case KeyEvent.KEYCODE_6:
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","29");
                startActivity(intent);
                break;
            case KeyEvent.KEYCODE_7:
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","28");
                startActivity(intent);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.uvv_vido:
                T.showShort(mActivity, "video");
                break;
            case R.id.iv_home:
                T.showShort(mActivity, "首页");
                break;
            case R.id.iv_home_monk:
//                T.showShort(mActivity, "布袋小和尚");
                Intent intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","22");
                startActivity(intent);
                break;
            case R.id.iv_home_cate_one:
//                T.showShort(mActivity, "美食大冒险一");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","14");
                startActivity(intent);
                break;
            case R.id.iv_home_go_home:
//                T.showShort(mActivity, "我要回家");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","11");
                startActivity(intent);
                break;
            case R.id.iv_home_cate_two:
//                T.showShort(mActivity, "美食大冒险二");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","21");
                startActivity(intent);
                break;
            case R.id.tv_btn_science:
//                T.showShort(mActivity, "少儿科普");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","2");
                startActivity(intent);
                break;
            case R.id.tv_btn_dance:
//                T.showShort(mActivity, "少儿舞蹈");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","17");
                startActivity(intent);
                break;
            case R.id.tv_btn_song:
//                T.showShort(mActivity, "少儿歌曲");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","15");
                startActivity(intent);
                break;
            case R.id.tv_btn_enlightenment:
//                T.showShort(mActivity, "少儿启蒙");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","18");
                startActivity(intent);
                break;
            case R.id.tiv_image1:
//                T.showShort(mActivity, "image1");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","28");
                startActivity(intent);
                break;
            case R.id.tiv_image2:
//                T.showShort(mActivity, "image2");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","32");
                startActivity(intent);
                break;
            case R.id.tiv_image3:
//                T.showShort(mActivity, "image3");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","29");
                startActivity(intent);
                break;
            case R.id.tiv_image4:
//                T.showShort(mActivity, "image4");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","30");
                startActivity(intent);
                break;
            case R.id.tiv_image5:
//                T.showShort(mActivity, "image5");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","31");
                startActivity(intent);
                break;
            case R.id.tiv_image6:
//                T.showShort(mActivity, "image6");
                intent = new Intent(mActivity, MonkActivity.class);
                intent.putExtra("category","21");
                startActivity(intent);
                break;

        }
    }
}
