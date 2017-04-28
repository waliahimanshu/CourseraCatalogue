package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.ui.home.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomNavActivity extends AppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        return true;
                    case R.id.navigation_search:
                        Intent intent = new Intent(getBaseContext(),HomeActivity.class);
                        startActivity(intent);

                        return true;
                }
                return false;
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
