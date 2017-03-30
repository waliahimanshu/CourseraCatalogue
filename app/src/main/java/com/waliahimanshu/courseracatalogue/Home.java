package com.waliahimanshu.courseracatalogue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        View viewById = (TextView) findViewById(R.id.editText);
        assert viewById != null;

        /**
         * method 3 via xml layout
         */

        /**
         * method 2
         */
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /**
     * method one
     * @param v
     */
    @Override
    public void onClick(View v) {

    }
}
