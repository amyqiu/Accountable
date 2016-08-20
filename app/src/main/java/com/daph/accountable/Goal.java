package com.daph.accountable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Amy on 2016-08-20.
 */
public class Goal {

    private String name;
    private String description;
    private int value;
    private Date deadline;
    public enum Category{
        WORKOUT, MEDITATION, NUTRITION, SLEEP
    }
    private Category category;
    private List<SubGoal> subGoals;

    public Goal()
    {

    }

    public Goal(String newName, String newDescription, int newValue, Date newDeadline, Category newCategory)
    {
        name = newName;
        description = newDescription;
        value = newValue;
        deadline = newDeadline;
        category = newCategory;
        subGoals = new ArrayList<SubGoal>();
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setDescription(String newDescription)
    {
        description = newDescription;
    }

    public void setValue(int newValue)
    {
        value = newValue;
    }

    public void setDeadline(Date newDeadline)
    {
        deadline = newDeadline;
    }

    public void setCategory (Category newCategory)
    {
        category = newCategory;
    }

    public void addSubGoal(SubGoal subGoal)
    {
        subGoals.add(subGoal);
    }

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

    public Date getDeadline()
    {
        return deadline;
    }

    public Category getCategory()
    {
        return category;
    }

    public List<SubGoal> getSubGoals()
    {
        return subGoals;
    }

}
