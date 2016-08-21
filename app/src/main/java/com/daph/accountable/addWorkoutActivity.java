package com.daph.accountable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.daph.accountable.model.Constants;
import com.daph.accountable.model.Workout;

import java.util.ArrayList;
import java.util.List;

public class AddWorkoutActivity extends AppCompatActivity {

    Spinner choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        initializeSpinner();
    }

    public void initializeSpinner(){
        choose = (Spinner) findViewById(R.id.spinner);
        //Listing the data into the spinner
        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Low");
        spinnerArray.add("Medium");
        spinnerArray.add("High");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choose.setAdapter(adapter);

        choose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String accName = Constants.globalAccomplishment.getName();
                String accDesc = Constants.globalAccomplishment.getDescription();

                double newIntensity = 0;
                if (pos == 0)
                {
                    newIntensity = 1;
                    //Set workout intensity to low
                }
                else if (pos == 1)
                {
                    newIntensity = 1.5;
                    //Set workout intensity to medium
                }
                else
                {
                    newIntensity = 2;
                    //Set workout intensity to high
                }

                TextView time = (TextView) findViewById(R.id.editText);

                Workout newWorkout = new Workout(accName, accDesc, newIntensity,
                        Integer.parseInt(time.toString()));

                Constants.globalUser.addWorkout(newWorkout);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void workoutNext() {
        Intent intent = new Intent(AddWorkoutActivity.this, Splash.class);
        // Change the above to (AddWorkoutActivity.this, splash.class);
        // the "splash" page says "Your Plant Gru!" with a back to menu button and maybe some
        // display shit (like how many gains you got, and your XP until next level)
        startActivity(intent);

    }
}
