package com.waliahimanshu.courseracatalogue.ui.home;

import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.di.CourseraApiModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {
    public static String TAG = HomeFragment.class.getSimpleName();

    @BindView(R.id.search_view)
    SearchView searchView;

    @Inject
    HomeFragmentPresenter homeFragmentPresenter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, view);

        DaggerHomeActivityComponent.builder()
                .courseraApiModule(new CourseraApiModule())
                .homeModule(new HomeModule(getActivity().getBaseContext(), view))
                .build().inject(this);

        setUpSearch();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homeFragmentPresenter.unSubscribe();
    }

    private void setUpSearch() {
        searchView.setIconifiedByDefault(false);
        Activity activity = getActivity();
        SearchManager searchManager =
                (SearchManager) activity.getApplicationContext().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity.getComponentName()));
    }
}



