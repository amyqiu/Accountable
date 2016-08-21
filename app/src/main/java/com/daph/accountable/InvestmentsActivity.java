package com.daph.accountable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;

import com.daph.accountable.model.Constants;
import com.daph.accountable.model.Investment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InvestmentsActivity extends AppCompatActivity {

    private List<Investment> seedMoney = new ArrayList<>();
    private List<Investment> investments = new ArrayList<>();
    private RecyclerView seedMoneyView;
    private RecyclerView investmentsView;
    private InvestmentAdapter mAdapter;
    private InvestmentAdapter iAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investments);

        SharedPreferences prefs = this.getSharedPreferences(
                "com.daph.accountable", Context.MODE_PRIVATE);
        final String name = prefs.getString("com.daph.accountable.name", "");

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = firebaseDatabase.getReference("investments");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                allInvestments = Investment.stringListToInvestmentList((ArrayList<String>)dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        for (Investment investment:
             allInvestments) {
            if (investment.getRecipient().getName() == name)
            {
                seedMoney.add(investment);
            }
            else
            {
                investments.add(investment);
            }

        }

        seedMoneyView = (RecyclerView) findViewById(R.id.seed_money_view);
        investmentsView = (RecyclerView) findViewById(R.id.investments_view);

        mAdapter = new InvestmentAdapter(seedMoney);
        iAdapter = new InvestmentAdapter(investments);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager iLayoutManager = new LinearLayoutManager(getApplicationContext());

        seedMoneyView.setLayoutManager(mLayoutManager);
        seedMoneyView.setItemAnimator(new DefaultItemAnimator());
        seedMoneyView.setAdapter(mAdapter);

        investmentsView.setLayoutManager(iLayoutManager);
        investmentsView.setItemAnimator(new DefaultItemAnimator());
        investmentsView.setAdapter(iAdapter);

    }

    public void investmentNext(View view) {
        Intent intent = new Intent(InvestmentsActivity.this, AddInvestmentActivity.class);
        // Change the above to (AddNutritionActivity.this, splash.class);
        // the "splash" page says "Your Plant Gru!" with a back to menu button and maybe some
        // display shit (like how many gains you got, and your XP until next level)
        startActivity(intent);

    }
}
