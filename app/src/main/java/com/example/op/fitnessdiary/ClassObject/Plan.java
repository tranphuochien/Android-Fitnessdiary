package com.example.op.fitnessdiary.ClassObject;

import java.io.Serializable;

/**
 * Created by OP on 1/1/2017.
 */

public class Plan implements Serializable {
    String id;
    int numdays;
    boolean status;

    //Method: get
    String getId() { return this.id;}

    int getNumdays() { return this.numdays;}

    boolean getStatus() {return  this.status;}

    //Method: set
    void setId(String id) { this.id = id;}

    void setNumdays(int numdays) { this.numdays = numdays;}

    void setStatus (boolean status) { this.status = status;}


}
