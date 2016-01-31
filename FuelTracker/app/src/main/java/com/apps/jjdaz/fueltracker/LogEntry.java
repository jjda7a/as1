package com.apps.jjdaz.fueltracker;

import android.widget.EditText;

/**
 * Created by jjdaz on 2016-01-27.
 */
public class LogEntry {
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
    public void modifyDate(String newDate){
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

    public EntryDate getEntryDate() {
        return entryDate;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public Station getStation() {
        return station;
    }

    public Odometer getOdometer() {
        return odometer;
    }
}
