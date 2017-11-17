package com.gsccs.sme.api.domain.site;

import java.io.Serializable;
import java.util.List;

import com.gsccs.sme.api.domain.base.Domain;

public class Banner extends Domain {

	private static final long serialVersionUID = 132158652580522323L;

	private String id;
	private String title;
	private String url;
	private String img;
	private String remark;
	private Integer indexnum;
	// 分类标识
	private String classtag;
	private String status;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIndexnum() {
		return indexnum;
	}

	public void setIndexnum(Integer indexnum) {
		this.indexnum = indexnum;
	}

	public String getClasstag() {
		return classtag;
	}

	public void setClasstag(String classtag) {
		this.classtag = classtag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
