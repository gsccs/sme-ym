package com.gsccs.sme.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.domain.shop.Project;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ProjectServiceI;
import com.gsccs.sme.plat.svg.model.ProjectT;
import com.gsccs.sme.plat.svg.service.ProjectService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 项目服务接口
 * 
 * @author x.d zhang
 * 
 */
public class ProjectServiceAPI implements ProjectServiceI {

	@Autowired
	private ProjectService projectService;

	@Override
	public void addCproject(Project cproject) throws ApiException {
		if (null != cproject) {
			ProjectT cropProject = new ProjectT();
			BeanUtilsEx.copyProperties(cropProject, cproject);
			projectService.add(cropProject);
		}
	}

	@Override
	public Project getCproject(Integer id) throws ApiException {
		ProjectT cropProject = projectService.findById(id);
		if (null != cropProject) {
			Project cproject = new Project();
			BeanUtilsEx.copyProperties(cproject, cropProject);
			return cproject;
		}
		return null;
	}

	@Override
	public List<Project> queryProjectList(Project o, String orderstr, int page,
			int pagesize) throws ApiException {
		List<Project> list = null;
		ProjectT t = new ProjectT();
		if (null != o) {
			BeanUtilsEx.copyProperties(t, o);
		}

		List<ProjectT> cropProjects = projectService.find(t, orderstr, page, pagesize);
		if (null != cropProjects && cropProjects.size() > 0) {
			list = new ArrayList<Project>();
			for (ProjectT projectT : cropProjects) {
				Project cproject_ = new Project();
				BeanUtilsEx.copyProperties(cproject_, projectT);
				list.add(cproject_);
			}
		}
		return list;
	}

	@Override
	public Integer count(Project param) throws ApiException {
		ProjectT cropProject = null;
		if (null != param) {
			cropProject = new ProjectT();
			BeanUtilsEx.copyProperties(cropProject, param);
		}
		return projectService.count(cropProject);
	}

	@Override
	public void updateProject(Project project) throws ApiException {
		if (null != project) {
			ProjectT cropProject = new ProjectT();
			BeanUtilsEx.copyProperties(cropProject, project);
			projectService.update(cropProject);
		}
		
	}

}
