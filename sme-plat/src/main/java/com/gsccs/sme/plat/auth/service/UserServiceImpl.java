package com.gsccs.sme.plat.auth.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.Location;
import com.gsccs.sme.plat.Constants;
import com.gsccs.sme.plat.auth.dao.RoleMapper;
import com.gsccs.sme.plat.auth.dao.UserMapper;
import com.gsccs.sme.plat.auth.model.Authorization;
import com.gsccs.sme.plat.auth.model.Role;
import com.gsccs.sme.plat.auth.model.User;
import com.gsccs.sme.plat.auth.model.UserExample;
import com.gsccs.sme.plat.auth.model.UserExample.Criteria;
import com.gsccs.sme.plat.svg.dao.CorpTMapper;
import com.gsccs.sme.plat.svg.dao.ExpertTMapper;
import com.gsccs.sme.plat.svg.dao.SvorgTMapper;
import com.gsccs.sme.plat.svg.model.CorpT;
import com.gsccs.sme.plat.svg.model.ExpertT;
import com.gsccs.sme.plat.svg.model.SvorgT;

/**
 * 
 * @author x.d zhang
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;
	@Autowired
	private CorpTMapper corpTMapper;
	@Autowired
	private SvorgTMapper svorgTMapper;
	@Autowired
	private ExpertTMapper expertTMapper;
	@Autowired
	private PasswordHelper passwordHelper;
	@Autowired
	private AuthService authService;

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user) {
		if (null != user) {
			// 加密密码
			// passwordHelper.encryptPassword(user);
			userMapper.insert(user);
			return userMapper.selectByPrimaryKey(user.getId());
		}
		return null;
	}

	public void addAccount(User user, Location location) {
		Long fid = null;
		if (null != user) {
			// 注册帐号
			userMapper.insert(user);
			// 分配角色
			Authorization authorization = new Authorization();
			authorization.setAppId(1l);
			authorization.setUserId(user.getId());
			Role role = null;
			// 注册企业
			if (null == user.getOrgid() && null != user.getUsertype()) {
				if (user.getUsertype().equals("C")) {
					CorpT corpT = new CorpT();
					corpT.setTitle(user.getOrgname());
					corpT.setLinker(user.getTitle());
					corpT.setLinktel(user.getPhone());
					corpT.setEmail(user.getEmail());
					if (null != location) {
						corpT.setPcode(location.getPcode());
						corpT.setCcode(location.getCcode());
						corpT.setAcode(location.getAcode());
					}
					corpTMapper.insert(corpT);
					fid = corpT.getId();
					role = roleMapper.selectByCode(Constants.ROLE_SV_C);
				}

				if (user.getUsertype().equals("S")) {
					SvorgT svorgT = new SvorgT();
					svorgT.setTitle(user.getOrgname());
					svorgT.setLinker(user.getTitle());
					svorgT.setLinktel(user.getPhone());
					svorgT.setEmail(user.getEmail());
					if (null != location) {
						svorgT.setPcode(location.getPcode());
						svorgT.setCcode(location.getCcode());
						svorgT.setAcode(location.getAcode());
					}
					svorgTMapper.insert(svorgT);
					fid = svorgT.getId();
					role = roleMapper.selectByCode(Constants.ROLE_SV_S);
				}

				if (user.getUsertype().equals("G")) {
					SvorgT svorgT = new SvorgT();
					svorgT.setTitle(user.getOrgname());
					svorgT.setLinker(user.getTitle());
					svorgT.setLinktel(user.getPhone());
					svorgT.setEmail(user.getEmail());
					if (null != location) {
						svorgT.setPcode(location.getPcode());
						svorgT.setCcode(location.getCcode());
						svorgT.setAcode(location.getAcode());
					}
					svorgTMapper.insert(svorgT);
					fid = svorgT.getId();
					role = roleMapper.selectByCode(Constants.ROLE_SV_G);
				}

				if (user.getUsertype().equals("E")) {
					ExpertT expertT = new ExpertT();
					expertTMapper.insert(expertT);
					fid = expertT.getId();
				}

				user.setOrgid(fid);
				userMapper.updateByPrimaryKey(user);
				if (null != role) {
					List<Long> roleids = new ArrayList<Long>();
					roleids.add(role.getId());
					authorization.setRoleIdList(roleids);
					authService.createAuthorization(authorization);
				}

			}
		}
	}

	@Override
	public User updateUser(User user) {
		userMapper.updateByPrimaryKey(user);
		return userMapper.selectByPrimaryKey(user.getId());
	}

	@Override
	public void deleteUser(Long userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword) {
		User user = userMapper.selectByPrimaryKey(userId);
		user.setPassword(newPassword);
		//passwordHelper.encryptPassword(user);
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User find(Long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByAccount(String account) {

		UserExample uExample = new UserExample();
		Criteria criteria = uExample.createCriteria();
		criteria.andAccountEqualTo(account);
		List<User> users = userMapper.selectByExample(uExample);
		if (null != users && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<User> find(User user, String order, int currPage, int pageSize) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(user, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return userMapper.selectPageByExample(example);
	}

	@Override
	public int count(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(user, criteria);
		return userMapper.countByExample(example);
	}

	public void proSearchParam(User user, UserExample.Criteria criteria) {
		if (null != user) {
			if (StringUtils.isNotEmpty(user.getTitle())) {
				criteria.andTitleLike("%" + user.getTitle() + "%");
			}

			if (StringUtils.isNotEmpty(user.getAccount())) {
				criteria.andAccountEqualTo(user.getAccount());
			}

			if (null != user.getOrgid()) {
				criteria.andOrganizationIdEqualTo(user.getOrgid());
			}
		}
	}

	@Override
	public List<User> findByOrgId(Long orgid) {
		UserExample uExample = new UserExample();
		Criteria criteria = uExample.createCriteria();
		criteria.andOrganizationIdEqualTo(orgid);
		return userMapper.selectByExample(uExample);
	}

}
