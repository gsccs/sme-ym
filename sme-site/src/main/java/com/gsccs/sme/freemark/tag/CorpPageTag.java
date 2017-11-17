package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.CorpServiceI;

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
 * Title: CorpPageTag.java
 * 
 * Description: 企业分页标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;
 * 
 * 返回值 corp 企业对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_corp_page parkid="${parkid}" num="6" page="${page}"
 * pagenum="${pagenum!0}" titleLen="48" dateFormat="yyyy-MM-dd"; infoList,pager>
 * <#list infoList as info> 
 * </@sme_corp_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("corpPageTag")
public class CorpPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private CorpServiceI corpAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		//行业
		Long hycode = getParamLong(params, "hycode",0);
		//园区ID
		Long parkid = getParamLong(params, "parkid",0);
		// 关键字
		String keyword = getParam(params, "keyword");
		// 关键字
		String status = getParam(params, "status");
		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 排序
		String order = getParam(params, "order", "istop");
		// 当前第几页
		int page = getParamInt(params, "page", 1);
		// 最多显示页数
		int pagenum = getParamInt(params, "pagenum", 0);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Corp corp = new Corp();
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				if (StringUtils.isNotEmpty(keyword)) {
					corp.setTitle(keyword);
					urlParams.put("keyword", keyword);
				}
				
				if (null != hycode && hycode!=0){
					corp.setHycode(hycode);
					urlParams.put("hycode", hycode + "");
				}
				
				
				if (null != parkid && parkid!=0){
					corp.setParkid(parkid);
					urlParams.put("parkid", parkid + "");
				}
				
				if (StringUtils.isNotEmpty(status)){
					corp.setStatus(status);
				}
				
				// 获取总数
				int count;
				try {
					count = corpAPI.count(corp);
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/corp.html");
					pager.setParams(urlParams);

					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
					}
					
					List<Corp> corplist = corpAPI.queryCorpList(corp, order,
							page, num);
					if (null != corplist && corplist.size() > 0) {
						loopVars[0] = new ArrayModel(corplist.toArray(),
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
