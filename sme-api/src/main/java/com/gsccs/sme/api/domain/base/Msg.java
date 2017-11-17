package com.gsccs.sme.api.domain.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Msg extends Domain{

	private String id;
	private Long sender;
	private Long receiver;
	private Date addtime;
	private String title;
	private String content;
	private String isemail;
	private String isphone;
	private String status;
	
	private String addtimestr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSender() {
		return sender;
	}

	public void setSender(Long sender) {
		this.sender = sender;
	}

	public Long getReceiver() {
		return receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsemail() {
		return isemail;
	}

	public void setIsemail(String isemail) {
		this.isemail = isemail;
	}

	public String getIsphone() {
		return isphone;
	}

	public void setIsphone(String isphone) {
		this.isphone = isphone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddtimestr() {
		if (null != addtime){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			addtimestr = df.format(addtime);
		}
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}
	
	

}