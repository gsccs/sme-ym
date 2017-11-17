package com.gsccs.sme.plat.auth.model;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: x.d zhang
 * Date: 14-3-13
 * Version: 1.0
 */
public class Authorization implements Serializable {
	
	private Long id;
	private Long userId;
	private Long appId;
	private String roleIds;
	private List<Long> roleIdList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public List<Long> getRoleIdList() {
		if (roleIdList == null) {
			roleIdList = new ArrayList<Long>();
		}
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public String getRoleIds() {
		if (CollectionUtils.isEmpty(roleIdList)) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for (Long roleId : roleIdList) {
			s.append(roleId);
			s.append(",");
		}
		return s.toString();
	}

	public void setRoleIds(String roleIds) {
		if (StringUtils.isEmpty(roleIds)) {
			return;
		}
		String[] roleIdStrs = roleIds.split(",");
		for (String roleIdStr : roleIdStrs) {
			if (StringUtils.isEmpty(roleIdStr)) {
				continue;
			}
			getRoleIdList().add(Long.valueOf(roleIdStr));
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Authorization that = (Authorization) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Authorization{" + "id=" + id + ", userId=" + userId
				+ ", appId=" + appId + ", roleIds=" + roleIds + '}';
	}
}
