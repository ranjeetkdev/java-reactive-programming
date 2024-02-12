package com.rp.sec04;

import com.rp.courseUtil.Util;
import com.rp.sec04.handle.OrderService;
import com.rp.sec04.handle.PurchaseOrder;
import com.rp.sec04.handle.UserService;

public class Lec12FlatMap {
    public static void main(String[] args) {

        UserService.getUsers()
//                .map(user ->
//                    OrderService.getOrders(user.getUserId())
                .flatMap(user -> OrderService.getOrders(user.getUserId())
                ).subscribe(Util.subscriber());
    }
}
