package com.waliahimanshu.courseracatalogue.ui.partners;

import com.waliahimanshu.courseracatalogue.ui.domain.PartnerDetailsDomain;

import java.util.List;

public interface PartnersContract {

    interface Presenter {
        void getData();

    }

    interface View {
        void initRecyclerView(List<PartnerDetailsDomain> partnerDetailsDomains);

    }
}
