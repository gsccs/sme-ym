package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.site.Channel;

/**
 * 类目API 提供了标准类目
 * 
 * @author x.d zhang
 * 
 */
public interface ChannelServiceI {

	/**
	 * 获取根类目
	 * 
	 * @return
	 */
	public List<Channel> getRootChannel();

	/**
	 * 获取站点根类目
	 * 
	 * @param cateid
	 *            父级分类ID
	 * @return
	 */
	public List<Channel> getSubChannel(Long cateid);

	/**
	 * 获取类目详情
	 * 
	 * @param cateId
	 * @return
	 */
	public Channel getChannel(Long cateid);

}
