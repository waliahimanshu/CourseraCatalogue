package com.waliahimanshu.courseracatalogue.ui.all_courses;

import com.waliahimanshu.courseracatalogue.api.response_dto.Partners;
import com.waliahimanshu.courseracatalogue.ui.all_courses.domain.InfoDomain;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.BiFunction;

/**
 * Created by waliahimanshu.
 */

public class LinkedPartnersMapper implements BiFunction<List<String>, List<Partners>, List<InfoDomain>> {

    @Override
    public List<InfoDomain> apply(List<String> partnerIds, List<Partners> partners) throws Exception {
        ArrayList<InfoDomain> moreInfoDomains = new ArrayList<>();

        for (Partners linkedPartners : partners) {

            if (partnerIds.contains(linkedPartners.id)) {
                moreInfoDomains.add(new InfoDomain(linkedPartners.name, linkedPartners.id));
            }
        }
        return moreInfoDomains;
    }
}
