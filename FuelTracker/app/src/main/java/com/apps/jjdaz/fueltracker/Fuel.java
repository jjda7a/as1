package com.apps.jjdaz.fueltracker;

/**
 * Created by jjdaz on 2016-01-27.
 */

public class Fuel {
    private Float unitCost;
    private Float amount;
    private Float cost;
    private String type;

    public Fuel(Float unitCost, Float amount, String type) {
        this.unitCost = unitCost;
        this.amount = amount;
        this.cost = cost;
        this.type = type;
    }

    public Fuel(Float unitCost, Float amount) {
        // set values
        this.unitCost = unitCost;
        this.amount = amount;
        this.type = type;
        this.cost = amount*unitCost;
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
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
