package com.waliahimanshu.courseracatalogue.ui.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.api.Response.Courses;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class SearchActivityView implements SearchActivityContract.View {
    private Context baseContext;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.no_of_api_calls)
    TextView noOfApiCalls;

    @BindView(R.id.search_view)
    android.support.v7.widget.SearchView searchView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    public SearchActivityView(Context baseContext, View view) {
        this.baseContext = baseContext;
        ButterKnife.bind(this, view);
    }

    @Override
    public void initRecyclerView(List<Courses> courses) {
        setUpRecyclerView(courses);
    }

    @Override
    public void setApiCallTextView(int count) {
        noOfApiCalls.setText(String.format(Locale.getDefault(),
                "%s%d", baseContext.getString(R.string.no_of_api_calls), count));
    }

    @Override
    public Observable<String> getSearchViewQueryTextChangesObservable() {
        return RxSearch.fromSearchView(searchView);
    }

    @Override
    public void showProgressBar(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError() {

    }

    private void setUpRecyclerView(List<Courses> courses) {
        MyAdapter adapter = new MyAdapter(baseContext, courses);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
