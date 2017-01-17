package com.example.op.fitnessdiary.ClassObject;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by OP on 1/17/2017.
 */

public class DetailPlan implements Serializable {
    String id;
    String idPlan;
    String datePlan;
    int idMethod;
    int status;

    public DetailPlan(String id, String idPlan, String datePlan, int idMethod, int status )
    {
        this.id = id;
        this.idPlan = idPlan;
        this.datePlan = datePlan;
        this.idMethod = idMethod;
        this.status = status;
    }

    public DetailPlan( String idPlan, String datePlan, int idMethod, int status )
    {
        this.id = UUID.randomUUID().toString();
        this.idPlan = idPlan;
        this.datePlan = datePlan;
        this.idMethod = idMethod;
        this.status = status;
    }
    // Set method
    public void setStatus(int status) { this.status = status;}

    public void setId(String id) {this.id = id;}

    public void setIdPlan (String idPlan) { this.idPlan = idPlan;   }

    public void setDatePlan (String datePlan) { this.datePlan = datePlan;}

    public void setIdMethod (int idMethod) { this.idMethod = idMethod;}

    //Get method
    public String getId() { return this.id;}

    public String getIdPlan() {return this.idPlan;}

    public String getDatePlan() { return this.datePlan;}

    public int getIdMethod() {return this.idMethod;}

    public int getStatus() { return this.status;}

}
