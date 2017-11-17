package com.gsccs.sme.api.domain.corp;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 企业固体废弃物
 * @author x.d zhang
 *
 */
public class CorpMsw extends Domain{

	private Long id;
	private Long corpid;
	private Integer year;
	private Integer month;

	private String type;
	private Float prodnum;
	private Float usernum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCorpid() {
		return corpid;
	}

	public void setCorpid(Long corpid) {
		this.corpid = corpid;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getProdnum() {
		return prodnum;
	}

	public void setProdnum(Float prodnum) {
		this.prodnum = prodnum;
	}

	public Float getUsernum() {
		return usernum;
	}

	public void setUsernum(Float usernum) {
		this.usernum = usernum;
	}

}