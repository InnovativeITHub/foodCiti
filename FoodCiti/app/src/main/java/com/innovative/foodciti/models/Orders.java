package com.innovative.foodciti.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pulkit on 29/10/17.
 */

public class Orders implements Serializable{

    @SerializedName("master_id")
    private String masterId;
    @SerializedName("cart_id")
    private String cartId;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("transaction_id")
    private String transactionId;
    @SerializedName("transaction_method")
    private String transactionMethod;
    @SerializedName("total_amount")
    private String totalAmount;
    @SerializedName("add_time")
    private String addTime;
    @SerializedName("status")
    private String status;
    @SerializedName("order_method")
    private String orderMethod;
    @SerializedName("res_id")
    private String resId;
    @SerializedName("del_charges")
    private String delCharges;
    @SerializedName("discount")
    private String discount;
    @SerializedName("extra_crg")
    private String extraCrg;
    @SerializedName("order_collection_time")
    private String orderCollectionTime;
    @SerializedName("order_comments")
    private String orderComments;
    @SerializedName("order_accept_time")
    private String orderAcceptTime;
    @SerializedName("card_tax")
    private String cardTax;
    @SerializedName("order_process_time")
    private String orderProcessTime;
    @SerializedName("address")
    
    private Address address;

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionMethod() {
        return transactionMethod;
    }

    public void setTransactionMethod(String transactionMethod) {
        this.transactionMethod = transactionMethod;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
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

    public String getOrderMethod() {
        return orderMethod;
    }

    public void setOrderMethod(String orderMethod) {
        this.orderMethod = orderMethod;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getDelCharges() {
        return delCharges;
    }

    public void setDelCharges(String delCharges) {
        this.delCharges = delCharges;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getExtraCrg() {
        return extraCrg;
    }

    public void setExtraCrg(String extraCrg) {
        this.extraCrg = extraCrg;
    }

    public String getOrderCollectionTime() {
        return orderCollectionTime;
    }

    public void setOrderCollectionTime(String orderCollectionTime) {
        this.orderCollectionTime = orderCollectionTime;
    }

    public String getOrderComments() {
        return orderComments;
    }

    public void setOrderComments(String orderComments) {
        this.orderComments = orderComments;
    }

    public String getOrderAcceptTime() {
        return orderAcceptTime;
    }

    public void setOrderAcceptTime(String orderAcceptTime) {
        this.orderAcceptTime = orderAcceptTime;
    }

    public String getCardTax() {
        return cardTax;
    }

    public void setCardTax(String cardTax) {
        this.cardTax = cardTax;
    }

    public String getOrderProcessTime() {
        return orderProcessTime;
    }

    public void setOrderProcessTime(String orderProcessTime) {
        this.orderProcessTime = orderProcessTime;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
