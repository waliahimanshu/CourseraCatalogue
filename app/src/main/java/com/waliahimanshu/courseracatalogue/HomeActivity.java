package com.waliahimanshu.courseracatalogue;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.waliahimanshu.courseracatalogue.Service.CoursesResponse;
import com.waliahimanshu.courseracatalogue.Service.RetrofitRestClient;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeActivity extends AppCompatActivity {
    public static String TAG = HomeActivity.class.getSimpleName();
    private CoursesResponse resp;
    private String start;
    private String limit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_activity);

        SearchView searchView = (SearchView) findViewById(R.id.search);
        searchView.setIconifiedByDefault(false);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        EditText startView = (EditText) findViewById(R.id.start);
        EditText limitView = (EditText) findViewById(R.id.limit);

        start = startView.getText().toString();
        limit = startView.getText().toString();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                getDataViaApiAsynchronously(query, start, limit);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }


    private void getDataViaApiAsynchronously(String query, String start, String limit) {
        Call<CoursesResponse> responseCall = new RetrofitRestClient().search(query, start, limit);
        responseCall.enqueue(new Callback<CoursesResponse>() {
            @Override
            public void onResponse(Call<CoursesResponse> call, retrofit2.Response<CoursesResponse> response) {
                resp = response.body();
                Gson gson = new Gson();
                Toast.makeText(getBaseContext(), response.code() + " " + response.message(), Toast.LENGTH_LONG).show();
                Log.d(TAG, gson.toJson(response.raw().request().url()));
                if (response.isSuccessful()) {
                    setUpRecyclerView();
                }

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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
