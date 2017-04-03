package com.waliahimanshu.courseracatalogue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.waliahimanshu.courseracatalogue.Service.CoursesResponse;
import com.waliahimanshu.courseracatalogue.Service.RetrofitRestClient;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeActivity extends AppCompatActivity {
    public static String TAG = HomeActivity.class.getSimpleName();
    private CoursesResponse resp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_activity);
        //inflate layout and init widgets

        Log.i(TAG, "On create");

        getDataViaApiAsynchronously();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //activity visible to user but can not interact
        Log.i(TAG, "On start");


    }

    // Execute the call asynchronously. Get a positive or negative callback.
    private void getDataViaApiAsynchronously() {
        Call<CoursesResponse> responseCall = new RetrofitRestClient().listAllCourses();
        responseCall.enqueue(new Callback<CoursesResponse>() {
            @Override
            public void onResponse(Call<CoursesResponse> call, retrofit2.Response<CoursesResponse> response) {

                response.code();
                resp = response.body();
                setUpRecyclerView();

            }


            @Override
            public void onFailure(Call<CoursesResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });

    }

    private void getDataSynchronously() {


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Call<CoursesResponse> responseCall = new RetrofitRestClient().listAllCourses();
//                try {
//                    resp = responseCall.execute().body();
//                    Log.i(TAG, "Task finished");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();


    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        MyAdapter adapter = new MyAdapter(this, resp.courses);
        recyclerView.setAdapter(adapter);

        //diff layout managers
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
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
