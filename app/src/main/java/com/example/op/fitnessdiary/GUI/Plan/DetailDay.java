package com.example.op.fitnessdiary.GUI.Plan;

/**
 * Created by OP on 12/26/2016.
 */
public class DetailDay {
    private int idDay;
    private String date;

    public  DetailDay(int idDay, String date)
    {
        this.idDay = idDay;
        this.date  = date;
    }
    public void setIdDay(int s)
    {
        idDay = s;
    }
    public void setDate(String d) {this.date = d;}

    public String getDate() {return "Day " + this.idDay + " : " + date;}

    public String getIdDay()
    {
        return "Day " + this.idDay;
    }

}
