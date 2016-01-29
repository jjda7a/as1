package com.apps.jjdaz.fueltracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;


public class NewEntry extends AppCompatActivity {
    //Activity should take in various inputs and store them in the appropriate areas.
    //Raise exceptions when invalid inputs are entered.
    //"Cancel Entry" button returns user to main activity window, with no inputs saved
    //"Save Entry" button validates and takes in all inputs and stores it into a new logEntry object, which is saved into
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
    }
}
