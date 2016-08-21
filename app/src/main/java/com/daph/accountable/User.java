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
    private int levelMax;
    private int experienceMax;

    private List<Goal> goals;
    private List<Workout> workouts;
    private List<Nutrition> nutritions;
    private List<Meditation> meditations;

    public User()
    {
        points = 0;
        experience = 0;
        level = 1;
        levelMax = 10;
        experienceMax = 100;
    }

    public User (String userString) {
        String[] user = userString.split("/");

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
        levelMax = 10;
        experienceMax = 100;

        goals = new ArrayList<>();
        workouts = new ArrayList<>();
        nutritions = new ArrayList<>();
        meditations = new ArrayList<>();

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

    public int getLevelMax() { return  levelMax; }

    public int getExperienceMax() { return experienceMax; }

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

    public List<Meditation> getMeditations() {return meditations; }

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

    // Meditation Info

    public void addMeditation(Meditation newMeditation) { meditations.add(newMeditation); }

    public void delMeditation(Meditation deletedMeditation) {
        meditations.remove(deletedMeditation);
    }





    //Checks current experience and level up accordingly
    public int refreshLevel()
    {
        if (experience < 500)
        {
            level = 1;
        }
        else if (experience >= 500 && experience < 1500 )
        {
            level = 2;
        }
        else if (experience >= 1500 && experience < 3000 )
        {
            level = 3;
        }
        else if (experience >= 3000 && experience < 5000 )
        {
            level = 4;
        }
        else if (experience >= 5000 && experience < 7500 )
        {
            level = 5;
        }

        else if (experience >= 7500 && experience < 10500 )
        {
            level = 6;
        }
        else if (experience >= 10500 && experience < 14500 )
        {
            level = 7;
        }
        else if (experience >= 14500 && experience < 19500 )
        {
            level = 8;
        }
        else if (experience >= 19500 && experience < 25000 )
        {
            level = 9;
        }
        else
        {
            level = 10;
        }
        return level;
    }

    @Override
    public String toString()
    {
        return name + "/" +
            Boolean.toString(gender) + "/" +
            Integer.toString(age) + "/" +
            Integer.toString(weight) + "/" +
            Integer.toString(height) + "/" +
            Integer.toString(points) + "/" +
            Integer.toString(personalMultiplier) + "/" +
            Integer.toString(experience) + "/" +
            Integer.toString(level) + "/" +
            Integer.toString(levelMax) + "/" +
            Integer.toString(experienceMax) + "/" +
            goals.toString() + "/" +
            workouts.toString() + "/" +
            nutritions.toString() + "/" +
            meditations.toString();
    }
}
