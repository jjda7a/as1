package com.apps.jjdaz.fueltracker;

import java.io.Serializable;

/**
 * Created by jjdaz on 2016-01-27.
 */
public class Odometer implements Serializable{
    private Float distance;

    public Odometer(Float distance) {
        this.distance = distance;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}
