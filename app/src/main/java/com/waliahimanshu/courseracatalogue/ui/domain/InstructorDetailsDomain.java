package com.waliahimanshu.courseracatalogue.ui.domain;

/**
 * Created by waliahimanshu.
 */

public class InstructorDetailsDomain {
    public final String id;
    public final String fullName;
    public final String bio;
    public final String photo;

    public InstructorDetailsDomain(String id, String fullName, String bio, String photo) {

        this.id = id;
        this.fullName = fullName;
        this.bio = bio;
        this.photo = photo;
    }
}