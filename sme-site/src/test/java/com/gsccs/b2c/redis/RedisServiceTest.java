package com.gsccs.b2c.redis;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.CacheConst;
import com.gsccs.sme.api.domain.PorderItem;
import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.shiro.redis.SerializeUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class RedisServiceTest {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private RedisTemplate ssdbTemplate;
	
	
	//@Test
	public void redisDelList(){
		String key = "SITE_NAV_LIST_1001";
		System.out.println("start:"+redisTemplate.boundListOps(key).size());
		redisTemplate.delete(key);
		System.out.println("start:"+redisTemplate.boundListOps(key).size());
	}
	
	
	//@Test
	public void ssdnDelList(){
		final String key="CART_LIST_1001_admin";
		System.out.println("start:"+ssdbTemplate.boundListOps(key).size());
		
		PorderItem item = (PorderItem) ssdbTemplate.boundListOps(key).index(0);
		System.out.println(item.getId());
		ssdbTemplate.delete(key);
		//ssdbTemplate.boundListOps(key)
		//ssdbTemplate.opsForList().remove(key, 1, item);
		ssdbTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.del(SerializeUtils.serialize(key));
				return null;
			}
		});
		
		System.out.println("end:"+ssdbTemplate.boundListOps(key).size());
	}

	//@Test
	public void addListObject() {
		List<Itemtype> cateList = new ArrayList<Itemtype>();
		Itemtype c1 = new Itemtype();
		c1.setId(Long.valueOf(1));
		Itemtype c2 = new Itemtype();
		c2.setId(Long.valueOf(2));
		Itemtype c3 = new Itemtype();
		c3.setId(Long.valueOf(3));

		ListOperations<String, Itemtype> ops = redisTemplate.opsForList();
		ops.rightPush("c-list", c1);
		ops.rightPush("c-list", c2);
		ops.rightPush("c-list", c3);
	}

	//@Test
	public void getListObject() {
		ListOperations<String, Itemtype> ops = redisTemplate.opsForList();
		List<Itemtype> cateList = ops.range("c-list", 0, -1);
		for (Itemtype c : cateList) {
			System.out.println(c.getId());
		}
	}
	
	
	//@Test
	public void addHashObject() {
		Itemtype c7 = new Itemtype();
		c7.setId(Long.valueOf(7));
		c7.setTitle("7");
		Writer out = new StringWriter();
		try {
			out.append("一开始以为Spring下操作哈希表，列表，真就是那么土。恍惚间发现“stringRedisTemplate.opsForList()”的强大，抓紧时间恶补下。酷"
			+ "相关链接："
			+ "征服 Redis"
			+ "征服 Redis + Jedis"
			+ "征服 Redis + Jedis + Spring （一）—— 配置&常规操作（GET SET DEL）"
			+ "征服 Redis + Jedis + Spring （二）—— 哈希表操作（HMGET HMSET）"
			+ "征服 Redis + Jedis + Spring （三）—— 列表操作");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		ops.set("1001:index_html", out.toString());
		String out_ = ops.get("1001:index_html");
		System.out.println(out_);
		
		/*ValueOperations<String, Category> ops = redisTemplate.opsForValue();
		ops.set("1001:index_html", c7);
		Category out_ = ops.get("1001:index_html");
		System.out.println(out_.getTitle());*/
	}
	
	@Test
	public void getProductImgs() {
		Long sid = 1001l;
		Long pid = 251l;
		JSONArray jsonArray = (JSONArray) ssdbTemplate.boundValueOps(
				CacheConst.PRODUCT_IMG_LIST_ + sid + "_" + pid).get();

		if (null == jsonArray || jsonArray.size() <= 0) {
			jsonArray = new JSONArray();
			for (int i = 0; i < 5; i++) {
				JSONObject json = new JSONObject();
				json.put("url", "http://cdn.titles.top/pic/product-" + i + ".jpg");
				jsonArray.add(json);
			}
			System.out.println("cache is not null");
		} else {
			System.out.println("cache is null");
			try {
				/*List<ProductImg> goodsImgs = goodsAPI.getProductByPid(sid, pid);
				if (null == goodsImgs || goodsImgs.size() <= 0) {
					for (int i = 0; i < 5; i++) {
						JSONObject json = new JSONObject();
						json.put("url", "http://cdn.titles.top/pic/product-" + i
								+ ".jpg");
						jsonArray.add(json);
					}
				} else {
					for (ProductImg img : goodsImgs) {
						JSONObject json = new JSONObject();
						json.put("url", img.getUrl());
						jsonArray.add(json);
					}
					ssdbTemplate.boundValueOps(
							CacheConst.PRODUCT_IMG_LIST_ + sid + "_" + pid)
							.set(jsonArray);
					ssdbTemplate.boundValueOps(
							CacheConst.PRODUCT_IMG_LIST_ + sid + "_" + pid).expireAt(new Date());
				}*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//return jsonArray;
	}
}
