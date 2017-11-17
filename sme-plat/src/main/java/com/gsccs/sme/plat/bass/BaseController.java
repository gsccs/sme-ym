package com.gsccs.sme.plat.bass;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.plat.auth.model.User;
import com.gsccs.sme.plat.auth.service.UserService;
import com.gsccs.sme.plat.corp.service.CorpService;
import com.gsccs.sme.plat.svg.model.CorpT;
import com.gsccs.sme.plat.svg.model.SvorgT;
import com.gsccs.sme.plat.svg.service.SvorgService;

public class BaseController {

	@Resource
	private UserService userService;
	@Resource
	private SvorgService svorgService;
	@Resource
	private CorpService corpService;

	protected User getCurrUser() {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		return userService.findByAccount(username);
	}

	protected SvorgT getCurrSvg() {
		User user = getCurrUser();
		if (null != user) {
			return svorgService.findById(user.getOrgid());
		}
		return null;
	}
	
	protected CorpT getCurrCorp() {
		User user = getCurrUser();
		if (null != user) {
			return corpService.getCorp(user.getOrgid());
		}
		return null;
	}
}
