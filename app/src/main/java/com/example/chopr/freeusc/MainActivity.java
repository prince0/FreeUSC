package com.example.chopr.freeusc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;

    EventAdapter eventAdapter;
    List<EventDetail> eventDetailList;
    private RecyclerView.LayoutManager recyclerLayoutManager;
//    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerView = findViewById(R.id.main_recycler_view);
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

        eventDetailList = new ArrayList<>();

        recyclerLayoutManager = new LinearLayoutManager(this );
        recyclerView.setLayoutManager(recyclerLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        eventAdapter = new EventAdapter(eventDetailList);
        recyclerView.setAdapter(eventAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        prepareEventData();
    }

    private void prepareEventData() {
        EventDetail eventDetail = new EventDetail("VGSA Alumni Mixer","SGM", "01/28/2018", "1:00PM - 5:00PM");
        eventDetailList.add(eventDetail);
        eventDetail = new EventDetail("Comedy Show","Ground Zero", "01/23/2018", "1:00PM - 5:00PM");
        eventDetailList.add(eventDetail);
        eventDetail = new EventDetail("Social Mixer","THH", "02/12/2018", "1:00PM - 5:00PM");
        eventDetailList.add(eventDetail);

        eventAdapter.notifyDataSetChanged();
    }
}
