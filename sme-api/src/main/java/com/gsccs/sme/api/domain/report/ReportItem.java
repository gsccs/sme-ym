package com.gsccs.sme.api.domain.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

public class ReportItem extends Domain{
	
	private String id;
	private Long reportid;
	private Date submitdate;
	private Date addtime;
	private Long corpid;
	private Long userid;
	private String isattach;
	private String remark;
	private String status;

	private List<Attach> attachs;
	
	private String corptitle;
	private String reporttitle;
	private String submitdatestr;
	private String addtimestr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getReportid() {
		return reportid;
	}

	public void setReportid(Long reportid) {
		this.reportid = reportid;
	}

	public Date getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(Date submitdate) {
		this.submitdate = submitdate;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getCorpid() {
		return corpid;
	}

	public void setCorpid(Long corpid) {
		this.corpid = corpid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getIsattach() {
		return isattach;
	}

	public void setIsattach(String isattach) {
		this.isattach = isattach;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Attach> getAttachs() {
		return attachs;
	}

	public void setAttachs(List<Attach> attachs) {
		this.attachs = attachs;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getReporttitle() {
		return reporttitle;
	}

	public void setReporttitle(String reporttitle) {
		this.reporttitle = reporttitle;
	}

	public String getSubmitdatestr() {
		if (null != submitdate) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.format(submitdate);
		}
		return submitdatestr;
	}

	public void setSubmitdatestr(String submitdatestr) {
		this.submitdatestr = submitdatestr;
	}

	public String getAddtimestr() {
		if (null != addtime) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.format(addtime);
		}
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}

}