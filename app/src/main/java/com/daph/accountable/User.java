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

    //True = female, False = female
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
        points = points + morePoints;
    }

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

    public int getExperience()
    {
        return experience;
    }

    public int getLevel()
    {
        return level;
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
