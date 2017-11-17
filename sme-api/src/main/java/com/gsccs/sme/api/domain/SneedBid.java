package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 
 * @author think
 * 
 */
public class SneedBid extends Domain {

	private Long id;
	private Long svgid;
	private String linktel;
	private String linker;
	private String remark;
	private Integer evalnum;
	private Date addtime;
	private Date lasttime;
	private String istoned;
	private String status;
	private Long sneedid;
	//
	private String svgtitle;
	private String corptitle;
	private String sneedtitle;
	private String addtimestr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSvgid() {
		return svgid;
	}

	public void setSvgid(Long svgid) {
		this.svgid = svgid;
	}

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public String getLinker() {
		return linker;
	}

	public void setLinker(String linker) {
		this.linker = linker;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getEvalnum() {
		return evalnum;
	}

	public void setEvalnum(Integer evalnum) {
		this.evalnum = evalnum;
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

	public String getIstoned() {
		return istoned;
	}

	public void setIstoned(String istoned) {
		this.istoned = istoned;
	}

	public Long getSneedid() {
		return sneedid;
	}

	public void setSneedid(Long sneedid) {
		this.sneedid = sneedid;
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

	public String getSneedtitle() {
		return sneedtitle;
	}

	public void setSneedtitle(String sneedtitle) {
		this.sneedtitle = sneedtitle;
	}

	public String getAddtimestr() {
		if (null != addtime) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			addtimestr = df.format(addtime);
		}
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}