package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.exception.ApiException;
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
 * Title:ProductPageTag.java
 * 
 * Description: 服务项分页标签
 * 参数 code分类编码:"0":所有;
 * 参数 subcode子分类编码:"0":所有; 
 * 参数 city地域 空字符串:所有;
 * 参数keyword关键字;
 * 
 * 返回值 product 服务项对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_product_page code="${code}" subcode="${subcode}" num="6" page="${page}" pagenum="${pagenum!0}" titleLen="48" dateFormat="yyyy-MM-dd"; productList,pager> 
 * <#list productList as product> 
 * 
 * </#list>
 * </@sme_product_page>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("productPageTag")
public class ProductPageTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private ProductServiceI productAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 分类
		String categoryid = getParam(params, "categoryid");
		// 地域
		String areacode = getParam(params, "areacode");
		//
		Long corpid = getParamLong(params, "corpid", 0);
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
		//标题长度
		int titlelen = getParamInt(params, "titlelen", 0);

		if (body != null) {
			
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				// 参数
				Map<String, String> urlParams = new HashMap<String, String>();
				Product product = new Product();
				if (StringUtils.isNotEmpty(keyword)){
					product.setTitle(keyword);
					urlParams.put("keyword", keyword);
				}
				if (null != categoryid && !categoryid.equals("0")){
					product.setCateid(categoryid);
				}
				
				if (titlelen!=0){
					product.setTitlelen(titlelen);
				}
				
				if (null != corpid && corpid!=0){
					product.setCorpid(corpid);
				}
				
				try {
					// 获取总数
					int count = productAPI.count(product);
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
					List<Product> productlist = productAPI.queryProductList(product,
							order, page, num);
					if (null != productlist && productlist.size() > 0) {
						loopVars[0] = new ArrayModel(productlist.toArray(),
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
