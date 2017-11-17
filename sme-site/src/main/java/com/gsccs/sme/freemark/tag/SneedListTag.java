package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SneedServiceI;
import com.gsccs.sme.api.service.SneedServiceI;

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
 * Title: SneedListTag.java
 * 
 * Description: 服务需求列表标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;
 * 
 * 返回值 Sneed 服务需求对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_sneed_list siteid="${site.id}" ;sneed,index>
 * 
 * </@sme_sneed_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("sneedListTag")
public class SneedListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private SneedServiceI sneedAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 分类
		Long scode = getParamLong(params, "scode", 0);
		// 子分类
		Long subscode = getParamLong(params, "subscode", 0);
		// 地域
		String areacode = getParam(params, "areacode");
		// 关键字
		String keyword = getParam(params, "keyword");
		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 排序
		String order = getParam(params, "order", "1");
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Sneed sneed = new Sneed();
				if (StringUtils.isNotEmpty(keyword)) {
					sneed.setTitle(keyword);
				}

				if (null != scode && scode!=0) {
					sneed.setScode(scode);
				}

				if (null != subscode && subscode!=0) {
					sneed.setSubscode(subscode);
				}
				try {
					List<Sneed> sitemlist = sneedAPI.querySneedList(sneed,
							order, 1, num);
					if (sitemlist != null && sitemlist.size() > 0) {
						for (int i = 0; i < sitemlist.size(); i++) {
							if (null != sitemlist.get(i)) {
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
