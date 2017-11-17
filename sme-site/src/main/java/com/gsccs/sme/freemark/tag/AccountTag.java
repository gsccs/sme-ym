package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;
import com.gsccs.sme.web.api.service.RedisService;

import freemarker.core.Environment;
import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * 
 * @param Title
 *            : Account.java
 * @param Description
 *            : 用户标签
 * 
 * @param参数 id 返回值 Account 用户对象
 * 
 * 使用示例
 * 
 * <@sme_account id="${id}" ;user> </@sme_account>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("accountTag")
public class AccountTag extends BaseDirective implements TemplateDirectiveModel {

	@Autowired
	private AccountServiceI accountAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// ID
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		
		System.out.println("account:"+username);
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Account user = null;
				if (StringUtils.isNotEmpty(username)) {
					try {
						user = accountAPI.getAccount(username);
					} catch (ApiException e) {
						e.printStackTrace();
					}
				}
				if (user != null) {
					System.out.println("user is not null");
					loopVars[0] = new BeanModel(user, new BeansWrapper());
					body.render(env.getOut());
				}
			}
		}
	}
}
