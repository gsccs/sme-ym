package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Sorder;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SorderServiceI;

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
 * Title: OrderListTag.java
 * 
 * Description: 类目循环标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;
 * 
 * 返回值 sorder 类目对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_sorder_list sitemid="" ;sorder,index> 
 * </@sme_sorder_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("sorderListTag")
public class SorderListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SorderServiceI sorderAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取参数
		int num = getParamInt(params, "num", 10);
		int titlelen = getParamInt(params, "titlelen", 10);
		// 服务项目
		Long sitemid = getParamLong(params, "sitemid", 0);
		// 服务机构
		Long svgid = getParamLong(params, "svgid", 0);
		// 注册企业
		Long corpid = getParamLong(params, "corpid", 0);
		// 状态
		String status = getParam(params, "status");
		
		
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Sorder param = new Sorder();
				List<Sorder> orders = null;
				try {
					if (null != sitemid && sitemid!=0){
						param.setSitemid(sitemid);
					}
					orders = sorderAPI.getSorderList(param, "addtime desc", 1,
							num);
				} catch (ApiException e) {
					e.printStackTrace();
				}
				if (orders != null && orders.size() > 0) {
					for (int i = 0; i < orders.size(); i++) {
						loopVars[0] = new BeanModel(orders.get(i),
								new BeansWrapper());
						if (titlelen > 0) {
							orders.get(i).setTitlelen(titlelen);
						}
						if (loopVars.length > 1) {
							loopVars[1] = new SimpleNumber(i);
						}
						body.render(env.getOut());
					}
				}
			}
		}
	}

}
