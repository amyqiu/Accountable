package com.daph.accountable;

import java.util.*;

/**
 * Created by Derin on 2016-08-21.
 */
public class Meditation extends Accomplishment {
    private long startTime;
    private long endTime;
    private long time;

    private int value;

    public Meditation() {
        time = 0;
        startTime = System.currentTimeMillis();
        endTime = startTime;
    }

    public void pause() { // If pause button is clicked.
        endTime = System.currentTimeMillis();
        time += endTime - startTime;
        startTime = endTime;
    }

    public void endMeditation() { // If stop button is clicked.
        endTime = System.currentTimeMillis();
        time += endTime - startTime;

        value = (int)(time/1000); // Change this later?
        setValue(value);
    }
}
