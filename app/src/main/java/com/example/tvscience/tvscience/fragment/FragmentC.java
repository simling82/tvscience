package com.example.tvscience.tvscience.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tvscience.tvscience.R;

/**
 * Created by admin on 2017/5/22.
 */

public class FragmentC extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.frag_b, container, false);
        return parent;
    }
}
