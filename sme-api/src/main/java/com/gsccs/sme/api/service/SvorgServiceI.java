package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 服务机构API
 * 
 * @author x.d zhang
 * 
 */
public interface SvorgServiceI {

	/**
	 * 获取服务机构的基本信息
	 * 
	 * @throws Throwable
	 */
	public Svorg getSvg(Long id) throws ApiException;

	public void addSvg(Svorg svorg) throws ApiException;

	public void updateSvg(Svorg svorg) throws ApiException;

	public void delSvg(Long id) throws ApiException;

	public Integer count(Svorg svorg);

	public List<Svorg> querySvgList(Svorg o, String orderstr, int page,
			int pagesize) throws ApiException;
	
	public List<Svorg> querySvgByItemLike(String title) throws ApiException;
}
