package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ProductServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SitemServiceI;

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
 * Title: ProductListTag.java
 * 
 * Description: 产品列表标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;
 * 返回值 category 类目对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_product_list  ;product,index> 
 * </@sme_product_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("productListTag")
public class ProductListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private ProductServiceI productAPI;

	
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		//标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		// 企业
		Long corpid = getParamLong(params, "corpid",0);
		// 排序
		String order = getParam(params, "order", "1");
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				try {
					Product product = new Product();
					if (titlelen!=0){
						product.setTitlelen(titlelen);
					}
					
					if (null != corpid && corpid!=0){
						product.setCorpid(corpid);
					}
					List<Product> productlist = productAPI.queryProductList(product,
							order, 1, num);
					if (productlist != null && productlist.size() > 0) {
						for (int i = 0; i < productlist.size(); i++) {
							if (null != productlist.get(i)) {
								loopVars[0] = new BeanModel(productlist.get(i),
										new BeansWrapper());
								if (loopVars.length > 1) {
									loopVars[1] = new SimpleNumber(i);
								}
								body.render(env.getOut());
							}
						}
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
