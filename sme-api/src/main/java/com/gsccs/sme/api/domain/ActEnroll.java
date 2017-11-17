package com.gsccs.sme.api.domain;

import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 活动报名
 * 
 * @author x.d zhang
 * 
 */
public class ActEnroll extends Domain {

	private static final long serialVersionUID = 4468427473728698992L;

	private Long id;
	private Long actid;
	private Long corpid;
	private Long svgid;
	private Long expid;
	private Long userid;
	private Integer usernum;
	private Date addtime;
	private Date comtime;
	private String remark;
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActid() {
		return actid;
	}

	public void setActid(Long actid) {
		this.actid = actid;
	}

	public Long getCorpid() {
		return corpid;
	}

	public void setCorpid(Long corpid) {
		this.corpid = corpid;
	}

	public Long getSvgid() {
		return svgid;
	}

	public void setSvgid(Long svgid) {
		this.svgid = svgid;
	}

	public Long getExpid() {
		return expid;
	}

	public void setExpid(Long expid) {
		this.expid = expid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Integer getUsernum() {
		return usernum;
	}

	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getComtime() {
		return comtime;
	}

	public void setComtime(Date comtime) {
		this.comtime = comtime;
	}

}
