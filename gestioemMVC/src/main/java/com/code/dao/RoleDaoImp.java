package com.code.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.entities.Role;
import com.code.entities.User;

@Repository
public class RoleDaoImp implements RoleDao {

	@Autowired
    private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAll() {
		List<Role> roles = null;
        Session session=sessionFactory.getCurrentSession();
        roles = session.createQuery("from Role").list();
        return roles;	
	}
	@Override
	public Role getById(int id) {
		Role role = null;
        Session session=sessionFactory.getCurrentSession();
        role = session.get(Role.class, id);
        return role;
	}
	

}
