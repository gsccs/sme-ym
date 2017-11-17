package com.gsccs.sme.plat.auth.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信
 * @author x.d zhang
 *
 */
public class Sms implements Serializable {

	private Long id;
	private String phone;
	private String content;
	private String userid;
	private Date addtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

}
