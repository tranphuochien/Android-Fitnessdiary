package com.example.op.fitnessdiary.ListExercise;

import java.util.ArrayList;

/**
 * Created by OP on 12/24/2016.
 */

public class ListExercise {
    // Prototype
    private ArrayList<Exercise> sampleExercise = new ArrayList<Exercise>();;
    public  ListExercise()
    {
        sampleExercise = new ArrayList<Exercise>();
        sampleExercise.add(new Jogging());
        sampleExercise.add(new Lifting());
        sampleExercise.add(new Dancing());
        sampleExercise.add(new PushUp());
        //sampleExercise.add(new PushUp());
        //sampleExercise.add(new Lifting());
    }

    public ArrayList<Exercise> getListExercise()
    {
        ListExercise obj = new ListExercise();
        return obj.sampleExercise;
    }

    public Exercise ChooseExercise(String strTypeName)
    {
        for (int i = 0; i < sampleExercise.size(); i++)
            if (sampleExercise.get(i).isOkByName(strTypeName))
                return ChooseExercise(i);
        return ChooseDefaultExercise();
    }

    private Exercise ChooseDefaultExercise()
    {
        return sampleExercise.get(0).Clone();

    }

    public Exercise ChooseExercise(int idx)
    {
        if (idx >= 0 && idx < sampleExercise.size())
            return sampleExercise.get(idx).Clone();
        return ChooseDefaultExercise();
    }
}
