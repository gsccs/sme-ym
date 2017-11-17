package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.binary.StringUtils;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 服务订单域对象
 * 
 * @author x.d zhang
 * 
 */
public class Sorder extends Domain {

	private String id;
	private Long sitemid;
	private Long svgid;
	private Long corpid;
	private String paytype;
	private String phone;
	private String ordertype;
	private Double totalfee;
	private Double payfee;
	private Integer totalnum;
	private String platsource;
	private Date addtime;
	private Date lasttime;
	private String status;
	//评分
	private Integer score;
	//评分
	private String evalcontent;

	private String itemtitle;
	private String svgtitle;
	private String corptitle;
	private String adddatestr;
	private String showtitle;
	private Integer titlelen;
	private String dateformat;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
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

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Double getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}

	public Double getPayfee() {
		return payfee;
	}

	public void setPayfee(Double payfee) {
		this.payfee = payfee;
	}

	public Integer getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public String getPlatsource() {
		return platsource;
	}

	public void setPlatsource(String platsource) {
		this.platsource = platsource;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItemtitle() {
		return itemtitle;
	}

	public void setItemtitle(String itemtitle) {
		this.itemtitle = itemtitle;
	}

	public String getSvgtitle() {
		return svgtitle;
	}

	public void setSvgtitle(String svgtitle) {
		this.svgtitle = svgtitle;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getAdddatestr() {
		if (dateformat == null || dateformat.trim().length() == 0) {
			dateformat = "yyyy-MM-dd";
		}
		if (addtime != null) {
			adddatestr = new SimpleDateFormat(dateformat).format(addtime);
		}
		return adddatestr;
	}

	public void setAdddatestr(String adddatestr) {
		this.adddatestr = adddatestr;
	}

	public Integer getTitlelen() {
		return titlelen;
	}

	public void setTitlelen(Integer titlelen) {
		this.titlelen = titlelen;
	}

	public String getShowtitle() {
		if (null == getTitlelen()) {
			showtitle = itemtitle;
		} else if (null != getItemtitle()) {
			if (itemtitle.length() > titlelen) {
				showtitle = itemtitle.substring(0, titlelen);
			}
		}
		return showtitle;
	}

	public void setShowtitle(String showtitle) {
		this.showtitle = showtitle;
	}

	public String getDateformat() {
		return dateformat;
	}

	public void setDateformat(String dateformat) {
		this.dateformat = dateformat;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getEvalcontent() {
		return evalcontent;
	}

	public void setEvalcontent(String evalcontent) {
		this.evalcontent = evalcontent;
	}

	
}