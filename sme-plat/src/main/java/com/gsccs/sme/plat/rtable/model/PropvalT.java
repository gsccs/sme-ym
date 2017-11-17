package com.gsccs.sme.plat.rtable.model;

import java.util.Date;

/**
 * 企业报送数据值
 * @author x.d zhang
 *
 */
public class PropvalT {
	
	//
	private String id;
	//指标ID
	private String propid;
	//企业ID
	private String corpid;
	//报表ID
	private String reportid;
	//报送记录ID
	private String itemid;
	//指标值
	private String propval;
	//
	private Date addtime;
	//备注信息
	private String remark;

	//关联字段
	private String propcode;
	private String proptitle;
	private String showtype;
	private String dictcode;
	private String dictval;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getPropid() {
		return propid;
	}

	public void setPropid(String propid) {
		this.propid = propid == null ? null : propid.trim();
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid == null ? null : corpid.trim();
	}

	
	public String getPropval() {
		return propval;
	}

	public void setPropval(String propval) {
		this.propval = propval;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPropcode() {
		return propcode;
	}

	public void setPropcode(String propcode) {
		this.propcode = propcode;
	}

	public String getProptitle() {
		return proptitle;
	}

	public void setProptitle(String proptitle) {
		this.proptitle = proptitle;
	}

	public String getReportid() {
		return reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}

	public String getShowtype() {
		return showtype;
	}

	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}

	public String getDictcode() {
		return dictcode;
	}

	public void setDictcode(String dictcode) {
		this.dictcode = dictcode;
	}

	public String getDictval() {
		return dictval;
	}

	public void setDictval(String dictval) {
		this.dictval = dictval;
	}
	
}