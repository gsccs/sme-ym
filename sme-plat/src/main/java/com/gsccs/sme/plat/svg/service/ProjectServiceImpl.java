package com.gsccs.sme.plat.svg.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.svg.dao.ProjectMapper;
import com.gsccs.sme.plat.svg.model.ProjectT;
import com.gsccs.sme.plat.svg.model.ProjectTExample;
import com.gsccs.sme.plat.svg.model.ProjectTExample.Criteria;

/**
 * 工程项目
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public void add(ProjectT cropProject) {
		if (null != cropProject) {
			projectMapper.insert(cropProject);
		}
	}

	/**
	 * 根据id查询信息
	 */
	@Override
	public ProjectT findById(Integer id) {
		ProjectT cropProject = projectMapper.selectByPrimaryKey(id);
		return cropProject;
	}

	@Override
	public void update(ProjectT cropProject) {
		if (null != cropProject) {
			projectMapper.updateByPrimaryKey(cropProject);
		}
	}

	@Override
	public void del(Integer id) {
		projectMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ProjectT> find(ProjectT store, String order,
			int currPage, int pageSize) {
		ProjectTExample example = new ProjectTExample();
		ProjectTExample.Criteria criteria = example.createCriteria();
		proSearchParam(store, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		List<ProjectT> cropProjects = projectMapper
				.selectPageByExample(example);
		return cropProjects;
	}

	@Override
	public int count(ProjectT cropProject) {
		ProjectTExample example = new ProjectTExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(cropProject, criteria);
		return projectMapper.countByExample(example);
	}

	public void proSearchParam(ProjectT cropProject,
			ProjectTExample.Criteria criteria) {
		if (null != cropProject) {
			if (StringUtils.isNotEmpty(cropProject.getTitle())) {
				criteria.andTitleLike("%" + cropProject.getTitle() + "%");
			}

			if (null != cropProject.getCorpid()) {
				criteria.andCorpidEqualTo(cropProject.getCorpid());
			}
			
			if (StringUtils.isNotEmpty(cropProject.getStatus())){
				criteria.andStatusEqualTo(cropProject.getStatus());
			}
		}
	}

}
