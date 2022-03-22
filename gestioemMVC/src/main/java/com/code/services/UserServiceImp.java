package com.code.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.code.dao.RoleDao;
import com.code.dao.UserDao;
import com.code.entities.Role;
import com.code.entities.User;
import com.code.repository.AdminRepos;

@Service
@Transactional
public class UserServiceImp implements UserService{
	 @Autowired
	    private UserDao userDao;
	 @Autowired
	 private RoleDao roleDao;
	 @Autowired
	   private AdminRepos adminRepos;

	public User findId(int id) {
		User user=userDao.findById(id);
		return user;
	}

	public List<User> finAll() {
		List<User> users =userDao.findAll();
		return users;
	}

	public void save(User user, int rol_id) {
		 Role role = roleDao.getById(rol_id);  
		 user.setRol(role);
		 userDao.save(user);	
	}
	public void update(User user, int rol_id) {
		 Role role = roleDao.getById(rol_id);  
		 user.setRol(role);
		 userDao.update(user);	
	}


	public void delete(int id) {
		 userDao.delete(id); 
	}

	public boolean islogged(String email, String password) throws Exception {
		if(adminRepos.validate(email,password)) {
			return true;
		} else {
			return false;
		}
		

	}

}
