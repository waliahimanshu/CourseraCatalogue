package com.waliahimanshu.courseracatalogue.ui.courses;

import com.waliahimanshu.courseracatalogue.api.courses.CoursesDto;
import com.waliahimanshu.courseracatalogue.api.courses.CoursesResponse;
import com.waliahimanshu.courseracatalogue.ui.domain.CourseDetailsDomain;
import com.waliahimanshu.courseracatalogue.ui.domain.InfoDomain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

public class CoursesDetailDomainMapper implements Function<CoursesResponse, List<CourseDetailsDomain>> {

    private LinkedInstructorMapper instructorMapper;
    private LinkedPartnersMapper linkedPartnersMapper;

    @Inject
    public CoursesDetailDomainMapper(LinkedInstructorMapper instructorMapper, LinkedPartnersMapper linkedPartnersMapper) {
        this.instructorMapper = instructorMapper;
        this.linkedPartnersMapper = linkedPartnersMapper;
    }

    @Override
    public List<CourseDetailsDomain> apply(CoursesResponse courses) throws Exception {

        ArrayList<CourseDetailsDomain> courseDetailsDomains = new ArrayList<>();

        for (CoursesDto course : courses.course) {
            List<InfoDomain> partnersId = linkedPartnersMapper.apply(course.partnerIds, courses.linkedDto.partners);
            List<InfoDomain> instructorIds = instructorMapper.apply(course.instructorIds, courses.linkedDto.instructors);
            courseDetailsDomains.add( new CourseDetailsDomain(
                    course.id,
                    course.courseType,
                    course.name,
                    course.slug,
                    course.photoUrl,
                    partnersId,
                    instructorIds));
        }
        return courseDetailsDomains;
    }
}
