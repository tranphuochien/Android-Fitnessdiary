package com.example.op.fitnessdiary.ClassObject.ListExercise;

/**
 * Created by OP on 12/24/2016.
 */

public class PushUp extends Exercise implements Strength {
    private  int times;
    private int nHitOnTime;

    public PushUp()
    {
        avatar="pushup";
    }
    @Override
    public Exercise Clone() {
        Exercise obj = new PushUp();
        return obj;
    }

    @Override
    public String GetName() {
        return "pushup";
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
