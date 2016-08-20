package com.daph.accountable;

/**
 * Created by Amy on 2016-08-20.
 */
public class Challenge {

    private int amount;
    private User requester;
    private User recipient;
    private Accomplishment accomplishment;

    public Challenge(){

    }

    public Challenge(int newAmount, User newRequester, User newRecipient, Accomplishment newAccomplishment)
    {
        amount = newAmount;
        requester = newRequester;
        recipient = newRecipient;
        accomplishment = newAccomplishment;
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

    public void setAccomplishment(Accomplishment newAccomplishment)
    {
        accomplishment = newAccomplishment;
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

    public void markCompleted()
    {

    }

}
