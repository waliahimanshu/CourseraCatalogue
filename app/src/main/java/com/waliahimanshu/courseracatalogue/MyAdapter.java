package com.waliahimanshu.courseracatalogue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.waliahimanshu.courseracatalogue.Service.Courses;

import java.util.Arrays;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<Courses> courses;
    private String TAG = MyAdapter.class.getSimpleName();

    MyAdapter(Context context, List<Courses> courses) {
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
        Courses currentObject = courses.get(position);
        holder.setData(currentObject);

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView courseName;
        private final TextView instructorName;
        private final TextView partnerName;

        MyViewHolder(View itemView) {
            super(itemView);

            courseName = (TextView) itemView.findViewById(R.id.course_name);
            instructorName = (TextView) itemView.findViewById(R.id.instructor_id);
            partnerName = (TextView) itemView.findViewById(R.id.partner_id);
        }

        void setData(Courses currentObject) {

            courseName.setText(currentObject.name);
            instructorName.setText(Arrays.toString(currentObject.instructorIds));
            partnerName.setText(Arrays.toString(currentObject.partnerIds));
        }
    }
}
