package com.gsccs.sme.plat.auth.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.dao.RoleMapper;
import com.gsccs.sme.plat.auth.model.Role;
import com.gsccs.sme.plat.auth.model.RoleExample;

/**
 * <p>User: x.d zhang
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
    private RoleMapper roleMapper;
    @Autowired
    private ResourceService resourceService;

    public Role createRole(Role role) {
    	roleMapper.insert(role);
        return roleMapper.selectByPrimaryKey(role.getId());
    }

    public Role updateRole(Role role) {
    	roleMapper.updateByPrimaryKey(role);
        return roleMapper.selectByPrimaryKey(role.getId());
    }

    public void deleteRole(Long roleId) {
    	roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public Role findByRoleid(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
    
    @Override
	public Role findByRolecode(String rolecode) {
    	return roleMapper.selectByCode(rolecode);
	}

    @Override
    public List<Role> findAll() {
    	RoleExample example = new RoleExample();
        return roleMapper.selectByExample(example);
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            Role role = findByRoleid(roleId);
            if(role != null) {
                roles.add(role.getRolecode());
            }
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for(Long roleId : roleIds) {
            Role role = findByRoleid(roleId);
            if(role != null) {
                resourceIds.addAll(role.getResourceIdList());
            }
        }
        return resourceService.findPermissions(resourceIds);
    }

	
}
