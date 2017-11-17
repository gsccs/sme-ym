package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Expect;
import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ExpertServiceI;
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
 *            : ExpertTag.java
 * @param Description
 *            : 专家对象标签
 * 
 * @param参数 返回值 Expert 专家对象
 * 
 *          使用示例
 * 
 *          <@sme_expert id="${expert.id}" ;info> </@sme_expert>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("expertTag")
public class ExpertTag extends BaseDirective implements TemplateDirectiveModel {

	@Autowired
	private RedisService redisService;
	@Autowired
	private ExpertServiceI expertAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		// ID
		String id = getParam(params, "id");

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Expect expert = null;
				if (StringUtils.isNotEmpty(id)) {
					try {
						expert = expertAPI.getExpert(id);
						if (expert != null) {
							loopVars[0] = new BeanModel(expert,
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
