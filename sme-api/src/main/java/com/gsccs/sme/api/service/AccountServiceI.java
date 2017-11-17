package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 用户API 提供了用户基本信息查询功能
 * 
 * @author x.d zhang
 */
public interface AccountServiceI {

	/**
	 * 根据ID查询用户信息
	 * 
	 * @param userId
	 *            用户ID
	 */
	public Account getAccount(Long id) throws ApiException;
	
	
	/**
	 * 更新帐号信息
	 * 
	 * @param userId
	 *            用户ID
	 */
	public void updateAccount(Account user) throws ApiException;
	
	
	/**
	 * 根据登录帐号查询用户
	 * 
	 * @param account
	 *            登录帐号
	 */
	public Account getAccount(String account) throws ApiException;

	/**
	 * 帐号注册
	 */
	public void registAccount(Account user) throws ApiException;

	/**
	 * 登录
	 */
	public Account loginAccount(String account, String pwd)
			throws ApiException;
	
	/**
	 * 查询账户列表
	 * @param deptid
	 * @return
	 */
	public List<Account> find(Long deptid,int page,int pagesize);

}
