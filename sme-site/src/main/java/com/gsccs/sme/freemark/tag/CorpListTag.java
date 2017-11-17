package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.CorpServiceI;

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
 * Title: CorpListTag.java
 * 
 * Description: 企业列表标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;
 * 
 * 返回值 corp 企业对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_corp_list ;corp,index> 
 * ${corp.title} 
 * </@sme_corp_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("corpListTag")
public class CorpListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private CorpServiceI corpAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {
		// 行业
		Long hycode = getParamLong(params, "hycode", 0);
		// 园区ID
		Long parkid = getParamLong(params, "parkid", 0);
		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		// 标题长度
		String dateformat = getParam(params, "dateformat");
		// 排序
		String order = getParam(params, "order", "1");
		// 状态
		String status = getParam(params, "status");

		if (body != null) {
			// 设置循环变量
			if (order.equals("1")) {
				order = "addtime desc";
			}
			if (loopVars != null && loopVars.length > 0) {
				Corp corp = new Corp();
				if (null != parkid && parkid != 0) {
					corp.setParkid(parkid);
				}

				if (null != hycode && hycode != 0) {
					corp.setHycode(hycode);
				}

				if (StringUtils.isNotEmpty(status)) {
					corp.setStatus(status);
				}

				try {
					List<Corp> corpList = corpAPI.queryCorpList(corp, order, 1,
							num);
					if (corpList != null && corpList.size() > 0) {
						for (int i = 0; i < corpList.size(); i++) {
							loopVars[0] = new BeanModel(corpList.get(i),
									new BeansWrapper());
							if (loopVars.length > 1) {
								loopVars[1] = new SimpleNumber(i);
							}
							body.render(env.getOut());
						}
					}
				} catch (ApiException | TemplateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
