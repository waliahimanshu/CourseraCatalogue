package com.waliahimanshu.courseracatalogue.ui.all_courses.domain;


import java.util.List;

public class CourseDetailsDomain {

    public final String id;
    public final String courseType;
    public final String name;
    public final String slug;
    public String photoUrl;
    public final List<InfoDomain> partnerName;
    public final List<InfoDomain> instructorName;

    public CourseDetailsDomain(String id, String courseType, String name, String slug, String photoUrl, List<InfoDomain> partnerName, List<InfoDomain> instructorName) {
        this.id = id;
        this.courseType = courseType;
        this.name = name;
        this.slug = slug;
        this.photoUrl = photoUrl;
        this.partnerName = partnerName;
        this.instructorName = instructorName;
    }
}
