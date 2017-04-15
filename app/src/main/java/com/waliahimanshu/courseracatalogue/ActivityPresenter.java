package com.waliahimanshu.courseracatalogue;

import android.util.Log;

import com.waliahimanshu.courseracatalogue.Service.CoursesResponse;
import com.waliahimanshu.courseracatalogue.Service.RetrofitRestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class ActivityPresenter implements HomeActivityContract.Presenter {
    private static String TAG = ActivityPresenter.class.getSimpleName();
    private Response<CoursesResponse> coursesResponse;

    @Override
    public Response<CoursesResponse> loadData(String query, String start, String limit) {
        getDataViaApiAsynchronously(query, start, limit);
        return coursesResponse;
    }

    private void getDataViaApiAsynchronously(String query, String start, String limit) {
        Call<CoursesResponse> responseCall = new RetrofitRestClient().search(query, start, limit);
        responseCall.enqueue(new Callback<CoursesResponse>() {
            @Override
            public void onResponse(Call<CoursesResponse> call, retrofit2.Response<CoursesResponse> response) {
                coursesResponse = response;
                if (response.isSuccessful()) {
//                    setUpRecyclerView();
                }
            }
            @Override
            public void onFailure(Call<CoursesResponse> call, Throwable t) {
                Log.e(TAG, "Failed to call the coursera api ", t);
            }
        });
    }
}
