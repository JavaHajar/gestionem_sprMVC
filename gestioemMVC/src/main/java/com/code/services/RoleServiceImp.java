package com.code.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.dao.RoleDao;
import com.code.entities.Role;


@Service
@Transactional
public class RoleServiceImp implements RoleService {
	@Autowired
    private RoleDao roleDao;

	@Override
	public List<Role> findAll() {
		List<Role> roles =roleDao.getAll();
		return roles;
	}
	

}
