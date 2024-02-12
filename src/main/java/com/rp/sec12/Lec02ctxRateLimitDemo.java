package com.rp.sec12;

import com.rp.courseUtil.Util;
import com.rp.sec09.helper.BookOrder;
import com.rp.sec12.helper.BookService;
import com.rp.sec12.helper.UserService;
import reactor.util.context.Context;

public class Lec02ctxRateLimitDemo {

    public static void main(String[] args) {
        BookService.getBook()
                .repeat(2)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user","Ranjeet"))
                .subscribe(Util.subscriber());
    }
}
