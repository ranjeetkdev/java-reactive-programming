package com.rp.sec09.Assignment;

import com.rp.courseUtil.Util;
import lombok.ToString;

@ToString
public class PurchaseOrder {

    private String item;
    private double price;
    private String catagory;

    public PurchaseOrder(){
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price());
        this.catagory = Util.faker().commerce().department();
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

}
