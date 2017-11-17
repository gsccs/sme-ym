package com.gsccs.sme.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.Sorder;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.SitemServiceI;
import com.gsccs.sme.api.service.SorderServiceI;
import com.gsccs.sme.api.service.SvorgServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 服务评价控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class SevalController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private SitemServiceI sitemAPI;
	@Autowired
	private SvorgServiceI svorgAPI;
	@Autowired
	private SorderServiceI sorderAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 服务评价列表
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sevallist", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg sevallist(Long sitemid, 
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, 
			Model model,
			HttpServletRequest request, HttpServletResponse response) {
		JsonMsg jsonMsg = new JsonMsg();
		try {
			Sorder param = new Sorder();
			param.setSitemid(sitemid);
			List<Sorder> sorders = sorderAPI.getSorderList(param,
					"addtime desc", 1, Integer.MAX_VALUE);
			if (null != sorders && sorders.size() > 0) {
				jsonMsg.setSuccess(true);
				jsonMsg.setData(sorders);
			} else {
				jsonMsg.setSuccess(true);
			}
		} catch (ApiException e) {
			jsonMsg.setSuccess(false);
		}
		return jsonMsg;
	}


}
