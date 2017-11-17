package com.gsccs.sme.plat.auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * 
 * @author x.d zhang
 * 
 */
public class Role implements Serializable {

	private Long id; // 编号
	private String rolecode; // 角色标识 程序中判断使用,如"admin"
	private String description; // 角色描述,UI界面显示使用
	private String resourceIds;
	private List<Long> resourceIdList; // 拥有的资源
	private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户
	private String roletype;

	public Role() {
	}

	public Role(String rolecode, String description, Boolean available) {
		this.rolecode = rolecode;
		this.description = description;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Long> getResourceIdList() {
		if (resourceIds == null || resourceIds.trim().length() <= 0) {
			resourceIdList = new ArrayList<Long>();
		} else {
			resourceIdList = new ArrayList<Long>();
			String[] resourceIdStrs = resourceIds.split(",");
			for (String resourceIdStr : resourceIdStrs) {
				if (StringUtils.isEmpty(resourceIdStr)) {
					continue;
				}
				resourceIdList.add(Long.valueOf(resourceIdStr));
			}
		}
		return resourceIdList;
	}

	public void setResourceIdList(List<Long> resourceIdList) {
		this.resourceIdList = resourceIdList;
	}

	public String getResourceIds() {
		/*
		 * if (CollectionUtils.isEmpty(resourceIdList)) { return ""; }
		 * StringBuilder s = new StringBuilder(); for (Long resourceId :
		 * resourceIdList) { s.append(resourceId); s.append(","); } return
		 * s.toString();
		 */

		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		/*
		 * if (StringUtils.isEmpty(resourceIds)) { return; } String[]
		 * resourceIdStrs = resourceIds.split(","); for (String resourceIdStr :
		 * resourceIdStrs) { if (StringUtils.isEmpty(resourceIdStr)) { continue;
		 * } getResourceIdList().add(Long.valueOf(resourceIdStr)); }
		 */

		this.resourceIds = resourceIds;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Role role = (Role) o;

		if (id != null ? !id.equals(role.id) : role.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Role{" + "id=" + id + ", rolecode='" + rolecode + '\''
				+ ", description='" + description + '\'' + ", resourceIds="
				+ resourceIds + ", available=" + available + '}';
	}
}
