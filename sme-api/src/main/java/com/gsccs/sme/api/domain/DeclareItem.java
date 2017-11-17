package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

/**
 * 项目申报记录
 * 
 * @author x.d zhang
 * 
 */
public class DeclareItem extends Domain {

	private Long id;
	private Long topicid;
	private Long corpid;

	private String title;
	private String leader;
	private String linktel;
	private Float invest;
	private Float owncapital;
	private Float bankcapital;
	private Float othercapital;
	private Float saleincome;
	private Float saleprofits;
	private Float taxes;
	private Integer employee;

	private Date addtime;
	private Date endtime;
	private String content; // 申请内容
	private String status;

	private String reply;// 回复内容
	private String topictitle;
	private String corptitle;
	private String svgtitle;
	private String addtimestr;
	private String endtimestr;

	private List<Attach> attachs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTopicid() {
		return topicid;
	}

	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}

	public Long getCorpid() {
		return corpid;
	}

	public void setCorpid(Long corpid) {
		this.corpid = corpid;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTopictitle() {
		return topictitle;
	}

	public void setTopictitle(String topictitle) {
		this.topictitle = topictitle;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getAddtimestr() {
		if (null != addtime) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			addtimestr = df.format(addtime);
		}
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}

	public String getEndtimestr() {
		if (null != endtime) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			endtimestr = df.format(endtime);
		}
		return endtimestr;
	}

	public void setEndtimestr(String endtimestr) {
		this.endtimestr = endtimestr;
	}

	public List<Attach> getAttachs() {
		return attachs;
	}

	public void setAttachs(List<Attach> attachs) {
		this.attachs = attachs;
	}

	public String getSvgtitle() {
		return svgtitle;
	}

	public void setSvgtitle(String svgtitle) {
		this.svgtitle = svgtitle;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public Float getInvest() {
		return invest;
	}

	public void setInvest(Float invest) {
		this.invest = invest;
	}

	public Float getOwncapital() {
		return owncapital;
	}

	public void setOwncapital(Float owncapital) {
		this.owncapital = owncapital;
	}

	public Float getBankcapital() {
		return bankcapital;
	}

	public void setBankcapital(Float bankcapital) {
		this.bankcapital = bankcapital;
	}

	public Float getOthercapital() {
		return othercapital;
	}

	public void setOthercapital(Float othercapital) {
		this.othercapital = othercapital;
	}

	public Float getSaleincome() {
		return saleincome;
	}

	public void setSaleincome(Float saleincome) {
		this.saleincome = saleincome;
	}

	public Float getSaleprofits() {
		return saleprofits;
	}

	public void setSaleprofits(Float saleprofits) {
		this.saleprofits = saleprofits;
	}

	public Float getTaxes() {
		return taxes;
	}

	public void setTaxes(Float taxes) {
		this.taxes = taxes;
	}

	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}

}