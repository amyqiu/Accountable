package com.daph.accountable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amy on 2016-08-20.
 */
public class SubGoal extends Goal {
    private List<Accomplishment> tasks;

    public SubGoal()
    {
        super();
        tasks = new ArrayList<Accomplishment>();
    }
}
