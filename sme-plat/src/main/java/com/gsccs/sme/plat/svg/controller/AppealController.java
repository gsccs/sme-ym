package com.gsccs.sme.plat.svg.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.plat.auth.model.MsgT;
import com.gsccs.sme.plat.auth.service.MsgService;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.AppealItemT;
import com.gsccs.sme.plat.svg.model.AppealPushT;
import com.gsccs.sme.plat.svg.model.AppealTopicT;
import com.gsccs.sme.plat.svg.model.AppealTraceT;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.model.SvorgT;
import com.gsccs.sme.plat.svg.service.AppealService;
import com.gsccs.sme.plat.svg.service.SclassService;
import com.gsccs.sme.plat.svg.service.SvorgService;

/**
 * 行政诉求控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/appeal")
public class AppealController extends BaseController {

	@Autowired
	private AppealService appealService;
	@Autowired
	private SvorgService svorgService;
	@Autowired
	private SclassService sclassService;
	@Autowired
	private MsgService msgService;
	
	@RequestMapping(value = "/topic", method = RequestMethod.GET)
	protected String topicList( ModelMap map) {
		SvorgT param = new SvorgT();
		param.setSvgtype("G");
		List<SvorgT> svglist = svorgService.find(param, "", 1, Integer.MAX_VALUE);
		map.put("svglist", svglist);
		return "appeal/topic-list";
	}

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	protected String itemList(HttpServletRequest req) {
		return "appeal/item-list";
	}

	@RequestMapping(value = "/topic/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid topicList(AppealTopicT decTopic,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		decTopic.setSvgid(getCurrUser().getOrgid());
		List<AppealTopicT> list = appealService.find(decTopic, orderstr, page,
				rows);
		int count = appealService.count(decTopic);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	@RequestMapping(value = "/item/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid itemList(AppealItemT appealItemT,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		appealItemT.setSvgid(getCurrUser().getOrgid());
		List<AppealItemT> list = appealService.find(appealItemT, orderstr,
				page, rows);
		int count = appealService.count(appealItemT);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/topic/form", method = RequestMethod.GET)
	public String showTopicForm(Long id, Model model) {
		AppealTopicT appealTopic = null;
		if (null != id) {
			appealTopic = appealService.findTopicById(id);
		}
		SclassT param = new SclassT();
		param.setTypeid("G");
		List<SclassT> sclassList = sclassService.find(param);
		
		
		model.addAttribute("sclassList", sclassList);
		model.addAttribute("appealTopic", appealTopic);
		return "appeal/topic-form";
	}

	/**
	 * 新增行政事项
	 * @param appealTopicT
	 * @return
	 */
	@RequestMapping(value = "/topic/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addTopic(@RequestBody AppealTopicT appealTopicT) {
		JsonMsg msg = new JsonMsg();
		try {
			if (null == appealTopicT) {
				msg.setSuccess(false);
				msg.setMsg("保存失败，行政事项信息有误！");
				return msg;
			}
			appealTopicT.setSvgid(getCurrUser().getOrgid());
			appealService.insertTopic(appealTopicT);
			msg.setSuccess(true);
			msg.setMsg("添加成功!");
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("保存失败，未知错误!");
		}
		return msg;
	}

	/**
	 * 修改行政诉求主题
	 * 
	 * @param appealTopicT
	 * @return
	 */
	@RequestMapping(value = "/topic/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(@RequestBody AppealTopicT appealTopicT) {
		JsonMsg msg = new JsonMsg();
		try {
			if (null != appealTopicT) {
				if (null == appealTopicT.getSvgid()) {
					appealTopicT.setSvgid(getCurrUser().getOrgid());
				}
				appealTopicT.setAddtime(new Date());
				appealService.updateTopic(appealTopicT);
				msg.setSuccess(true);
				msg.setMsg("行政事项修改成功!");
			} else {
				msg.setSuccess(false);
				msg.setMsg("行政事项修改失败!");
			}
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("行政事项修改失败,未知的错误原因！");
		}
		return msg;
	}

	
	/**
	 * 查看行政诉求内容
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/item/view", method = RequestMethod.GET)
	public String showItemView(Long id, Model model) {
		if (null != id) {
			AppealItemT appealItemT = appealService.findItemById(id);
			model.addAttribute("appealItem", appealItemT);
			List<AppealTraceT> tracelist = appealService.find(id);
			model.addAttribute("appealItem", appealItemT);
			model.addAttribute("tracelist", tracelist);
		}
		return "appeal/item-view";
	}
	
	
	@RequestMapping(value = "/item/form", method = RequestMethod.GET)
	public String showItemForm(Long id, Model model) {
		AppealItemT appealItemT = null;
		AppealTopicT appealTopicT = null;
		if (null != id) {
			appealItemT = appealService.findItemById(id);
			if (null != appealItemT){
				appealTopicT = appealService.findTopicById(appealItemT.getTopicid());
				 
				if (null != appealTopicT && appealTopicT.getSvgid().equals(getCurrUser().getOrgid())
						&& !appealItemT.getStatus().equals("2")){
					appealItemT.setStatus("2");
					appealService.updateItem(appealItemT);
					// 保存轨迹
					AppealTraceT traceT = new AppealTraceT();
					traceT.setContent("受理事项");
					traceT.setItemid(id);
					traceT.setSvgid(getCurrUser().getOrgid());
					traceT.setStatus("1");
					appealService.insertTrace(traceT);
				}
			}
		}
		List<AppealTraceT> tracelist = appealService.find(id);
		model.addAttribute("appealItem", appealItemT);
		model.addAttribute("appealTopicT", appealTopicT);
		model.addAttribute("tracelist", tracelist);
		return "appeal/item-form";
	}
	
	/**
	 * 事项督办表单
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/item/push", method = RequestMethod.GET)
	public String showPushForm(Long id, Model model) {
		if (null != id) {
			AppealItemT appealItemT = appealService.findItemById(id);
			List<AppealTraceT> tracelist = appealService.find(id);
			model.addAttribute("appealItem", appealItemT);
			model.addAttribute("tracelist", tracelist);
		}
		return "appeal/item-push";
	}

	/**
	 * 行政诉求办理
	 * 
	 * @param itemid
	 * @return
	 */
	@RequestMapping(value = "/item/attend", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg attend(@RequestBody AppealItemT appealItem) {
		JsonMsg msg = new JsonMsg();
		// 申请事项不为空
		if (null == appealItem) {
			msg.setSuccess(false);
			msg.setMsg("服务事项不存在");
			return msg;
		}
		AppealItemT appealItemT = appealService.findItemById(appealItem.getId());
		// 申请事项已办理
		if (null==appealItemT || appealItemT.getStatus().equals("1")) {
			msg.setSuccess(false);
			msg.setMsg("提交失败,申请事项已办理!");
			return msg;
		}

		try {
			//已办理
			appealItem.setStatus("1");
			appealItem.setEndtime(new Date());
			appealService.updateItem(appealItem);
			String phonenum = getCurrUser().getPhone();
			if (StringUtils.isNotEmpty(phonenum)){
				//短信提醒
				//smsService.sendMsg(new String{phonenum}, "事项已办理");
			}
			
			// 保存轨迹
			AppealTraceT traceT = new AppealTraceT();
			traceT.setContent(appealItem.getResultstr());
			traceT.setItemid(appealItem.getId());
			traceT.setSvgid(getCurrUser().getOrgid());
			traceT.setStatus("1");
			appealService.insertTrace(traceT);

			msg.setSuccess(true);
			msg.setMsg("提交成功!");
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("提交失败,未知错误!");
		}
		return msg;
	}

	/**
	 * 行政诉求督办
	 * 
	 * @param itemid
	 * @return
	 */
	@RequestMapping(value = "/item/push", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg itempush(AppealPushT pushT) {
		JsonMsg msg = new JsonMsg();
		AppealItemT appealItemT = appealService.findItemById(pushT.getItemid());
		// 申请事项不为空
		if (null == appealItemT) {
			msg.setSuccess(false);
			msg.setMsg("服务事项督办失败!");
			return msg;
		}
		// 申请事项已办理
		if (!appealItemT.getStatus().equals("0")) {
			msg.setSuccess(false);
			msg.setMsg("督办失败,申请事项已办理!");
			return msg;
		}

		try {
			Integer pushnum = appealItemT.getPushnum();
			pushnum = pushnum==null?1:pushnum+1;
			appealItemT.setPushnum(pushnum);
			appealItemT.setEndtime(new Date());
			appealService.updateItem(appealItemT);
			
			AppealTopicT topicT = appealService.findTopicById(appealItemT
					.getTopicid());
			pushT.setTopicid(appealItemT.getTopicid());
			pushT.setSvgid(topicT.getSvgid());
			pushT.setSuperid(getCurrUser().getOrgid());
			pushT.setStatus("1");
			appealService.insertAppealPush(pushT);
			msg.setSuccess(true);
			msg.setMsg("服务事项督办成功!");

			// 保存轨迹
			AppealTraceT traceT = new AppealTraceT();
			traceT.setContent("服务事项督办");
			traceT.setItemid(pushT.getItemid());
			traceT.setSvgid(getCurrUser().getOrgid());
			traceT.setStatus("1");
			appealService.insertTrace(traceT);

			//消息通知
			MsgT msgT = new MsgT();
			msgT.setSender(getCurrUser().getOrgid());
			msgT.setReceiver(topicT.getSvgid());
			msgT.setContent("督办通知:请尽快受理 ["+appealItemT.getCorptitle()+"]需求。");
			msgService.createMsg(msgT);
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("服务事项督办失败,未知原因！");
		}
		return msg;
	}

	/**
	 * 行政事项附件删除
	 * 
	 * @param attachid
	 * @return
	 */
	@RequestMapping(value = "/attach/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg attachDelete(Long  attachid) {
		JsonMsg msg = new JsonMsg();
		if (null==attachid){
			msg.setSuccess(false);
			msg.setMsg("附件删除失败!");
			return msg;
		}
		try {
			List<Long> attachids = new ArrayList<>();
			attachids.add(attachid);
			appealService.delAttachs(attachids);
			msg.setSuccess(true);
			msg.setMsg("附件删除成功!");
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("附件删除失败,未知原因！");
		}
		return msg;
	}

}
