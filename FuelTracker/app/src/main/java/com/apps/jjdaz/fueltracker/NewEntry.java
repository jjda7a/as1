package com.apps.jjdaz.fueltracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class NewEntry extends AppCompatActivity {
    //Activity should take in various inputs and store them in the appropriate areas.
    //Raise exceptions when invalid inputs are entered.
    //"Cancel Entry" button returns user to main activity window, with no inputs saved
    //"Save Entry" button validates and takes in all inputs and stores it into a new logEntry object, which is saved into
    private LogEntry newLog;

    private Fuel fuelEntry;
    private EntryDate dateEntry;
    private Station stationEntry;
    private Odometer odometerEntry;

    private EditText datetext;
    private EditText stationtext;
    private EditText odometertext;
    private EditText gradetext;
    private EditText amounttext;
    private EditText unitcosttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        datetext = (EditText) findViewById(R.id.dateentry);
        stationtext = (EditText) findViewById(R.id.stationentry);
        odometertext = (EditText) findViewById(R.id.kmentry);
        gradetext = (EditText) findViewById(R.id.fueltypeentry);
        amounttext = (EditText) findViewById(R.id.fuelamountentry);
        unitcosttext = (EditText) findViewById(R.id.unitcostentry);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        FuelTrackMain.getLogs();

        Button saveEntry = (Button) findViewById(R.id.save);
        Button cancelEntry = (Button) findViewById(R.id.cancel);

        saveEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);

                String dateText = datetext.getText().toString();
                String stationText = stationtext.getText().toString();
                Float odometerText = Float.valueOf(odometertext.getText().toString());
                String gradeText = gradetext.getText().toString();
                Float amountText = Float.valueOf(amounttext.getText().toString());
                Float unitcostText = Float.valueOf(unitcosttext.getText().toString());

                Fuel fuelEntry = new Fuel(amountText, unitcostText, gradeText);
                EntryDate dateEntry = new EntryDate(dateText);
                Station stationEntry = new Station(stationText);
                Odometer odometerEntry = new Odometer(odometerText);

                LogEntry newLog = new LogEntry(dateEntry, fuelEntry, stationEntry, odometerEntry);

                FuelTrackMain.getLogs().add(newLog);
                startActivity(new Intent(NewEntry.this, FuelTrackMain.class));
            }
        });

        cancelEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                startActivity(new Intent(NewEntry.this, FuelTrackMain.class));
            }
        });

    }

    protected void onStart() {

        super.onStart();



    }
}
