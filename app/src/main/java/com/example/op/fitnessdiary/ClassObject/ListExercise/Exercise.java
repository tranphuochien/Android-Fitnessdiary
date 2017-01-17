package com.example.op.fitnessdiary.ClassObject.ListExercise;

import java.io.Serializable;

/**
 * Created by OP on 12/24/2016.
 */

public abstract class Exercise implements  Serializable{
    protected String name = "Exercise";
    protected String avatar;
    protected int duration = 0;
    protected String idPlan;
    protected String datePlan;

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

    public void setDatePlan(String datePlan) { this.datePlan = datePlan;}

    public void setIdPlan(String idPlan) { this.idPlan = idPlan;}

    public String getAvatar() {return  avatar;}

    public void setAvatar(String s) {avatar = s;}

    public String getIdPlan() { return this.idPlan;}

    public String getDatePlan() { return this.datePlan;}

    public abstract int getIdMethod();

    public abstract Exercise Clone();

}
