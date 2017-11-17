package com.gsccs.sme.plat.site.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.plat.Constants;
import com.gsccs.sme.plat.auth.model.User;
import com.gsccs.sme.plat.auth.service.UserService;
import com.gsccs.sme.plat.bass.BaseController;
import com.gsccs.sme.plat.bass.Datagrid;
import com.gsccs.sme.plat.bass.JsonMsg;
import com.gsccs.sme.plat.site.model.Content;
import com.gsccs.sme.plat.site.service.ChannelService;
import com.gsccs.sme.plat.site.service.ContentService;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.model.SvorgT;
import com.gsccs.sme.plat.svg.service.SvorgService;
import com.gsccs.sme.plat.utils.HtmlCode;

/**
 * 信息管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/info")
public class InfoController extends BaseController {

	@Autowired
	private ContentService infoService;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private UserService userService;
	@Autowired
	private SvorgService svorgService;

	@RequestMapping(method = RequestMethod.GET)
	protected String infolist(Model model, 
			HttpServletRequest request) {
		SvorgT param = new SvorgT();
		List<SvorgT> svorglist = svorgService.find(param, "", 1, Integer.MAX_VALUE);
		model.addAttribute("svorglist", svorglist);
		return "site/info-list";
	}
	
	@RequestMapping(value = "/audits", method = RequestMethod.GET)
	protected String infolistAudit(Model model, SclassT sclassT,
			HttpServletRequest request) {
		return "site/info-list-audit";
	}
	
	/**
	 * 信息统计
	 * @param model
	 * @param info
	 * @param page
	 * @param rows
	 * @param orderstr
	 * @param map
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid datagrid(Model model, Content info,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) throws ParseException {
		Datagrid grid = new Datagrid();
		Subject subject = SecurityUtils.getSubject();
		List<Content> list = null;
		if (subject.hasRole(Constants.ROLE_SYS_M)
				|| subject.hasRole(Constants.ROLE_INFO_M)) {
			list = infoService.find(info, orderstr, page, rows);
		} else {
			info.setUserid(getCurrUser().getId());
			info.setSvgid(getCurrUser().getOrgid());
			list = infoService.find(info, orderstr, page, rows);
		}
		int count = infoService.count(info);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	
	/**
	 * 平台通知公告
	 * @param model
	 * @param info
	 * @param page
	 * @param rows
	 * @param orderstr
	 * @param map
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/noticeList", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid noticeList(Model model, Content info,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "5") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) throws ParseException {
		Datagrid grid = new Datagrid();
		List<Content> list = infoService.find(info, orderstr, page, rows);;
		int count = infoService.count(info);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}
	
	
	/**
	 * 待审核信息列表
	 * @param model
	 * @param info
	 * @param page
	 * @param rows
	 * @param orderstr
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/audits/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid auditsDatagrid(Model model, Content info,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int rows,
			@RequestParam(defaultValue = "") String orderstr,
			HttpServletRequest request, ModelMap map) throws ParseException {
		Datagrid grid = new Datagrid();
		info.setIsrelease("0");
		info.setStatus("1");
		List<Content> list = infoService.find(info, orderstr, page, rows);;
		int count = infoService.count(info);
		grid.setRows(list);
		grid.setTotal(Long.valueOf(count));
		return grid;
	}

	// 新增
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String infoForm(Long id, Model model) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		User user = userService.findByAccount(username);
		SvorgT svorgT = null;
		Content content = null;
		if (null != user) {
			svorgT = svorgService.findById(user.getOrgid());
		}
		if (null != id) {
			content = infoService.getContent(id);
		}

		if (null != content) {
			content.setSource(svorgT.getTitle());
			content.setAuthor(user.getTitle());
		}
		model.addAttribute("info", content);
		model.addAttribute("svorg", svorgT);
		model.addAttribute("user", user);
		return "site/info-form";
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
		Content content = null;
		if (null != id) {
			content = infoService.getContent(id);
		}
		model.addAttribute("info", content);
		return "site/info-audit";
	}

	/**
	 * 信息审核
	 * 
	 * @param id
	 * @param result
	 * @param auditdesc
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/audit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg infoAudit(Long id, 
			@RequestParam(defaultValue = "1") String result,
			String remark, Model model) {
		JsonMsg msg = new JsonMsg();
		try {
			Content content = infoService.getContent(id);
			if (null == content) {
				msg.setSuccess(false);
				msg.setMsg("信息审核失败，信息不存在!");
				return msg;
			}
			
			content.setStatus("2");
			content.setIsrelease(result);
			infoService.update(content);

			msg.setSuccess(true);
			msg.setMsg("信息审核提交成功!");
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("信息审核提交失败，未知错误原因!");
		}
		return msg;
	}

	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addInfo(@RequestBody Content info, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == info) {
			msg.setSuccess(false);
			msg.setMsg("信息保存失败，内容有误！");
			return msg;
		}
		try {
			info.setUserid(getCurrUser().getId());
			info.setSvgid(getCurrUser().getOrgid());

			// 如果没有摘要，则自动生成
			if (StringUtils.isEmpty(info.getRemark())
					&& StringUtils.isNotEmpty(info.getContent())) {
				info.setRemark(HtmlCode.replaceHtml(info.getContent()));
				if (info.getRemark().length() > 200) {
					info.setRemark(info.getRemark().substring(0, 200));
				}
			}

			if (StringUtils.isEmpty(info.getImg())
					&& StringUtils.isNotEmpty(info.getContent())) {
				// 如果没有选择信息图片，则检查信息内容中是否有图片
				try {
					Parser parser = new Parser(info.getContent());
					NodeFilter filter = new TagNameFilter("img");
					NodeList nodes = parser.extractAllNodesThatMatch(filter);
					Node eachNode = null;
					ImageTag imageTag = null;
					if (nodes != null && nodes.size() > 0) {
						// 遍历所有的img节点
						for (int i = 0; i < nodes.size(); i++) {
							if (info.getImg() == null
									|| info.getImg().trim().length() == 0) {
								eachNode = (Node) nodes.elementAt(i);
								if (eachNode instanceof ImageTag) {
									imageTag = (ImageTag) eachNode;
									if (imageTag.getAttribute("src")
											.startsWith("http://")) {
										info.setImg(imageTag
												.getAttribute("src"));
										info.setImg("1");
										break;
									}
								}
							} else {
								break;
							}
						}
					}
				} catch (ParserException e) {
					e.printStackTrace();
				}
			}
			infoService.addContent(info);
			msg.setSuccess(true);
			msg.setMsg("信息发布成功!");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("信息发布失败!");
		}
		return msg;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg infoEdit(@RequestBody Content info, Model model) {
		JsonMsg msg = new JsonMsg();
		if (null == info || null == info.getId()) {
			msg.setSuccess(false);
			msg.setMsg("信息保存失败，内容有误！");
			return msg;
		}
		try {
			info.setUserid(getCurrUser().getId());
			info.setSvgid(getCurrUser().getOrgid());

			// 如果没有摘要，则自动生成
			if (StringUtils.isEmpty(info.getRemark())
					&& StringUtils.isNotEmpty(info.getContent())) {
				info.setRemark(HtmlCode.replaceHtml(info.getContent()));
				if (info.getRemark().length() > 200) {
					info.setRemark(info.getRemark().substring(0, 200));
				}
			}

			if ((info.getImg() == null || info.getImg().trim().length() == 0)
					&& StringUtils.isNotEmpty(info.getContent())) {
				// 如果没有选择信息图片，则检查信息内容中是否有图片
				try {
					Parser parser = new Parser(info.getContent());
					NodeFilter filter = new TagNameFilter("img");
					NodeList nodes = parser.extractAllNodesThatMatch(filter);
					Node eachNode = null;
					ImageTag imageTag = null;
					if (nodes != null && nodes.size() > 0) {
						// 遍历所有的img节点
						for (int i = 0; i < nodes.size(); i++) {
							if (info.getImg() == null
									|| info.getImg().trim().length() == 0) {
								eachNode = (Node) nodes.elementAt(i);
								if (eachNode instanceof ImageTag) {
									imageTag = (ImageTag) eachNode;
									if (imageTag.getAttribute("src")
											.startsWith("http://")) {
										info.setImg(imageTag
												.getAttribute("src"));
										info.setImg("1");
										break;
									}
								}
							} else {
								break;
							}
						}
					}
				} catch (ParserException e) {
					e.printStackTrace();
				}
			}
			infoService.update(info);
			msg.setSuccess(true);
			msg.setMsg("信息内容修改成功!");
		} catch (Exception e) {
			msg.setSuccess(false);
			msg.setMsg("信息内容修改失败!");
		}
		return msg;
	}

	// 删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg del(Long id, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != id) {
			infoService.delContent(id);
			msg.setSuccess(true);
			msg.setMsg("记录删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("记录删除失败!");
		}
		return msg;
	}

	// 删除
	@RequestMapping(value = "/attach/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg attachDelete(Long attachid, HttpServletRequest request) {
		JsonMsg msg = new JsonMsg();
		if (null != attachid) {
			List<Long> ids = new ArrayList<>();
			ids.add(attachid);
			infoService.delAttachs(ids);
			msg.setSuccess(true);
			msg.setMsg("附件删除成功!");
		} else {
			msg.setSuccess(false);
			msg.setMsg("附件删除失败!");
		}
		return msg;
	}

}
