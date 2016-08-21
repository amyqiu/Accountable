package com.daph.accountable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Amy on 2016-08-20.
 */
public class Goal {

    private String name;
    private String description; // Currently, gain weight, lose weight, maintain weight
    private int value;          // Bulk: weight gain in pounds times 1000,
                                // Cut: weight loss in pounds times 1000
                                // Maintain: Weeks maintained times 1000
    private Date deadline;
    public enum goalType{
        BULK, CUT, MAINTAIN
    }
    private goalType myGoalType;
    private int goalWeight;
    private Constants.Category category;
    private List<SubGoal> subGoals;

    public Goal()
    {

    }

    public Goal(String newName, String newDescription, int newValue, Date newDeadline,
                Constants.Category newCategory, goalType newGoalType, int newGoalWeight)
    {
        name = newName;
        description = newDescription;
        value = newValue;
        deadline = newDeadline;
        category = newCategory;
        myGoalType = newGoalType;
        goalWeight = newGoalWeight;
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

    public void setCategory (Constants.Category newCategory)
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

    public Constants.Category getCategory()
    {
        return category;
    }

    public List<SubGoal> getSubGoals()
    {
        return subGoals;
    }

    public void goalEnd(User myUser, int newWeight) {
        switch (myGoalType) {
            case BULK:
                 if (newWeight >= (goalWeight - 1) && newWeight <= (goalWeight + 1)) {
                    myUser.addPoints(value);
                } // add elsif 2 pounds, less points, etc
                // include time based brackets? (more time bigger brackets)
                break;
            // Similar for cut
            // Same for maintain, new weight is equal to user weight +/- 1 pound, etc)
        }
    }

}
