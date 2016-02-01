package com.apps.jjdaz.fueltracker;

import android.widget.EditText;

import java.io.InvalidClassException;
import java.io.Serializable;
import java.text.DecimalFormat;

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

    public void modifyOdometer(String kilometer) throws InvalidInputException {
        try {
            odometer.setDistance(kilometer);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    public void modifyUnitCost(Double cost){
        fuel.setUnitCost(cost);
    }

    public void modifyFuelAmount(Double amount){
        fuel.setAmount(amount);
    }

    public void modifyFuelGrade(String grade){
        fuel.setType(grade);
    }

    public String getEntryDate() {
        return entryDate.getEntryDate();
    }

    public Double getFuelUnitCost() { return fuel.getUnitCost(); }
    public Double getFuelAmount() { return fuel.getAmount();}
    public Double getFuelCost() { return fuel.getCost(); }
    public String getFuelType() { return fuel.getType();}

    public String getStation() {
        return station.getName();
    }

    public String getOdometer() {
        return odometer.getDistance();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.00");
        return entryDate.getEntryDate() +" | " + station.getName() +" | Fuel Cost: $" +decimalFormat.format(fuel.getCost());
    }
}
