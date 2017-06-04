package com.waliahimanshu.courseracatalogue.ui.courses;

import com.waliahimanshu.courseracatalogue.api.instructors.InstructorsDto;
import com.waliahimanshu.courseracatalogue.ui.domain.InfoDomain;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.BiFunction;

/**
 * Created by waliahimanshu.
 */

public class LinkedInstructorMapper implements BiFunction<List<String>, List<InstructorsDto>, List<InfoDomain>> {

    @Override
    public List<InfoDomain> apply(List<String> courseInstructorIds, List<InstructorsDto> instructors) throws Exception {
        ArrayList<InfoDomain> moreInfoDomains = new ArrayList<>();
        for (InstructorsDto linkedInstructor : instructors) {
            if (courseInstructorIds.contains(linkedInstructor.id)) {
                moreInfoDomains.add(new InfoDomain(linkedInstructor.name, linkedInstructor.id));
            }
        }
        return moreInfoDomains;
    }
}
