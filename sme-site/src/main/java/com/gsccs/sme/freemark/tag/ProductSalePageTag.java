package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Porder;
import com.gsccs.sme.api.domain.PorderItem;
import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.PorderServiceI;
import com.gsccs.sme.api.service.ProductServiceI;
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
 * Title:ProductSalePageTag.java
 * 
 * Description: 产品订单分页标签
 * 参数 code分类编码:"0":所有;
 * 参数 subcode子分类编码:"0":所有; 
 * 参数 city地域 空字符串:所有;
 * 参数keyword关键字;
 * 
 * 返回值 porder 产品订单对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_porder_page productid="${productid}" corpid="${corpid}" num="6" page="${page}" pagenum="${pagenum!0}" titleLen="48" dateFormat="yyyy-MM-dd"; productList,pager> 
 * <#list porderlist as porder> 
 * 
 * </#list>
 * </@sme_porder_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("productsalePageTag")
public class ProductSalePageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private PorderServiceI orderAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 产品
		Long productid = getParamLong(params, "productid",0);
		// 企业
		Long corpid = getParamLong(params, "corpid",0);
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
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				try {
					// 获取总数
					int count = orderAPI.countProductOrders(productid);
					FreemarkerPager pager = new FreemarkerPager();
					pager.setCurrPage(page);
					pager.setTotalCount(count);
					pager.setPageSize(num);
					pager.setUrl("/product.html");
					pager.setParams(urlParams);
					// 如果总页数大于最多显示页数，则设置总页数为最多显示页数
					if (pagenum > 0 && pagenum < pager.getTotalPage()) {
						pager.setTotalPage(pagenum);
					}
					
					List<Porder> list = orderAPI.getProductOrderList(productid,
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
