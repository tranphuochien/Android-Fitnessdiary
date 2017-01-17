package com.example.op.fitnessdiary.ClassObject.ListExercise;

import com.example.op.fitnessdiary.R;

/**
 * Created by OP on 12/24/2016.
 */

public class Jogging extends Exercise implements Endurance {
    protected float nKilometer = 0;

    public  Jogging()
    {
        avatar = "joging";
    }

    public Jogging(String idPlan, String datePlan, int duration, float nKilometer)
    {
        this.idPlan = idPlan;
        this.datePlan = datePlan;
        this.duration = duration;
        this.nKilometer = nKilometer;
    }

    @Override
    public Exercise Clone() {
        Exercise obj = new Jogging();
        return obj;
    }

    @Override
    public String GetName() {
        return "JOGGING";
    }

    @Override
    public Boolean isOkByName(String strTypeName) {
        return NormalizeName(strTypeName) == GetName();
    }

    @Override
    public int getIdMethod() {
        return 6;
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
