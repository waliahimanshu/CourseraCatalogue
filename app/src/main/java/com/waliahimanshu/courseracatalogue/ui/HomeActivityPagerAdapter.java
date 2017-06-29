package com.waliahimanshu.courseracatalogue.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.waliahimanshu.courseracatalogue.ui.courses.CoursesFragment;
import com.waliahimanshu.courseracatalogue.ui.instructors.InstructorFragment;
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
        switch (position) {
            case 0:
                return new CoursesFragment();
            case 1:
                return new PartnersFragment();
            case 2:
                return new InstructorFragment();
            default:
                throw new IllegalArgumentException("Not a valid tab position " + position);
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
