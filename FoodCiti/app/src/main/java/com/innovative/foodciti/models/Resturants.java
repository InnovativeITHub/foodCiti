package com.innovative.foodciti.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pulkit on 29/10/17.
 */

public class Resturants implements Serializable{

    @SerializedName("restaurant_id")
    private String restaurantId;
    @SerializedName("name")
    private String name;
    @SerializedName("loc")
    private String loc;
    @SerializedName("pincode")
    private String pincode;
    @SerializedName("city")
    private String city;
    @SerializedName("service")
    private String service;
    @SerializedName("cuisine")
    private String cuisine;
    @SerializedName("logo")
    private String logo;
    @SerializedName("add_time")
    private String addTime;
    @SerializedName("status")
    private String status;
    @SerializedName("category")
    private String category;
    @SerializedName("des")
    private String des;
    @SerializedName("menu_des")
    private String menuDes;
    @SerializedName("delivery")
    private String delivery;
    @SerializedName("mininum_order")
    private String mininumOrder;
    @SerializedName("phone")
    private String phone;
    @SerializedName("fax")
    private String fax;
    @SerializedName("email")
    private String email;
    @SerializedName("mile")
    private String mile;
    @SerializedName("event_date")
    private String eventDate;
    @SerializedName("display_order")
    private String displayOrder;
    @SerializedName("force_lock")
    private String forceLock;
    @SerializedName("lock_date")
    private String lockDate;
    @SerializedName("dispaly_opt")
    
    private String dispalyOpt;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getMenuDes() {
        return menuDes;
    }

    public void setMenuDes(String menuDes) {
        this.menuDes = menuDes;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getMininumOrder() {
        return mininumOrder;
    }

    public void setMininumOrder(String mininumOrder) {
        this.mininumOrder = mininumOrder;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMile() {
        return mile;
    }

    public void setMile(String mile) {
        this.mile = mile;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getForceLock() {
        return forceLock;
    }

    public void setForceLock(String forceLock) {
        this.forceLock = forceLock;
    }

    public String getLockDate() {
        return lockDate;
    }

    public void setLockDate(String lockDate) {
        this.lockDate = lockDate;
    }

    public String getDispalyOpt() {
        return dispalyOpt;
    }

    public void setDispalyOpt(String dispalyOpt) {
        this.dispalyOpt = dispalyOpt;
    }
    
}
