package com.code.services;

import java.util.List;

import com.code.entities.User;

public interface UserService {
	List<User> finAll();
	 User findId(int id);
	 void save(User user, int rol_id);
	 void update (User user, int rol_id);
	 void delete(int id);
	 boolean islogged(String email, String password) throws Exception;
}
