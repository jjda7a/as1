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

    public void setEntryDate(String entryDate) throws InvalidInputException{
        if(entryDate.matches("^(\\d{4}-\\d{2}-\\d{2})$")) {
            this.entryDate = entryDate;
        } else {
            throw new InvalidInputException();
        }



    }
}