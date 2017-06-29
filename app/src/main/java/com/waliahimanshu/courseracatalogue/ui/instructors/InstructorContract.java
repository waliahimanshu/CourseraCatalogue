package com.waliahimanshu.courseracatalogue.ui.instructors;

import com.waliahimanshu.courseracatalogue.ui.domain.InstructorDetailsDomain;
import com.waliahimanshu.courseracatalogue.ui.domain.PartnerDetailsDomain;

import java.util.List;

public interface InstructorContract {

    interface Presenter {
        void getData();

    }

    interface View {
        void initRecyclerView(List<InstructorDetailsDomain> instructorDetailsDomains);

    }
}
