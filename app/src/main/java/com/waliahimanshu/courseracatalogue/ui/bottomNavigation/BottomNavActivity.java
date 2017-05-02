package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.ui.home.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomNavActivity extends AppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationView navigationView;


    AllCoursesFragment coursesFragment = new AllCoursesFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:

                getSupportFragmentManager().beginTransaction().
                        replace(R.id.container, coursesFragment, "courses").commit();
                return true;
            case R.id.navigation_search:
                Intent homeActivity = new Intent(getBaseContext(), SearchActivity.class);
                startActivity(homeActivity);

                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        ButterKnife.bind(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
}
