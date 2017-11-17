package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.service.SvorgServiceI;
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
 *            : SvorgTag.java
 * @param Description
 *            : 服务机构标签
 * 
 * @param参数 id 返回值 Svorg 服务机构对象
 * 
 * 使用示例
 * 
 * <@sme_svorg id="${svorg.id}" ;svorg> </@sme_svorg>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("svorgTag")
public class SvorgTag extends BaseDirective implements TemplateDirectiveModel {

	@Autowired
	private RedisService redisService;
	@Autowired
	private SvorgServiceI svgAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 栏目id
		String id = getParam(params, "id");

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Svorg svorg = null;
				if (StringUtils.isNotEmpty(id)) {
					svorg = redisService.getSVG(id);
				}
				if (svorg != null) {
					loopVars[0] = new BeanModel(svorg, new BeansWrapper());
					body.render(env.getOut());
				}
			}
		}
	}
}
