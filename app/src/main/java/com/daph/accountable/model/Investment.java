package com.daph.accountable.model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Amy on 2016-08-20.
 */
public class Investment {

    protected int amount;
    protected String requester;
    protected String recipient;

    Accomplishment investmentTask;

    public Investment(){

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

    public Accomplishment getInvestmentTask()
    {
        return investmentTask;
    }

    // investmentCompleted in main function.
    public void investmentType(Workout challengeWorkout) {
        investmentTask = challengeWorkout;
    }

    public void investmentType(Nutrition challengeNutrition) {
        investmentTask = challengeNutrition;
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

    // No function for failure because investor already lost their amount, and investee gets
    // nothing for doing nothing.
}
