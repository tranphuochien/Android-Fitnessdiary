package com.example.op.fitnessdiary.ClassObject.ListExercise;

/**
 * Created by OP on 12/24/2016.
 */

public class PushUp extends Exercise implements Strength {
    private  int sections;
    private int times;

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
        return "PUSHUP";
    }

    @Override
    public Boolean isOkByName(String strTypeName) {
        return NormalizeName(strTypeName) == GetName();
    }

    @Override
    public int getIdMethod() {
        return 2;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int t) {
        sections = t;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int t) {
        times = t;
    }
}
