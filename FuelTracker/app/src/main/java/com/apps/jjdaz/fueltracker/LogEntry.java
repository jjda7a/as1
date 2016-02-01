package com.apps.jjdaz.fueltracker;

import android.widget.EditText;

import java.io.Serializable;

/**
 * Created by jjdaz on 2016-01-27.
 */
public class LogEntry implements Serializable {
    private EntryDate entryDate;
    private Fuel fuel;
    private Station station;
    private Odometer odometer;


    public LogEntry(EntryDate entryDate, Fuel fuel, Station station, Odometer odometer) {
        this.entryDate = entryDate;
        this.fuel = fuel;
        this.station = station;
        this.odometer = odometer;
    }

    public void modifyDate(String newDate) throws InvalidInputException{

        entryDate.setEntryDate(newDate);
    }

    public void modifyStation(String name){
        station.setName(name);
    }

    public void modifyOdometer(Float kilometer){
        odometer.setDistance(kilometer);
    }

    public void modifyUnitCost(Float cost){
        fuel.setUnitCost(cost);
    }

    public void modifyFuelAmount(Float amount){
        fuel.setAmount(amount);
    }

    public void modifyFuelGrade(String grade){
        fuel.setType(grade);
    }

    public String getEntryDate() {
        return entryDate.getEntryDate();
    }

    public Float getFuelUnitCost() { return fuel.getUnitCost(); }
    public Float getFuelAmount() { return fuel.getAmount();}
    public Float getFuelCost() { return fuel.getCost(); }
    public String getFuelType() { return fuel.getType();}

    public String getStation() {
        return station.getName();
    }

    public Float getOdometer() {
        return odometer.getDistance();
    }

    @Override
    public String toString() {
        return entryDate.getEntryDate() +" | " + station.getName() +" | Fuel Cost: $" +fuel.getCost();
    }
}
