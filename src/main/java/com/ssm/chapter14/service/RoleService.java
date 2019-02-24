package com.ssm.chapter14.service;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.pojo.RoleParams;

import java.util.List;

public interface RoleService {

    public Role getRole(Long id);

    List<Role> findRoles(RoleParams roleParams);

    int insertRoles(List<Role> roleList);

    int insertRole(Role role);

    int deleteRoles(List<Long> idList);

    int updateRole(Role role);

    int updateRoleArr(Role[] roles);
}
