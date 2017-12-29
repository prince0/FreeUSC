package com.example.chopr.freeusc;

import java.util.Date;

/**
 * This class holds the event details.
 * Created by Prince on 12/24/2017.
 */

public class EventDetail {

    private String eventName;
    private String locationName;
    private double latitude, longitude;
    private String date;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;

    EventDetail(String eventName, String locationName, String date, String time){
        this.eventName = eventName;
        this.locationName = locationName;
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
