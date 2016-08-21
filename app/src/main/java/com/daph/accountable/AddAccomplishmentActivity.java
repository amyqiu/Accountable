package com.daph.accountable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AddAccomplishmentActivity extends AppCompatActivity {
    Spinner choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_accomplishment);
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

        // on next click


    }

    public void accomplishmentNext() {

        // I need the spinner info
        // I n

        Intent intent;

        String spinnerText = choose.getSelectedItem().toString();

        if (spinnerText.equals("Workout")) {
            intent = new Intent(AddAccomplishmentActivity.this, addWorkoutActivity.class);
        }
        else if (spinnerText.equals("Nutrition")) {
            intent = new Intent(AddAccomplishmentActivity.this, addWorkoutActivity.class);
            // Placeholder above
           // intent = new Intent(AddAccomplishmentActivity.this, addNutritionActivity.class);
            // Once we actually make addNutritionActivity.class
        }
        else {
            intent = new Intent(AddAccomplishmentActivity.this, addWorkoutActivity.class);
            // intent = new Intent(AddAccomplishmentActivity.this, addMeditationActivity.class);
            // As above, note that this is an else if in case we add other activities
            // Note that the comment is the real thing, the current line is a placeholder
        }




        startActivity(intent);
    }

}
