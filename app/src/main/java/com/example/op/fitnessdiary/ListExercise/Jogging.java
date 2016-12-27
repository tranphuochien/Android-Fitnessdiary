package com.example.op.fitnessdiary.ListExercise;

/**
 * Created by OP on 12/24/2016.
 */

public class Jogging extends Exercise implements Endurance {
    protected float nKilometer = 0;

    public  Jogging()
    {
        avatar = "joging";
    }
    @Override
    public Exercise Clone() {
        Exercise obj = new Jogging();
        return obj;
    }

    @Override
    public String GetName() {
        return "jogging";
    }

    @Override
    public Boolean isOkByName(String strTypeName) {
        return NormalizeName(strTypeName) == GetName();
    }

    public float getnKilometer()
    {
        return nKilometer;
    }

    public void setnKilometer(int k)
    {
        nKilometer = k;
    }
}