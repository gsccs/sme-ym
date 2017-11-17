package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.site.Info;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.InfoServiceI;
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
 * Title: InfoPageTag.java
 * 
 * Description: 服务项分页标签 参数 code分类编码:"0":所有;
 * 
 * 返回值 infolist 信息列表对象 page 分页字符串
 * 
 * 使用示例
 * 
 * <@sme_info_page num="6" page="${page}" pagenum="${pagenum!0}" titlelen="48"
 * dateformat="yyyy-MM-dd"; infolist,pager> <#list infolist as info>
 * 
 * </#list> </@sme_info_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("infoPageTag")
public class InfoPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private InfoServiceI infoAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		// 标题长度
		String dateformat = getParam(params, "dateformat");
		// 栏目ID
		Long channelid = getParamLong(params, "channelid", 0);
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
				Info info = new Info();
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				if (StringUtils.isNotEmpty(keyword)) {
					info.setTitle(keyword);
					urlParams.put("keyword", keyword);
				}

				if (null != channelid && channelid != 0) {
					info.setChannelid(channelid);
					urlParams.put("id", channelid.toString());
				}
				
				if (null != svgid && svgid != 0) {
					info.setSvgid(svgid);
					urlParams.put("svgid", svgid.toString());
				}
				if (StringUtils.isNotEmpty(dateformat)) {
					info.setDateformat(dateformat);
				}
				if (titlelen > 0) {
					info.setTitlelen(titlelen);
				}
				try {
					// 获取总数
					int count = infoAPI.count(info);
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/channel.html");
					pager.setParams(urlParams);
					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
					}

					List<Info> infolist = infoAPI.queryInfoList(info,
							"addtime desc", 1, num);
					if (null != infolist && infolist.size() > 0) {
						loopVars[0] = new ArrayModel(infolist.toArray(),
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
