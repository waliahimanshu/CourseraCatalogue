package com.waliahimanshu.courseracatalogue;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.EditText;

import com.waliahimanshu.courseracatalogue.Service.CoursesResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    public static String TAG = HomeActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //adds Fragment to activity, can be added via xml.
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, new HomeFragment(), HomeFragment.class.getSimpleName());
        transaction.commit();
    }
}
