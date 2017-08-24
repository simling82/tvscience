package com.example.tvscience.tvscience.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tvscience.tvscience.R;
import com.example.tvscience.tvscience.bean.QueryResult;
import com.example.tvscience.tvscience.bean.Result;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import reco.frame.tv.view.TvImageView;
import reco.frame.tv.view.component.TvBaseAdapter;
import timber.log.Timber;

/**
 * Created by admin on 2017/5/26.
 */

public class TvGridAdapter extends TvBaseAdapter {

    private List<String> name, image;
    List<QueryResult> qr;
    private LayoutInflater inflater;

    public TvGridAdapter(Context context, List<QueryResult> qr) {
        this.qr = qr;
        this.inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return qr.size();
    }

    @Override
    public Object getItem(int position) {
        return qr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {

        ViewHolder holder=null;
        if (contentView==null) {
            contentView=inflater.inflate(R.layout.item_grid, null);

            holder=new ViewHolder();
            holder.tv_title=(TextView) contentView.findViewById(R.id.tv_title);
            holder.tiv_icon=(TvImageView) contentView.findViewById(R.id.tiv_icon);
            contentView.setTag(holder);
        }else{
            holder=(ViewHolder) contentView.getTag();
        }

        QueryResult q = qr.get(position);
        holder.tv_title.setText(q.getName());

        try {
            JSONObject json = new JSONObject(q.getMeta());
            String hashed = json.getString("hashed");
            String h = hashed.substring(2,34);

            String url = "http://172.16.147.83:8080//kpmh/asset/images/"+h+".jpg";
            holder.tiv_icon.configImageUrl(url);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return contentView;
    }

    public void addItem(List<QueryResult> item) {
        qr.addAll(item);
    }

    static class ViewHolder{
        TextView tv_title;
        TvImageView tiv_icon;
    }
}
