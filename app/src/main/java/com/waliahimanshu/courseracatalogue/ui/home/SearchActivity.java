package com.waliahimanshu.courseracatalogue.ui.home;

import android.os.Bundle;
import android.support.v7.widget.SearchView;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.ui.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity {
    public static String TAG = SearchActivity.class.getSimpleName();

    @BindView(R.id.search_view)
    SearchView searchView;

    @Inject
    SearchActivityPresenter searchActivityPresenter;

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.search_activity;
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        setUpSearch();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        searchActivityPresenter.unSubscribe();
    }

    private void setUpSearch() {
        searchView.setIconifiedByDefault(false);
//        Activity activity = getActivity();
//        SearchManager searchManager =
//                (SearchManager) getC.getApplicationContext().getSystemService(Context.SEARCH_SERVICE);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity.getComponentName()));
    }
}



