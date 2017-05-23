package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.di.ActivityModule;
import com.waliahimanshu.courseracatalogue.di.CourseraApiModule;
import com.waliahimanshu.courseracatalogue.di.DaggerActivityComponent;
import com.waliahimanshu.courseracatalogue.ui.BaseFragment;
import com.waliahimanshu.courseracatalogue.ui.home.RxSearch;
import com.waliahimanshu.courseracatalogue.ui.home.SearchActivityPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class AllCoursesFragment extends BaseFragment {


    @Inject
    AllCoursesPresenter presenter;

    @Inject
    SearchActivityPresenter searchActivityPresenter;

    @BindView(R.id.search)
    android.widget.SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getFragmentId(), container, false);
        ButterKnife.bind(this, view);

        activityModule = new ActivityModule(getContext(), view);
        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .courseraApiModule(new CourseraApiModule())
                .activityModule(activityModule)
                .build();
        injectFrom(activityComponent);
        setUpFragment();

        setupSearch();
        return view;
    }

    private void setupSearch() {
        //         Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getActivity().getComponentName()));

        Observable<String> stringObservable = RxSearch.fromSearchView(searchView);

        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getContext(), "on submit" +query,Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                Toast.makeText(getContext(), "new text enterd" +newText,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void setUpFragment() {
        presenter.getData();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.all_courses_activity;
    }
}
