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
import com.gsccs.sme.api.exception.ApiException;
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
 * Title: SItemListTag.java
 * 
 * Description: 服务项循环标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;"parid":此id下类目; navigation 是否导航 空字符串:所有;"1":是;"0":否;
 * state 是否有效 空字符串:所有;"1":是;"0":否;
 * 
 * 返回值 category 类目对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_sitem_list siteid="${site.id}" ;sitemlist> </@sme_sitem_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("sitemListTag")
public class SitemListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private SitemServiceI sitemAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		//服务分类
		long scode = getParamLong(params, "scode",0);
		//服务子分类
		long subscode = getParamLong(params, "subscode",0);
		// 服务机构
		long svgid = getParamLong(params, "svgid", 0);
		// 排序
		String order = getParam(params, "order", "1");
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				try {
					Sitem sitem = new Sitem();
					if (svgid != 0) {
						sitem.setSvgid(svgid);
					}
					if(scode != 0){
						sitem.setScode(scode);
					}
					
					if(subscode != 0){
						sitem.setSubscode(subscode);
					}
					
					List<Sitem> sitemlist = sitemAPI.querySitemList(sitem,
							order, 1, num);
					if (sitemlist != null && sitemlist.size() > 0) {
						for (int i = 0; i < sitemlist.size(); i++) {
							if (null != sitemlist.get(i)) {
								if (titlelen > 0) {
									sitemlist.get(i).setTitlelen(titlelen);
								}
								loopVars[0] = new BeanModel(sitemlist.get(i),
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
