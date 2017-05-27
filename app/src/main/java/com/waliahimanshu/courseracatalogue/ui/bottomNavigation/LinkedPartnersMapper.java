package com.waliahimanshu.courseracatalogue.ui.bottomNavigation;

import com.waliahimanshu.courseracatalogue.api.Response.Partners;
import com.waliahimanshu.courseracatalogue.ui.home.MoreInfoDomain;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.BiFunction;

/**
 * Created by waliahimanshu.
 */

public class LinkedPartnersMapper implements BiFunction<List<String>, List<Partners>, List<MoreInfoDomain>> {

    @Override
    public List<MoreInfoDomain> apply(List<String> partnerIds, List<Partners> partners) throws Exception {
        ArrayList<MoreInfoDomain> moreInfoDomains = new ArrayList<>();

        for (Partners linkedPartners : partners) {

            if (partnerIds.contains(linkedPartners.id)) {
                moreInfoDomains.add(new MoreInfoDomain(linkedPartners.name, linkedPartners.id));
            }
        }
        return moreInfoDomains;
    }
}
