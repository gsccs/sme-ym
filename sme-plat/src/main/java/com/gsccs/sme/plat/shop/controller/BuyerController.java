package com.gsccs.sme.plat.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsccs.sme.plat.corp.service.CorpService;

/**
 * 
 */
@Controller
@RequestMapping("/buyer")
public class BuyerController {

	@Autowired
	private CorpService buyerService;

}
