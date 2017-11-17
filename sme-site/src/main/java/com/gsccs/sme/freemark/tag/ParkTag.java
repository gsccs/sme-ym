package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Park;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ParkServiceI;

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
 * Title: ParkTag.java
 * 
 * Description: 园区标签
 * 
 * 参数 parid
 * 
 * 返回值 park 园区对象 
 * 
 * 使用示例
 * 
 * <@sme_park id="10" ;park> 
 * </@sme_park>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("parkTag")
public class ParkTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private ParkServiceI parkAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		Long id = getParamLong(params, "id", 0);
	
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				try {
					Park park = parkAPI.getPark(id);
					if (park==null){
						 park = new Park();
					}
					loopVars[0] = new BeanModel(park,
							new BeansWrapper());
					body.render(env.getOut());
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
