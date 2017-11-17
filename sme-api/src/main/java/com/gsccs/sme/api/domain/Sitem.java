package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 服务项目
 * 
 * @author x.d zhang
 * 
 */
public class Sitem extends Domain {

	private static final long serialVersionUID = 7214112869815458438L;

	private Long id;
	private Long svgid;
	private Long scode;
	private Long subscode;
	private String title;
	private String img;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date addtime;

	private String addtimeStr;

	private Integer clicknum;
	private String tags;
	private String remark;

	private Double price;
	private Integer salenum;
	private Integer evalnum;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lasttime;

	private Long typeid;

	private String status;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endtime;

	private String endtimeStr;

	private String linker;

	private String phone;

	private String email;
	// 服务区域 多选
	private String areacodes;
	// 服务对象 多选
	private String sproject;
	// 服务方式 多选
	private String spattern;
	// 收费模式 .单选
	private String spay;
	// 其他收费标准 input
	private String otherpay;

	private String qq;
	private String content;

	private Integer titlelen;
	private String showtitle;
	private Integer remarklen;
	private String showremark;
	// 服务发布时间
	private String addtimestr;
	// 服务分类
	private String sclassstr;
	// 二级服务分类
	private String subsclassstr;

	// 服务机构名称
	private String svglogo;
	private String svgtitle;
	// 收费标准（price+收费模式+其他收费模式）
	private String spaystr;

	// 服务区域
	private List<String> arealist;
	// 服务对象
	private List<String> sprolist;
	// 服务方式
	private List<String> spanlist;

	private String url;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getClicknum() {
		return clicknum;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags == null ? null : tags.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSalenum() {
		return salenum;
	}

	public void setSalenum(Integer salenum) {
		this.salenum = salenum;
	}

	public Integer getEvalnum() {
		return evalnum;
	}

	public void setEvalnum(Integer evalnum) {
		this.evalnum = evalnum;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getLinker() {
		return linker;
	}

	public void setLinker(String linker) {
		this.linker = linker;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getAreacodes() {
		return areacodes;
	}

	public void setAreacodes(String areacodes) {
		this.areacodes = areacodes;
	}

	public String getSproject() {
		return sproject;
	}

	public void setSproject(String sproject) {
		this.sproject = sproject == null ? null : sproject.trim();
	}

	public String getSpattern() {
		return spattern;
	}

	public void setSpattern(String spattern) {
		this.spattern = spattern == null ? null : spattern.trim();
	}

	public String getSpay() {
		return spay;
	}

	public void setSpay(String spay) {
		this.spay = spay == null ? null : spay.trim();
	}

	public String getOtherpay() {
		return otherpay;
	}

	public void setOtherpay(String otherpay) {
		this.otherpay = otherpay == null ? null : otherpay.trim();
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

	public List<String> getArealist() {
		return arealist;
	}

	public void setArealist(List<String> arealist) {
		this.arealist = arealist;
	}

	public List<String> getSprolist() {
		return sprolist;
	}

	public void setSprolist(List<String> sprolist) {
		this.sprolist = sprolist;
	}

	public List<String> getSpanlist() {
		return spanlist;
	}

	public void setSpanlist(List<String> spanlist) {
		this.spanlist = spanlist;
	}

	public String getSvgtitle() {
		return svgtitle;
	}

	public void setSvgtitle(String svgtitle) {
		this.svgtitle = svgtitle;
	}

	public String getSvglogo() {
		return svglogo;
	}

	public void setSvglogo(String svglogo) {
		this.svglogo = svglogo;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq == null ? null : qq.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
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

	public Integer getTitlelen() {
		return titlelen;
	}

	public void setTitlelen(Integer titlelen) {
		this.titlelen = titlelen;
	}

	public String getAddtimeStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (null != addtime) {
			return format.format(addtime);
		}
		return addtimeStr;
	}

	public void setAddtimeStr(String addtimeStr) {
		this.addtimeStr = addtimeStr;
	}

	public String getEndtimeStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (null != endtime) {
			return format.format(endtime);
		}
		return endtimeStr;
	}

	public void setEndtimeStr(String endtimeStr) {
		this.endtimeStr = endtimeStr;
	}

	public String getSpaystr() {
		return spaystr;
	}

	public void setSpaystr(String spaystr) {
		this.spaystr = spaystr;
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

	
	public Integer getRemarklen() {
		return remarklen;
	}

	public void setRemarklen(Integer remarklen) {
		this.remarklen = remarklen;
	}

	public String getShowremark() {
		showremark = title;
		if (null != titlelen && remarklen > 0) {
			if (null != remark && remark.length() > remarklen) {
				showremark = remark.substring(0, remarklen);
			}
		}
		return showremark;
	}

	public void setShowremark(String showremark) {
		this.showremark = showremark;
	}

	public String getUrl() {
		return "/sitem-" + id + ".html";
	}

}
