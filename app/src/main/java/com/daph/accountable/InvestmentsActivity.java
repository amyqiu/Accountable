package com.daph.accountable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;

import com.daph.accountable.model.Constants;
import com.daph.accountable.model.Investment;

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

        //seedMoney = Constants.globalUser.getInvestmentsInMe();
        //investments = Constants.globalUser.getMyInvestments();

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
