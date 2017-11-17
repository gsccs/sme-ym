package com.gsccs.sme.plat.statist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.domain.StatistGroup;
import com.gsccs.sme.plat.corp.service.CorpService;
import com.gsccs.sme.plat.svg.model.AppealTopicT;
import com.gsccs.sme.plat.svg.model.SitemT;
import com.gsccs.sme.plat.svg.service.AppealService;
import com.gsccs.sme.plat.svg.service.GclassService;
import com.gsccs.sme.plat.svg.service.SclassService;
import com.gsccs.sme.plat.svg.service.SitemService;
import com.gsccs.sme.plat.svg.service.SorderService;
import com.gsccs.sme.plat.svg.service.SvorgService;

@Service
public class StatistServiceImpl implements StatistService {

	@Autowired
	private AppealService appealService;
	@Autowired
	private SitemService sitemService;
	@Autowired
	private SvorgService svorgService;
	@Autowired
	private CorpService corpService;
	@Autowired
	private SorderService sorderService;
	@Autowired
	private SclassService sclassService;

	@Override
	public JSONObject platStatist() {
		JSONObject jsonObject = new JSONObject();
		int svorgnum = svorgService.count(null);
		int corpnum = corpService.count(null);
		int sitemnum = sitemService.count(new SitemT());
		int sordernum = sorderService.count(null);
		int appealtopicnum = appealService.count(new AppealTopicT());
		jsonObject.put("svorgnum", svorgnum);
		jsonObject.put("corpnum", corpnum);
		jsonObject.put("sitemnum", sitemnum);
		jsonObject.put("sordernum", sordernum);
		jsonObject.put("appealtopicnum", appealtopicnum);
		return jsonObject;
	}

	@Override
	public JSONArray loadSitemClass(String order) {

		return null;
	}

	@Override
	public JSONArray loadSvorgClass(String order) {

		return null;
	}

	@Override
	public JSONArray loadAppealTopicSvg(String order) {
		return null;
	}

	@Override
	public JSONArray loadAppealTopicGclass(String order) {
		JSONArray array = new JSONArray();
		List<StatistGroup> grouplist = sclassService.statistAppealTopicNum();
		if (null != grouplist) {
			array.addAll(grouplist);
		}
		return array;
	}

}
