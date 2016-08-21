package com.daph.accountable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daph.accountable.model.Constants;
import com.daph.accountable.model.Nutrition;
import com.daph.accountable.model.User;

public class AddNutritionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nutrition);
    }

    public void nutritionNext(View view) {
        String accName = Constants.globalAccomplishment.getName();
        String accDesc = Constants.globalAccomplishment.getDescription();


        TextView protein = (TextView) findViewById(R.id.proteinIntake);
        TextView calories = (TextView) findViewById(R.id.Calorie);

        Nutrition newNutrition = new Nutrition(2500, 140,Integer.parseInt(calories.toString()),
                Integer.parseInt(protein.toString())); // Calories = 2500, protein = 140 hardcoded

        Constants.globalUser.addNutrition(newNutrition);
        User.addNutrition(Constants.globalUser.getName(), newNutrition);
        Constants.globalUser.addPoints(newNutrition.getValue());

        Intent intent = new Intent(AddNutritionActivity.this, Splash.class);
        // Change the above to (AddNutritionActivity.this, splash.class);
        // the "splash" page says "Your Plant Gru!" with a back to menu button and maybe some
        // display shit (like how many gains you got, and your XP until next level)
        startActivity(intent);

    }
}
