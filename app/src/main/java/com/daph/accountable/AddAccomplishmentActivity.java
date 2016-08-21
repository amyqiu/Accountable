package com.daph.accountable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.daph.accountable.model.Accomplishment;
import com.daph.accountable.model.Nutrition;
import com.daph.accountable.model.Workout;

import java.util.ArrayList;
import java.util.List;

public class AddAccomplishmentActivity extends AppCompatActivity {
    Spinner choose;
    String activity;
    Accomplishment accomplishment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_accomplishment);

        initializeSpinner();
    }

    protected void initializeSpinner() {
        choose = (Spinner) findViewById(R.id.spinner);
        //Listing the data into the spinner
        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Workout");
        spinnerArray.add("Nutrition");
        spinnerArray.add("Meditation");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choose.setAdapter(adapter);

        choose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0)
                {
                    activity = "Workout";
                    accomplishment = new Workout();
                }
                else if (pos == 1)
                {
                    activity = "Nutrition";
                    accomplishment = new Nutrition();
                }
                else
                {
                    activity = "Meditation";
                    accomplishment = new Nutrition();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void getData(){

        TextView name = (TextView) findViewById(R.id.editText);
        accomplishment.setName(name.getText().toString());

        TextView description = (TextView) findViewById(R.id.editText2);
        accomplishment.setDescription(description.getText().toString());

    }

    public void accomplishmentNext(View view) {

        getData();

        Intent intent;
        if (activity == "Workout")
        {
            intent = new Intent(AddAccomplishmentActivity.this, addWorkoutActivity.class);
        }
        else if (activity == "Nutrition")
        {
            //Change to nutrition
            intent = new Intent(AddAccomplishmentActivity.this, addWorkoutActivity.class);
        }
        else
        {
            //Change to meditation
            intent = new Intent(AddAccomplishmentActivity.this, addWorkoutActivity.class);
        }
        startActivity(intent);


    }

}
