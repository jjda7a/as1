package com.apps.jjdaz.fueltracker;

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
    public void modifyDate(){

    }

    public void modifyStation(){

    }

    public void modifyOdometer(){

    }

    public void modifyUnitCost(){

    }

    public void modifyFuelAmount(){

    }

}
