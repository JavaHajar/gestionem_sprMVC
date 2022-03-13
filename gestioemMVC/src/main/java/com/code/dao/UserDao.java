package com.code.dao;

import java.util.List;

import com.code.entities.User;

public interface UserDao {
	List<User> findAll();
    User findById(int id);
    void save(User user);
    void update (User user);
    void delete(int id);

}
