package com.waliahimanshu.courseracatalogue.ui.home;


import java.util.List;

public class CourseDetailsDomain {

    public final String id;
    public final String courseType;
    public final String name;
    public final String slug;
    public final List<MoreInfoDomain> partnerName;
    public final List<MoreInfoDomain> instructorName;

    public CourseDetailsDomain(String id, String courseType, String name, String slug, List<MoreInfoDomain> partnerName, List<MoreInfoDomain> instructorName) {
        this.id = id;
        this.courseType = courseType;
        this.name = name;
        this.slug = slug;
        this.partnerName = partnerName;
        this.instructorName = instructorName;
    }
}
