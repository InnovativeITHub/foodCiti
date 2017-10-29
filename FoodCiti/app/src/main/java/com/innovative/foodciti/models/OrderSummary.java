package com.innovative.foodciti.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pulkit on 29/10/17.
 */

public class OrderSummary implements Serializable{

    @SerializedName("rest_status")
    private String restStatus;
    @SerializedName("order_status")
    private String orderStatus;
    @SerializedName("resturants")
    private Resturants resturants;
    @SerializedName("orders")
    private Orders orders;
    @SerializedName("order_time")
    private String orderTime;
    @SerializedName("order_method")
    private String orderMethod;
    @SerializedName("discount")
    private String discount;
    @SerializedName("cart_amt")
    private Double cartAmt;
    @SerializedName("extra")
    private String extra;
    @SerializedName("cart_total_amt")

    private String cartTotalAmt;

    public String getRestStatus() {
        return restStatus;
    }

    public void setRestStatus(String restStatus) {
        this.restStatus = restStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Resturants getResturants() {
        return resturants;
    }

    public void setResturants(Resturants resturants) {
        this.resturants = resturants;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderMethod() {
        return orderMethod;
    }

    public void setOrderMethod(String orderMethod) {
        this.orderMethod = orderMethod;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Double getCartAmt() {
        return cartAmt;
    }

    public void setCartAmt(Double cartAmt) {
        this.cartAmt = cartAmt;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getCartTotalAmt() {
        return cartTotalAmt;
    }

    public void setCartTotalAmt(String cartTotalAmt) {
        this.cartTotalAmt = cartTotalAmt;
    }
}
