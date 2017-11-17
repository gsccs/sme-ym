package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Activity;
import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ActivityServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SneedServiceI;
import com.gsccs.sme.api.service.SneedServiceI;

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
 * Title: ActivityListTag.java
 * 
 * Description: 服务活动列表标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;
 * 
 * 返回值 activity 活动对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_activity_list siteid="${site.id}" ;activity,index>
 * 
 * </@sme_activity_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("activityListTag")
public class ActivityListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private ActivityServiceI activityAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 排序
		String order = getParam(params, "order", "1");

		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		// 简介长度
		int remarklen = getParamInt(params, "remarklen", 0);
		// 服务分类
		long scode = getParamLong(params, "scode", 0);
		// 服务子分类
		long subscode = getParamLong(params, "subscode", 0);
		// 服务机构
		long svgid = getParamLong(params, "svgid", 0);
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Activity activity = new Activity();
				try {
					if (svgid != 0) {
						activity.setSvgid(svgid);
					}
					if(scode != 0){
						activity.setScode(scode);
					}
					
					List<Activity> actlist = activityAPI.queryActivityList(
							activity, order, 1, num);
					if (actlist != null && actlist.size() > 0) {
						for (int i = 0; i < actlist.size(); i++) {
							if (null != actlist.get(i)) {
								if (titlelen > 0) {
									actlist.get(i).setTitlelen(titlelen);
								}
								
								if (remarklen > 0) {
									actlist.get(i).setRemarklen(remarklen);
								}
								loopVars[0] = new BeanModel(actlist.get(i),
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
