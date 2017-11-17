package com.gsccs.sme.plat.auth.service;

import java.util.List;

import com.gsccs.sme.plat.auth.model.Config;

public interface ConfigService {

	
	/**
	 * 查询所有系统配置项目
	 * 
	 * @return
	 */
	public List<Config> find();
	public List<Config> find(Config conf,int currPage, int pageSize);
	
	/**
	 * 查询指定编码配置
	 * 
	 * @return
	 */
	public Config findByCode(String code);
	
	/**
	 * 查询指定编码配置并以分隔符处理数组
	 * 
	 * @return
	 */
	public String[] findArrayByCode(String code, String split);
	
	
	/**
	 * 更新配置项
	 * 
	 * @param code
	 * @param configvalue
	 */
	public void update(String code, String configvalue);
	
	public int count(Config conf);
	
	
}
