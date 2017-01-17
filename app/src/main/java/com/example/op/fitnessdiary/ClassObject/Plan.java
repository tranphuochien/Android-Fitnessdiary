package com.example.op.fitnessdiary.ClassObject;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by OP on 1/1/2017.
 */

public class Plan implements Serializable {
    String id;
    int numdays;
    int status;

    public Plan(String id, int numdays, int status)
    {
        this.id = id;
        this.numdays = numdays;
        this.status = status;
    }

    public Plan(int numdays)
    {
        this.id = UUID.randomUUID().toString();
        this.numdays = numdays;
    }
    //Method: get
    public String getId() { return this.id;}

    public int getNumdays() { return this.numdays;}

    public int getStatus() {return  this.status;}

    //Method: set
    public void setId(String id) { this.id = id;}

    public void setNumdays(int numdays) { this.numdays = numdays;}

    public void setStatus (int status) { this.status = status;}

}
