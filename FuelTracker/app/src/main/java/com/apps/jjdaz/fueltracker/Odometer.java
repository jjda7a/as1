package com.apps.jjdaz.fueltracker;

import java.io.Serializable;

/**
 * Created by jjdaz on 2016-01-27.
 */
public class Odometer implements Serializable{
    private Double distance;

    public Odometer(Double distance) {
        this.distance = distance;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
