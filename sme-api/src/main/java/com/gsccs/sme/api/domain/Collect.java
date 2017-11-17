package com.gsccs.sme.api.domain;

import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 用户收藏
 * 
 * @author x.d zhang
 * 
 */
public class Collect extends Domain {

	private String id;
	/**
	 * 目标对象ID,如果type=product是商品即商品ID，如果type=brand 即品牌ID
	 */
	private String targetid;
	private Long buyerid;
	private Date addtime;
	private Long siteid;

	/**
	 * 收藏类型
	 */
	private CollectType type;

	private String remark;
	private String account;
	private String picurl;

	public String getTargetid() {
		return targetid;
	}

	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}

	public CollectType getType() {
		return type;
	}

	public void setType(CollectType type) {
		this.type = type;
	}

	public Long getSiteid() {
		return siteid;
	}

	public void setSiteid(Long siteid) {
		this.siteid = siteid;
	}

	public Long getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Long buyerid) {
		this.buyerid = buyerid;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	/**
	 * 收藏类型
	 * 
	 * @author x.d zhang
	 * 
	 */
	public static enum CollectType {
		SITE("site"), PRODUCT("product"), BRAND("brand"), ACTIVITY("activiy"), INFO(
				"info");

		private final String type;

		private CollectType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}
}
