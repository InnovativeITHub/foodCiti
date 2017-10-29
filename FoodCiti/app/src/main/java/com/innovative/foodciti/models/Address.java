package com.innovative.foodciti.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pulkit on 29/10/17.
 */

public class Address implements Serializable{

    @SerializedName("user_id")
    private String userId;
    @SerializedName("name")
    private String name;
    @SerializedName("ph")
    private String ph;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("post_code")
    private String postCode;
    @SerializedName("add_time")
    private String addTime;
    @SerializedName("status")
    
    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
