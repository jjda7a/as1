package com.apps.jjdaz.fueltracker;

import java.io.InvalidClassException;
import java.io.Serializable;

/**
 * Created by jjdaz on 2016-01-27.
 */
public class Odometer implements Serializable{
    private String distance;

    public Odometer(String distance) {
        this.distance = distance;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) throws InvalidInputException{
        if(distance.matches("[-+]?\\d*\\.?\\d+")) {
            this.distance = distance;
        } else {
            throw new InvalidInputException();
        }
    }
}
