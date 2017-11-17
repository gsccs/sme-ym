package com.gsccs.sme.api.domain.base;


/**
 * 系统字典
 * 
 * @author x.d zhang
 * 
 */
public class Dict extends Domain {

	private static final long serialVersionUID = 3897573635852722321L;

	private String id;
	private String title;
	private String remark;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
