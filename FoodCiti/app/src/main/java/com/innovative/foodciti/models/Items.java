package com.innovative.foodciti.models;

import java.util.ArrayList;

/**
 * Created by pulkit on 29/10/17.
 */

public class Items {
    private String item;
    private String price;
    private ArrayList<SubItem> subitem;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ArrayList<SubItem> getSubitem() {
        return subitem;
    }

    public void setSubitem(ArrayList<SubItem> subitem) {
        this.subitem = subitem;
    }
}
