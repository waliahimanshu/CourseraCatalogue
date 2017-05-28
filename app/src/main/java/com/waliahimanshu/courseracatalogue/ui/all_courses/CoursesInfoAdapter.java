package com.waliahimanshu.courseracatalogue.ui.all_courses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.ui.all_courses.domain.CourseDetailsDomain;
import com.waliahimanshu.courseracatalogue.ui.all_courses.domain.InfoDomain;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoursesInfoAdapter extends RecyclerView.Adapter<CoursesInfoAdapter.MyViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<CourseDetailsDomain> courses;

    public CoursesInfoAdapter(Context context, List<CourseDetailsDomain> courses) {
        layoutInflater = LayoutInflater.from(context);
        this.courses = courses;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CourseDetailsDomain currentObject = courses.get(position);
        holder.setData(currentObject);
    }

    @Override
    public int getItemCount() {
        return courses.size();
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

        void setData(CourseDetailsDomain currentObject) {
            courseName.setText(currentObject.getName());

            ArrayList<String> strings = new ArrayList<>();
            for (InfoDomain moreInfoDomain : currentObject.getInstructorName()) {
                strings.add(moreInfoDomain.getName());
            }
            instructorName.setText(TextUtils.join(",", strings));

            ArrayList<String> partner = new ArrayList<>();
            for (InfoDomain moreInfoDomain : currentObject.getPartnerName()) {
                partner.add(moreInfoDomain.getName());
            }
            partnerName.setText(TextUtils.join(",", partner));

            Picasso.with(itemView.getContext())
                    .load(currentObject.getPhotoUrl())
                    .placeholder(R.drawable.avatar_jen)
                    .error(R.drawable.avatar_moss)
                    .into(courseLogo);
        }
    }
}


