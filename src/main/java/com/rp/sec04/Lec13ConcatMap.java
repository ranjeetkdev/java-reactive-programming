package com.rp.sec04;

import com.rp.courseUtil.Util;
import com.rp.sec04.handle.OrderService;
import com.rp.sec04.handle.UserService;

public class Lec13ConcatMap {

    public static void main(String[] args) {
        UserService.getUsers()
                .concatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());
    }
}
