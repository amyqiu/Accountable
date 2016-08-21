package com.daph.accountable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddNutritionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nutrition);
    }

    public void nutritionNext(View view) {
        Intent intent = new Intent(AddNutritionActivity.this, AddWorkoutActivity.class);
        // Change the above to (AddNutritionActivity.this, splash.class);
        // the "splash" page says "Your Plant Gru!" with a back to menu button and maybe some
        // display shit (like how many gains you got, and your XP until next level)

    }
}
