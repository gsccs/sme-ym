package com.gsccs.sme.api.domain.shop;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 订单评价
 * 
 * @author x.d zhang
 * 
 */
public class EvalOrder extends Domain {

	private static final long serialVersionUID = 4145351793736355994L;

	private Long id;
	private Long itemId;
	private Long productid;
	private Long userid;
	private Integer score;
	private String account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
