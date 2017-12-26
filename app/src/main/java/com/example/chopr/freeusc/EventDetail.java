package com.example.chopr.freeusc;

import java.util.Date;

/**
 * This class holds the event details.
 * Created by Prince on 12/24/2017.
 */

public class EventDetail {

    String eventName;
    String locationName;
    double latitude, longitude;

    EventDetail(String eventName, String locationName){
        this.eventName = eventName;
        this.locationName = locationName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    Date date;

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
