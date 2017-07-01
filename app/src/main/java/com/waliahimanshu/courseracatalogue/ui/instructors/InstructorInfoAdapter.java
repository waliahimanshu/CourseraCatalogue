package com.waliahimanshu.courseracatalogue.ui.instructors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.waliahimanshu.courseracatalogue.R;
import com.waliahimanshu.courseracatalogue.ui.domain.InstructorDetailsDomain;
import com.waliahimanshu.courseracatalogue.util.CircleTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstructorInfoAdapter extends RecyclerView.Adapter<InstructorInfoAdapter.MyViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<InstructorDetailsDomain> instructorDetailsDomains;

    public InstructorInfoAdapter(Context context, List<InstructorDetailsDomain> instructorDetailsDomains) {
        layoutInflater = LayoutInflater.from(context);
        this.instructorDetailsDomains = instructorDetailsDomains;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.courses_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InstructorDetailsDomain currentObject = instructorDetailsDomains.get(position);
        holder.setData(currentObject);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return instructorDetailsDomains.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.description)
        TextView description;

        @BindView(R.id.image)
        ImageView instructorLogo;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setData(InstructorDetailsDomain instructorDomain) {
            title.setText(instructorDomain.fullName);
            description.setText(instructorDomain.bio);

                Picasso.with(itemView.getContext())
                        .load(instructorDomain.photo)
                        .placeholder(R.drawable.ic_tag_faces_black_24dp)
                        .transform(new CircleTransform())
                        .into(instructorLogo);
            }
        }
    }


