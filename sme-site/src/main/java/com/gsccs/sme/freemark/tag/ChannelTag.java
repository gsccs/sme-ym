package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.shop.Brand;
import com.gsccs.sme.api.domain.site.Channel;
import com.gsccs.sme.api.service.ChannelServiceI;
import com.gsccs.sme.web.api.service.RedisService;

import freemarker.core.Environment;
import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * 
 * @param Title: ChannelTag.java 
 * @param Description: 栏目标签
 * 
 * 返回值 Channel 栏目对象 
 * 
 * 使用示例
 * 
 * <@sme_channel id="${site.id}" ;channel> 
 * </@sme_channel> </p>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("channelTag")
public class ChannelTag extends BaseDirective implements
		TemplateDirectiveModel {
	
	@Resource
	private ChannelServiceI channelAPI;
	
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
		Long id = getParamLong(params, "id",0);
		
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Channel channel = null;
				if (null != id && id!=0) {
					channel = channelAPI.getChannel(id);
				}
				if (channel != null) {
					loopVars[0] = new BeanModel(channel, new BeansWrapper());
					body.render(env.getOut());
				}
			}
		}
	}
}
