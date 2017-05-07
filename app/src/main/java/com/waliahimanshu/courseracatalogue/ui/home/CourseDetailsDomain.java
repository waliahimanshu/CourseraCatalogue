package com.waliahimanshu.courseracatalogue.ui.home;


import java.util.List;

public class CourseDetailsDomain {

    public final String name;
    public final List<String> partnerName;
    public final List<String> InstructorName;

    public CourseDetailsDomain(String name, List<String> partnerName, List<String> instructorName) {
        this.name = name;
        this.partnerName = partnerName;
        InstructorName = instructorName;
    }
}
