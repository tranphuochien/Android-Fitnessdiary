package com.example.op.fitnessdiary.ClassObject;

import java.io.Serializable;

/**
 * Created by theriddle on 12/24/16.
 */

public class UserImage implements Serializable{
    private String imageid;
    private String imageCreate;
    private String imageInAlbum;
    private String imageInPost;
    private String imageInDetail;
    private String imageName;
    private String imageInfo;
    private String imagePath;

    public UserImage(String imageName, String imageInfo, String imagePath){
        this.imageInfo = imageInfo;
        this.imageName = imageName;
        this.imagePath = imagePath;
    }

    public UserImage(String imageid, String imageCreate, String imageInAlbum, String imageInPost, String imageInDetail, String imageName, String imageInfo, String imagePath){
        this.imageid = imageid;
        this.imageCreate = imageCreate;
        this.imageInAlbum = imageInAlbum;
        this.imageInPost = imageInPost;
        this.imageInDetail = imageInDetail;
        this.imageName = imageName;
        this.imageInfo = imageInfo;
        this.imagePath= imagePath;
    }

    public UserImage(String imageid, String imageCreate, String imageInAlbum, String imageInPost, String imageInDetail){
        this.imageid = imageid;
        this.imageCreate = imageCreate;
        this.imageInAlbum = imageInAlbum;
        this.imageInPost = imageInPost;
        this.imageInDetail = imageInDetail;
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

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public String getImageCreate() {
        return imageCreate;
    }

    public void setImageCreate(String imageCreate) {
        this.imageCreate = imageCreate;
    }

    public String getImageInAlbum() {
        return imageInAlbum;
    }

    public void setImageInAlbum(String imageInAlbum) {
        this.imageInAlbum = imageInAlbum;
    }

    public String getImageInPost() {
        return imageInPost;
    }

    public void setImageInPost(String imageInPost) {
        this.imageInPost = imageInPost;
    }

    public String getImageInDetail() {
        return imageInDetail;
    }

    public void setImageInDetail(String imageInDetail) {
        this.imageInDetail = imageInDetail;
    }
}
