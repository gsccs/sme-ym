package com.gsccs.sme.api.domain;

import java.util.Date;
import java.util.List;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

/**
 * 园区对象
 * @author x.d zhang
 *
 */
public class Park extends Domain{

	private Long id;
	private String title;
	private String logo;
	private String remark;
	private Date addtime;
	private String status;
	private Long svgid;
	private String template;
	private String content;
	private String address;
	private String phone;
	private String domain;
	private Integer indexnum;
	private Integer corpnum;
	private String svgtitle;
	
	private List<Attach> attachs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getIndexnum() {
		return indexnum;
	}

	public void setIndexnum(Integer indexnum) {
		this.indexnum = indexnum;
	}

	public String getImg() {
		return logo;
	}

	public void setImg(String logo) {
		this.logo = logo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSvgid() {
		return svgid;
	}

	public void setSvgid(Long svgid) {
		this.svgid = svgid;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
	public Integer getCorpnum() {
		return corpnum;
	}

	public void setCorpnum(Integer corpnum) {
		this.corpnum = corpnum;
	}

	public String getSvgtitle() {
		return svgtitle;
	}

	public void setSvgtitle(String svgtitle) {
		this.svgtitle = svgtitle;
	}

	public List<Attach> getAttachs() {
		return attachs;
	}

	public void setAttachs(List<Attach> attachs) {
		this.attachs = attachs;
	}
	
	

}