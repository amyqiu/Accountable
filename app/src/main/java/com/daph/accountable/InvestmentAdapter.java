package com.daph.accountable;

/**
 * Created by Amy on 2016-08-21.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daph.accountable.model.Investment;

import java.util.List;

public class InvestmentAdapter extends RecyclerView.Adapter<InvestmentAdapter.MyViewHolder> {

    private List<Investment> investments;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, value, investor;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            value = (TextView) view.findViewById(R.id.value);
            investor = (TextView) view.findViewById(R.id.investor);
        }
    }


    public InvestmentAdapter(List<Investment> investments) {
        this.investments = investments;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.investment_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Investment investment = investments.get(position);
        holder.name.setText(investment.getInvestmentTask());
        holder.value.setText(String.valueOf(investment.getAmount()));
        holder.investor.setText(investment.getRequester());
    }

    @Override
    public int getItemCount() {
        return investments.size();
    }
}
