package com.daph.accountable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.daph.accountable.R;
import com.daph.accountable.model.Constants;

public class AddMeditationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meditation);
    }

    public void meditationNext(View view) {
        String accName = Constants.globalAccomplishment.getName();
        String accDesc = Constants.globalAccomplishment.getDescription();


        Intent intent = new Intent(AddMeditationActivity.this, AddWorkoutActivity.class);
        // Change the above to (AddMeditationActivity.this, splash.class);
        // the "splash" page says "Your Plant Gru!" with a back to menu button and maybe some
        // display shit (like how many gains you got, and your XP until next level)

    }
}
