package com.gsccs.sme.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.Sitemeval;
import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.SitemServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 服务项目控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class SItemController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private SitemServiceI sitemAPI;
	@Autowired
	private SvorgServiceI svorgAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 服务项目页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sitem.html", method = RequestMethod.GET)
	public String sitemlist(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num,
			String keyword,String scode,String subscode,
			String pcode,String ccode,String acode, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("keyword", keyword);
		model.addAttribute("scode", scode);
		model.addAttribute("subscode", subscode);
		model.addAttribute("pcode", pcode);
		model.addAttribute("ccode", ccode);
		model.addAttribute("acode", acode);
		model.addAttribute("page", page);
		model.addAttribute("num", num);
		return "sitemlist";
	}
	
	public void list(String keyword, Integer page, String scode,
			String areacode,ModelMap map, Model model, HttpServletRequest request,
			HttpServletResponse response) {}

	/**
	 * 服务详情页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sitem-{id}.html", method = RequestMethod.GET)
	public String listData(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "sitem";

		Sitem sitem = null;
		Svorg svorg = null;
		try {
			sitem = sitemAPI.getSitem(id);
			if (null == sitem) {
				tempPath = "error404";
			} else {
				Long svgid = sitem.getSvgid();
				svorg = svorgAPI.getSvg(svgid);
			}
			model.addAttribute("svorg", svorg);
			model.addAttribute("currSitem", sitem);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return tempPath;
	}

	/**
	 * 服务项评价列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sitemevals", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg sorderlist(Long sitemid,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		try {
			Sitemeval param = new Sitemeval();
			param.setSitemid(sitemid);
			List<Sitemeval> sitemevals = sitemAPI.findItemEvals(param,
					"addtime desc", page, pagesize);
			if (null != sitemevals && sitemevals.size() > 0) {
				jsonMsg.setSuccess(true);
				jsonMsg.setData(sitemevals);
			} else {
				jsonMsg.setSuccess(true);
			}
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
		}
		return jsonMsg;
	}
	
	
	/**
	 * 服务项评价列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/querySvorg", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg querySvorg(String title, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		try {
			Svorg param = new Svorg();
			param.setTitle(title);
			List<Svorg> list = svorgAPI.querySvgByItemLike(title);
			if (null != list && list.size() > 0) {
				jsonMsg.setSuccess(true);
				jsonMsg.setData(list);
			} else {
				jsonMsg.setSuccess(true);
			}
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
		}
		return jsonMsg;
	}

}
