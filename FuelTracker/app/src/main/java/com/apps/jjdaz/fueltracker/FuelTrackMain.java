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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class FuelTrackMain extends AppCompatActivity {
    //implement data storage in a file labelled file.sav
    public static final String FILENAME = "file.sav";

    //List view
    private ListView logEntryList;
    //Array for listview
    private static ArrayList<LogEntry> logs;

    private ArrayAdapter<LogEntry> adapter;
    private Double totalFuelCost;


    // Activity should display a list of all the entries, and a calculated value of the total cost from the entries.
    // Contains 2 buttons, one that goes opens another activity where user enters information for a new entry.
    // Second button clears all current entries. (Optional)


    public static String getFILENAME() {
        return FILENAME;
    }

    public static ArrayList<LogEntry> getLogs() {
        return logs;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_track_main);

        logs = new ArrayList<>();
        logEntryList = (ListView) findViewById(R.id.logentrylist);
        //List items start activity with info on item
        //Reference code from http://stackoverflow.com/questions/21295328/android-listview-with-onclick-items by Lena Bru
        logEntryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent passLogItem = new Intent(FuelTrackMain.this, ListEntryEdit.class);
                LogEntry item = adapter.getItem(position);
                //LogEntry item = logs.get(position);


                //Toast.makeText(getApplicationContext(),item.getEntryDate(), Toast.LENGTH_LONG).show();
                //PROBLEM SENDING ITEM HERE
                passLogItem.putExtra("logItemEdit", item);
                passLogItem.putExtra("logKey", position);
                startActivity(passLogItem);

            }
        });

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
                //Additional clear button implementation
                logs.clear();
                adapter.notifyDataSetChanged();
                saveInFile();

            }
        });
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<>(this, R.layout.list_item, logs);
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
