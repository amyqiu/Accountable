package com.daph.accountable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.daph.accountable.model.Investment;
import com.daph.accountable.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AddInvestmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_investment);
    }

    public void invest(View view){

        final User requester, recipient;

        TextView gains = (TextView)findViewById(R.id.investing_gains);
        final int gainAmount = Integer.parseInt(gains.getText().toString());

        TextView person = (TextView)findViewById(R.id.person);
        final String personName = person.getText().toString();

        SharedPreferences prefs = this.getSharedPreferences(
                "com.daph.accountable", Context.MODE_PRIVATE);
        final String name = prefs.getString("com.daph.accountable.name", "");

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        final DatabaseReference newRef = firebaseDatabase.getReference("investments");
        newRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Investment> allInvestments = Investment.stringListToInvestmentList((ArrayList<String>)dataSnapshot.getValue());
                allInvestments.add(new Investment(gainAmount, name, personName));
                newRef.setValue(Investment.listToString(allInvestments));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        Intent intent = new Intent(AddInvestmentActivity.this, MainActivity.class);
        // Change the above to (AddNutritionActivity.this, splash.class);
        // the "splash" page says "Your Plant Gru!" with a back to menu button and maybe some
        // display shit (like how many gains you got, and your XP until next level)
        startActivity(intent);

    }
}
