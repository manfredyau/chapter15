package com.ssm.chapter14.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.pojo.RoleParams;

@Repository
public interface RoleDao {
	
	public int insertRole(Role role);
	
	public Role getRole(Long id);
	
	public List<Role> findRoles(RoleParams roleParams);
	
	public int deleteRole(Long id);
}
