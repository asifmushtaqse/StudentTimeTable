package com.climesoft.studenttimetable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.climesoft.studenttimetable.meta.KeyMeta;
import com.climesoft.studenttimetable.util.ActivityUtil;

public class TimeTableActivity extends BaseCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.activity_time_table, null);
        frameLayout.addView(linearLayout);
    }

    public void mondayTimeTable(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(KeyMeta.DAY, "Monday");
        ActivityUtil.moveToActivity(this, TimeTableDetailActivity.class, bundle);
    }
    public void tuesdayTimeTable(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(KeyMeta.DAY, "Tuesday");
        ActivityUtil.moveToActivity(this, TimeTableDetailActivity.class, bundle);
    }
    public void wednesdayTimeTable(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(KeyMeta.DAY, "Wednesday");
        ActivityUtil.moveToActivity(this, TimeTableDetailActivity.class, bundle);
    }
    public void thursdayTimeTable(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(KeyMeta.DAY, "Thursday");
        ActivityUtil.moveToActivity(this, TimeTableDetailActivity.class, bundle);
    }
    public void fridayTimeTable(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(KeyMeta.DAY, "Friday");
        ActivityUtil.moveToActivity(this, TimeTableDetailActivity.class, bundle);
    }
    public void saturdayTimeTable(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(KeyMeta.DAY, "Saturday");
        ActivityUtil.moveToActivity(this, TimeTableDetailActivity.class, bundle);
    }
    public void sundayTimeTable(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(KeyMeta.DAY, "Sunday");
        ActivityUtil.moveToActivity(this, TimeTableDetailActivity.class, bundle);
    }

}