package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.base.Area;
import com.gsccs.sme.api.service.AreaServiceI;

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
 * Title: AreaListTag.java
 * 
 * Description: 地域列表标签
 * 
 * 参数 parid 父分类"0"::所有;
 * state 是否有效 空字符串:所有;"1":是;"0":否;
 * 
 * 返回值 Area 地域对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_area_list parid="${}" ;area,index>
 * 
 * </@sme_area_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("areaListTag")
public class AreaListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private AreaServiceI areaAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 父级
		int parid = getParamInt(params, "parid",0);
		// 显示数量
		int num = getParamInt(params, "num", 10);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				try {
					List<Area> arealist = areaAPI.getArea(parid);
					if (arealist != null && arealist.size() > 0) {
						for (int i = 0; i < arealist.size(); i++) {
							if (null != arealist.get(i)) {
								loopVars[0] = new BeanModel(arealist.get(i),
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
