package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Expect;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.ExpertServiceI;
import com.gsccs.sme.api.service.ExpertServiceI;

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
 * Title: ExpertPageTag.java
 * 
 * Description: 服务专家分页标签
 * 
 * 参数 code分类编码:"0":所有; 参数 subcode子分类编码:"0":所有; 参数 city地域 空字符串:所有; 参数keyword关键字;
 * 
 * 返回值 expert 服务项对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_expert_page siteid="${site.id}" channelid="${currChannel.id}" num="6"
 * page="${page}" pagenum="${pagenum!0}" titleLen="48" dateFormat="yyyy-MM-dd";
 * expertList,pager> <#list expertList as expert>
 * 
 * </#list> </@sme_expert_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("expertPageTag")
public class ExpertPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private ExpertServiceI expertAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		// 分类
		String code = getParam(params, "code");
		// 子分类
		String subcode = getParam(params, "subcode");
		// 地域
		String city = getParam(params, "city");
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
				Expect expert = new Expect();

				// 获取总数
				int count;
				try {
					count = expertAPI.count(expert);
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("index");

					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
					}
					List<Expect> expertlist = expertAPI.queryExpertList(expert,
							order, page, num);
					if (null != expertlist && expertlist.size() > 0) {
						loopVars[0] = new ArrayModel(expertlist.toArray(),
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
