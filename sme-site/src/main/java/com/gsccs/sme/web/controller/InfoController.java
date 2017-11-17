package com.gsccs.sme.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gsccs.sme.api.domain.site.Channel;
import com.gsccs.sme.api.domain.site.Info;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ChannelServiceI;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.InfoServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.api.service.RedisService;

/**
 * 站点信息控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class InfoController {

	@Autowired
	private AccountServiceI accountAPI;
	@Autowired
	private InfoServiceI infoAPI;
	@Autowired
	private ChannelServiceI channelAPI;
	@Autowired
	private ConfigServiceI configAPI;
	@Autowired
	private RedisService redisService;

	/**
	 * 信息列表页面
	 * 
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "channel.html", method = RequestMethod.GET)
	public String infolist(String keyword,Long id,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int num, 
			Model model,
			HttpServletRequest request, HttpServletResponse response) {
		Channel channel = null;
		String path = "channel";
		try {
			if (null != id){
				channel = channelAPI.getChannel(id);
			}
			if (null != channel && StringUtils.isNotEmpty(channel.getTemplet())){
				path = channel.getTemplet();
			}
			model.addAttribute("currChannel", channel);
			model.addAttribute("id", id);
			model.addAttribute("keyword", keyword);
			model.addAttribute("page", page);
			model.addAttribute("num", num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * 栏目详情页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/channel-{id}.html", method = RequestMethod.GET)
	public String channeldetail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "channel-info";
		Channel channel = null;
		try {
			channel = channelAPI.getChannel(id);
			if(null != channel){
				String template = channel.getTemplet();
				if (StringUtils.isNotEmpty(template)){
					tempPath = template;
				}
			}
			model.addAttribute("currChannel", channel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempPath;
	}



	/**
	 * 信息详情页
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/info-{id}.html", method = RequestMethod.GET)
	public String infodetail(@PathVariable("id") Long id, Model model,
			HttpServletResponse response) {
		String tempPath = "info";
		Info info = null;
		try {
			info = infoAPI.getInfo(id,true);
			if(null != info){
				String template = info.getTemplate();
				if (StringUtils.isNotEmpty(template)){
					tempPath = template;
				}
			}
			model.addAttribute("currInfo", info);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return tempPath;
	}

}
