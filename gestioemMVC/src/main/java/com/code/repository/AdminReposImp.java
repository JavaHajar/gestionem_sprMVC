 package com.code.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.entities.Role;
import com.code.entities.User;
import com.code.repository.*;

@Repository
public class AdminReposImp implements AdminRepos {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean validate(String email, String password) throws Exception {

		User user = null;
		Session session = sessionFactory.openSession();
		user = (User) session.createQuery("FROM User U WHERE U.email = :email").setParameter("email", email)
				.uniqueResult();
		if (user != null && user.getPassword().equals(password)&& user.getRol().getId_role()== 1) {
			return true;
		} else {
			return false;
		}

	}

}
