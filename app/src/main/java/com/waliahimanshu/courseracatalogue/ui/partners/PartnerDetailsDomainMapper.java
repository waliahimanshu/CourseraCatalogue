package com.waliahimanshu.courseracatalogue.ui.partners;

import com.waliahimanshu.courseracatalogue.api.partners.PartnersDto;
import com.waliahimanshu.courseracatalogue.api.partners.PartnerResponseDto;
import com.waliahimanshu.courseracatalogue.ui.domain.PartnerDetailsDomain;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by waliahimanshu.
 */

public class PartnerDetailsDomainMapper implements Function<PartnerResponseDto, List<PartnerDetailsDomain>> {


    @Override
    public List<PartnerDetailsDomain> apply(PartnerResponseDto partnerResponseDto) throws Exception {
        ArrayList<PartnerDetailsDomain> partnerDetailsDomains = new ArrayList<>();

        for (PartnersDto partnersDto : partnerResponseDto.partners) {
            partnerDetailsDomains.add( new PartnerDetailsDomain(
                    partnersDto.id,
                    partnersDto.name,
                    partnersDto.shortName,
                    partnersDto.logo));
        }
        return partnerDetailsDomains;
    }
}
