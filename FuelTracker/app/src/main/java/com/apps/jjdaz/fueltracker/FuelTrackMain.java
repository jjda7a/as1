package com.apps.jjdaz.fueltracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class FuelTrackMain extends AppCompatActivity {
    //implement data storage in a file labelled file.sav
    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView logEntryList;

    private ArrayList<LogEntry> logs = new ArrayList<LogEntry>();
    private ArrayAdapter<LogEntry> adapter;
    private Float totalFuelCost;

    // Activity should display a list of all the entries, and a calculated value of the total cost from the entries.
    // Contains 2 buttons, one that goes opens another activity where user enters information for a new entry.
    // Second button clears all current entries. (Optional)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_track_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        logEntryList = (ListView) findViewById(R.id.logentrylist);
        Button newEntryButton = (Button) findViewById(R.id.addnewbutton);
        Button ClearEntryButton = (Button) findViewById(R.id.clearall);

        //Send Array list to be edited in NewEntry activity
        //Source code from Ravind Maurya; http://stackoverflow.com/questions/21250339/how-to-pass-arraylistcustomeobject-from-one-activity-to-another 2016-01-29


        //implement buttons on main activity
        //newEntry button goes to new entry activity
        newEntryButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                startActivity(new Intent(FuelTrackMain.this, NewEntry.class));
            }
        });
        ClearEntryButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //clear tweets on disk & remove tweets on screen
                logs.clear();
                adapter.notifyDataSetChanged();
                saveInFile();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fuel_track_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        loadFromFile();
        // CHeck what this line is for corectness
        adapter = new ArrayAdapter<LogEntry>(this, R.layout.activity_list_entry_edit, logs);
        logEntryList.setAdapter(adapter);
    }
    //Code from lonelyTwitter application from Lab sessions
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            //Source: https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-17-2016
            Type listType = new TypeToken<ArrayList<LogEntry>>() {}.getType();
            logs = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            logs = new ArrayList<LogEntry>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(logs, out);
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
