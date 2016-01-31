package com.apps.jjdaz.fueltracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ListEntryEdit extends AppCompatActivity {
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

        datetext = (EditText) findViewById(R.id.dateedit);
        stationtext = (EditText) findViewById(R.id.stationedit);
        odometertext = (EditText) findViewById(R.id.kmedit);
        gradetext = (EditText) findViewById(R.id.fueltypeedit);
        amounttext = (EditText) findViewById(R.id.fuelamountedit);
        unitcosttext = (EditText) findViewById(R.id.unitcostedit);

        //Initialize edittext spaces to contain values of desired log entry

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
