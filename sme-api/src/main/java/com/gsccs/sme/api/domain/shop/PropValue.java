package com.gsccs.sme.api.domain.shop;

import java.util.Date;
import java.util.List;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 属性值
 * 
 * @author x.d zhang
 * 
 */
public class PropValue extends Domain {
	
	private static final long serialVersionUID = 5442686669772618479L;

	/**
	 * 类目ID
	 */
	private Long cid;

	/**
	 * 是否为父类目属性
	 */
	private Boolean isParent;

	/**
	 * 修改时间（类目增量专用）
	 */
	private Date modifiedTime;

	/**
	 * 三种枚举类型：modify，add，delete (增量类目专用)
	 */
	private String modifiedType;

	/**
	 * 属性值
	 */
	private String name;

	/**
	 * 属性值别名
	 */
	private String nameAlias;

	/**
	 * 属性 ID
	 */
	private Long pid;

	/**
	 * 属性名
	 */
	private String propName;

	/**
	 * 排列序号。取值范围:大于零的整数
	 */
	private Long sortOrder;

	/**
	 * 状态。可选值:normal(正常),deleted(删除)
	 */
	private String status;

	/**
	 * 属性值ID
	 */
	private Long vid;

}
