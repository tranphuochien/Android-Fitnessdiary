package com.example.op.fitnessdiary.ClassObject;

import java.io.Serializable;

/**
 * Created by theriddle on 1/6/17.
 */

public class Album implements Serializable {
    private String id;

    public Album (String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
