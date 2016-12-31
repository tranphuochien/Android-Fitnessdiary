package com.example.op.fitnessdiary.ClassObject.ListExercise;

/**
 * Created by OP on 12/24/2016.
 */

public class Dancing extends Exercise implements Endurance {

    public Dancing()
    {
        avatar = "dancing";
    }
    @Override
    public Exercise Clone() {
        Exercise obj = new Dancing();
        return obj;
    }

    @Override
    public String GetName() {
        return "DANCING";
    }

    @Override
    public Boolean isOkByName(String strTypeName) {
        return NormalizeName(strTypeName) == GetName();
    }
}
