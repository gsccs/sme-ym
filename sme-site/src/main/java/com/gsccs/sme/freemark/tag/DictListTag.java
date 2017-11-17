package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.base.Dict;
import com.gsccs.sme.api.service.DictServiceI;

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
 * Title: DictListTag.java
 * 
 * Description: 产品分类列表标签
 * 
 * state 是否有效 空字符串:所有;"1":是;"0":否;
 * 
 * 返回值 Dict 类目对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_dict_list code="${}" ;dictitem,index>
 * 
 * </@sme_dict_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("dictListTag")
public class DictListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private DictServiceI dictAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		// 分类
		String code = getParam(params, "code");
		// 显示数量
		int num = getParamInt(params, "num", 10);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				try {
					List<Dict> dictlist = dictAPI.queryDictList(code, true);
					if (dictlist != null && dictlist.size() > 0) {
						for (int i = 0; i < dictlist.size(); i++) {
							if (null != dictlist.get(i)) {
								loopVars[0] = new BeanModel(dictlist.get(i),
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
