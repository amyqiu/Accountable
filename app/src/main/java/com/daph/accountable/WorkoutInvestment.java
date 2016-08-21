package com.daph.accountable;

/**
 * Created by Amy on 2016-08-20.
 */
public class WorkoutInvestment extends Investment {

    private Workout workout;

    public WorkoutInvestment(int newAmount, User newRequester, User newRecipient, Workout newWorkout)
    {
        amount = newAmount;
        requester = newRequester;
        recipient = newRecipient;
        workout = newWorkout;
    }

    public void setWorkout(Workout newWorkout)
    {
        workout = newWorkout;
    }

    public Workout getWorkout()
    {
        return workout;
    }

    public void completeWorkout()
    {
        recipient.addWorkout(workout);
        recipient.addPoints(amount);
        requester.addPoints(amount * 2);
    }

    public void failWorkout()
    {
        //Nothing because investor just loses gains
    }

}