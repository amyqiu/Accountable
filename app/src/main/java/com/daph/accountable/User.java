package com.daph.accountable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amy on 2016-08-20.
 */
public class User {

    private String name;
    private boolean gender;
    private int age;
    private int weight;
    private int height;

    private int points;
    private int personalMultiplier;

    private int experience;
    private int level;

    private List<Goal> goals;
    private List<Workout> workouts;
    private List<Nutrition> nutritions;

    public User()
    {

    }

    public User(String newName, boolean newGender, int newAge, int newWeight, int newHeight)
    {
        name = newName;
        gender = newGender;
        age = newAge;
        weight = newWeight;
        height = newHeight;

        points = 0;
        personalMultiplier = 1;
        experience = 0;
        level = 1;

        goals = new ArrayList<>();
        workouts = new ArrayList<>();
        nutritions = new ArrayList<>();

    }

    public void setName(String newName)
    {
        if (newName != null)
        {
            name = newName;
        }

    }

    //True = female, False = male
    public void setGender(Boolean newGender)
    {
        gender = newGender;
    }

    public void setAge(int newAge)
    {
        age = newAge;
    }

    public void setWeight(int newWeight)
    {
        weight = newWeight;
    }

    public void setHeight(int newHeight)
    {
        height = newHeight;
    }

    public void setPoints(int newPoints)
    {
        points = newPoints;
    }

    public void setExperience(int newExperience)
    {
        experience = newExperience;
    }

    public void setLevel(int newLevel)
    {
        level = newLevel;
    }

    public void addPoints(int morePoints)
    {
        points = points +  personalMultiplier*morePoints;
    }
    // Also include servermultiplier

    public void subtractPoints(int lessPoints)
    {
        points = points - lessPoints;
    }

    public void addExperience (int moreExperience)
    {
        experience = experience + moreExperience;
    }

    public String getName()
    {
        return name;
    }

    public boolean getGender()
    {
        return gender;
    }

    public int getAge()
    {
        return age;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getHeight()
    {
        return height;
    }

    public int getPoints()
    {
        return points;
    }

    public int getExperience()
    {
        return experience;
    }

    public int getLevel()
    {
        return level;
    }

    // **** ARRAYS ****

    // Array Accessors

    public List<Goal> getGoals()
    {
        return goals;
    }

    public List<Workout> getWorkouts()
    {
        return workouts;
    }

    public List<Nutrition> getNutritions()
    {
        return nutritions;
    }

    // Array Mutators

    // Goal Info
    public void addGoal(Goal newGoal)
    {
        goals.add(newGoal);
    }

    public void delGoal(Goal deletedGoal)
    {
        goals.remove(deletedGoal);
    }

    // Workout Info
    public void addWorkout(Workout newWorkout)
    {
        workouts.add(newWorkout);
    }

    public void delWorkout(Workout deletedWorkout)
    {
        workouts.remove(deletedWorkout);
    }

    // Nutrition Info
    public void addNutrition(Nutrition newNutrition)
    {
        nutritions.add(newNutrition);
    }

    public void delNutrition(Nutrition deletedNutrition)
    {
        nutritions.remove(deletedNutrition);
    }


    //Checks current experience and level up accordingly
    public int refreshLevel()
    {
        if (experience < 1000)
        {
            level = 1;
        }
        return level;
    }

}
