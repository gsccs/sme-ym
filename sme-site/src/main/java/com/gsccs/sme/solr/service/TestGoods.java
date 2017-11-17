package com.gsccs.sme.solr.service;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 
 * @author x.d zhang
 * 
 */
public class TestGoods {

	@Field
	private String id;
	@Field
	private String siteid;
	@Field
	private String productid;
	@Field
	private String title;
	
	@Field
	private String cateid;
	@Field
	private String catestr;
	@Field
	private String brandid;
	@Field
	private String brandstr;
	
	/*@Field
	private String[] cat;
*/
	@Field
	private String[] attrid; // 产品属性ID
	@Field
	private String[] attrstr; // 产品属性组合
	@Field
	private String[] attrvalid; // 产品属性值ID
	@Field
	private String[] attrvalstr;// 产品属性值组合
	@Field
	private Float price;
	@Field
	private String picurl;

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

	public String getBrandid() {
		return brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}
	
	public String getBrandstr() {
		return brandstr;
	}

	public void setBrandstr(String brandstr) {
		this.brandstr = brandstr;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String[] getAttrid() {
		return attrid;
	}

	public void setAttrid(String[] attrid) {
		this.attrid = attrid;
	}

	public String[] getAttrstr() {
		return attrstr;
	}

	public void setAttrstr(String[] attrstr) {
		this.attrstr = attrstr;
	}

	public String[] getAttrvalid() {
		return attrvalid;
	}

	public void setAttrvalid(String[] attrvalid) {
		this.attrvalid = attrvalid;
	}

	public String[] getAttrvalstr() {
		return attrvalstr;
	}

	public void setAttrvalstr(String[] attrvalstr) {
		this.attrvalstr = attrvalstr;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getCatestr() {
		return catestr;
	}

	public void setCatestr(String catestr) {
		this.catestr = catestr;
	}

}
