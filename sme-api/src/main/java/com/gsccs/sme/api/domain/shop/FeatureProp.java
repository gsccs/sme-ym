package com.gsccs.sme.api.domain.shop;

import java.util.List;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 产品属性。
 * 
 * @author x.d zhang
 * 
 */
public class FeatureProp extends Domain {

	private static final long serialVersionUID = 5482946573424751529L;

	/**
	 * 产品属性ID。
	 */
	private Long propId;

	/**
	 * 产品属性标题
	 */
	private String propTitle;

	/**
	 * 产品属性别名
	 */
	private String propAlias;

	/**
	 * 产品属性值
	 */
	private String propVal;

	
	/**
	 * 标识着props内容里面的pid、属性名称、属性值对应关系。格式为：pid1:pid1_name1:vid_value;pid2:
	 * pid_name:vid_value……
	 * 
	 * @return
	 */
	public String getPropStr() {
		
		return this.propId + ":" + this.propTitle + ":" + this.propAlias + ":"
				+ this.propVal;
	}

	public Long getPropId() {
		return propId;
	}

	public void setPropId(Long propId) {
		this.propId = propId;
	}

	public String getPropTitle() {
		return propTitle;
	}

	public void setPropTitle(String propTitle) {
		this.propTitle = propTitle;
	}

	public String getPropAlias() {
		return propAlias;
	}

	public void setPropAlias(String propAlias) {
		this.propAlias = propAlias;
	}

	public String getPropVal() {
		return propVal;
	}

	public void setPropVal(String propVal) {
		this.propVal = propVal;
	}

}
