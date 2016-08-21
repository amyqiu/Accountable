package com.daph.accountable;

/**
 * Created by Derin on 2016-08-20.
 */
public class Nutrition extends Accomplishment {

    private int dailyCalorieGoal; //Also include weekly option later
    private int dailyProteinGoal;

    private int caloriesToday; // Honestly weekly is better, but lets add a +/- 50 interval
    private int proteinToday;


    // Import from nutrition goal

    // Weekly calorie goal, daily protein goal7

    public Nutrition(int newDailyCalorieGoal, int newDailyProteinGoal) {
        dailyCalorieGoal = newDailyCalorieGoal;
        dailyProteinGoal = newDailyProteinGoal;

        caloriesToday = 0; // Needs to be set later on.
        proteinToday = 0;

        setCategory(Constants.Category.NUTRITION);

        // With this constructor, call nutritionPoints in main at the end of the day.
    }

    public Nutrition(int newDailyCalorieGoal, int newDailyProteinGoal, int newCaloriesToday,
                     int newProteinToday) {
        dailyCalorieGoal = newDailyCalorieGoal;
        dailyProteinGoal = newDailyProteinGoal;

        caloriesToday = newCaloriesToday;
        proteinToday = newProteinToday;

        setCategory(Constants.Category.NUTRITION);

        nutritionPoints(); // This is declared later, idk if it will work.
    }

    // Mutators of goals and current calories as well as protein
    public void setDailyCalorieGoal(int newCalorieGoal) {
        dailyCalorieGoal = newCalorieGoal;
    }

    public void setDailyProteinGoal(int newProteinGoal) {
        dailyProteinGoal = newProteinGoal;
    }

    public void setCaloriesToday(int newCalories) {
        caloriesToday = newCalories;
    }

    public void setProteinToday(int newProtein) {
        proteinToday = newProtein;
    }

    // Accessors of goals and current calories as well as protein
    public int getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public int getDailyProteinGoal() {
        return dailyProteinGoal;
    }

    public int getCaloriesToday() {
        return caloriesToday;
    }

    public int getProteinToday() {
        return proteinToday;
    }

    // Helper functions

    public void nutritionPoints() {
        // If caloriesToday and proteinToday were not defined from the constructor,
        // this needs to be run in the main function.

        // There are two situations: 1. A user sets the calorie goal as a longstanding goal, and
        // needs to input their calories throughout the day.2. a user sets a daily calorie goal
        // at the end of the day, and records their daily calories.  The constructors represent
        // these two cases, respectively.

        int multiplier = 0;

        if (caloriesToday >= (dailyCalorieGoal - 50) && caloriesToday <= (dailyCalorieGoal + 50)) {
            multiplier = 1;
        }

        if (proteinToday >= dailyProteinGoal) {
            multiplier += 0.5; // You get some credit for only hitting protein.
        }

        setValue(multiplier * 100); // 100 is just a placeholder value
    }



}
