package com.waliahimanshu.courseracatalogue.ui.home;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.waliahimanshu.courseracatalogue.R;


/**
 * adds Fragment to activity, can be added via xml.
 * to pass data from activity to fragment
 * {@code fragment.setArguments(new Bundle()); }
 * <p>
 * to enable back button
 * {@code transaction.addToBackStack("");
 * manager.popBackStack();}
 */
public class HomeActivity extends AppCompatActivity {
    public static String TAG = HomeActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        HomeFragment fragment = new HomeFragment();

        transaction.add(R.id.container, fragment, HomeFragment.class.getSimpleName());
        transaction.commit();
        Log.d(TAG,"Fragment transaction committed");
    }
}
