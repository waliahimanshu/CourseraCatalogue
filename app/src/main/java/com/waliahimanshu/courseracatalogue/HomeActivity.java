package com.waliahimanshu.courseracatalogue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class HomeActivity extends AppCompatActivity  {

    public static String TAG = HomeActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "ON create");
        setContentView(R.layout.activity_home);


        View viewById = findViewById(R.id.editText);
        assert viewById != null;

    }

    public void onClick(View v) {
        v.animate().alphaBy(10);
        startOther();
    }
    private void startOther() {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "on Start");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "on Resume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "on Pause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "On stop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "On destroy");

    }


}
