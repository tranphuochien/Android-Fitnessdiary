package com.example.op.fitnessdiary.ListExercise;

/**
 * Created by OP on 12/24/2016.
 */

public class Lifting extends  Exercise implements Strength {
    private  int times;
    private int nHitOnTime;

    public Lifting()
    {
        avatar = "lifting";
    }
    @Override
    public Exercise Clone() {
        Exercise obj = new Lifting();
        return obj;
    }

    @Override
    public String GetName() {
        return "lifting";
    }

    @Override
    public Boolean isOkByName(String strTypeName) {
        return NormalizeName(strTypeName) == GetName();
    }

    @Override
    public int getTimes() {
        return times;
    }

    @Override
    public void setTimes(int t) {
        times = t;
    }

    @Override
    public int getnHitOnTime() {
        return nHitOnTime;
    }

    @Override
    public void setnHitOnTime(int t) {
        nHitOnTime = t;
    }

}
