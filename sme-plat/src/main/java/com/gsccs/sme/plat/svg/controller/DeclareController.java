package com.gsccs.sme.plat.svg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.sme.plat.Constants;
import com.gsccs.sme.plat.auth.model.DictItemT;
import com.gsccs.sme.plat.auth.model.MsgT;
import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.auth.service.MsgService;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.svg.model.DeclareItemT;
import com.gsccs.sme.plat.svg.model.DeclareTopicT;
import com.gsccs.sme.plat.svg.service.DeclareService;

/**
 * 项目申报控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/declare")
public class DeclareController extends BaseController {

	@Autowired
	private DeclareService declareService;
	@Autowired
	private DictService dictService;
	@Autowired
	private MsgService msgService;

	@RequestMapping(value = "/topic", method = RequestMethod.GET)
	protected String topicList(ModelMap map, HttpServletRequest req) {
		// 申报类型
		List<DictItemT> dectypelist = dictService.getDictItems("DEC_TYPE");
		map.put("dectypelist", dectypelist);
		return "declare/topic-list";
	}

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	protected String itemList(HttpServletRequest req) {
		return "declare/item-list";
	}

	@RequestMapping(value = "/topic/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid topicList(DeclareTopicT decTopic,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "starttime desc") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		Subject subject = SecurityUtils.getSubject();
		List<DeclareTopicT> list = null;
		if (subject.hasRole(Constants.ROLE_SYS_M)
				|| subject.hasRole(Constants.ROLE_DECLARE_M)) {
			list = declareService.find(decTopic, orderstr, page, rows);
		} else {
			decTopic.setSvgid(getCurrUser().getOrgid());
			list = declareService.find(decTopic, orderstr, page, rows);
		}
		int count = declareService.count(decTopic);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	@RequestMapping(value = "/item/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid itemList(DeclareItemT declareItemT,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) {
		Datagrid grid = new Datagrid();
		List<DeclareItemT> list = declareService.findItemBySvg(declareItemT,
				orderstr, page, rows);
		int count = declareService.count(declareItemT);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/topic/form", method = RequestMethod.GET)
	public String showTopicForm(Long id, Model model) {
		if (null != id) {
			DeclareTopicT decTopic = declareService.findTopicById(id);
			model.addAttribute("decTopic", decTopic);
		}

		// 申报类型
		List<DictItemT> dectypelist = dictService.getDictItems("DEC_TYPE");
		model.addAttribute("dectypelist", dectypelist);

		return "declare/topic-form";
	}

	@RequestMapping(value = "/topic/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg deleteTopic(Long id) {
		JsonMsg msg = new JsonMsg();
		try {
			if (null != id) {
				declareService.delTopics(id);
				msg.setSuccess(true);
				msg.setMsg("删除成功!");
			} else {
				msg.setSuccess(false);
				msg.setMsg("删除失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("操作失败，未知错误!");
		}
		return msg;
	}
	
	@RequestMapping(value = "/topic/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addTopic(@RequestBody DeclareTopicT declareTopicT,
			RedirectAttributes redirectAttributes) {
		JsonMsg msg = new JsonMsg();
		try {
			if (null != declareTopicT) {
				declareTopicT.setSvgid(getCurrUser().getOrgid());
				declareService.insertTopic(declareTopicT);
				msg.setSuccess(true);
				msg.setMsg("添加成功!");
			} else {
				msg.setSuccess(false);
				msg.setMsg("添加成功!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("保存失败，未知错误!");
		}
		return msg;
	}

	/**
	 * 修改行政诉求主题
	 * 
	 * @param declareTopicT
	 * @return
	 */
	@RequestMapping(value = "/topic/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg update(@RequestBody DeclareTopicT declareTopicT) {
		JsonMsg msg = new JsonMsg();
		try {
			if (null != declareTopicT) {
				if (null == declareTopicT.getSvgid()) {
					declareTopicT.setSvgid(getCurrUser().getOrgid());
				}
				declareService.updateTopic(declareTopicT);
				msg.setSuccess(true);
				msg.setMsg("修改成功!");
			} else {
				msg.setSuccess(false);
				msg.setMsg("修改失败!");
			}
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("修改失败,未知的错误原因！");
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
	@RequestMapping(value = "/item/form", method = RequestMethod.GET)
	public String showItemForm(Long id, Model model) {
		DeclareTopicT declareTopic = null;
		DeclareItemT declareItem = null;
		if (null != id) {
			declareItem = declareService.findItemById(id);
			Long topicid = declareItem.getTopicid();
			declareTopic = declareService.findTopicById(topicid);
		}
		model.addAttribute("declareItem", declareItem);
		model.addAttribute("declareTopic", declareTopic);
		return "declare/item-form";
	}

	/**
	 * 行政诉求办理
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/item/audit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg itemaudit(@RequestBody DeclareItemT declareItem) {
		JsonMsg msg = new JsonMsg();
		if (null==declareItem){
			msg.setSuccess(false);
			msg.setMsg("审核失败，申报内容不存在。");
			return msg;
		}
		declareService.updateItem(declareItem);
		
		//消息通知
		MsgT msgT = new MsgT();
		msgT.setContent(declareItem.getReply());
		msgT.setReceiver(declareItem.getCorpid());
		msgT.setSender(getCurrUser().getOrgid());
		msgService.createMsg(msgT);
		
		msg.setSuccess(true);
		msg.setMsg("审核操作成功！");
		return msg;
	}

}
