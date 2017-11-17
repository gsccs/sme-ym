package com.gsccs.sme.plat.auth.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.plat.auth.dao.ResourceMapper;
import com.gsccs.sme.plat.auth.model.Resource;
import com.gsccs.sme.plat.auth.model.Resource.ResourceType;
import com.gsccs.sme.plat.auth.model.ResourceExample;
import com.gsccs.sme.plat.auth.model.ResourceExample.Criteria;


@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public Resource createResource(Resource resource) {
		resourceMapper.insert(resource);
		return resourceMapper.selectByPrimaryKey(resource.getId());
	}

	@Override
	public Resource updateResource(Resource resource) {
		resourceMapper.updateByPrimaryKey(resource);
		return resourceMapper.selectByPrimaryKey(resource.getId());
	}

	@Override
	public void deleteResource(Long resourceId) {
		resourceMapper.deleteByPrimaryKey(resourceId);
	}

	@Override
	public Resource findOne(Long resourceId) {
		return resourceMapper.selectByPrimaryKey(resourceId);
	}

	@Override
	public List<Resource> findAll(Resource param) {
		ResourceExample rexample = new ResourceExample();
		Criteria c = rexample.createCriteria();
		if (null != param){
			if (null != param.getType()){
				c.andTypeEqualTo(param.getType().name());
			}
		}
		return resourceMapper.selectByExample(rexample);
	}

	@Override
	public Set<String> findPermissions(Set<Long> resourceIds) {
		Set<String> permissions = new HashSet<String>();
		for (Long resourceId : resourceIds) {
			Resource resource = findOne(resourceId);
			if (resource != null
					&& !StringUtils.isEmpty(resource.getPermission())) {
				permissions.add(resource.getPermission());
			}
		}
		return permissions;
	}

	@Override
	public List<Resource> findMenus(Set<String> permissions) {
		List<Resource> allResources = findAll(null);
		List<Resource> menus = new ArrayList<Resource>();
		for (Resource resource : allResources) {
			if (resource.isRootNode()) {
				continue;
			}
			if (resource.getType() != Resource.ResourceType.menu) {
				continue;
			}
			if (!hasPermission(permissions, resource)) {
				continue;
			}
			menus.add(resource);
		}
		return menus;
	}

	
	
	private boolean hasPermission(Set<String> permissions, Resource resource) {
		if (StringUtils.isEmpty(resource.getPermission())) {
			return true;
		}
		for (String permission : permissions) {
			WildcardPermission p1 = new WildcardPermission(permission);
			WildcardPermission p2 = new WildcardPermission(
					resource.getPermission());
			if (p1.implies(p2) || p2.implies(p1)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Resource> findMenus(Set<String> permissions, Resource param) {
		List<Resource> allResources = findAll(param);
		List<Resource> menus = new ArrayList<Resource>();
		for (Resource resource : allResources) {
			
			if (resource.isRootNode()) {
				continue;
			}
			
			if (resource.getType() != Resource.ResourceType.menu) {
				continue;
			}
			if (!hasPermission(permissions, resource)) {
				continue;
			}
			if (resource.getParentId()==1l) {
				resource.setSubs(findMenus(permissions, allResources, resource));
				menus.add(resource);
			}
		}
		return menus;
	}

	public List<Resource> findMenus(Set<String> permissions,
			List<Resource> allResources, Resource param) {
		if (null == allResources || allResources.size() <= 0) {
			return null;
		}
		List<Resource> menus = new ArrayList<Resource>();
		for (Resource resource : allResources) {

			if (resource.isRootNode()) {
				continue;
			}
			if (resource.getType() != Resource.ResourceType.menu) {
				continue;
			}
			if (!hasPermission(permissions, resource)) {
				continue;
			}

			if (null != resource.getParentId()
					&& resource.getParentId().equals(param.getId())) {
				menus.add(resource);
			}
		}
		return menus;
	}

	@Override
	public List<Resource> findSysMenus(Set<String> permissions,Resource param) {
		List<Resource> allResources = findAll(param);
		if (null != allResources) {
			return treeList(permissions, allResources, 1l);
		}
		return null;
	}

	
	public List<Resource> treeList(Set<String> permissions,
			List<Resource> nodeList, Long parentId) {
		List<Resource> nodearray = new ArrayList<>();
		for (Resource resource : nodeList) {
			if (resource.isRootNode()) {
				continue;
			}
			if (resource.getType() != Resource.ResourceType.menu) {
				continue;
			}
			if (!hasPermission(permissions, resource)) {
				continue;
			}

			long menuId = resource.getId();
			long pid = resource.getParentId();
			if (parentId == pid) {
				List<Resource> subitems = treeList(permissions, nodeList,
						menuId);
				resource.setSubs(subitems);
				nodearray.add(resource);
			}
		}
		return nodearray;
	}
	
	
	
	@Override
	public JSONArray findSysMenuTree() {
		Resource param = new Resource();
		param.setType(ResourceType.menu);
		List<Resource> roots = findAll(param);
		if (null != roots) {
			JSONArray rootArray = (JSONArray) JSON.toJSON(roots);
			return treeList(rootArray, 1l);
		}
		return null;
	}
	
	
	public JSONArray treeList(JSONArray nodeList, Long parentId) {
		JSONArray nodearray = new JSONArray();
		for (Object object : nodeList) {
			JSONObject json = (JSONObject) JSON.toJSON(object);
			long menuId = json.getLong("id");
			long pid = json.getLong("parentId");
			
			json.put("text", json.get("name"));
			if (parentId == pid) {
				JSONArray subitems = treeList(nodeList, menuId);
				json.put("children", subitems);
				nodearray.add(json);
			}
		}
		return nodearray;
	}
}
