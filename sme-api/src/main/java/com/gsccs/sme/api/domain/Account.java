package com.gsccs.sme.api.domain;

import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 用户帐号
 * 
 * @author x.d zhang
 * 
 */
public class Account extends Domain {

	private static final long serialVersionUID = 4183136143627688513L;

	/**
	 * 用户数字ID
	 */
	private Long id;
	// 用户头像
	private String avatar;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 用户注册时间。
	 */
	private Date created;

	/**
	 * 联系人email
	 */
	private String email;
	/**
	 * 联系人email
	 */
	private String phone;

	/**
	 * 最近登陆时间。
	 */
	private Date lastvisit;

	/**
	 * 用户昵称
	 */
	private String nick;
	/**
	 * 用户名称
	 */
	private String name;

	/**
	 * 有无实名认证。可选值:authentication(实名认证),not authentication(没有认证)
	 */
	private String promoted;

	/**
	 * 状态。可选值:normal(正常),inactive(未激活),delete(删除),reeze(冻结),supervise(监管)
	 */
	private String status;

	/**
	 * 用户类型。可选值:B(企业),C(服务机构)
	 */
	private String usertype;
	// 用户分类
	private String userclass;

	/**
	 * 机构部门
	 */
	private Long orgid;
	private String orgname;

	/**
	 * 是否锁定
	 */
	private Boolean locked;

	// 登录帐号名
	private String account;
	private String password;
	private String salt;

	private Location location;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastvisit() {
		return lastvisit;
	}

	public void setLastvisit(Date lastvisit) {
		this.lastvisit = lastvisit;
	}

	public String getPromoted() {
		return promoted;
	}

	public void setPromoted(String promoted) {
		this.promoted = promoted;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUserclass() {
		return userclass;
	}

	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
