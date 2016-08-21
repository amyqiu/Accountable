package com.daph.accountable;

/**
 * Created by Amy on 2016-08-20.
 */
public class NutritionInvestment extends Investment {


    private Nutrition nutrition;

    public NutritionInvestment(int newAmount, User newRequester, User newRecipient, Nutrition newNutrition)
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
        recipient.addPoints(amount);
        requester.addPoints(amount * 2);
    }

    public void failNutrition()
    {
        //Nothing because investor just loses gains
    }

}
