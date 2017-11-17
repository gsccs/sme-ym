package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 融资需求回复
 * @author x.d zhang
 *
 */
public class CapitalReply extends Domain{

	private Long id;
	private Long applid;
	private Long svgid;
	private Date addtime;
	private String linker;
	private String linktel;
	private String status;
	private String content;
	private String isstoned;

	private Long corpid;
	private String corptitle;
	private String svgtitle;
	private String addtimestr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplid() {
		return applid;
	}

	public void setApplid(Long applid) {
		this.applid = applid;
	}

	public Long getSvgid() {
		return svgid;
	}

	public void setSvgid(Long svgid) {
		this.svgid = svgid;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getLinker() {
		return linker;
	}

	public void setLinker(String linker) {
		this.linker = linker;
	}

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsstoned() {
		return isstoned;
	}

	public void setIsstoned(String isstoned) {
		this.isstoned = isstoned;
	}

	public Long getCorpid() {
		return corpid;
	}

	public void setCorpid(Long corpid) {
		this.corpid = corpid;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getSvgtitle() {
		return svgtitle;
	}

	public void setSvgtitle(String svgtitle) {
		this.svgtitle = svgtitle;
	}

	public String getAddtimestr() {
		if (null != getAddtime()){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			addtimestr = df.format(getAddtime());
		}
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}
	
	

}