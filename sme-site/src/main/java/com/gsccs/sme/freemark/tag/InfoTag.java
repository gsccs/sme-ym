package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.site.Info;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.InfoServiceI;
import com.gsccs.sme.api.service.SitemServiceI;
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
 * @param Title
 *            : InfoTag.java
 * @param Description
 *            : 信息对象标签
 * 
 * @param参数 
 *          返回值 Info 信息对象
 * 
 *          使用示例
 * 
 *<@sme_info id="${info.id}" ;info> 
 *</@sme_info> 
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("infoTag")
public class InfoTag extends BaseDirective implements TemplateDirectiveModel {

	@Autowired
	private RedisService redisService;
	@Autowired
	private InfoServiceI infoAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		
		// 信息ID
		Long id = getParamLong(params, "id",0);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Info info = null;
				if (null != id) {
					try {
						info = infoAPI.getInfo(id,true);
						if (info != null) {
							loopVars[0] = new BeanModel(info,
									new BeansWrapper());
							body.render(env.getOut());
						}
					} catch (ApiException e) {
						e.printStackTrace();
					} catch (TemplateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}
	}
}
