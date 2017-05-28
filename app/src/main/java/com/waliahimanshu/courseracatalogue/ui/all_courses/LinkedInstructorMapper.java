package com.waliahimanshu.courseracatalogue.ui.all_courses;

import com.waliahimanshu.courseracatalogue.api.response_dto.Instructors;
import com.waliahimanshu.courseracatalogue.ui.all_courses.domain.InfoDomain;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.BiFunction;

/**
 * Created by waliahimanshu.
 */

public class LinkedInstructorMapper implements BiFunction<List<String>, List<Instructors>, List<InfoDomain>> {

    @Override
    public List<InfoDomain> apply(List<String> courseInstructorIds, List<Instructors> instructors) throws Exception {
        ArrayList<InfoDomain> moreInfoDomains = new ArrayList<>();
        for (Instructors linkedInstructor : instructors) {
            if (courseInstructorIds.contains(linkedInstructor.id)) {
                moreInfoDomains.add(new InfoDomain(linkedInstructor.name, linkedInstructor.id));
            }
        }
        return moreInfoDomains;
    }
}
