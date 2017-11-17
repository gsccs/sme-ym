package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.domain.site.Channel;
import com.gsccs.sme.api.service.ChannelServiceI;
import com.gsccs.sme.plat.site.model.ChanelT;
import com.gsccs.sme.plat.site.service.ChannelService;

/**
 * 信息栏目服务接口
 * 
 * @author x.d zhang
 * 
 */
public class ChannelServiceAPI implements ChannelServiceI {

	@Autowired
	private ChannelService channelService;

	@Override
	public Channel getChannel(Long cateid) {
		ChanelT sclassT = channelService.findById(cateid);
		if (null != sclassT) {
			Channel c = new Channel();
			try {
				BeanUtils.copyProperties(c, sclassT);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return c;
		}
		return null;
	}

	@Override
	public List<Channel> getRootChannel() {
		List<Channel> result = null;
		List<ChanelT> list = channelService.find(null);
		if (null != list && list.size() > 0) {
			result = new ArrayList<Channel>();
			Channel cate;
			for (ChanelT t : list) {
				cate = new Channel();
				try {
					BeanUtils.copyProperties(cate, t);
					result.add(cate);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<Channel> getSubChannel(Long channelid) {
		List<Channel> result = null;
		List<ChanelT> list = channelService.findSubChannel(channelid);
		if (null != list && list.size() > 0) {
			result = new ArrayList<Channel>();
			Channel cate;
			for (ChanelT t : list) {
				cate = new Channel();
				try {
					BeanUtils.copyProperties(cate, t);
					result.add(cate);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
