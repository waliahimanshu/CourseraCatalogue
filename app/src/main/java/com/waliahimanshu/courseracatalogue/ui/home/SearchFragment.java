package com.waliahimanshu.courseracatalogue.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.di.ActivityComponent;
import com.waliahimanshu.courseracatalogue.ui.BaseActivity;
import com.waliahimanshu.courseracatalogue.ui.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFragment extends BaseFragment {
    public static String TAG = SearchFragment.class.getSimpleName();

    @BindView(R.id.search_view)
    SearchView searchView;

    @Inject
    SearchActivityPresenter searchActivityPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void injectFrom(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void setUpFragment() {

    }

    @Override
    protected int getFragmentId() {
        return 0;
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



