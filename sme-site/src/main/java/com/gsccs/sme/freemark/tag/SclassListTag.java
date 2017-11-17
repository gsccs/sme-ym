package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SitemServiceI;

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
 * Title: SclassListTag.java
 * 
 * Description: 服务分类列表标签
 * 
 * 参数 code 父分类"0"::所有;
 * state 是否有效 空字符串:所有;"1":是;"0":否;
 * 
 * 返回值 Sclass 类目对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_sclass_list code="${}" ;sclasslist>
 * 
 * </@sme_sclass_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("sclassListTag")
public class SclassListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		// 分类
		Long code = getParamLong(params, "code",0);
		//类型
		String type = getParam(params, "type","S");
		// 显示数量
		int num = getParamInt(params, "num", 10);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				try {
					List<Itemtype> sclasslist = null;
					if (null == code || code==0){
						sclasslist = sclassAPI.getRootClass(type);
					}else{
						sclasslist = sclassAPI.getSubClass(code);
					}
					if (sclasslist != null && sclasslist.size() > 0) {
						for (int i = 0; i < sclasslist.size(); i++) {
							if (null != sclasslist.get(i)) {
								loopVars[0] = new BeanModel(sclasslist.get(i),
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
