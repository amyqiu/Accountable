package com.daph.accountable.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Derin on 2016-08-20.
 */
public class Workout extends Accomplishment{
    // Include intensity enums
    private double intensity; // Low = 1x multiplier, medium = 1.5x, high = 2x multiplier
    // Actually on second thought, maybe define intensity
    // Could also use fitbit info for heart rate
    private int time;

    // Take information from a form for this
    public Workout(String newName, String newDescription, int newIntensity, int newTime) {

        setName(newName);
        setDescription(newDescription);
        // setCategory(Constants.Category.WORKOUT);
        intensity = newIntensity;
        time = newTime;
        setValue((int)Math.round(time*intensity));

    }

    public void WorkoutTime() {
        // Use location tracker to track time in gym.
        // 1: check-in
        // 2: Track location, pause timer if location exits gym
        // 3: Finish workout

    }

    public void setTime(int newTime) {
        time = newTime;
    }

    public void setIntensity(int newIntensity) {
        intensity = newIntensity;
    }

    public int getTime() {
        return time;
    }

    public double getIntensity() {
        return intensity;
    }

    public static String listToString (List<Workout> workouts) {
        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < workouts.size(); i++) {
            newList.add(workouts.get(i).toString());
        }
        return TextUtils.join(",", newList);
    }

    @Override
    public String toString () {
        return getName() + "~" +
                getDescription() + "~" +
                Integer.toString(getValue()) + "~" +
                Double.toString(intensity) + "~" +
                Integer.toString(time);
    }


}
