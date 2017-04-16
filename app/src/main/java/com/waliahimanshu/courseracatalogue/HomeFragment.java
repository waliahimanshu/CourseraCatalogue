package com.waliahimanshu.courseracatalogue;

import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.waliahimanshu.courseracatalogue.Service.Courses;
import com.waliahimanshu.courseracatalogue.Service.CoursesResponse;
import com.waliahimanshu.courseracatalogue.Service.RetrofitRestClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

public class HomeFragment extends Fragment {
    public static String TAG = HomeFragment.class.getSimpleName();

    @BindView(R.id.search_view)
    SearchView searchView;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ActivityPresenter activityPresenter;
    private SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextSubmit(String query) {
            getDataViaApiAsynchronously(query);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, view);
        setUpSearch();
        return view;

    }

    private void setUpSearch() {
        searchView.setIconifiedByDefault(false);
        Activity activity = getActivity();
        SearchManager searchManager = (SearchManager) activity.getApplicationContext().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity.getComponentName()));
        searchView.setOnQueryTextListener(listener);

    }

    private void setUpRecyclerView(List<Courses> courses) {
        Activity activity = getActivity();
        MyAdapter adapter = new MyAdapter(activity.getBaseContext(), courses);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity.getBaseContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void getDataViaApiAsynchronously(String query) {
        Call<CoursesResponse> responseCall = new RetrofitRestClient().search(query);
        responseCall.enqueue(new Callback<CoursesResponse>() {
            @Override
            public void onResponse(Call<CoursesResponse> call, retrofit2.Response<CoursesResponse> response) {
                if (response.isSuccessful()) {
                    if(response.body().courses.isEmpty())
                    {
                        Toast.makeText(getActivity().getBaseContext(),"Success but no data ?",Toast.LENGTH_LONG).show();
                    }
                    setUpRecyclerView(response.body().courses);
                }
            }

            @Override
            public void onFailure(Call<CoursesResponse> call, Throwable t) {
                Log.e(TAG, "Failed to call the coursera api ", t);
            }
        });
    }
}
