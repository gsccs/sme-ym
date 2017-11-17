package com.gsccs.sme.api.domain;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 服务分类，多级结构
 * 
 * @author x.d zhang
 * 
 */
public class Industry extends Domain {

	private static final long serialVersionUID = 7445495934523484654L;

	private Long id;
	private Long parid;
	private String title;
	private String code;
	private String state;
	private Integer clicknum;
	private String pagemark;
	private Integer indexnum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParid() {
		return parid;
	}

	public void setParid(Long parid) {
		this.parid = parid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getClicknum() {
		return clicknum;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	public String getPagemark() {
		return pagemark;
	}

	public void setPagemark(String pagemark) {
		this.pagemark = pagemark;
	}

	public Integer getIndexnum() {
		return indexnum;
	}

	public void setIndexnum(Integer indexnum) {
		this.indexnum = indexnum;
	}

}
