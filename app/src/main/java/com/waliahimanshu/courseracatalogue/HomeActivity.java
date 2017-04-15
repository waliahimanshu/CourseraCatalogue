package com.waliahimanshu.courseracatalogue;

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
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    public static String TAG = HomeActivity.class.getSimpleName();

    @BindView(R.id.start)
    EditText startView;

    @BindView(R.id.limit)
    EditText limitView;

    @BindView(R.id.search)
    SearchView searchView;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ActivityPresenter activityPresenter;
    private SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextSubmit(String query) {

            String start = startView.getText().toString();
            String limit = limitView.getText().toString();
            Response<CoursesResponse> response = activityPresenter.loadData(query, start, limit);

            if(response.isSuccessful()){
                setUpRecyclerView(response.body());
            }

            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        activityPresenter = new ActivityPresenter();

        setUpSearch();
    }

    private void setUpSearch() {
        searchView.setIconifiedByDefault(false);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(listener);

    }

    private void setUpRecyclerView(CoursesResponse coursesResponse) {
        MyAdapter adapter = new MyAdapter(this, coursesResponse.courses);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
