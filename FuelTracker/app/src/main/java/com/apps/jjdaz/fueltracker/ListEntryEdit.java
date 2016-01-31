package com.apps.jjdaz.fueltracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class ListEntryEdit extends AppCompatActivity implements Serializable{
    private EditText datetext;
    private EditText stationtext;
    private EditText odometertext;
    private EditText gradetext;
    private EditText amounttext;
    private EditText unitcosttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_entry_edit);
        //Retrieve log item passed
        //Referenced from http://www.101apps.co.za/index.php/articles/passing-objects-between-activities.html
        Intent receiveItem = getIntent();
        LogEntry editLog = (LogEntry) receiveItem.getSerializableExtra("logItemEdit");


        datetext = (EditText) findViewById(R.id.dateedit);
        stationtext = (EditText) findViewById(R.id.stationedit);
        odometertext = (EditText) findViewById(R.id.kmedit);
        gradetext = (EditText) findViewById(R.id.fueltypeedit);
        amounttext = (EditText) findViewById(R.id.fuelamountedit);
        unitcosttext = (EditText) findViewById(R.id.unitcostedit);

        //Set text spaces with previously entered log data
        datetext.setText(editLog.getEntryDate(), TextView.BufferType.EDITABLE);
        stationtext.setText(editLog.getStation(), TextView.BufferType.EDITABLE);
        odometertext.setText(editLog.getOdometer().toString(), TextView.BufferType.EDITABLE);
        gradetext.setText(editLog.getFuelType(), TextView.BufferType.EDITABLE);
        amounttext.setText(editLog.getFuelAmount().toString(), TextView.BufferType.EDITABLE);
        unitcosttext.setText(editLog.getFuelUnitCost().toString(), TextView.BufferType.EDITABLE);

        Button saveEdit = (Button) findViewById(R.id.saveedit);
        Button cancelEdit = (Button) findViewById(R.id.canceledit);

        saveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);

                startActivity(new Intent(ListEntryEdit.this, FuelTrackMain.class));
            }
        });

        cancelEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                startActivity(new Intent(ListEntryEdit.this, FuelTrackMain.class));
            }
        });

    }
}
