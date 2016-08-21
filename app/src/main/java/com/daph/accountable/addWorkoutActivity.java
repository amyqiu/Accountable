package com.daph.accountable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class addWorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);
    }

    public void workoutNext() {
        Intent intent = new Intent(addWorkoutActivity.this, addWorkoutActivity.class);
        // Change the above to (addWorkoutActivity.this, splash.class);
        // the "splash" page says "Your Plant Gru!" with a back to menu button and maybe some
        // display shit


}
