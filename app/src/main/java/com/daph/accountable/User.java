package com.daph.accountable;

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

    public void addPoints(int morePoints)
    {
        points = points + morePoints;
    }

    public void subtractPoints(int lessPoints)
    {
        points = points - lessPoints;
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
}
