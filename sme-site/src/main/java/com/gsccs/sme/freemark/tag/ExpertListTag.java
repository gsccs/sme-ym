package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Expect;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ExpertServiceI;
import com.gsccs.sme.api.service.SclassServiceI;

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
 * Title: ExpertListTag.java
 * 
 * Description: 服务专家列表标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;
 * 
 * 返回值 expert 专家对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_expert_list classid="${classid}" ;expertlist> 
 * 
 * </@sme_expert_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("expertListTag")
public class ExpertListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private ExpertServiceI expertAPI;

	
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 排序
		String order = getParam(params, "order", "1");
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Expect expert = new Expect();
				try {
					List<Expect> expertlist  = expertAPI.queryExpertList(expert, order, 1, num);
					if (expertlist != null && expertlist.size() > 0) {
						for (int i = 0; i < expertlist.size(); i++) {
							if (null != expertlist.get(i)) {
								loopVars[0] = new BeanModel(expertlist.get(i),
										new BeansWrapper());
								if (loopVars.length > 1) {
									loopVars[1] = new SimpleNumber(i);
								}
								body.render(env.getOut());
							}
						}
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
