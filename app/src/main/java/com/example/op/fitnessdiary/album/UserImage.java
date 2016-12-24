package com.example.op.fitnessdiary.album;

import java.io.Serializable;

/**
 * Created by theriddle on 12/24/16.
 */

public class UserImage implements Serializable{
    private String imageName;
    private String imageInfo;

    public UserImage(String imageName, String imageInfo){
        this.imageInfo = imageInfo;
        this.imageName = imageName;
    }

    public String getImageName(){
        return this.imageName;
    }

    public String getImageInfo(){
        return this.imageInfo;
    }

    public void setImageName(String imageName){
        this.imageName = imageName;
    }

    public void setImageInfo(String imageInfo){
        this.imageInfo = imageInfo;
    }

}
