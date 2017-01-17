package com.example.op.fitnessdiary.ClassObject.ListExercise;

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
        return "LIFTING";
    }

    @Override
    public Boolean isOkByName(String strTypeName) {
        return NormalizeName(strTypeName) == GetName();
    }

    @Override
    public int getIdMethod() {
        return 3;
    }

    public int getSections() {
        return times;
    }

    public void setSections(int t) {
        times = t;
    }

    public int getTimes() {
        return nHitOnTime;
    }

    public void setTimes(int t) {
        nHitOnTime = t;
    }

}
