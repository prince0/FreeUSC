package com.example.chopr.freeusc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This is adapter for recycler view of all the events
 * Created by chopr on 12/24/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private List<EventDetail> eventList;

    public EventAdapter(List<EventDetail> eventDetailList) {
        eventList = eventDetailList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EventDetail eventDetail = eventList.get(position);

        holder.eventName.setText(eventDetail.getEventName());
        holder.eventLocation.setText(eventDetail.getLocationName());
        holder.eventDate.setText(eventDetail.getDate().toString());
        holder.eventDistance.setText("0.12 miles");
//        holder.eventTiming.setText("0.12 miles");

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_event_name)
        TextView eventName;

        @BindView(R.id.text_view_event_location)
        TextView eventLocation;

        @BindView(R.id.text_view_event_timing)
        TextView eventTiming;

        @BindView(R.id.text_view_event_date)
        TextView eventDate;

        @BindView(R.id.text_view_distance)
        TextView eventDistance;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
