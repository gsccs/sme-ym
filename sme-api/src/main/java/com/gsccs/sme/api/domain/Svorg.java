package com.gsccs.sme.api.domain;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 服务机构
 * 
 * @author x.d zhang
 * 
 */
public class Svorg extends Domain {

	private static final long serialVersionUID = 8567396925328831457L;

	private Long id;
	private String title;
	private String phone;
	private String email;
	private String domain;
	private String nature;
	private String legaler;
	private String linker;
	private String linktel;
	private String sremark;
	private Long scode;
	private Long subscode;
	private String orgcode;
	private String regcode;
	private String regtype;
	private Long hycode;
	private String stake;
	private Float regasset;
	private Integer pcode;
	private Integer ccode;
	private Integer acode;
	private String address;
	private String profqualif;
	private String equcond;
	private String personnel;
	private String orgcodeimg;
	private String regcodeimg;
	private String logo;
	private String status;
	private String content;
	// 机构类型 "S"/"G"
	private String svgtype;
	// 地址
	private String areastr;
	// 单位性质
	private String naturestr;
	// 注册类型
	private String regtypestr;
	// 控股类型
	private String stakestr;
	// 服务分类
	private String sclassstr;
	// 二级分类
	private String subsclassstr;
	// 行业
	private String industrystr;

	private String url;
	
	//标题长度
	private Integer titlelen;
	private String showtitle;

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

	public String getSremark() {
		return sremark;
	}

	public void setSremark(String sremark) {
		this.sremark = sremark;
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

	public Long getHycode() {
		return hycode;
	}

	public void setHycode(Long hycode) {
		this.hycode = hycode;
	}

	public String getStake() {
		return stake;
	}

	public void setStake(String stake) {
		this.stake = stake;
	}

	public Float getRegasset() {
		return regasset;
	}

	public void setRegasset(Float regasset) {
		this.regasset = regasset;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfqualif() {
		return profqualif;
	}

	public void setProfqualif(String profqualif) {
		this.profqualif = profqualif;
	}

	public String getEqucond() {
		return equcond;
	}

	public void setEqucond(String equcond) {
		this.equcond = equcond;
	}

	public String getPersonnel() {
		return personnel;
	}

	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	public String getOrgcodeimg() {
		return orgcodeimg;
	}

	public void setOrgcodeimg(String orgcodeimg) {
		this.orgcodeimg = orgcodeimg;
	}

	public String getRegcodeimg() {
		return regcodeimg;
	}

	public void setRegcodeimg(String regcodeimg) {
		this.regcodeimg = regcodeimg;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public String getAreastr() {
		return areastr;
	}

	public void setAreastr(String areastr) {
		this.areastr = areastr;
	}

	public String getNaturestr() {
		return naturestr;
	}

	public void setNaturestr(String naturestr) {
		this.naturestr = naturestr;
	}

	public String getRegtypestr() {
		return regtypestr;
	}

	public void setRegtypestr(String regtypestr) {
		this.regtypestr = regtypestr;
	}

	public Long getScode() {
		return scode;
	}

	public void setScode(Long scode) {
		this.scode = scode;
	}

	public Long getSubscode() {
		return subscode;
	}

	public void setSubscode(Long subscode) {
		this.subscode = subscode;
	}

	public String getSvgtype() {
		return svgtype;
	}

	public void setSvgtype(String svgtype) {
		this.svgtype = svgtype;
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

	public String getStakestr() {
		return stakestr;
	}

	public void setStakestr(String stakestr) {
		this.stakestr = stakestr;
	}

	public String getSclassstr() {

		return sclassstr;
	}

	public void setSclassstr(String sclassstr) {
		this.sclassstr = sclassstr;
	}

	public String getSubsclassstr() {
		return subsclassstr;
	}

	public void setSubsclassstr(String subsclassstr) {
		this.subsclassstr = subsclassstr;
	}

	public String getIndustrystr() {
		return industrystr;
	}

	public void setIndustrystr(String industrystr) {
		this.industrystr = industrystr;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		url = "/svorg-" + id + ".html";
		return url;
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

}
