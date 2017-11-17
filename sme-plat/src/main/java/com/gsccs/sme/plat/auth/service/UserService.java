package com.gsccs.sme.plat.auth.service;

import java.util.List;

import com.gsccs.sme.api.domain.Location;
import com.gsccs.sme.plat.auth.model.User;

public interface UserService {

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user);

	public void addAccount(User user, Location location);

	public User updateUser(User user);

	public void deleteUser(Long userId);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword);

	User find(Long userId);
	
	List<User> findByOrgId(Long orgid);

	List<User> find(User user, String order, int currPage, int pageSize);

	public int count(User user);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByAccount(String username);

}
