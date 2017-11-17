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
import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SitemServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;

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
 * Title: SvorgPageTag.java
 * 
 * Description: 服务机构分页标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;
 * 
 * 返回值 svorg 服务项对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_svorg_page classid="${currChannel.id}" num="6" page="${page}"
 * pagenum="${pagenum!0}" titleLen="48" dateFormat="yyyy-MM-dd"; infoList,pager>
 * <#list infoList as info> </@sme_svorg_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("svorgPageTag")
public class SvorgPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private SvorgServiceI svorgAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 分类
		Long scode = getParamLong(params, "scode", 0);
		// 子分类
		Long subscode = getParamLong(params, "subscode", 0);
		//
		String svgtype = getParam(params, "svgtype");
		// 地域
		Integer pcode = getParamInt(params, "pcode",0);
		Integer ccode = getParamInt(params, "ccode",0);
		Integer acode = getParamInt(params, "acode",0);
		// 关键字
		String keyword = getParam(params, "keyword");

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
				Svorg svorg = new Svorg();
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				if (StringUtils.isNotEmpty(keyword)) {
					svorg.setTitle(keyword);
					urlParams.put("keyword", keyword);
				}
				if (null != scode && scode != 0) {
					svorg.setScode(scode);
					urlParams.put("scode", scode + "");
				}

				if (null != subscode && subscode != 0) {
					svorg.setSubscode(subscode);
					urlParams.put("subscode", subscode + "");
				}
				
				if (null != pcode && pcode!=0){
					svorg.setPcode(pcode);
					urlParams.put("pcode", pcode + "");
				}
				
				if (null != ccode && ccode!=0){
					svorg.setCcode(ccode);
					urlParams.put("ccode", ccode + "");
				}
				
				if (null != acode && acode!=0){
					svorg.setAcode(acode);
					urlParams.put("acode", acode + "");
				}
				
				if (StringUtils.isNotEmpty(svgtype)){
					svorg.setSvgtype(svgtype);
					urlParams.put("svgtype", svgtype);
				}
				// 获取总数
				int count;
				try {
					count = svorgAPI.count(svorg);
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/svorg.html");
					pager.setParams(urlParams);

					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
					}
					List<Svorg> svorglist = svorgAPI.querySvgList(svorg, order,
							page, num);
					if (null != svorglist && svorglist.size() > 0) {
						loopVars[0] = new ArrayModel(svorglist.toArray(),
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
