package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.ui.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class AllCoursesActivity extends BaseActivity {

    @Inject
    AllCoursesPresenter presenter;

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.all_courses_activity;
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        presenter.getData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view_app_bar, menu);

//         Associate searchable configuration with the SearchView
//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
}
