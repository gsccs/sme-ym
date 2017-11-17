package com.gsccs.sme.api.domain.shop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 商品评价
 * @author x.d zhang
 *
 */
public class EvalGoods extends Domain{
	
	
	private static final long serialVersionUID = 1824833393882688421L;
	
	private Long id;
	
	/**
	 * 产品ID
	 */
	private Long productid;
	
	/**
	 * 评分
	 */
	private Integer score;

	/**
	 * 评价者
	 */
	private Long userid;
	
	/**
	 * 店铺ID
	 */
	private Long siteid;
	
	/**
	 * 评价内容
	 */
	private String content;

	/**
	 * 评价时间
	 */
	private Date addtime;
	
	private String showdatestr;
	private String username;
	
	public String getShowdatestr() {
		if (null != getAddtime()){
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			showdatestr = df.format(getAddtime());
		}
		return showdatestr;
	}

	public void setShowdatestr(String showdatestr) {
		this.showdatestr = showdatestr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getSiteid() {
		return siteid;
	}

	public void setSiteid(Long siteid) {
		this.siteid = siteid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
