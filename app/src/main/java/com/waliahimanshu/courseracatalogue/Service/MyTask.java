package com.waliahimanshu.courseracatalogue.Service;

import android.os.AsyncTask;

import java.io.IOException;

import retrofit2.Call;

public class MyTask extends AsyncTask {

    private CoursesResponse body;

    @Override
    protected Object doInBackground(Object[] objects) {

        Call<CoursesResponse> responseCall = new RetrofitRestClient().listAllCourses();

        try {
            body = responseCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}