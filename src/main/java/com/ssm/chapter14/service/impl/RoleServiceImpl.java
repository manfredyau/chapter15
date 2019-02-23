package com.ssm.chapter14.service.impl;

import com.ssm.chapter14.dao.RoleDao;
import com.ssm.chapter14.pojo.RoleParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Override
    public List<Role> findRoles(RoleParams roleParams) {
        return roleDao.findRoles(roleParams);
    }

    @Override
    public int insertRoles(List<Role> roleList) {
        int count = 0;
        for (Role role : roleList) {
            count += roleDao.insertRole(role);
        }
        return count;
    }

    @Override
    public int insertRole(Role role) {
        return roleDao.insertRole(role);
    }


    @Override
    public int deleteRoles(List<Long> idList) {
        int count = 0;
        for (long id : idList) {
            count += roleDao.deleteRole(id);
        }
        return count;
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.update(role);
    }

    @Override
    public int updateRoleArr(List<Role> roleList) {
        int count = 0;
        for (int i = 0; i < roleList.size(); i++) {
            count += roleDao.update(roleList.get(i));
        }
        return count;
    }

}
