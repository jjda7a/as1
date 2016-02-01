package com.apps.jjdaz.fueltracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class NewEntry extends AppCompatActivity {
    //Activity should take in various inputs and store them in the appropriate areas.
    //Raise exceptions when invalid inputs are entered.
    //"Cancel Entry" button returns user to main activity window, with no inputs saved
    //"Save Entry" button validates and takes in all inputs and stores it into a new logEntry object, which is saved into

    private EditText datetext;
    private EditText stationtext;
    private EditText odometertext;
    private EditText gradetext;
    private EditText amounttext;
    private EditText unitcosttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        FuelTrackMain.getLogs();

        datetext = (EditText) findViewById(R.id.dateentry);
        stationtext = (EditText) findViewById(R.id.stationentry);
        odometertext = (EditText) findViewById(R.id.kmentry);
        gradetext = (EditText) findViewById(R.id.fueltypeentry);
        amounttext = (EditText) findViewById(R.id.fuelamountentry);
        unitcosttext = (EditText) findViewById(R.id.unitcostentry);
        Button saveEntry = (Button) findViewById(R.id.save);
        Button cancelEntry = (Button) findViewById(R.id.cancel);

        saveEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                try {
                    String dateText = datetext.getText().toString();
                    String stationText = stationtext.getText().toString();
                    String odometerText = odometertext.getText().toString();
                    String gradeText = gradetext.getText().toString();
                    Double amountText = Double.valueOf(amounttext.getText().toString());
                    Double unitcostText = Double.valueOf(unitcosttext.getText().toString());

                    //Create new logEntry and add it to the log list

                    Fuel fuelEntry = new Fuel(amountText, unitcostText, gradeText);
                    EntryDate dateEntry = new EntryDate(dateText);
                    Station stationEntry = new Station(stationText);
                    Odometer odometerEntry = new Odometer(odometerText);
                    LogEntry newLog = new LogEntry(dateEntry, fuelEntry, stationEntry, odometerEntry);
                    FuelTrackMain.getLogs().add(newLog);
                    saveInFile();
                    startActivity(new Intent(NewEntry.this, FuelTrackMain.class));

                } catch(NumberFormatException e) {
                    //Catch if user fails to enter a value
                    Toast.makeText(getApplicationContext(),"Invalid input, entry cancelled.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(NewEntry.this, FuelTrackMain.class));
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(),"Empty input, entry cancelled.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(NewEntry.this, FuelTrackMain.class));
                }

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
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FuelTrackMain.getFILENAME(), 0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(FuelTrackMain.getLogs(), out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}
