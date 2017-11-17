package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConsultServiceI;

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
 * Title: ConsultListTag.java
 * 
 * Description: 咨询列表标签
 * 
 * 参数 scode 分类
 * 
 * 返回值 consult 咨询象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_consult_page scode="${scode}" titlelen="10"
 * dateformat="yyyy-MM-dd" ;consultlist,pager> 
 * </@sme_consult_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("consultPageTag")
public class ConsultPageTag extends BaseDirective implements
		TemplateDirectiveModel {
	@Resource
	private ConsultServiceI consultAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		// 标题长度
		String dateformat = getParam(params, "dateformat");
		// 栏目ID
		Long scode = getParamLong(params, "scode", 0);
		// 发布企业
		Long svgid = getParamLong(params, "svgid", 0);
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
				Consult consult = new Consult();
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				if (StringUtils.isNotEmpty(keyword)) {
					consult.setTitle(keyword);
					urlParams.put("keyword", keyword);
				}

				if (null != scode && scode != 0) {
					consult.setScode(scode);
					urlParams.put("scode", scode.toString());
				}
				
				if (null != svgid && svgid != 0) {
					consult.setSvgid(svgid);
					urlParams.put("svgid", svgid.toString());
				}
				
				try {
					
					List<Consult> list = consultAPI.findConsultList(consult, "addtime desc",
							1, num);
					// 获取总数
					int count = consultAPI.countConsults(consult);
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/consults.html");
					pager.setParams(urlParams);
					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
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
