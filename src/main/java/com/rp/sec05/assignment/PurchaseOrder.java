package com.rp.sec05.assignment;

import com.rp.courseUtil.Util;
import lombok.ToString;

@ToString
public class PurchaseOrder {

    private String item;
    private double price;
    private String catagory;
    private int quantity;

    public PurchaseOrder(){
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price());
        this.catagory = Util.faker().commerce().department();
        this.quantity = Util.faker().random().nextInt(1,10);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
