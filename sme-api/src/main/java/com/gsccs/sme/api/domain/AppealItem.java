package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

/**
 * 行政诉求申请记录
 * 
 * @author think
 * 
 */
public class AppealItem extends Domain {

	private Long id;
	private Long topicid;
	private Long svgid;
	private Long corpid;
	private Long userid;
	private Date addtime; // 发起时间
	private Date endtime; // 结束时间
	private Integer score;	//评分
	private String evalstr; //评价内容

	private String content;

	/**
	 * 0 已提交 1 已办理 2 正在办理 3 已确认
	 * 
	 */
	private String status; // 状态
	/**
	 * 1已受理 0 驳回
	 */
	private String result; // 结果
	private String resultstr; // 结果
	//督办次数
	private Integer pushnum;

	//
	private String addtimestr;
	private String endtimestr;
	private String corptitle;
	private String svgtitle;
	private String topictitle;
	private Integer daynum;
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

	public String getEndtimestr() {
		if (null != endtime) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultstr() {
		return resultstr;
	}

	public void setResultstr(String resultstr) {
		this.resultstr = resultstr;
	}

	public Integer getDaynum() {
		return daynum;
	}

	public void setDaynum(Integer daynum) {
		this.daynum = daynum;
	}

	public String getSvgtitle() {
		return svgtitle;
	}

	public void setSvgtitle(String svgtitle) {
		this.svgtitle = svgtitle;
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

	public String getEvalstr() {
		return evalstr;
	}

	public void setEvalstr(String evalstr) {
		this.evalstr = evalstr;
	}

	public Integer getPushnum() {
		return pushnum;
	}

	public void setPushnum(Integer pushnum) {
		this.pushnum = pushnum;
	}
	
	
}