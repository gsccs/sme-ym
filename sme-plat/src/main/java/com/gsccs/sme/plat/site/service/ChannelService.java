package com.gsccs.sme.plat.site.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.plat.site.model.ChanelT;

public interface ChannelService {

	public void insert(ChanelT sclassT);

	public void update(ChanelT sclassT);

	public void delChannel(Long id);

	public ChanelT findById(Long id);

	public List<ChanelT> find(ChanelT sclassT, String orderstr, int page,
			int pagesize);

	public List<ChanelT> find(ChanelT sclassT);

	public List<ChanelT> findSubChannel(Long parid);

	public int count(ChanelT sclassT);

	public List<ChanelT> findByParids(String string);
	
	public JSONArray findChannelTree();
}
