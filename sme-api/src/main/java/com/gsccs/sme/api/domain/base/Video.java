package com.gsccs.sme.api.domain.base;

import java.util.Date;

public class Video extends Domain {
	
	private static final long serialVersionUID = 4878121741748856161L;

	/**
	 * 视频关联记录创建时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	private Date created;

	/**
	 * 视频关联记录的id，和商品相对应
	 */
	private Long id;

	/**
	 * 视频记录关联的商品的数字id(注意：iid近期即将废弃，请用num_iid参数)
	 */
	private String iid;

	/**
	 * 视频关联记录修改时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	private Date modified;

	/**
	 * 视频记录所关联的商品的数字id
	 */
	private Long numIid;

	/**
	 * video的url连接地址。
	 */
	private String url;

	/**
	 * video的id
	 */
	private Long videoId;

}
