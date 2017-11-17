package com.gsccs.sme.plat.auth.model;

import java.io.Serializable;

public class Config implements Serializable {

	private String code;

	private String name;

	private String configvalue;

	private Integer ordernum;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	
	public String getConfigvalue() {
		return configvalue;
	}

	
	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue == null ? null : configvalue.trim();
	}

	
	public Integer getOrdernum() {
		return ordernum;
	}

	
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
}