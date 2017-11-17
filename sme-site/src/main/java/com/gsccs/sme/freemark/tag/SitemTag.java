package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.exception.ApiException;
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
 *            : SitemTag.java
 * @param Description
 *            : 服务项标签
 * 
 * @param参数 id 返回值 sitem 服务项目对象
 * 
 *          使用示例
 * 
 *          <@sme_sitem id="${site.id}" ;sitem> </@sme_sitem> </p>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("sitemTag")
public class SitemTag extends BaseDirective implements TemplateDirectiveModel {

	@Autowired
	private RedisService redisService;
	@Autowired
	private SitemServiceI sitemAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		// 服务项ID
		Long id = getParamLong(params, "id", 0);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Sitem sitem = null;
				if (null != id) {
					try {
						sitem = sitemAPI.getSitem(id);
						if (sitem != null) {
							loopVars[0] = new BeanModel(sitem,
									new BeansWrapper());
							body.render(env.getOut());
						}
						// sitem = redisService.getSitem(id);
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
