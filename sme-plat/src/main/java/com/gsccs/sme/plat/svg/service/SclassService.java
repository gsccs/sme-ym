package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.api.domain.StatistGroup;
import com.gsccs.sme.plat.svg.model.SclassT;

public interface SclassService {

	public void insert(SclassT sclassT);

	public void update(SclassT sclassT);

	public void delSclass(Long id);

	public SclassT findById(Long id);

	public List<SclassT> find(SclassT sclassT,String orderstr, int page,
			int pagesize);
	
	public List<SclassT> find(SclassT sclassT);
	
	public List<SclassT> findSubList(Long parid);

	public int count(SclassT sclassT);

	public List<SclassT> findByParids(String string);
	
	public List<StatistGroup> statistAppealTopicNum();
}
