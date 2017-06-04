package com.waliahimanshu.courseracatalogue.ui.partners;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.ui.domain.PartnerDetailsDomain;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PartnersInfoAdapter extends RecyclerView.Adapter<PartnersInfoAdapter.MyViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<PartnerDetailsDomain> partnerDetailsDomains;

    public PartnersInfoAdapter(Context context, List<PartnerDetailsDomain> partnerDetailsDomains) {
        layoutInflater = LayoutInflater.from(context);
        this.partnerDetailsDomains = partnerDetailsDomains;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.courses_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PartnerDetailsDomain currentObject = partnerDetailsDomains.get(position);
        holder.setData(currentObject);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return partnerDetailsDomains.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.course_name)
        TextView courseName;

        @BindView(R.id.instructor_id)
        TextView instructorName;

        @BindView(R.id.partner_id)
        TextView partnerName;

        @BindView(R.id.course_logo)
        ImageView courseLogo;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(PartnerDetailsDomain currentObject) {
            courseName.setText(currentObject.name);


            instructorName.setText(currentObject.shortName);


            Picasso.with(itemView.getContext())
                    .load(currentObject.logo)
                    .placeholder(R.drawable.default_image)
                    .error(R.drawable.avatar_moss)
                    .into(courseLogo);
        }
    }
}


