package com.example.hw33;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("id")
    private String ImageId;
    @SerializedName("url")
    private String image_url;
    private Search [] name;

//
//    public Image(String id, String image_url) {
//        this.ImageId = id;
//        this.image_url = image_url;
//    }

    public String getImageId() {
        return ImageId;
    }

    public void setId(String ImageId) {
        this.ImageId = ImageId;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

//    public static class Search{
//        public String getId(){
//            return id;
//
//        }


    public static class Name{



    private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }




}
