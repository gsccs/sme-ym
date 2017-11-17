package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.report.Report;
import com.gsccs.sme.api.service.ReportServiceI;

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
 * Title: ReportPageTag.java
 * 
 * Description: 数据上报分页标签
 * 
 * 参数 svgid 服务机构编码:"0":所有; 
 * 参数keyword关键字;
 * 
 * 返回值 reportlist 服务项对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_report_page svgid="${svgid}"  num="6"
 * page="${page}" pagenum="${pagenum!0}" titlelen="48" dateFormat="yyyy-MM-dd";
 * actList,pager>
 * 
 * <#list reportList as act> </#list>
 * 
 * </@sme_report_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("reportPageTag")
public class ReportPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private ReportServiceI reportAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		//标题长度
		Integer titlen = getParamInt(params, "titlelen",0);
		String dateformat = getParam(params, "dateformat");
		// 关键字
		String keyword = getParam(params, "keyword");
		// 服务机构
		Long svgid = getParamLong(params, "svgid",0);
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
				Report report = new Report();
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				if (StringUtils.isNotEmpty(keyword)) {
					report.setTitle(keyword);
					urlParams.put("keyword", keyword);
				}
				
				if (null != svgid && svgid != 0){
					report.setSvgid(svgid);
				}
				
				try {
					List<Report> list = reportAPI.find(report,order, page, num);
					
					// 获取总数
					int count = reportAPI.count(report);;
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/report.html");
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
					
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
