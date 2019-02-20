package com.ssm.chapter14.mapper;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.pojo.RoleParams;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int insertRole(Role role);

    int deleteRole(Long id);

    Role getRole(@Param("id") Long id);

    int updateRole(Role role);

    List<Role> findRoles(RoleParams roleParams);
}
