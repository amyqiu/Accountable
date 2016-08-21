package com.daph.accountable.model;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Derin on 2016-08-21.
 */
public class Meditation extends Accomplishment {
    private int time;

    public Meditation() {
        time = 0;
    }

//    public void pause() { // If pause button is clicked.
//        endTime = System.currentTimeMillis();
//        time += endTime - startTime;
//        startTime = endTime;
//    }
//
//    public void endMeditation() { // If stop button is clicked.
//        endTime = System.currentTimeMillis();
//        time += endTime - startTime;
//
//        setValue((int)(time/1000)); // Change this later?
//    }

    public static String listToString (List<Meditation> mediation) {
        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < mediation.size(); i++) {
            newList.add(mediation.get(i).toString());
        }
        return TextUtils.join(",", newList);
    }

    @Override
    public String toString () {
        return getName() + "~" +
                getDescription() + "~" +
                Integer.toString(getValue()) + "~" +
                Integer.toString(time);
    }
}
