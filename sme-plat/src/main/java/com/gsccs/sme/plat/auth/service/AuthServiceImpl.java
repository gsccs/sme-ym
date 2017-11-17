package com.gsccs.sme.plat.auth.service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.dao.AuthorizationMapper;
import com.gsccs.sme.plat.auth.model.Authorization;
import com.gsccs.sme.plat.auth.model.AuthorizationExample;
import com.gsccs.sme.plat.auth.model.User;
import com.gsccs.sme.plat.auth.model.AuthorizationExample.Criteria;

/**
 * <p>
 * User: x.d zhang
 * <p>
 * Date: 14-1-28
 * <p>
 * Version: 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthorizationMapper authorizationMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private AppService appService;

	public Authorization createAuthorization(Authorization authorization) {
		return merge(authorization);
	}

	public Authorization updateAuthorization(Authorization authorization) {
		return merge(authorization);
	}

	public Authorization merge(Authorization authorization) {
		AuthorizationExample aExample = new AuthorizationExample();
		Criteria criteria = aExample.createCriteria();
		criteria.andAppIdEqualTo(authorization.getAppId());
		criteria.andUserIdEqualTo(authorization.getUserId());
		
		List<Authorization> authlist = authorizationMapper.selectByExample(
				aExample);
		System.out.println("authlist:"+authlist.size());
		if (authlist == null || authlist.size()<=0) {// 如果数据库中不存在相应记录 直接新增
			authorizationMapper.insert(authorization);
			return authorizationMapper
					.selectByPrimaryKey(authorization.getId());
		}

		Authorization dbAuthorization  = authlist.get(0);
		if (dbAuthorization.equals(authorization)) {// 如果是同一条记录直接更新即可
			System.out.println("是同一条记录直接更新");
			authorizationMapper.updateByPrimaryKey(dbAuthorization);
			return authorizationMapper
					.selectByPrimaryKey(authorization.getId());
		}

		for (Long roleId : authorization.getRoleIdList()) {// 否则合并
			System.out.println("合并");
			if (!dbAuthorization.getRoleIdList().contains(roleId)) {
				dbAuthorization.getRoleIdList().add(roleId);
			}
		}

		if (dbAuthorization.getRoleIds().isEmpty()) {// 如果没有角色 直接删除记录即可
			authorizationMapper.deleteByPrimaryKey(dbAuthorization.getId());
			return dbAuthorization;
		}
		// 否则更新
		System.out.println("否则更新");
		authorizationMapper.updateByPrimaryKey(dbAuthorization);
		return authorizationMapper.selectByPrimaryKey(authorization.getId());
	}

	public void deleteAuthorization(Long authorizationId) {
		authorizationMapper.deleteByPrimaryKey(authorizationId);
	}

	@Override
	public Authorization findOne(Long authorizationId) {
		return authorizationMapper.selectByPrimaryKey(authorizationId);
	}

	@Override
	public List<Authorization> findAll() {
		AuthorizationExample aExample = new AuthorizationExample();
		Criteria criteria = aExample.createCriteria();
		return authorizationMapper.selectByExample(aExample);
	}

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String appKey, String username) {
		User user = userService.findByAccount(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		Long appId = appService.findAppIdByAppKey(appKey);
		if (appId == null) {
			return Collections.EMPTY_SET;
		}

		AuthorizationExample aExample = new AuthorizationExample();
		Criteria criteria = aExample.createCriteria();
		criteria.andAppIdEqualTo(appId);
		criteria.andUserIdEqualTo(user.getId());
		
		List<Authorization> authlist = authorizationMapper.selectByExample(
				aExample);
		System.out.println("authlist:"+authlist.size());
		if (authlist==null || authlist.size()<=0) {
			return Collections.EMPTY_SET;
		}
		return roleService.findRoles(authlist.get(0).getRoleIdList().toArray(
				new Long[0]));
	}

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String appKey, String username) {
		User user = userService.findByAccount(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		
		Long appId = appService.findAppIdByAppKey(appKey);
		if (appId == null) {
			return Collections.EMPTY_SET;
		}

		AuthorizationExample aExample = new AuthorizationExample();
		Criteria criteria = aExample.createCriteria();
		criteria.andAppIdEqualTo(appId);
		criteria.andUserIdEqualTo(user.getId());

		List<Authorization> authlist = authorizationMapper
				.selectByExample(aExample);
		if (null == authlist || authlist.size() <= 0) {
			return Collections.EMPTY_SET;
		}

		if (authlist.get(0) == null) {
			return Collections.EMPTY_SET;
		}
		
		Set<String> perset = roleService.findPermissions(authlist.get(0).getRoleIdList()
				.toArray(new Long[0]));
		/*Iterator<String> its = perset.iterator();
		while(its.hasNext()){
			System.out.println(its.next());
		}*/
		return perset;
	}

}
