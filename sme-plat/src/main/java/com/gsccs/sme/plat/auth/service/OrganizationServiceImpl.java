package com.gsccs.sme.plat.auth.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.plat.auth.dao.OrganizationMapper;
import com.gsccs.sme.plat.auth.model.Organization;
import com.gsccs.sme.plat.auth.model.OrganizationExample;
import com.gsccs.sme.plat.auth.model.ResourceExample.Criteria;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	private OrganizationMapper organizationMapper;

	@Override
	public Organization createOrganization(Organization organization) {
		organizationMapper.insert(organization);
		return organizationMapper.selectByPrimaryKey(organization.getId());
	}

	@Override
	public Organization updateOrganization(Organization organization) {
		organizationMapper.updateByPrimaryKey(organization);
		return organizationMapper.selectByPrimaryKey(organization.getId());
	}

	@Override
	public void deleteOrganization(Long organizationId) {
		organizationMapper.deleteByPrimaryKey(organizationId);
	}

	@Override
	public Organization findOne(Long organizationId) {
		return organizationMapper.selectByPrimaryKey(organizationId);
	}

	@Override
	public List<Organization> findAll() {
		OrganizationExample example = new OrganizationExample();
		OrganizationExample.Criteria c = example.createCriteria();
		return organizationMapper.selectByExample(example);
	}

	@Override
	public List<Organization> findAllWithExclude(
			Organization excludeOraganization) {

		return null;
		// organizationDao.findAllWithExclude(excludeOraganization);
	}

	@Override
	public void move(Organization source, Organization target) {
		// organizationDao.move(source, target);
	}

	@Override
	public String getOrgTreeToJson() {
		return this.createTreeJson(findAll());
	}

	/**
	 * 创建一颗树，以json字符串形式返回
	 * 
	 * @param list
	 *            原始数据列表
	 * @return 树
	 */
	private String createTreeJson(List<Organization> list) {
		JSONArray rootArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Organization org = list.get(i);
			if (org.getParentId() == 0) { // 根节点
				JSONObject rootObj = createBranch(list, org);
				rootArray.add(rootObj);
			}
		}
		System.out.println("rootArray.toString():" + rootArray.toString());
		return rootArray.toString();

	}

	/**
	 * 递归创建分支节点Json对象
	 * 
	 * @param list
	 *            创建树的原始数据
	 * @param currentNode
	 *            当前节点
	 * @return 当前节点与该节点的子节点json对象
	 */
	private JSONObject createBranch(List<Organization> list,
			Organization currentNode) {

		JSONObject currentObj = (JSONObject) JSONObject.toJSON(currentNode);
		System.out.println("currObj:" + currentObj.toJSONString());
		JSONArray childArray = new JSONArray();

		/*
		 * 循环遍历原始数据列表，判断列表中某对象的父id值是否等于当前节点的id值，
		 * 如果相等，进入递归创建新节点的子节点，直至无子节点时，返回节点，并将该 节点放入当前节点的子节点列表中
		 */
		for (int i = 0; i < list.size(); i++) {
			Organization newNode = list.get(i);
			if (newNode.getParentId() != 0
					&& newNode.getParentId().compareTo(currentNode.getId()) == 0) {
				System.out.println("newNode.getParentId():"
						+ newNode.getParentId());
				System.out
						.println("currentNode.getId():" + currentNode.getId());
				JSONObject childObj = createBranch(list, newNode);
				childArray.add(childObj);
			}
		}

		/*
		 * 判断当前子节点数组是否为空，不为空将子节点数组加入children字段中
		 */
		if (!childArray.isEmpty()) {
			// currentObj.put("children", childArray);
			currentObj.put("state", "closed");
		}
		currentObj.put("id", currentNode.getId().toString());
		currentObj.put("text", currentNode.getName());
		currentObj.put("parentId", currentNode.getParentId().toString());
		currentObj.put("iconCls", "icon-file");
		return currentObj;
	}

	@Override
	public List<Organization> find(Organization param) {
		OrganizationExample example = new OrganizationExample();
		OrganizationExample.Criteria c = example.createCriteria();
		if (null != param){
			if(StringUtils.isNotEmpty(param.getName())){
				c.andNameLike("%"+param.getName()+"%");
			}
		}
		return null;
	}
}
