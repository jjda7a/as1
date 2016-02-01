package com.apps.jjdaz.fueltracker;

import java.io.Serializable;

/**
 * Created by jjdaz on 2016-01-27.
 */

public class Fuel implements Serializable {
    private Double unitCost;
    private Double amount;

    private String type;

    public Fuel(Double unitCost, Double amount, String type) {
        this.unitCost = unitCost;
        this.amount = amount;
        this.type = type;
    }

    public Fuel(Double unitCost, Double amount) {
        // set values
        this.unitCost = unitCost;
        this.amount = amount;
        this.type = type;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {

        this.unitCost = unitCost;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCost() {
        Double cost = (amount*unitCost)/100;
        return cost;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
