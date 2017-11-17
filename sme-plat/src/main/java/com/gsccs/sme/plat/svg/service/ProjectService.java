package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.plat.svg.model.ProjectT;

/**
 * 工程项目
 * 
 * @author x.d zhang
 * 
 */
public interface ProjectService {

	/**
	 * 添加
	 * 
	 * @param cropProject
	 * @return
	 */
	public void add(ProjectT cropProject);

	/**
	 * 更新
	 * 
	 * @param cropProject
	 */
	public void update(ProjectT cropProject);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void del(Integer id);

	/**
	 * 分页查询
	 */
	public List<ProjectT> find(ProjectT cropProject, String order, int currPage,
			int pageSize);

	public int count(ProjectT cropProject);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public ProjectT findById(Integer id);

}
