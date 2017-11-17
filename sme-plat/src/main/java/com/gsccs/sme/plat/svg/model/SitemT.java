package com.gsccs.sme.plat.svg.model;

import com.gsccs.sme.api.domain.Sitem;


/**
 * 服务项目
 * @author x.d zhang
 *
 */
public class SitemT extends Sitem {
	
	private String state;
	private String spayunit;
	private String scompany;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSpayunit() {
		return spayunit;
	}

	public void setSpayunit(String spayunit) {
		this.spayunit = spayunit;
	}

	public String getScompany() {
		return scompany;
	}

	public void setScompany(String scompany) {
		this.scompany = scompany;
	}
	
}