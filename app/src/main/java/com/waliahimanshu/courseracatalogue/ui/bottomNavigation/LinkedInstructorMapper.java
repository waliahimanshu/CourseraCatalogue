package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;

import com.waliahimanshu.courseracatalogue.api.Response.Instructors;
import com.waliahimanshu.courseracatalogue.ui.home.MoreInfoDomain;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.BiFunction;

/**
 * Created by waliahimanshu.
 */

public class LinkedInstructorMapper implements BiFunction<List<String>, List<Instructors>, List<MoreInfoDomain>> {

    @Override
    public List<MoreInfoDomain> apply(List<String> courseInstructorIds, List<Instructors> instructors) throws Exception {
        ArrayList<MoreInfoDomain> moreInfoDomains = new ArrayList<>();

        for (Instructors linkedInstructor : instructors) {

            if (courseInstructorIds.contains(linkedInstructor.id)) {
                moreInfoDomains.add(new MoreInfoDomain(linkedInstructor.name, linkedInstructor.id));
            }
        }

        return moreInfoDomains;
    }
}
