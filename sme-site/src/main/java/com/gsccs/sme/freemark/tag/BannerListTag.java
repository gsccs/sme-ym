package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.site.Banner;
import com.gsccs.sme.api.service.BannerServiceI;

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
 * Title: bannerListTag.java
 * 
 * Description: 热点列表标签
 * 
 * 参数 parid
 * 
 * 返回值 info 信息对象 index 索引
 * 
 * 使用示例
 * 
 * <@bannerListTag channelid="${channel.id}" titlelen="10"
 * dateformat="yyyy-MM-dd" ;infolist,index> </@bannerListTag>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("bannerListTag")
public class BannerListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private BannerServiceI bannerAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		int remarklen = getParamInt(params, "remarklen", 0);
		// 标题长度
		String dateformat = getParam(params, "dateformat");
		// 排序
		String order = getParam(params, "order", "1");
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				try {
					Banner param = new Banner();
					param.setStatus("1");
					List<Banner> list = bannerAPI.find(param, 1, num);
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							if (null != list.get(i)) {
								loopVars[0] = new BeanModel(list.get(i),
										new BeansWrapper());
								if (loopVars.length > 1) {
									loopVars[1] = new SimpleNumber(i);
								}
								body.render(env.getOut());
							}
						}
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
