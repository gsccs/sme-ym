package com.gsccs.sme.plat.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Repository for key/value pairs of type String/Object.
 * 
 * @author x.d zhang
 */
@Service
public class RedisRepository<T> {

	@Autowired
	private RedisTemplate<String, T> template;

	public void add(String key, T t) {
		template.opsForValue().set(key, t);
	}

	public T get(String key) {
		return template.opsForValue().get(key);
	}

	public void addList(String key, List<T> list) {
		if (null != list && list.size() > 0) {
			for (T t : list) {
				template.opsForList().rightPush(key, t);
			}
		}
	}

	public List<T> getList(String key) {
		List<T> list = null;
		long size = template.opsForList().size(key);
		if (size > 0) {
			list = new ArrayList<T>();
			for (long i = 0; i < size; i++) {
				T t = template.opsForList().leftPop(key);
				list.add(t);
			}
		}
		return list;
	}

}
