package com.waliahimanshu.courseracatalogue;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    public static String TAG = HomeActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        // adds Fragment to activity, can be added via xml.
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        HomeFragment fragment = new HomeFragment();

        // to pass data from activity to fragment
        // fragment.setArguments(new Bundle());

        // enable back button
        // transaction.addToBackStack("");
        // manager.popBackStack();

        transaction.add(R.id.container, fragment, HomeFragment.class.getSimpleName());
        transaction.commit();
    }
}
