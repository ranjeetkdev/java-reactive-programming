package com.rp.sec04.handle;

import com.rp.courseUtil.Util;
import lombok.ToString;

@ToString
public class PurchaseOrder {
    private int userId;
    private String price;
    private String item;

    public PurchaseOrder(int userId) {
        this.userId = userId;
        this.price = Util.faker().commerce().price();
        this.item = Util.faker().commerce().productName();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
