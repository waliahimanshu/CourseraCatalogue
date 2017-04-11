package com.waliahimanshu.courseracatalogue;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
        SearchView searchView = (SearchView) findViewById(R.id.search);
// Sets searchable configuration defined in searchable.xml for this SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

//        getDataViaApiAsynchronously();
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
                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });

    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        MyAdapter adapter = new MyAdapter(this, resp.courses);
        recyclerView.setAdapter(adapter);

        //diff layout managers
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }

}
