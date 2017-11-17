package com.gsccs.sme.plat.svg.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.sme.plat.Constants;
import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.ActenrollT;
import com.gsccs.sme.plat.svg.model.ActivityT;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.model.SvorgT;
import com.gsccs.sme.plat.svg.service.ActivityService;
import com.gsccs.sme.plat.svg.service.SclassService;
import com.gsccs.sme.plat.svg.service.SvorgService;
import com.gsccs.sme.plat.utils.HtmlCode;

/**
 * 服务活动控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/activity")
public class ActivityController extends BaseController {

	@Autowired
	private ActivityService activityService;
	@Autowired
	private SclassService sclassService;
	@Autowired
	private SvorgService svorgService;
	@Autowired
	private DictService dictService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	protected String activityList(ModelMap map, HttpServletRequest req) {
		List<SclassT> sclassTs = sclassService.findSubList(0l);
		map.addAttribute("sclasslist", sclassTs);
		return "activity/activity-list";
	}

	/**
	 * 活动报名页面
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/enrolls", method = RequestMethod.GET)
	protected String activityEnrolls(ModelMap map, HttpServletRequest req) {
		Subject subject = SecurityUtils.getSubject();
		ActivityT activity = new ActivityT();
		List<ActivityT> list = null;
		if (subject.hasRole(Constants.ROLE_SYS_M)
				|| subject.hasRole(Constants.ROLE_ACTIVITY_M)) {
			list = activityService.find(activity, "", 1, Integer.MAX_VALUE);
		} else {
			activity.setSvgid(getCurrUser().getOrgid());
			list = activityService.find(activity, "", 1, Integer.MAX_VALUE);
		}
		map.addAttribute("activitylist", list);
		return "activity/activity-enrolls";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid activityList(ActivityT activity,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {

		Datagrid grid = new Datagrid();
		Subject subject = SecurityUtils.getSubject();
		List<ActivityT> list = null;
		if (subject.hasRole(Constants.ROLE_SYS_M)
				|| subject.hasRole(Constants.ROLE_ACTIVITY_M)) {
			list = activityService.find(activity, orderstr, page, rows);
		} else {
			activity.setSvgid(getCurrUser().getOrgid());
			list = activityService.find(activity, orderstr, page, rows);
		}
		int count = activityService.count(activity);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	/**
	 * 活动报名表
	 * 
	 * @param page
	 * @param rows
	 * @param orderstr
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/enroll/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid enrollList(Long activityid,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {

		Datagrid grid = new Datagrid();
		Subject subject = SecurityUtils.getSubject();
		ActenrollT param = new ActenrollT();
		List<ActenrollT> list = null;
		if (subject.hasRole(Constants.ROLE_SYS_M)
				|| subject.hasRole(Constants.ROLE_ACTIVITY_M)) {
			list = activityService.find(param, orderstr, page, rows);
		} else {
			param.setSvgid(getCurrUser().getOrgid());
			list = activityService.find(param, orderstr, page, rows);
		}
		int count = activityService.count(param);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String showForm(Long id, Model model, SclassT sclassT) {
		Long svgid = getCurrUser().getOrgid();
		if (null != svgid) {
			SvorgT svorg = svorgService.findById(svgid);
			model.addAttribute("svorg", svorg);
		}
		if (null != id) { // 修改
			ActivityT activity = activityService.findById(id);
			model.addAttribute("activity", activity);
		}
		List<SclassT> sclassTs = sclassService.findSubList(0l);
		model.addAttribute("sclasslist", sclassTs);
		return "activity/activity-form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg add(@RequestBody ActivityT activity, Model model) {
		JsonMsg msg = new JsonMsg();
		try {
			if (null != activity) {
				activity.setSvgid(getCurrUser().getOrgid());
				// 如果没有摘要，则自动生成
				if (StringUtils.isEmpty(activity.getRemark())
						&& StringUtils.isNotEmpty(activity.getContent())) {
					activity.setRemark(HtmlCode.replaceHtml(activity.getContent()));
					if (activity.getRemark().length() > 200) {
						activity.setRemark(activity.getRemark().substring(0, 200));
					}
				}

				activityService.insert(activity);
				msg.setSuccess(true);
				msg.setMsg("添加成功!");
			} else {
				msg.setSuccess(false);
				msg.setMsg("添加失败，请检查活动数据正确！");
			}
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("添加失败，未知的错误原因！");
		}
		return msg;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(@RequestBody ActivityT activity, Model model,
			RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		if (null != activity) {
			activity.setSvgid(getCurrUser().getOrgid());
			// 如果没有摘要，则自动生成
			if (StringUtils.isEmpty(activity.getRemark())
					&& StringUtils.isNotEmpty(activity.getContent())) {
				activity.setRemark(HtmlCode.replaceHtml(activity.getContent()));
				if (activity.getRemark().length() > 200) {
					activity.setRemark(activity.getRemark().substring(0, 200));
				}
			}
			activityService.update(activity);
			msg.setSuccess(true);
			msg.setMsg("活动信息修改成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("活动信息修改失败，请检查活动数据正确！");
		}
		return msg;
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public JsonMsg delete(Long id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		try {
			if (null != id) {
				activityService.delActivity(id);
				msg.setSuccess(true);
				msg.setMsg("活动删除成功!");
			} else {
				msg.setSuccess(false);
				msg.setMsg("删除失败，活动不存在！");
			}
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("删除失败,未知的错误原因！");
		}
		return msg;
	}

	
	/**
	 * 信息审核表单
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/auditForm", method = RequestMethod.GET)
	public String infoAudit(Long id, Model model) {
		if (null != id) {
			ActivityT activity = activityService.findById(id);
			model.addAttribute("activity", activity);
		}
		return "activity/activity-audit";
	}

	/**
	 * 活动审核
	 * 
	 * @param id
	 * @param result
	 * @param auditdesc
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/audit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg infoAudit(Long id, String auditresult, String auditdesc,
			Model model) {
		JsonMsg msg = new JsonMsg();
		try {
			ActivityT activity = activityService.findById(id);
			if (null == activity) {
				msg.setSuccess(false);
				msg.setMsg("审核失败，内容不存在!");
				return msg;
			}
			// 审核通过
			if (auditresult.equals("true")) {
				activity.setIsrelease("1");
				activityService.update(activity);
			}
			msg.setSuccess(true);
			msg.setMsg("审核提交成功!");
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("审核提交失败，未知错误原因!");
		}
		return msg;
	}
	
	/**
	 * 日期型数据转换，将页面上的表示日期限的字符串，转换为Date型
	 * **/
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));

	}
}
