package com.example.op.fitnessdiary.ListExercise;

import android.content.Intent;

/**
 * Created by OP on 12/24/2016.
 */

public abstract class Exercise {
    protected String name = "Exercise";
    protected String avatar;
    protected int duration = 0;

    public String GetName()
    {
        return name;
    }

    public Boolean isOkByName(String strTypeName){
        return false;
    }

    protected  String NormalizeName(String strTypeName)
    {
        return NameHelper.Normalize(strTypeName);
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int d)
    {
        duration = d;
    }

    public String getAvatar() {return  avatar;}

    public void setAvatar(String s) {avatar = s;}

    public abstract Exercise Clone();

}
