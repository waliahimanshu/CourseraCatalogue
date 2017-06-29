package com.waliahimanshu.courseracatalogue.ui.instructors;

import com.waliahimanshu.courseracatalogue.api.instructors.InstructorResponseDto;
import com.waliahimanshu.courseracatalogue.api.instructors.InstructorsDto;
import com.waliahimanshu.courseracatalogue.api.partners.PartnerResponseDto;
import com.waliahimanshu.courseracatalogue.api.partners.PartnersDto;
import com.waliahimanshu.courseracatalogue.ui.domain.InstructorDetailsDomain;
import com.waliahimanshu.courseracatalogue.ui.domain.PartnerDetailsDomain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

/**
 * Created by waliahimanshu.
 */

public class InstructorDetailsDomainMapper implements Function<InstructorResponseDto, List<InstructorDetailsDomain>> {



    @Inject
    public InstructorDetailsDomainMapper() {
    }

    @Override
    public List<InstructorDetailsDomain> apply(InstructorResponseDto instructorResponseDto) throws Exception {
        ArrayList<InstructorDetailsDomain> instructorDetailsDomains = new ArrayList<>();

        for (InstructorsDto instructorsDto : instructorResponseDto.instructorsDtos) {
            instructorDetailsDomains.add(new InstructorDetailsDomain(
                    instructorsDto.id,
                    instructorsDto.name,
                    instructorsDto.bio,
                    instructorsDto.photo));
        }
        return instructorDetailsDomains;
    }
}
