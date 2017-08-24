package com.example.tvscience.tvscience.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import timber.log.Timber;

/**
 * Created by admin on 2017/5/23.
 */

public class BaseApplication extends Application {

    private static Context mContext;
    private static Thread mMainThread;
    private static long mMainThreadId;
    private static Looper mMainLooper;
    private static Handler mMainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();// 上下文
        mMainThread = Thread.currentThread();// 主线程
        mMainThreadId = android.os.Process.myTid();// 主线程id
        mMainLooper = getMainLooper();// 主线程的Looper
        mMainHandler = new Handler();// 主线程的Handler

        Timber.plant(new Timber.DebugTree());//Timber初始化

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
