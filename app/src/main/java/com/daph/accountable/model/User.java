package com.daph.accountable.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amy on 2016-08-20.
 */
public class User {

    private String name;
    private int points;
    private double personalMultiplier;
    private int experience;
    private List<Workout> workouts;
    private List<Nutrition> nutritions;
    private List<Meditation> meditations;

    private List<Investment> investmentsInMe;
    private List<Investment> myInvestments;
    public User()
    {
        points = 0;
        experience = 0;
    }

    public User (String userString) {
        if (userString.contains("/")) {
            String[] user = userString.split("/");
            name = user[0];

            points = Integer.parseInt(user[1]);
            personalMultiplier = Double.parseDouble(user[2]);
            experience = Integer.parseInt(user[3]);

            workouts = Workout.stringToList(user[4]);
            nutritions = Nutrition.stringToList(user[5]);
            meditations = Meditation.stringToList(user[6]);
        } else {
            name = userString;
            points = 0;
            personalMultiplier = 1;
            experience = 0;
            workouts = new ArrayList<>();
            nutritions = new ArrayList<>();
            meditations = new ArrayList<>();
            investmentsInMe = new ArrayList<>();
            myInvestments = new ArrayList<>();
        }

    }

    public void setName(String newName)
    {
        if (newName != null)
        {
            name = newName;
        }

    }


    public void setPoints(int newPoints)
    {
        points = newPoints;
    }

    public void setExperience(int newExperience)
    {
        experience = newExperience;
    }

    public void addPoints(int morePoints)
    {
        points += personalMultiplier*morePoints;
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

    public int getPoints()
    {
        return points;
    }

    public int getExperience()
    {
        return experience;
    }
    // **** ARRAYS ****

    // Array Accessors

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

    // Investment Info

    public void addMeditation(Investment newInvestment, boolean mine) {
        if (mine) {
            myInvestments.add(newInvestment);
        }
        else {
            investmentsInMe.add(newInvestment);
        }
    }

    public void delInvestment(Investment deletedInvestment, boolean mine) {
        if (mine) {
            myInvestments.remove(deletedInvestment);
        }
        else {
            investmentsInMe.remove(deletedInvestment);
        }
    }

    public List<Investment> getInvestmentsInMe()
    {
        return investmentsInMe;
    }

    public List<Investment> getMyInvestments()
    {
        return myInvestments;
    }

    //Checks current experience and level up accordingly
    public int getLevel()
    {
        if (experience < 500)
        {
            return  1;
        }
        else if (experience < 1500 )
        {
            return 2;
        }
        else if (experience < 3000 )
        {
            return 3;
        }
        else if (experience < 5000 )
        {
            return 4;
        }
        else if (experience < 7500 )
        {
            return 5;
        }

        else if (experience < 10500 )
        {
            return 6;
        }
        else if (experience < 14500 )
        {
            return 7;
        }
        else if (experience < 19500 )
        {
            return 8;
        }
        else if (experience < 25000 )
        {
            return 9;
        }
        else
        {
            return 10;
        }
    }

    public static ArrayList<User> stringListToUserList (ArrayList<String> arr) {
        ArrayList<User> userArr = new ArrayList<>();
        for (int i = 0; i < arr.size(); ++i) {
            userArr.add(new User(arr.get(i)));
            }
        return userArr;
    }

    public static ArrayList<String>userListToStringList (ArrayList<User> arr) {
        ArrayList<String> stringArr = new ArrayList<>();
        for (int i = 0; i < arr.size(); ++i) {
            stringArr.add(arr.get(i).toString());
        }
        return stringArr;
    }

    @Override
    public String toString()
    {
        return name + "/" +
            Integer.toString(points) + "/" +
            Double.toString(personalMultiplier) + "/" +
            Integer.toString(experience) + "/" +
            Workout.listToString(workouts) + "/" +
            Nutrition.listToString(nutritions) + "/" +
            Meditation.listToString(meditations);
    }

    public static int userPos (String name, ArrayList<User> userlist) {
        int pos = -1;
        for (int i = 0; i < userlist.size(); ++i) {
            if (userlist.get(i).getName().equals(name)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
