package com.waliahimanshu.courseracatalogue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class TestActivity extends AppCompatActivity {
    public static String TAG = TestActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.relative);
        //inflate layout and init widgets
        Log.i(TAG, "On create");
    }


    @Override
    protected void onStart() {
        super.onStart();
        //activity visible to user but can not interact
        Log.i(TAG, "On start");

    }


    @Override
    protected void onResume() {
        super.onResume();
        // visible and can interact
        Log.i(TAG, "On resume");

    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "On pause");

        //user navigates to second activity
       // super.onCreate(null);
        //super.onStart();
        //super.onResume(); // second activity is visible
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "On stop");


        //first activity stops

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "On restart");

//        super.onStart();
//        super.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "On destroy");

    }

    public void onClick(View view) {
    }
}
