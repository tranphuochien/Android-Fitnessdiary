package com.example.op.fitnessdiary.GUI.Plan;

/**
 * Created by OP on 12/26/2016.
 */
public class DetailDay {
    private int idDay;

    public  DetailDay(int idDay)
    {
        this.idDay = idDay;
    }
    public void setIdDay(int s)
    {
        idDay = s;
    }

    public String getIdDay()
    {
        return "Day " + this.idDay;
    }

}
