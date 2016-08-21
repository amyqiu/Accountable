package com.daph.accountable.model;

import android.text.TextUtils;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amy on 2016-08-20.
 */
public class Investment {

    protected int amount;
    protected String requester;
    protected String recipient;
    protected String investmentTask;

    public Investment(){

    }

    public Investment(String investmentString) {
        String[] investmentArray = investmentString.split("~");
        amount = Integer.parseInt(investmentArray[0]);
        requester = investmentArray[1];
        recipient = investmentArray[2];
        investmentTask = investmentArray[3];
    }
    public Investment(int newAmount, String newRequester, String newRecipient)
    {
        amount = newAmount;
        requester = newRequester;
        recipient = newRecipient;

       // requester.addPoints(amount * -1); Take money from requester on creating the investment
    }

    public void setAmount(int newAmount)
    {
        amount = newAmount;
    }

    public void setRequester(String newRequester)
    {
        requester = newRequester;
    }

    public void setRecipient(String newRecipient)
    {
        recipient = newRecipient;
    }

    public int getAmount()
    {
        return amount;
    }

    public String getRequester()
    {
        return requester;
    }

    public String getRecipient()
    {
        return recipient;
    }

    public String getInvestmentTask()
    {
        return investmentTask;
    }

    public void investmentCompleted(final Workout challengeWorkout)
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = firebaseDatabase.getReference("users");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<User> userList = User.stringListToUserList((ArrayList<String>) dataSnapshot.getValue());
                int pos = User.userPos(recipient, userList);
                userList.get(pos).addWorkout(challengeWorkout);
                userList.get(pos).addPoints(amount);
                pos = User.userPos(requester, userList);
                userList.get(pos).addPoints(amount * 2);
                myRef.setValue(userList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void investmentCompleted(final Nutrition challengeNutrition)
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = firebaseDatabase.getReference("users");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<User> userList = User.stringListToUserList((ArrayList<String>) dataSnapshot.getValue());
                int pos = User.userPos(recipient, userList);
                userList.get(pos).addNutrition(challengeNutrition);
                userList.get(pos).addPoints(amount);
                pos = User.userPos(requester, userList);
                userList.get(pos).addPoints(amount * 2);
                myRef.setValue(userList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static ArrayList<Investment> stringListToInvestmentList (ArrayList<String> investmentStringArr) {
        ArrayList<Investment> newList = new ArrayList<>();
        for (int i = 0; i < investmentStringArr.size(); i++) {
            newList.add(new Investment(investmentStringArr.get(i)));
        }
        return newList;
    }

    public static String listToString (List<Workout> investments) {
        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < investments.size(); i++) {
            newList.add(investments.get(i).toString());
        }
        if (newList.size() == 0) return "empty";
        return TextUtils.join(",", newList);
    }

    @Override
    public String toString() {
        return Integer.toString(amount) + "/" +
            requester + "/" +
            recipient + "/" +
            investmentTask;
    }
    // No function for failure because investor already lost their amount, and investee gets
    // nothing for doing nothing.
}
