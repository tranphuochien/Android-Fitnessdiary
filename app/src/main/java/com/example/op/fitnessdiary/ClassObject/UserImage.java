package com.example.op.fitnessdiary.ClassObject;

import java.io.Serializable;

/**
 * Created by theriddle on 12/24/16.
 */

public class UserImage implements Serializable{
    private String imageName;
    private String imageInfo;
    private String imagePath;

    public UserImage(String imageName, String imageInfo, String imagePath){
        this.imageInfo = imageInfo;
        this.imageName = imageName;
        this.imagePath = imagePath;
    }

    public String getImageName(){
        return this.imageName;
    }

    public String getImageInfo(){
        return this.imageInfo;
    }

    public String getImagePath() { return this.imagePath; }

    public void setImageName(String imageName){
        this.imageName = imageName;
    }

    public void setImageInfo(String imageInfo){
        this.imageInfo = imageInfo;
    }

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

}
