package com.apps.jjdaz.fueltracker;

import java.io.Serializable;

/**
 * Created by jjdaz on 2016-01-28.
 */
public class EntryDate implements Serializable{
    private String entryDate;

    public EntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}