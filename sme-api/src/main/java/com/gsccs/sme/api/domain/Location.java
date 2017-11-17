package com.gsccs.sme.api.domain;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 地址对象
 * 
 * @author x.d zhang
 * 
 */
public class Location extends Domain {

	private static final long serialVersionUID = 1179624343648523626L;

	/**
	 * 国家名称
	 */
	private String country;
	// 省级编码
	private Integer pcode;
	// 省级编码
	private Integer ccode;
	// 省级编码
	private Integer acode;

	/**
	 * 详细地址，最大256个字节（128个中文）
	 */
	private String address;

	/**
	 * 邮政编码
	 */
	private String zip;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPcode() {
		return pcode;
	}

	public void setPcode(Integer pcode) {
		this.pcode = pcode;
	}

	public Integer getCcode() {
		return ccode;
	}

	public void setCcode(Integer ccode) {
		this.ccode = ccode;
	}

	public Integer getAcode() {
		return acode;
	}

	public void setAcode(Integer acode) {
		this.acode = acode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
