package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Sorder;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SorderServiceI;

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
 * Title: OrderPagerTag.java
 * 
 * Description: 服务订单循环标签
 
 * 
 * 返回值 sorder 类目对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_sorder_pager sitemid="" svgid="" corpid="" ;sorderlist,index> 
 * </@sme_sorder_pager>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("sorderPageTag")
public class SorderPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SorderServiceI sorderAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 服务项目
		Long sitemid = getParamLong(params, "sitemid", 0);
		// 服务机构
		Long svgid = getParamLong(params, "svgid", 0);
		// 注册企业
		Long corpid = getParamLong(params, "corpid", 0);
		// 状态
		String status = getParam(params, "status");
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
				Sorder param = new Sorder();
				//参数
				Map<String,String> urlParams = new HashMap<String, String>(); 
				try {
					if (null != sitemid && sitemid != 0) {
						param.setSitemid(sitemid);
					}
					if (null != svgid && svgid != 0) {
						param.setSvgid(svgid);
					}
					if (null != corpid && corpid != 0) {
						param.setCorpid(corpid);
					}
					// 获取总数
					int count = sorderAPI.count(param);
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/sorder.html");
					pager.setParams(urlParams);

					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
					}

					List<Sorder> list = sorderAPI.getSorderList(param, "addtime desc", 1,
							num);
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
				}

			}
		}
	}

}
