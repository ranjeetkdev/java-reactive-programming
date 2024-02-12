package com.rp.sec12.helper;

import reactor.util.context.Context;

import java.util.Map;
import java.util.function.Function;

public class UserService {

    private static Map<String, String> map = Map.of(
            "Ranjeet","std",
            "Supriya", "prime"
    );


    public static Function<Context, Context> userCategoryContext(){
        return ctx -> {
            String user = ctx.get("user").toString();
            String category = map.get(user);
            return ctx.put("category", category);
        };
    }
}
