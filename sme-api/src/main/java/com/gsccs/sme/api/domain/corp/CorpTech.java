package com.gsccs.sme.api.domain.corp;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 生产工艺
 * 
 * @author think
 * 
 */
public class CorpTech extends Domain {

	private Long id;
	private Long corpid;
	private String title;
	private String remark;
	private String corptitle;

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

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

}