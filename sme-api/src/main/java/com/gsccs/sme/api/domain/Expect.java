package com.gsccs.sme.api.domain;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 律师
 * @author x.d zhang
 * 
 */
public class Expect extends Domain {

	private static final long serialVersionUID = 3897573635852722321L;

	private Long id;
	private String title;
	private String logo;
	private String degree;
	private Long classid;
	private String technical;
	private Integer proflife;

	private String phone;
	private String telnum;
	private String email;
	private Integer age;
	private String sex;
	private String duties;
	private String state;
	/**
	 * 成功案例
	 */
	private String sucase;
	/**
	 * 荣誉奖励
	 */
	private String honor;
	/**
	 * 个人简历
	 */
	private String resume;
	private Integer clicknum;
	//经验值
	private Integer salenum;
	//职称
	private String lawlevel;

	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Long getClassid() {
		return classid;
	}

	public String getTechnical() {
		return technical;
	}

	public void setTechnical(String technical) {
		this.technical = technical;
	}

	public Integer getProflife() {
		return proflife;
	}

	public void setProflife(Integer proflife) {
		this.proflife = proflife;
	}

	public String getSucase() {
		return sucase;
	}

	public void setSucase(String sucase) {
		this.sucase = sucase;
	}

	public String getHonor() {
		return honor;
	}

	public void setHonor(String honor) {
		this.honor = honor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelnum() {
		return telnum;
	}

	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getSalenum() {
		return salenum;
	}

	public void setSalenum(Integer salenum) {
		this.salenum = salenum;
	}

	public Integer getClicknum() {
		return clicknum;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public String getLawlevel() {
		return lawlevel;
	}

	public void setLawlevel(String lawlevel) {
		this.lawlevel = lawlevel;
	}

	public String getUrl() {
		url = "/expert-" + id + ".html";
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
