package com.waliahimanshu.courseracatalogue.ui.partners;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.ui.domain.PartnerDetailsDomain;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PartnersView implements PartnersContract.View {

    @BindView(R.id.partner_recycler_view)
    RecyclerView recyclerView;


    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private Context context;

    public PartnersView(Context context, View rootView) {
        this.context = context;
        ButterKnife.bind(this, rootView);

    }

    @Override
    public void initRecyclerView(List<PartnerDetailsDomain> partnerDetailsDomains) {
        PartnersInfoAdapter adapter = new PartnersInfoAdapter(context, partnerDetailsDomains);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

}
