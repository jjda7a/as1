package com.apps.jjdaz.fueltracker;

import java.io.Serializable;

/**
 * Created by jjdaz on 2016-01-27.
 */

public class Fuel implements Serializable {
    private Float unitCost;
    private Float amount;

    private String type;

    public Fuel(Float unitCost, Float amount, String type) {
        this.unitCost = unitCost;
        this.amount = amount;
        this.type = type;
    }

    public Fuel(Float unitCost, Float amount) {
        // set values
        this.unitCost = unitCost;
        this.amount = amount;
        this.type = type;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {

        this.unitCost = unitCost;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getCost() {
        Float cost = (amount*unitCost)/100;
        return cost;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
