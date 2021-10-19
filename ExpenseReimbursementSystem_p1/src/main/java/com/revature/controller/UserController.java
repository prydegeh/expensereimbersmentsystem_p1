package com.revature.controller;
import java.util.Objects;

import com.google.gson.Gson;
import com.revature.dao.UserDao;
import com.revature.model.User;

import io.javalin.http.Handler;

public class UserController {
	private static Gson gson = new Gson();
	
	public static Handler fetchAllUsernames = ctx -> {
		UserDao dao = UserDao.instance();
		Iterable<String> allUsers = dao.getAllUsernames();
		ctx.json(allUsers);
	};

	public static Handler fetchById = ctx -> {
		int id = Integer.parseInt(Objects.requireNonNull(ctx.pathParam("id")));
		UserDao dao = UserDao.instance();
		User user = dao.getUserById(id).get();
		if (user == null) {
			ctx.html("Not Found");
		} else {
			ctx.json(user);
		}
	};
	
	public static Handler addUser = ctx -> {
		String body = ctx.body();
		UserDao dao = UserDao.instance();
		try {
			User user = gson.fromJson(body, User.class);
			if (user != null) {
				User returned = dao.addUser(user);
				ctx.result(gson.toJson(returned));
				ctx.status(200);
			} else
				ctx.status(404);

		} catch (Exception e) {
			ctx.status(404);
			e.printStackTrace();
		}
	};
}

