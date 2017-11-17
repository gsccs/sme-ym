package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.report.Report;
import com.gsccs.sme.api.service.ReportServiceI;

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
 * Title: ReportListTag.java
 * 
 * Description: 数据上报列表标签
 * 
 * 参数 svgid 空字符:所有;
 * 
 * 返回值 report 报表对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_report_list svgid="${svgid}" ;report,index>
 * 
 * </@sme_report_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("reportListTag")
public class ReportListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private ReportServiceI reportAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 排序
		String order = getParam(params, "order", "1");
		// 服务机构
		Long svgid = getParamLong(params, "svgid", 0);
		
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Report report = new Report();
				try {
					if (null != svgid && svgid != 0) {
						report.setSvgid(svgid);
					}
					List<Report> list = reportAPI.find(report,order, 1, num);
					
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							if (null != list.get(i)) {
								loopVars[0] = new BeanModel(list.get(i),
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
