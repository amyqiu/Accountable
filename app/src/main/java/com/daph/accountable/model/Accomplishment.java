package com.daph.accountable.model;

/**
 * Created by Amy on 2016-08-20.
 */
public class Accomplishment {

    private String name;
    private String description;
    private int value;

    public Accomplishment()
    {

    }

    public Accomplishment(String newName, String newDescription, int newValue)
    {
        name = newName;
        description = newDescription;
        value = newValue;
    }

    public void setName (String newName)
    {
        name = newName;
    }

    public void setDescription (String newDescription)
    {
        description = newDescription;
    }

    public void setValue(int newValue)
    {
        value = newValue;
    }

    /* public void setCategory (Constants.Category newCategory)
    {
        category = newCategory;
    } */

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public int getValue()
    {
        return value;
    }

    /* public Constants.Category getCategory()
    {
        return category;
    } */

    // NOTE When someone adds any accomplishment, just use (USER).addPoints(getValue);
}
