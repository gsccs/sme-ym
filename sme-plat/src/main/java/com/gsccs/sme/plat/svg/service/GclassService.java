package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.api.domain.StatistGroup;
import com.gsccs.sme.plat.svg.model.GclassT;

public interface GclassService {

	public void insert(GclassT sclassT);

	public void update(GclassT sclassT);

	public void delSclass(Long id);

	public GclassT findById(Long id);

	public List<GclassT> find(GclassT sclassT, String orderstr, int page,
			int pagesize);

	public List<GclassT> find(GclassT sclassT);

	public List<GclassT> findSubList(Long parid);

	public int count(GclassT sclassT);
	
	public List<StatistGroup> statistAppealTopicNum();
}
