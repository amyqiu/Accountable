package com.daph.accountable;

/**
 * Created by Amy on 2016-08-20.
 */
public class NutritionChallenge extends Challenge {

    private Nutrition nutrition;

    public NutritionChallenge(int newAmount, User newRequester, User newRecipient, Nutrition newNutrition)
    {
        amount = newAmount;
        requester = newRequester;
        recipient = newRecipient;
        nutrition = newNutrition;
    }

    public void setNutrition(Nutrition newNutrition)
    {
        nutrition = newNutrition;
    }

    public Nutrition getNutrition()
    {
        return nutrition;
    }

    public void completeNutrition()
    {
        recipient.addNutrition(nutrition);
        recipient.addPoints(amount * 2);
    }

    public void failNutrition()
    {
        recipient.subtractPoints(amount);
        requester.addPoints(amount * 2);
    }

}
