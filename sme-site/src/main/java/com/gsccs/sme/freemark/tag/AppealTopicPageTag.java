package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Activity;
import com.gsccs.sme.api.domain.AppealTopic;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ActivityServiceI;
import com.gsccs.sme.api.service.AppealServiceI;
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
 * Title: AppealPageTag.java
 * 
 * Description: 行政事项分页标签
 * 
 * 参数keyword关键字;
 * 
 * 返回值 appeallist 行政事项列表 index 索引
 * 
 * 使用示例
 * 
 * <@sme_appeal_page scode="${scode}" num="6" page="${page}"
 * pagenum="${pagenum!0}" titlelen="48" dateFormat="yyyy-MM-dd";
 * topiclist,pager>
 * 
 * <#list topiclist as topic> </#list>
 * 
 * </@sme_appeal_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("appealTopicPageTag")
public class AppealTopicPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private AppealServiceI appealAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		// 标题长度
		Integer titlen = getParamInt(params, "titlelen", 0);
		String dateformat = getParam(params, "dateformat");
		// 关键字
		String keyword = getParam(params, "keyword");
		// 业务状态
		String status = getParam(params, "status","1");
		// 服务机构
		Long svgid = getParamLong(params, "svgid", 0);
		// 服务分类
		Long scode = getParamLong(params, "scode", 0);
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
				AppealTopic appealTopic = new AppealTopic();
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				if (StringUtils.isNotEmpty(keyword)) {
					appealTopic.setTitle(keyword);
					urlParams.put("keyword", keyword);
				}

				if (null != scode && scode > 0) {
					appealTopic.setScode(scode);
					urlParams.put("scode", scode + "");
				}

				if (null != svgid && svgid != 0) {
					appealTopic.setSvgid(svgid);
				}
				try {
					appealTopic.setStatus(status);
					Datagrid datagrid = appealAPI.queryTopicList(appealTopic,
							order, page, num);
					// 获取总数
					int count = 0;
					if (null != datagrid) {
						count = datagrid.getTotal().intValue();
					}
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/appeal.html");
					pager.setParams(urlParams);
					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
					}

					List<AppealTopic> list = null;
					if (null != datagrid && null != datagrid.getRows()) {
						list = (List<AppealTopic>) datagrid.getRows();
					}
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
