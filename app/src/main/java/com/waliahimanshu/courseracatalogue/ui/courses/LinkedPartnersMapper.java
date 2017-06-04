package com.waliahimanshu.courseracatalogue.ui.courses;

import com.waliahimanshu.courseracatalogue.api.partners.PartnersDto;
import com.waliahimanshu.courseracatalogue.ui.domain.InfoDomain;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.BiFunction;

/**
 * Created by waliahimanshu.
 */

public class LinkedPartnersMapper implements BiFunction<List<String>, List<PartnersDto>, List<InfoDomain>> {

    @Override
    public List<InfoDomain> apply(List<String> partnerIds, List<PartnersDto> partners) throws Exception {
        ArrayList<InfoDomain> moreInfoDomains = new ArrayList<>();

        for (PartnersDto linkedPartnersDto : partners) {

            if (partnerIds.contains(linkedPartnersDto.id)) {
                moreInfoDomains.add(new InfoDomain(linkedPartnersDto.name, linkedPartnersDto.id));
            }
        }
        return moreInfoDomains;
    }
}
