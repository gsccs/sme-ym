package com.gsccs.sme.plat.rtable.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.rtable.model.PropT;
import com.gsccs.sme.plat.rtable.model.PropvalT;
import com.gsccs.sme.plat.rtable.service.PropService;
import com.gsccs.sme.plat.rtable.service.ReportService;
import com.gsccs.sme.plat.shop.service.ProductService;

/**
 * 产品属性值管理
 * 
 * @author x.d zhang
 * 
 */

@Controller
@RequestMapping("/propv")
public class PropVController {

	@Autowired
	private ReportService reportService;
	@Autowired
	private PropService propService;
	@Autowired
	private DictService dictService;

	
}
