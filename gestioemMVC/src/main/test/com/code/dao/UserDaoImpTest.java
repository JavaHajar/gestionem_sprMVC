package com.code.dao;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.code.services.*;
import com.code.entities.*;




public class UserDaoImpTest {
	
	 @Autowired
	    static UserDao userDao;

	@Test
	public final void testFindAll() {
			Assert.assertEquals(2, userDao.findAll().size());

	}
	
	

//	@Test
//	public final void testFindById() {
//		User admin = new User();
//        admin = userDao.findById(2);
//        Assertions.assertEquals("ElKhatabi", admin.getNom_user());
//	}
//
//	@Test
//	public final void testSave() {
//		Role role = new Role("Admin");
//		User user = new User( "najmi", "rachid", "rachid@gmail.com", "aimadrachid");
//		user.setRole(role);
//		userDao.save(user);
//		
//		assertEquals("najmi", user.getNom_user());
//	}
//
//	@Test
//	public final void testUpdate() {
//		Role role = new Role("Admin");
//		User user = new User( 10, "kolo", "rachid", "rachid@gmail.com", "aimadrachid");
//		user.setRole(role);
//		userDao.update(user);	
//		assertEquals("kolo", user.getNom_user());
//		
//	}
//
//	@Test
//	public final void testDelete() {
//		userDao.delete(11);
//	    Assert.assertNull(userDao.findById(11));
//	}

	
	
}
