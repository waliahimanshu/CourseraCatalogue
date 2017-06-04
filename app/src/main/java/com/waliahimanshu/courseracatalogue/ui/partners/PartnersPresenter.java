package com.waliahimanshu.courseracatalogue.ui.partners;


import com.waliahimanshu.courseracatalogue.api.CourseraService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PartnersPresenter implements PartnersContract.Presenter {

    private CourseraService apiService;
    private PartnersContract.View view;
    private PartnerDetailsDomainMapper responseMapper;

    @Inject
    public PartnersPresenter(PartnersContract.View view, CourseraService apiService, PartnerDetailsDomainMapper responseMapper) {
        this.apiService = apiService;
        this.view = view;
        this.responseMapper = responseMapper;
    }

    @Override
    public void getData() {
        apiService.getPartners()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(responseMapper)
                .subscribe(courseDetailsDomains -> view.initRecyclerView(courseDetailsDomains));

    }
}

