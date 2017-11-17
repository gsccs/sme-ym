package com.gsccs.sme.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.plat.auth.model.User;
import com.gsccs.sme.plat.auth.service.UserService;
import com.gsccs.sme.plat.corp.service.CorpService;
import com.gsccs.sme.plat.svg.service.ExpertService;
import com.gsccs.sme.plat.svg.service.SvorgService;

/**
 * 用户接口
 * 
 * @author x.d zhang
 * 
 */
public class AccountServiceAPI implements AccountServiceI {

	@Autowired
	private UserService userService;
	@Autowired
	private CorpService corpService;
	@Autowired
	private SvorgService svorgService;
	@Autowired
	private ExpertService expertService;

	@Override
	public Account getAccount(Long id) throws ApiException {
		Account user = null;
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		User userT = userService.find(id);
		if (null != userT) {
			user = new Account();
			user.setId(userT.getId());
			user.setAccount(userT.getAccount());
			user.setUsertype(userT.getUsertype());
			user.setUserclass(userT.getUserclass());
		}
		return user;
	}

	@Override
	public void registAccount(Account user) throws ApiException {

		if (null == user || null == user.getAccount()) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		// 判断帐号是否存在
		User userT = userService
				.findByAccount(user.getAccount());
		if (null == userT) {
			userT = new User();
			userT.setAccount(user.getAccount());
			userT.setPassword(user.getPassword());
			userT.setUsertype(user.getUsertype());
			userT.setUserclass(user.getUserclass());
			userT.setOrgid(user.getOrgid());
			userT.setOrgname(user.getOrgname());
			userT.setTitle(user.getName());
			userT.setPhone(user.getPhone());
			userT.setEmail(user.getEmail());
			userService.addAccount(userT,user.getLocation());
		}
	}

	@Override
	public Account getAccount(String account) throws ApiException {
		if (null == account) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		User userT = userService
				.findByAccount(account);
		if (null != userT) {
			Account user = new Account();
			user.setName(userT.getTitle());
			user.setId(userT.getId());
			user.setAccount(userT.getAccount());
			user.setUsertype(userT.getUsertype());
			user.setUserclass(userT.getUserclass());
			user.setOrgid(userT.getOrgid());
			return user;
		}
		return null;
	}

	@Override
	public Account loginAccount(String account, String pwd) throws ApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> find(Long deptid, int page, int pagesize) {
		User param = new User();
		param.setOrgid(deptid);
		List<User> userlistT = userService.find(
				param, "", page, pagesize);
		if (null != userlistT && userlistT.size() > 0) {
			List<Account> userlist = new ArrayList<>();
			for (User userT : userlistT) {
				Account user = new Account();
				user.setId(userT.getId());
				user.setAccount(userT.getAccount());
				user.setUsertype(userT.getUsertype());
				user.setUserclass(userT.getUserclass());
				user.setOrgid(userT.getOrgid());
				user.setStatus("" + userT.getLocked());
				userlist.add(user);
			}
			return userlist;
		}
		return null;
	}

	@Override
	public void updateAccount(Account user) throws ApiException {
		if (null == user || user.getId()==null) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		userService.changePassword(user.getId(), user.getPassword());
	}

}
