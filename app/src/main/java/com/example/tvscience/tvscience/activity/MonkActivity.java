package com.example.tvscience.tvscience.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import com.example.tvscience.tvscience.R;
import com.example.tvscience.tvscience.adapter.TvGridAdapter;
import com.example.tvscience.tvscience.bean.QueryResult;
import com.example.tvscience.tvscience.bean.Result;
import com.example.tvscience.tvscience.global.GlobalConfig;
import com.example.tvscience.tvscience.utils.T;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import reco.frame.tv.view.TvButton;
import reco.frame.tv.view.TvGridView;
import timber.log.Timber;

public class MonkActivity extends Activity {

    private Unbinder unbinder;
    public static Activity mActivity;
    @BindView(R.id.tgv_imagelist)
    TvGridView imagelist;
    @BindView(R.id.tb_add)
    TvButton tb_add;

    private String count;
    private String category;

    public void getCount(String count) {
        this.count = count;
    }

    private List<QueryResult> mQueryResult = new ArrayList<>();
    private TvGridAdapter adapter;
    private int d;
    private int a = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monk);
        //绑定activity
        unbinder = ButterKnife.bind(this);
        mActivity = this;
        Intent intent = getIntent();
        category = intent.getStringExtra("category");
        load();

    }

    private void load() {
        OkHttpUtils.get().url(GlobalConfig.GRIDLIST).addParams("category", category)
                .addParams("start", "0").addParams("size", "10").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<QueryResult>>() {
                }.getType();
                mQueryResult = gson.fromJson(response, type);
                adapter = new TvGridAdapter(mActivity, mQueryResult);
                imagelist.setAdapter(adapter);

            }
        });

        OkHttpUtils.get().url(GlobalConfig.ALWAYS_PUT).addParams("category", category)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String count = jsonObject.getString("count");
                    getCount(count);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        imagelist.setOnItemSelectListener(new TvGridView.OnItemSelectListener() {
            @Override
            public void onItemSelect(View item, final int position) {
                item.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        switch (event.getKeyCode()) {
                            case KeyEvent.KEYCODE_DPAD_UP:
                                switch (position) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        d--;
                                        break;
                                }
                                break;
                            case KeyEvent.KEYCODE_DPAD_DOWN:
                                int datasize = Integer.parseInt(count);
                                int count = adapter.getCount();
                                d++;
                                if (d % 2 == 0) {
                                    int c = ((a++) * 10);
                                    if (c <= datasize) {
                                        OkHttpUtils.get().url(GlobalConfig.GRIDLIST).addParams("category", category)
                                                .addParams("start", c + "").addParams("size", "10").build().execute(new StringCallback() {
                                            @Override
                                            public void onError(Call call, Exception e, int id) {

                                            }

                                            @Override
                                            public void onResponse(String response, int id) {
                                                Gson gson = new Gson();
                                                List<QueryResult> qr = new ArrayList<QueryResult>();
                                                Type type = new TypeToken<ArrayList<QueryResult>>() {
                                                }.getType();
                                                qr = gson.fromJson(response, type);

                                                adapter.addItem(qr);
                                                adapter.notifyDataSetChanged();
                                            }

                                        });
                                    }
                                    break;
                                }

                        }

                        return false;
                    }
                });


            }
        });

        imagelist.setOnItemClickListener(new TvGridView.OnItemClickListener() {
            @Override
            public void onItemClick(View item, int position) {
                Intent intent = new Intent(mActivity, VideoViewActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

}
