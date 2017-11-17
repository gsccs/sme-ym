package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.plat.svg.model.SvorgT;

/**
 * 服务机构
 * 
 * @author x.d zhang
 * 
 */
public interface SvorgService {

	/**
	 * 添加
	 * 
	 * @param svorgT
	 * @return
	 */
	public Long addSvorg(SvorgT svorgT);

	/**
	 * 更新
	 * 
	 * @param svorgT
	 */
	public void update(SvorgT svorgT);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void del(Long id);

	/**
	 * 分页查询
	 */
	public List<SvorgT> find(SvorgT svorgT, String order, int currPage,
			int pageSize);

	public int count(SvorgT svorgT);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public SvorgT findById(Long id);

	public List<SvorgT> querySvgByItemLike(String title, int currPage,
			int pageSize);

}
