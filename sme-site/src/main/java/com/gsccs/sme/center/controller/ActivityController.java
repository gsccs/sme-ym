package com.gsccs.sme.center.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.ActEnroll;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ActivityServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 企业活动管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="ActivityCtl")
@RequestMapping(value = "/cp/activity")
public class ActivityController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private ActivityServiceI activityAPI;
	@Autowired
	private RedisService redisService;

	
	/**
	 * 报名活动列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String activitylist(Model model, HttpServletResponse response) {
		return "activity/activitylist";
	}

	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Datagrid activitylist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Datagrid datagrid = new Datagrid();
		try {
			Account user = accountAPI.getAccount(username);
			datagrid = activityAPI.queryEnrollActList(user.getId(),
					"addtime desc", page, pagesize);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	/**
	 * 企业活动报名
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public String activityEnroll(Model model, HttpServletResponse response) {

		return "activity/activityform";
	}

	
	/**
	 * 提交参加活动信息
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
	public JsonMsg activityJoin(ActEnroll actEnroll, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null != actEnroll) {
				Account user = accountAPI.getAccount(username);
				if (null != user) {
					actEnroll.setCorpid(user.getOrgid());
					actEnroll.setUserid(user.getId());
					activityAPI.addActEnroll(actEnroll);
				}
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("活动报名成功。");
			}else{
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("活动报名失败,请确认报名信息正确");
			}
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("活动报名失败。");
		}
		return jsonMsg;
	}


}
