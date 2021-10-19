package com.revature.model;

import io.javalin.Javalin;

public class HelloJ {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/{name}", ctx -> ctx.result("Hello Javalin !!"));
    }
}