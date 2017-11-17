package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.DeclareTopic;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.DeclareServiceI;
import com.gsccs.sme.api.service.SclassServiceI;

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
 * Title: DeclarePageTag.java
 * 
 * Description: 项目申报分页标签
 * 
 * 参数 classid分类编码:"0":所有; 参数 subclassid子分类编码:"0":所有; 参数 city地域 空字符串:所有;
 * 参数keyword关键字;
 * 
 * 返回值 sneedlist 服务项对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_declare_page scode="${scode}"  num="6"
 * page="${page}" pagenum="${pagenum!0}" titlelen="48" dateFormat="yyyy-MM-dd";
 * actList,pager>
 * 
 * <#list declareList as act> </#list>
 * 
 * </@sme_declare_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("declareTopicPageTag")
public class DeclareTopicPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private DeclareServiceI declareAPI;

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
				DeclareTopic declareTopic = new DeclareTopic();
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				if (StringUtils.isNotEmpty(keyword)) {
					declareTopic.setTitle(keyword);
					urlParams.put("keyword", keyword);
				}

				
				if (StringUtils.isNotEmpty(dateformat)){
					//declareTopic.setDateformat(dateformat);
				}
				
				if (null != titlen && titlen>0){
					//activity.setTitlelen(titlen);
				}
				
				if (null != svgid && svgid != 0){
					declareTopic.setSvgid(svgid);
				}
				
				try {
					Datagrid datagrid = declareAPI.queryTopicList(
							declareTopic, order, page, num);
					// 获取总数
					int count = 0;
					if (null != datagrid ){
						count =datagrid.getTotal().intValue();
					}
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/declare.html");
					pager.setParams(urlParams);
					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
					}
					List<DeclareTopic> list = null;
					if (null != datagrid && null !=datagrid.getRows()){
						list = (List<DeclareTopic>) datagrid.getRows();
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
