package com.revature.main;

import io.javalin.Javalin;

public class HelloJ {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));
    }
}