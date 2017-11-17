package com.gsccs.sme.plat.shop.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.plat.shop.dao.CategoryTMapper;
import com.gsccs.sme.plat.shop.model.CategoryT;
import com.gsccs.sme.plat.shop.model.CategoryTExample;

/**
 * 产品分类业务
 * 
 * @author x.d zhang
 * 
 */
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryTMapper categoryTMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public CategoryT findById(Long id) {
		return categoryTMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加卖家账号
	 */
	@Override
	public void insert(CategoryT sclassT) {
		if (null != sclassT) {
			categoryTMapper.insert(sclassT);
		}
	}

	/**
	 * 修改卖家账号
	 */
	@Override
	public void update(CategoryT sclassT) {
		categoryTMapper.updateByPrimaryKey(sclassT);
	}

	@Override
	public int count(CategoryT sclassT) {
		CategoryTExample example = new CategoryTExample();
		CategoryTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sclassT, criteria);
		return categoryTMapper.countByExample(example);
	}

	@Override
	public List<CategoryT> find(CategoryT sclassT, String orderstr, int page,
			int pagesize) {
		CategoryTExample example = new CategoryTExample();
		CategoryTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sclassT, criteria);
		return categoryTMapper.selectByExample(example);
	}

	@Override
	public List<CategoryT> find(CategoryT sclassT) {
		CategoryTExample example = new CategoryTExample();
		CategoryTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sclassT, criteria);
		return categoryTMapper.selectByExample(example);
	}

	@Override
	public void delSclass(Long id) {
		categoryTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<CategoryT> findSubCategory(Long parid) {
		if (null != parid) {
			CategoryT sclassT = new CategoryT();
			sclassT.setParid(parid);
			CategoryTExample example = new CategoryTExample();
			CategoryTExample.Criteria criteria = example.createCriteria();
			proSearchParam(sclassT, criteria);
			return categoryTMapper.selectByExample(example);
		}
		return null;
	}

	public void proSearchParam(CategoryT sclassT,
			CategoryTExample.Criteria criteria) {
		if (null != sclassT) {
			if (StringUtils.isNotEmpty(sclassT.getTitle())) {
				criteria.andTitleLike("%" + sclassT.getTitle() + "%");
			}
			if (null != sclassT.getParid()) {
				criteria.andParidEqualTo(sclassT.getParid());
			}
			if (null != sclassT.getParids()) {
				criteria.andParidsLike("%" + sclassT.getParids() + "%");
			}
		}
	}

	@Override
	public List<CategoryT> findByParids(String parids) {
		if (null != parids) {
			CategoryT sclassT = new CategoryT();
			sclassT.setParids(parids);
			CategoryTExample example = new CategoryTExample();
			CategoryTExample.Criteria criteria = example.createCriteria();
			proSearchParam(sclassT, criteria);
			return categoryTMapper.selectByExample(example);
		}
		return null;
	}

	@Override
	public JSONArray findCategoryTree() {
		List<CategoryT> roots = find(null);
		if (null != roots) {
			JSONArray rootArray = (JSONArray) JSON.toJSON(roots);
			return treeList(rootArray, 0l);
		}
		return null;
	}

	public JSONArray treeList(JSONArray nodeList, Long parentId) {
		JSONArray nodearray = new JSONArray();
		for (Object object : nodeList) {
			JSONObject json = (JSONObject) JSON.toJSON(object);
			long menuId = json.getLong("id");
			long pid = json.getLong("parid");
			json.put("text", json.get("title"));
			if (parentId == pid) {
				JSONArray subitems = treeList(nodeList, menuId);
				json.put("children", subitems);
				nodearray.add(json);
			}
		}
		return nodearray;
	}
}
