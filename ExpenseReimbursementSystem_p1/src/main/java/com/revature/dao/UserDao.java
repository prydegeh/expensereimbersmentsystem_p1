package com.revature.dao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.revature.model.User;

public class UserDao {
	private List<User> users = new ArrayList<User>(Arrays.asList(new User(0, "Steve Rogers", "steve@gmail.com", null, null, null, null),
			new User(1, "Tony Stark", "tony@iron.com", null, null, null, null), new User(2, "Carol Danvers", "carol@xmas.com", null, null, null, null)));

	private static UserDao userDAO = null;

	private UserDao() {
	}

	public static UserDao instance() {
		if (userDAO == null) {
			userDAO = new UserDao();
		}
		return userDAO;
	}

	public Optional<User> getUserById(int id) {
		return users.stream().filter(u -> u.getId() == id).findAny();
	}

	public Iterable<String> getAllUsernames() {
		return users.stream().map(user -> user.getUsername()).collect(Collectors.toList());
	}

	public User addUser(User user) {
		users.add(user);
		return user;
	}
}
