package com.code.dao;

import java.util.List;
import com.code.entities.Role;
import com.code.entities.User;

public interface RoleDao {
	
	public List<Role> getAll();
	Role getById(int id);

}
