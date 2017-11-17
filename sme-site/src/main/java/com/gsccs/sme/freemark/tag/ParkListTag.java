package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Park;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ParkServiceI;

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
 * Title: ParkListTag.java
 * 
 * Description: 园区列表标签
 * 
 * 参数 parid
 * 
 * 返回值 park 信息对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_park_list titlelen="10" dateformat="yyyy-MM-dd" ;parklist,index> 
 * </@sme_park_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("parkListTag")
public class ParkListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private ParkServiceI parkAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		// 标题长度
		String dateformat = getParam(params, "dateformat");
		// 排序
		String order = getParam(params, "order", "1");
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				try {
					Park park = new Park();

					List<Park> parklist = parkAPI.queryParkList(park, order, 1,
							num);
					if (parklist != null && parklist.size() > 0) {
						for (int i = 0; i < parklist.size(); i++) {
							if (null != parklist.get(i)) {
								loopVars[0] = new BeanModel(parklist.get(i),
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
