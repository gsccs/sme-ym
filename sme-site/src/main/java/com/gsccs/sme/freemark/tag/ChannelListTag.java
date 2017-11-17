package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.site.Channel;
import com.gsccs.sme.api.service.ChannelServiceI;

import freemarker.core.Environment;
import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.SimpleNumber;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * Title: catePathTag.java
 * 
 * Description: 类目路径标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;"parid":此id下类目; navigation 是否导航 空字符串:所有;"1":是;"0":否;
 * state 是否有效 空字符串:所有;"1":是;"0":否;
 * 
 * 返回值 category 类目对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_channel_list ;channel,index> </@sme_channel_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("channelListTag")
public class ChannelListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private ChannelServiceI channelAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取参数
		Long parid = getParamLong(params, "parid", 0);
		
		// 是否倒序
		int desc = getParamInt(params, "desc",0);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				// 查询类目
				List<Channel> channels = new ArrayList<Channel>();
				if (null == parid) {
					channels = channelAPI.getRootChannel();
				} else {
					channels = channelAPI.getSubChannel(parid);
				}
				if (channels != null && channels.size() > 0) {
					if (desc==1){
						for (int i = channels.size()-1; i >= 0; i--) {
							loopVars[0] = new BeanModel(channels.get(i),
									new BeansWrapper());
							if (loopVars.length > 1) {
								loopVars[1] = new SimpleNumber(i);
							}
							
							body.render(env.getOut());
						}
					}else{
						for (int i = 0; i <channels.size(); i++) {
							loopVars[0] = new BeanModel(channels.get(i),
									new BeansWrapper());
							if (loopVars.length > 1) {
								loopVars[1] = new SimpleNumber(i);
							}
							body.render(env.getOut());
						}
					}
					
				}
			}
		}
	}

}
