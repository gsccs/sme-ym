package com.gsccs.sme.api.domain.shop;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 专家
 * @author x.d zhang
 *
 */
public class Brand extends Domain {
	
	private static final long serialVersionUID = 3897573635852722321L;

	private Long id;
	private String name;
	private Integer ordernum;
	private String description;
	private String parid;
	private String state;
	private Integer clicknum;
	private String templet;
	
	
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
	public Integer getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParid() {
		return parid;
	}
	public void setParid(String parid) {
		this.parid = parid;
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
	public String getTemplet() {
		return templet;
	}
	public void setTemplet(String templet) {
		this.templet = templet;
	}
	
	
	

}
