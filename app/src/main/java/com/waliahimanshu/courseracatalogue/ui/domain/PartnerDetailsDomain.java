package com.waliahimanshu.courseracatalogue.ui.domain;

/**
 * Created by waliahimanshu.
 */

public class PartnerDetailsDomain {
   public final String id;
   public final String name;
   public final String shortName;
   public final String logo;

    public PartnerDetailsDomain(String id, String name, String shortName, String logo) {

        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.logo = logo;
    }
}
