package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 服务评价
 * 
 * @author x.d zhang
 * 
 */
public class Sitemeval extends Domain {
	
	private String id;
	private Long sitemid;
	private Long svgid;
	private Long corpid;
	private String orderid;
	private Long userid;
	private Integer score;
	private String content;
	private Date addtime;
	private String status;

	private String adddatestr;
	private String corptitle;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSitemid() {
		return sitemid;
	}

	public void setSitemid(Long sitemid) {
		this.sitemid = sitemid;
	}

	public Long getSvgid() {
		return svgid;
	}

	public void setSvgid(Long svgid) {
		this.svgid = svgid;
	}

	public Long getCorpid() {
		return corpid;
	}

	public void setCorpid(Long corpid) {
		this.corpid = corpid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdddatestr() {
		if (null != addtime) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			adddatestr = format.format(addtime);
		}
		return adddatestr;
	}

	public void setAdddatestr(String adddatestr) {
		this.adddatestr = adddatestr;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

}