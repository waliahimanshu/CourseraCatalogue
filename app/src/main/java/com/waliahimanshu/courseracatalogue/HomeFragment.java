package com.waliahimanshu.courseracatalogue;

import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waliahimanshu.courseracatalogue.Service.CoursesResponse;
import com.waliahimanshu.courseracatalogue.Service.RetrofitRestClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

public class HomeFragment extends Fragment {
  public static String TAG = HomeFragment.class.getSimpleName();

  @BindView(R.id.search_view)
  SearchView searchView;

  private HomeFragmentPresenter homeFragmentPresenter;

  private SearchView.OnQueryTextListener listener =
      new SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextSubmit(String query) {
          return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
          homeFragmentPresenter.onQueryTextChange(newText);
          return false;
        }
      };

  @Override
  public View onCreateView(
      LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.home_fragment, container, false);
    ButterKnife.bind(this, view);
    homeFragmentPresenter =
        new HomeFragmentPresenter(new HomeFragmentView(getActivity().getBaseContext(), view));
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
    searchView.setOnQueryTextListener(listener);
  }

  /** retrofit async call. */
  private void getDataViaApiAsynchronously(String query) {
    Call<CoursesResponse> responseCall = new RetrofitRestClient().search(query);
    responseCall.enqueue(
        new Callback<CoursesResponse>() {
          @Override
          public void onResponse(
              Call<CoursesResponse> call, retrofit2.Response<CoursesResponse> response) {
            if (response.isSuccessful()) {
              //do stuff
            }
          }

          @Override
          public void onFailure(Call<CoursesResponse> call, Throwable t) {
            Log.e(TAG, "Failed to call the coursera api ", t);
          }
        });
  }
}
