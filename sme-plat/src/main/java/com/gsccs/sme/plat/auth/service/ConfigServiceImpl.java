package com.gsccs.sme.plat.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.dao.ConfigMapper;
import com.gsccs.sme.plat.auth.model.Config;
import com.gsccs.sme.plat.auth.model.ConfigExample;
import com.gsccs.sme.plat.auth.model.ConfigExample.Criteria;

/**
 * 系统配置服务类
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private ConfigMapper configMapper;
	@Autowired
	private RedisRepository redisRep;
	
	/**
	 * 平台配置列表
	 */
	private static final String key = "ALL_CONFIG_LIST";

	/**
	 * 查询所有系统配置项目
	 * 
	 * @return
	 */
	public List<Config> find() {
		List<Config> list = null;
		
		if (null != redisRep.getList(key)) {
			list = (List<Config>)redisRep.get(key);
			System.out.println("缓存  "+key+" 命中");
		}else{
			System.out.println("缓存  "+key+" 未命中");
			ConfigExample example = new ConfigExample();
			example.setOrderByClause(" orderNum ");
			list = configMapper.selectByExample(example);
			if (null != list) {
				redisRep.addList(key, list);
			}
		}
		return list;
	}

	/**
	 * 查询指定编码配置
	 * 
	 * @return
	 */
	public Config findByCode(String code) {
		ConfigExample example = new ConfigExample();
		Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(code);
		List<Config> list = configMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 查询指定编码配置并以分隔符处理数组
	 * 
	 * @return
	 */
	public String[] findArrayByCode(String code, String split) {
		ConfigExample example = new ConfigExample();
		Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(code);
		List<Config> list = configMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			Config config = list.get(0);
			if (config.getConfigvalue() != null) {
				if (split.length() > 0) {
					// 有分隔符，以数组形式处理
					return config.getConfigvalue().split(split);
				}
			}
		}
		return null;
	}

	/**
	 * 更新配置项
	 * 
	 * @param code
	 * @param configvalue
	 */
	public void update(String code, String configvalue) {
		Config config = new Config();
		config.setCode(code);
		config.setConfigvalue(configvalue);
		configMapper.updateByCode(config);
	}

	@Override
	public List<Config> find(Config conf, int currPage, int pageSize) {
		ConfigExample example = new ConfigExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(conf,criteria);
		return configMapper.selectByExample(example);
	}

	@Override
	public int count(Config conf) {
		ConfigExample example = new ConfigExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(conf,criteria);
		return configMapper.countByExample(example);
	}
	
	
	public void proSearchParam(Config conf, ConfigExample.Criteria criteria) {

	}

}
