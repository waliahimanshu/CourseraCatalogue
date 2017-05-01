package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.api.CourseraApiService;
import com.waliahimanshu.courseracatalogue.api.Response.CoursesResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Single;

public class AllCoursesActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_courses_activity);
        ButterKnife.bind(this);

        View view = this.getWindow().getDecorView();

        DaggerAllCoursesActivityComponent.builder().
                allCoursesModule(new AllCoursesModule(getBaseContext(),view))
                .build().inject(this);

    }

}
