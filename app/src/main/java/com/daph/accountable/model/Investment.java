package com.daph.accountable.model;

/**
 * Created by Amy on 2016-08-20.
 */
public class Investment {

    protected int amount;
    protected User requester;
    protected User recipient;

    Accomplishment investmentTask;

    public Investment(){

    }

    public Investment(int newAmount, User newRequester, User newRecipient)
    {
        amount = newAmount;
        requester = newRequester;
        recipient = newRecipient;

        requester.addPoints(amount * -1);
    }

    public void setAmount(int newAmount)
    {
        amount = newAmount;
    }

    public void setRequester(User newRequester)
    {
        requester = newRequester;
    }

    public void setRecipient(User newRecipient)
    {
        recipient = newRecipient;
    }

    public int getAmount()
    {
        return amount;
    }

    public User getRequester()
    {
        return requester;
    }

    public User getRecipient()
    {
        return recipient;
    }

    // investmentCompleted in main function.
    public void investmentType(Workout challengeWorkout) {
        investmentTask = challengeWorkout;
    }

    public void investmentType(Nutrition challengeNutrition) {
        investmentTask = challengeNutrition;
    }

    public void investmentCompleted(Workout challengeWorkout)
    {
        recipient.addWorkout(challengeWorkout);
        recipient.addPoints(amount);
        requester.addPoints(amount * 2);
    }

    public void investmentCompleted(Nutrition challengeNutrition)
    {
        recipient.addNutrition(challengeNutrition);
        recipient.addPoints(amount);
        requester.addPoints(amount * 2);
    }

    // No function for failure because investor already lost their amount, and investee gets
    // nothing for doing nothing.
}
