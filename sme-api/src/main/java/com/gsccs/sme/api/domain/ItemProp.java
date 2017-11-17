package com.gsccs.sme.api.domain;

import java.util.Date;
import java.util.List;

import com.gsccs.sme.api.domain.base.Domain;
import com.gsccs.sme.api.domain.shop.PropValue;

/**
 * 商品属性
 * @author x.d zhang
 *
 */
public class ItemProp extends Domain {
	
	private static final long serialVersionUID = 3145493243855193151L;

	/**
	 * 子属性的模板（卖家自行输入属性时需要用到）
	 */
	private String childTemplate;

	/**
	 * 类目ID
	 */
	private Long cid;


	/**
	 * 是否允许别名。可选值：true（是），false（否）
	 */
	private Boolean isAllowAlias;

	/**
	 * 是否颜色属性。可选值:true(是),false(否)
	 */
	private Boolean isColorProp;

	/**
	 * 是否是可枚举属性。可选值:true(是),false(否)
	 */
	private Boolean isEnumProp;

	/**
	 * 在is_enum_prop是true的前提下，是否是卖家可以自行输入的属性（注：如果is_enum_prop返回false，该参数统一返回false）。可选值:true(是),false(否)。<b>对于品牌和型号属性（包括子属性）：如果用户是C卖家，则可自定义属性；如果是B卖家，则不可自定义属性，而必须要授权的属性。</b>
	 */
	private Boolean isInputProp;

	/**
	 * 是否商品属性。可选值:true(是),false(否)
	 */
	private Boolean isItemProp;

	/**
	 * 是否关键属性。可选值:true(是),false(否)
	 */
	private Boolean isKeyProp;

	/**
	 * 是否销售属性。可选值:true(是),false(否)
	 */
	private Boolean isSaleProp;

	/**
	 * 是否度量衡属性项
	 */
	private Boolean isTaosir;

	/**
	 * 属性修改时间（增量类目专用）
	 */
	private Date modifiedTime;

	/**
	 * 三种枚举类型：modify，add，delete（增量类目专用）
	 */
	private String modifiedType;

	/**
	 * 发布产品或商品时是否可以多选。可选值:true(是),false(否)
	 */
	private Boolean multi;

	/**
	 * 发布产品或商品时是否为必选属性。可选值:true(是),false(否)
	 */
	private Boolean must;

	/**
	 * 属性名
	 */
	private String name;

	/**
	 * 上级属性ID
	 */
	private Long parentPid;

	/**
	 * 上级属性值ID
	 */
	private Long parentVid;

	/**
	 * 属性 ID 例：品牌的PID=20000
	 */
	private Long pid;

	/**
	 * null
	 */
	private List<PropValue> propValues;

	/**
	 * 发布产品或商品时是否为必选属性(与must相同)。可选值:true(是),false(否)
	 */
	private Boolean required;

	/**
	 * 排列序号。取值范围:大于零的整排列序号。取值范围:大于零的整数
	 */
	private Long sortOrder;

	/**
	 * 状态。可选值:normal(正常),deleted(删除)
	 */
	private String status;

	/**
	 * 属性值类型。可选值：
multiCheck(枚举多选)
optional(枚举单选)
multiCheckText(枚举可输入多选)
optionalText(枚举可输入单选)
text(非枚举可输入)
	 */
	private String type;

}
