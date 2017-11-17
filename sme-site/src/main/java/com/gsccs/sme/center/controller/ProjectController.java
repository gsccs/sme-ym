package com.gsccs.sme.center.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.Industry;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.Dict;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.domain.shop.Project;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.DictServiceI;
import com.gsccs.sme.api.service.IndustryServiceI;
import com.gsccs.sme.api.service.ProjectServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 企业项目管理
 * 
 * @author x.d zhang
 * 
 */
@Controller(value="ProjectCtl")
@RequestMapping(value = "/cp/project")
public class ProjectController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private CorpServiceI corpAPI;
	@Autowired
	private ProjectServiceI projectAPI;
	@Autowired
	private IndustryServiceI industryAPI;
	@Autowired
	private DictServiceI dictAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 发布项目
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public String projectadd(Model model, HttpServletResponse response) {
		List<Industry> industries = industryAPI.getRootList();
		// 资金来源
		List<Dict> msourcelist = dictAPI.queryDictList("MTYPE", true);
		model.addAttribute("msourcelist", msourcelist);
		model.addAttribute("industries", industries);
		return "project/projectform";
	}

	/**
	 * 项目列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String projectlist(Model model, HttpServletResponse response) {
		List<Industry> industries = industryAPI.getRootList();
		// 资金来源
		List<Dict> msourcelist = dictAPI.queryDictList("MTYPE", true);
		model.addAttribute("msourcelist", msourcelist);
		model.addAttribute("industries", industries);
		return "project/projectlist";
	}

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Datagrid projectlist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		Datagrid datagrid = new Datagrid();
		try {
			Project project = new Project();

			Account user = accountAPI.getAccount(username);
			if (null != user) {
				project.setCorpid(user.getOrgid());
			}
			List<Project> projectList = projectAPI.queryProjectList(project,
					"addtime desc", page, pagesize);
			int count  = projectAPI.count(project);
			datagrid.setRows(projectList);
			datagrid.setTotal(Long.valueOf(count));
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonMsg postProject(@RequestBody Project project, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			if (null != project) {
				Account user = accountAPI.getAccount(username);
				if (null != user) {
					project.setCorpid(user.getOrgid());
				}
				project.setAddtime(new Date());
				projectAPI.addCproject(project);
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("项目保存成功。");
			}
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("项目保存失败。");
		}
		return jsonMsg;
	}

	/**
	 * 修改项目
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg updateProject(Project project, Model model,
			HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			Account user = accountAPI.getAccount(username);
			if (null != project) {
				if (null == project.getCorpid()){
					project.setCorpid(user.getOrgid());
				}
				projectAPI.updateProject(project);
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return jsonMsg;
	}

}
