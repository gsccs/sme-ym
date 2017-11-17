package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.shop.Project;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 项目API
 * 
 * @author x.d zhang
 * @date 15-02-26
 * 
 */
public interface ProjectServiceI {

	/**
	 * 获取项目
	 */
	public Project getCproject(Integer id) throws ApiException;

	/**
	 * 添加项目
	 * 
	 * @param p
	 * @return
	 */
	public void addCproject(Project project) throws ApiException;

	/**
	 * 添加项目
	 * 
	 * @param p
	 * @return
	 */
	public void updateProject(Project project) throws ApiException;

	
	/**
	 * 获得项目列表
	 * 
	 * @param Project
	 *            项目
	 * @param orderstr
	 *            排序
	 * @return
	 * @throws ApiException
	 */
	public List<Project> queryProjectList(Project param, String orderstr, int page,
			int pagesize) throws ApiException;

	public Integer count(Project param) throws ApiException;

}
