package com.example.chopr.freeusc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;

    EventAdapter eventAdapter;
    List<EventDetail> eventDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        eventAdapter = new EventAdapter(eventDetailList);
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(getApplicationContext() );
        recyclerLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(eventAdapter);

        prepareEventData();
    }

    private void prepareEventData() {
        EventDetail eventDetail = new EventDetail("Hello","123");
        eventDetailList.add(eventDetail);

        eventAdapter.notifyDataSetChanged();
    }
}
