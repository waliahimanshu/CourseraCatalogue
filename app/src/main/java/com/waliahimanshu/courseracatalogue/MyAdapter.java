package com.waliahimanshu.courseracatalogue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.waliahimanshu.courseracatalogue.Service.Courses;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<Courses> courses;
    private String TAG = MyAdapter.class.getSimpleName();

    public MyAdapter(Context context , List<Courses> courses) {
        layoutInflater = LayoutInflater.from(context);

        this.courses = courses;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //this is re-used after initial view
        Log.i(TAG, "onCreateViewHolder");
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder" + position);
        Courses currentObject = courses.get(position);
        holder.setData(currentObject, position);

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView courseName;
        private final TextView courseType;
        private final TextView number;

        public MyViewHolder(View itemView) {
            super(itemView);

            courseName = (TextView) itemView.findViewById(R.id.course_name);
            courseType = (TextView) itemView.findViewById(R.id.course_type);
            number = (TextView) itemView.findViewById(R.id.position);
        }

        public void setData(Courses currentObject, int position) {

            courseName.setText(currentObject.name);
            courseType.setText(currentObject.courseType);
            number.setText(Integer.toString(position));


        }
    }
}
