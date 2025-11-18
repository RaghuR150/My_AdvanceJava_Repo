package com.kodekart.dao;

import com.kodekart.model.User;

public interface UserDao {
	boolean emailExists(String email);

	int save(User user);

	User findByEmail(String email);

	User findByEmailAndPassword(String email, String rawPassword);

	User findById(int id);

	void ensureAdminSeeded(String adminEmail, String adminPlainPassword);
}
