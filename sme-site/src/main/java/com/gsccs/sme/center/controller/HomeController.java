package com.gsccs.sme.center.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.domain.site.Info;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.api.service.AppealServiceI;
import com.gsccs.sme.api.service.ConsultServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.InfoServiceI;
import com.gsccs.sme.api.service.SorderServiceI;

/**
 * 企业中心
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class HomeController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private AppealServiceI appealAPI;
	@Autowired
	private SorderServiceI sorderAPI;
	@Autowired
	private InfoServiceI infoAPI;
	@Autowired
	private ConsultServiceI consultAPI;

	
	/**
	 * 企业中心首页
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		System.out.println("username:"+username);
		Corp corp = null;
		List<Consult> consultList = null;
		List<Info> infoList = null;
		try {
			Account user = accountAPI.getAccount(username);
			if (null == user || null == user.getUsertype() 
					|| !user.getUsertype().equals("C")) {
				return "redirect:/index.html";
			}
			
			
			corp = corpAPI.getCorp(user.getOrgid());
			//System.out.println("orgid:"+user.getOrgid());
			//System.out.println("corp:"+corp);
			subject.getSession().setAttribute("corp", corp);
			if (null == corp){
				return "redirect:/index.html";
			}
			
			Consult consultParam = new Consult();
			consultParam.setCorpid(corp.getId());
			consultList = consultAPI.findConsultList(consultParam, "addtime desc", 1, 10);
			
			Info infoParam = new Info();
			infoParam.setChannelid(102l);
			infoList = infoAPI.queryInfoList(infoParam, "addtime desc", 1, 5);
			
		} catch (ApiException e) {
			e.printStackTrace();
		}
		model.addAttribute("corp", corp);
		model.addAttribute("infoList", infoList);
		model.addAttribute("consultList", consultList);
		return "home";
	}

	

}
