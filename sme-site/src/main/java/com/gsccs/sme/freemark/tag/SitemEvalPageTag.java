package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.Sitemeval;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SitemServiceI;

import freemarker.core.Environment;
import freemarker.ext.beans.ArrayModel;
import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.SimpleNumber;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * Title: SitemCommonPageTag.java
 * 
 * Description: 服务项评价分页标签 
 * 
 * 返回值 sitem 服务项对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_sitem_page code="${code}" subcode="${subcode}" num="6" page="${page}"
 * pagenum="${pagenum!0}" titleLen="48" dateFormat="yyyy-MM-dd";
 * sitemList,pager> <#list sitemList as sitem>
 * 
 * </#list> </@sme_sitem_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("sitemEvalPageTag")
public class SitemEvalPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private SitemServiceI sitemAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		Long svgid = getParamLong(params, "svgid", 0);
		Long sitemid = getParamLong(params, "sitemid", 0);
		Long corpid = getParamLong(params, "corpid", 0);
		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 排序
		String order = getParam(params, "order", "1");
		// 当前第几页
		int page = getParamInt(params, "page", 1);
		// 最多显示页数
		int pagenum = getParamInt(params, "pagenum", 5);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Sitemeval sitemeval = new Sitemeval();
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				if (null != svgid && svgid != 0) {
					sitemeval.setSvgid(svgid);
				}
				if (null != sitemid && sitemid != 0) {
					sitemeval.setSitemid(sitemid);
				}
				
				if (null != corpid && corpid != 0) {
					sitemeval.setCorpid(corpid);
				}
				try {
					// 获取总数
					int count = sitemAPI.count(sitemeval);
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/sitemeval.html");
					pager.setParams(urlParams);
					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
					}
					List<Sitemeval> list = sitemAPI.findItemEvals(sitemeval,
							order, page, num);
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
