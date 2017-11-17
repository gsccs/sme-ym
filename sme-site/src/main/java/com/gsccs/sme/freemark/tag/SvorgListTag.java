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
import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.SitemServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;

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
 * Title: SvorgListTag.java
 * 
 * Description: 服务机构循环标签
 * 
 * 参数 code分类编码:"0":所有; 参数 subcode子分类编码:"0":所有; 参数 city地域 空字符串:所有; 参数keyword关键字;
 * 
 * 返回值 svorg 服务机构对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_svorg_list siteid="${site.id}" ;svorglist>
 * 
 * </@sme_svorg_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("svorgListTag")
public class SvorgListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private SvorgServiceI svorgAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 10);
		// 是否推荐
		String top = getParam(params, "top", "1");
		// 机构分类 S:社会服务机构 G:政府服务机构
		String svgtype = getParam(params, "svgtype", "S");
		// 分类
		long scode = getParamLong(params, "scode",0);
		// 排序
		String order = getParam(params, "order", "1");

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Svorg svorg = new Svorg();
				try {
					if (StringUtils.isNotEmpty(svgtype)) {
						svorg.setSvgtype(svgtype);
					}
					
					if (scode!=0) {
						svorg.setScode(scode);
					}

					List<Svorg> svorglist = svorgAPI.querySvgList(svorg, order,
							1, num);
					if (svorglist != null && svorglist.size() > 0) {
						for (int i = 0; i < svorglist.size(); i++) {
							if (null != svorglist.get(i)) {
								if (titlelen > 0) {
									svorglist.get(i).setTitlelen(titlelen);
								}
								loopVars[0] = new BeanModel(svorglist.get(i),
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
