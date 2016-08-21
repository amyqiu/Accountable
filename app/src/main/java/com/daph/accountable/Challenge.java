package com.daph.accountable;

/**
 * Created by Amy on 2016-08-20.
 */
public class Challenge {

    protected int amount;
    protected User requester;
    protected User recipient;

    public Challenge(){

    }

    public Challenge(int newAmount, User newRequester, User newRecipient)
    {
        amount = newAmount;
        requester = newRequester;
        recipient = newRecipient;


        requester.subtractPoints(amount);

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

    // WARNING: Make sure to use this in the main!!!!
    public void addAccomplishment(Workout challengeWorkout) {
        recipient.addWorkout(challengeWorkout);
            }

    public void addAccomplishment(Nutrition challengeNutrition) {
        recipient.addNutrition(challengeNutrition);
    }

}
