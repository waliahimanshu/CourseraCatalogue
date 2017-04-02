package com.waliahimanshu.courseracatalogue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;

public class TestActivity extends AppCompatActivity {
    public static String TAG = TestActivity.class.getSimpleName();
    private CoursesResponse resp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        //inflate layout and init widgets
        Log.i(TAG, "On create");

//        setUpRecyclerView();
    }


    public void onClickDisplay(View view) {
        setUpRecyclerView();
    }

    public void onClick(View view) {
        getDataViaApi();

    }
    private void getDataViaApi() {
        Call<CoursesResponse> responseCall = new RetrofitServiceImpl().listRepos();


        responseCall.enqueue(new Callback<CoursesResponse>() {
            @Override
            public void onResponse(Call<CoursesResponse> call, retrofit2.Response<CoursesResponse> response) {

                response.code();
                resp = response.body();
            }


            @Override
            public void onFailure(Call<CoursesResponse> call, Throwable t) {

                t.printStackTrace();
            }
        });

    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        MyAdapter adapter = new MyAdapter(this, resp.courses);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
    }


    @Override
    protected void onStart() {
        super.onStart();
        //activity visible to user but can not interact
        Log.i(TAG, "On start");

    }


    @Override
    protected void onResume() {
        super.onResume();
        // visible and can interact
        Log.i(TAG, "On resume");

    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "On pause");

        //user navigates to second activity
       // super.onCreate(null);
        //super.onStart();
        //super.onResume(); // second activity is visible
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "On stop");


        //first activity stops

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "On restart");

//        super.onStart();
//        super.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "On destroy");

    }

}
