package com.waliahimanshu.courseracatalogue.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.waliahimanshu.courseracatalogue.ui.courses.CoursesFragment;
import com.waliahimanshu.courseracatalogue.ui.partners.PartnersFragment;

/**
 * Created by waliahimanshu.
 */

public class HomeActivityPagerAdapter extends FragmentPagerAdapter {

    public HomeActivityPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private String tabTitles[] = new String[]{"Courses", "Universities", "Instructors"};

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CoursesFragment();
        } else {
            return new PartnersFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
