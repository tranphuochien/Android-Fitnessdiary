package com.example.op.fitnessdiary.GUI.ViewHolderListExercise;


import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by OP on 12/31/2016.
 */

public class ListVHExercise {
    private static ListVHExercise instances;
    // Prototype
    private static ArrayList<VHExercise> sampleVH = new ArrayList<VHExercise>();;
    private ListVHExercise()
    {
            sampleVH = new ArrayList<VHExercise>();
            sampleVH.add(new VHJogging());
            sampleVH.add(new VHLifting());
            sampleVH.add(new VHDancing());
            sampleVH.add(new VHPushup());
    }
    public static synchronized ListVHExercise getInstance() {
        if (instances == null) {
            instances = new ListVHExercise();
        }
        return instances;
    }

    public static ArrayList<VHExercise> getListVHExercise()
    {
        ListVHExercise obj = new ListVHExercise();
        return obj.sampleVH;
    }

    public static VHExercise ChooseVHExercise(String strTypeName)
    {
        for (int i = 0; i < sampleVH.size(); i++)
            if (sampleVH.get(i).isOkByName(strTypeName))
                return ChooseVHExercise(i);
        return ChooseDefaultVHExercise();
    }

    private static VHExercise ChooseDefaultVHExercise()
    {
        return sampleVH.get(0).Clone();

    }

    public static VHExercise ChooseVHExercise(int idx)
    {
        if (idx >= 0 && idx < sampleVH.size())
            return sampleVH.get(idx).Clone();
        return ChooseDefaultVHExercise();
    }
}
