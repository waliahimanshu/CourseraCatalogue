package com.waliahimanshu.courseracatalogue.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.waliahimanshu.courseracatalogue.R;

/**
 * Created by waliahimanshu.
 */

public class FragmentOne extends Fragment {

    public static Fragment newInstance(int i) {
        FragmentOne fragmentOne = new FragmentOne();
        Bundle bundle = new Bundle();
        bundle.putInt("num", i);
        fragmentOne.setArguments(bundle);
        return fragmentOne;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        int num = getArguments().getInt("num");

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        TextView pageTitle = (TextView) view.findViewById(R.id.pageTitle);
//        pageTitle.setText("--> " + num);

        return view;
    }
}
