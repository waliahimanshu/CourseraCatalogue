package com.waliahimanshu.courseracatalogue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity  {

    public static String TAG = HomeActivity.class.getSimpleName();
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "ON create");
        setContentView(R.layout.activity_home);


        EditText viewById = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);


    }



    public void onClick(View v) {
    startOther();

    }
    public void onClickTextTwo(View view) {
     button.setText("Clicked by View text 2");
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "on SaveInstanceState");
        outState.putString("TEXT", button.getText().toString());

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
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "on RestoreInstanceState");

        String text = (String)savedInstanceState.get("TEXT");
        button.setText(text);


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
