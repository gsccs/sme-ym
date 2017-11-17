package com.gsccs.sme.api.domain.corp;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 企业域对象
 * 
 * @author x.d zhang
 * 
 */
public class Corp extends Domain {

	private static final long serialVersionUID = 8567396925328831457L;

	private Long id;
	private String title;
	// 组织机构代码
	private String orgcode;
	// 工商注册编码
	private String regcode;
	// 企业注册类型
	private String regtype;
	//注册资金
	private Float regfund;
	
	private String phone;

	private String email;

	private String domain;
	// 单位性质
	private String nature;
	// 法人
	private String legaler;

	private String linker;
	private String linktel;

	private Integer pcode;
	private Integer ccode;
	private Integer acode;

	private String address;

	private String zipcode;

	private String qqcode;
	// 行业编码
	private Long hycode;
	private Long subhycode;
	// 控股情况
	private String stake;
	private String created;
	private String logo;

	private String content;
	private Long parkid;
	private String status;

	// 行业类型
	private String hytypestr;
	private String regtypestr;
	// 企业性质
	private String naturestr;
	private String stakestr;
	private String areastr;
	private String showtitle;
	private Integer titlelen;
	private String parktitle;

	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getRegcode() {
		return regcode;
	}

	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}

	public String getRegtype() {
		return regtype;
	}

	public void setRegtype(String regtype) {
		this.regtype = regtype;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getLegaler() {
		return legaler;
	}

	public void setLegaler(String legaler) {
		this.legaler = legaler;
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

	public Integer getPcode() {
		return pcode;
	}

	public void setPcode(Integer pcode) {
		this.pcode = pcode;
	}

	public Integer getCcode() {
		return ccode;
	}

	public void setCcode(Integer ccode) {
		this.ccode = ccode;
	}

	public Integer getAcode() {
		return acode;
	}

	public void setAcode(Integer acode) {
		this.acode = acode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getQqcode() {
		return qqcode;
	}

	public void setQqcode(String qqcode) {
		this.qqcode = qqcode;
	}

	public Long getHycode() {
		return hycode;
	}

	public void setHycode(Long hycode) {
		this.hycode = hycode;
	}

	public Long getSubhycode() {
		return subhycode;
	}

	public void setSubhycode(Long subhycode) {
		this.subhycode = subhycode;
	}

	public String getStake() {
		return stake;
	}

	public void setStake(String stake) {
		this.stake = stake;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getParkid() {
		return parkid;
	}

	public void setParkid(Long parkid) {
		this.parkid = parkid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Float getRegfund() {
		return regfund;
	}

	public void setRegfund(Float regfund) {
		this.regfund = regfund;
	}

	public String getHytypestr() {
		return hytypestr;
	}

	public void setHytypestr(String hytypestr) {
		this.hytypestr = hytypestr;
	}

	public String getRegtypestr() {
		return regtypestr;
	}

	public void setRegtypestr(String regtypestr) {
		this.regtypestr = regtypestr;
	}

	public String getNaturestr() {
		return naturestr;
	}

	public void setNaturestr(String naturestr) {
		this.naturestr = naturestr;
	}

	public String getStakestr() {
		return stakestr;
	}

	public void setStakestr(String stakestr) {
		this.stakestr = stakestr;
	}

	public String getAreastr() {
		return areastr;
	}

	public void setAreastr(String areastr) {
		this.areastr = areastr;
	}

	public Integer getTitlelen() {
		return titlelen;
	}

	public void setTitlelen(Integer titlelen) {
		this.titlelen = titlelen;
	}

	public String getShowtitle() {
		showtitle = title;
		if (null != titlelen && titlelen > 0) {
			if (null != title && title.length() > titlelen) {
				showtitle = title.substring(0, titlelen);
			}
		}
		return showtitle;
	}

	public void setShowtitle(String showtitle) {
		this.showtitle = showtitle;
	}

	public String getParktitle() {
		return parktitle;
	}

	public void setParktitle(String parktitle) {
		this.parktitle = parktitle;
	}

	public String getUrl() {
		url = "/corp-" + id + ".html";
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
