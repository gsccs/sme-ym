package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Activity;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ActivityServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SneedServiceI;

import freemarker.core.Environment;
import freemarker.ext.beans.ArrayModel;
import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * Title: ActivityPageTag.java
 * 
 * Description: 服务活动分页标签
 * 
 * 参数 classid分类编码:"0":所有; 参数 subclassid子分类编码:"0":所有; 参数 city地域 空字符串:所有;
 * 参数keyword关键字;
 * 
 * 返回值 sneedlist 服务项对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_activity_page scode="${scode}"  num="6"
 * page="${page}" pagenum="${pagenum!0}" titlelen="48" dateFormat="yyyy-MM-dd";
 * actList,pager>
 * 
 * <#list actList as act> </#list>
 * 
 * </@sme_activity_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("activityPageTag")
public class ActivityPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private ActivityServiceI activityAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		// 分类
		Long scode = getParamLong(params, "scode", 0);
		// 子分类
		Long subscode = getParamLong(params, "subscode", 0);
		// 地域
		Integer pcode = getParamInt(params, "pcode",0);
		Integer ccode = getParamInt(params, "ccode",0);
		Integer acode = getParamInt(params, "acode",0);
		//标题长度
		Integer titlen = getParamInt(params, "titlelen",0);
		String dateformat = getParam(params, "dateformat");
		// 关键字
		String keyword = getParam(params, "keyword");
		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 排序
		String order = getParam(params, "order", "1");
		// 当前第几页
		int page = getParamInt(params, "page", 1);
		// 最多显示页数
		int pagenum = getParamInt(params, "pagenum", 0);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Activity activity = new Activity();
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				if (StringUtils.isNotEmpty(keyword)) {
					activity.setTitle(keyword);
					urlParams.put("keyword", keyword);
				}

				if (null != scode && scode != 0) {
					activity.setScode(scode);
					urlParams.put("scode", scode+"");
				}

				if (null != subscode && subscode!=0) {
					activity.setSubscode(subscode);
					urlParams.put("subscode", subscode+"");
				}
				
				if (null != pcode && pcode!=0){
					activity.setPcode(pcode);
					urlParams.put("pcode", pcode + "");
				}
				
				if (null != ccode && ccode!=0){
					activity.setCcode(ccode);
					urlParams.put("ccode", ccode + "");
				}
				
				if (null != acode && acode!=0){
					activity.setAcode(acode);
					urlParams.put("acode", acode + "");
				}
				
				if (StringUtils.isNotEmpty(dateformat)){
					activity.setDateformat(dateformat);
				}
				
				if (null != titlen && titlen>0){
					activity.setTitlelen(titlen);
				}
				
				try {
					// 获取总数
					int count = activityAPI.count(activity);
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/activity.html");
					pager.setParams(urlParams);
					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
					}
					List<Activity> list = activityAPI.queryActivityList(
							activity, order, page, num);
					if (null != list && list.size() > 0) {
						loopVars[0] = new ArrayModel(list.toArray(),
								new BeansWrapper());
						if (loopVars.length > 1) {
							loopVars[1] = new BeanModel(pager,
									new BeansWrapper());
						}
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
