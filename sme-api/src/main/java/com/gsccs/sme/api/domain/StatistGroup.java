package com.gsccs.sme.api.domain;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 分组统计公共对象
 * 
 * @author x.d zhang
 * 
 */
public class StatistGroup extends Domain {

	private String id;
	private String title;
	private Integer num;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
