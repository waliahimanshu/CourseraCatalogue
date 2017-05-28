package com.waliahimanshu.courseracatalogue.ui.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.waliahimanshu.courseracatalogue.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Single;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<CourseDetailsDomain> courses;

    public MyAdapter(Context context, List<CourseDetailsDomain> courses) {
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
            courseName.setText(currentObject.name);

            ArrayList<String> strings = new ArrayList<>();
            for (MoreInfoDomain moreInfoDomain : currentObject.instructorName) {
                strings.add(moreInfoDomain.name);
            }
            instructorName.setText(TextUtils.join(",", strings));

            ArrayList<String> partner = new ArrayList<>();
            for (MoreInfoDomain moreInfoDomain : currentObject.partnerName) {
                partner.add(moreInfoDomain.name);
            }
            partnerName.setText(TextUtils.join(",", partner));


//      DownloadImageTask imageTask = new DownloadImageTask(courseLogo);
//      imageTask.execute(currentObject.photoUrl);

            Picasso.with(itemView.getContext())
                    .load(currentObject.photoUrl)
                    .placeholder(R.drawable.avatar_jen)
                    .error(R.drawable.avatar_moss)
                    .into(courseLogo);
        }
    }
}


