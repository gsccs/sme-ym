package com.gsccs.sme.solr.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse.Suggestion;
import org.apache.solr.common.SolrDocumentList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class SolrClient {

	
	//private String host;
	private SolrServer server;
	
	private static String DEFAULT_URL = "http://127.0.0.1:8983/solr/";
	//private static final String DEFAULT_URL = "http://192.168.72.129:8983/solr/";
	//private static final String DEFAULT_URL = "http://10.209.1.131:8983/solr/";

	public void init() {
		server = new HttpSolrServer(DEFAULT_URL);
	}
	
	public void init(String url) {
		DEFAULT_URL = url;
		server = new HttpSolrServer(DEFAULT_URL);
	}

	public void destory() {
		server = null;
		System.runFinalization();
		System.gc();
	}

	public final void fail(Object o) {
		System.out.println(o);
	}

	/**
	 * 测试是否创建server对象成功
	 * 
	 */
	public void server() {
		fail(server);
	}


	/**
	 * 处理查询条件
	 * 
	 * @param query
	 * @param param
	 */
	private void prefixParam(SolrQuery query, QueryParam param) {
		// 分站点查询
		if (StringUtils.isNotEmpty(param.getSiteId())) {
			query.addFilterQuery("siteid:" + param.getSiteId());
		}

		//
		if (StringUtils.isNotEmpty(param.getKeyword())) {
			query.addFilterQuery("title:" + param.getKeyword());
		}

		if (StringUtils.isNotEmpty(param.getCateId())) {
			query.addFilterQuery("cateid:" + param.getCateId());
		}

	}

	/**
	 * 查询列表
	 * 
	 * @param param
	 */
	public JSONArray queryRecord(QueryParam param) {
		SolrQuery query = new SolrQuery("*:*");
		// 处理查询参数
		prefixParam(query, param);
		// 分页
		query.set("start", param.getStart());
		query.set("rows", param.getRows());

		// 排序
		query.set("sort", param.getOrder());
		QueryResponse response;

		try {
			response = server.query(query);
			// 输出查询结果集
			SolrDocumentList list = response.getResults();
			return (JSONArray) JSON.toJSON(list);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 属性分组
	 * 
	 * @return
	 */
	public JSONObject queryFacet(QueryParam param) {
		JSONObject json = new JSONObject();
		SolrQuery query = new SolrQuery("*:*");
		query.setFacet(true).setFacetMinCount(1)
				// .setFacetLimit(5)
				.addFacetField("catestr");

		// 处理查询参数
		prefixParam(query, param);

		try {
			List<Count> cateFacets = new ArrayList<FacetField.Count>();
			QueryResponse response = server.query(query);
			long total = response.getResults().getNumFound();
			// 输出分片信息
			List<FacetField> facets = response.getFacetFields();
			for (FacetField facet : facets) {
				// 类目项
				if (facet.getName().equals("catestr")) {
					cateFacets = facet.getValues();
					//System.out.println(facet.getName()+"|"+facet.getValues());
					//json.put(facet.getName(), facet.getValues());
				}
			}

			List<Map<String, Object>> cateList = new ArrayList<Map<String, Object>>();
			if (cateFacets.size() > 0) {
				Map<String, Object> map = null;
				for (Count c : cateFacets) {
					//System.out.println(c.getName()+"|"+c.getCount());
					map = new HashMap<String, Object>();
					if (StringUtils.isNotEmpty(c.getName())
							&& c.getName().split("-").length > 1) {
						map.put("id", c.getName().split("-")[0]);
						map.put("title", c.getName().split("-")[1]+ "(" + c.getCount()
								+ ")");
						cateList.add(map);
					}
				}
			}

			if (null != cateList) {
				json.put("cate_facts", cateList);
			}
			
			json.put("total",total);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

	public void remove() {
		try {
			// 删除id为1的索引
			server.deleteByQuery("*:*");
			server.commit();

			/*
			 * // 根据id集合，删除多个索引 List<String> ids = new ArrayList<String>();
			 * ids.add("2"); ids.add("3"); server.deleteById(ids);
			 * server.commit(true, true); query("id:3 id:2");
			 * 
			 * // 删除查询到的索引信息 server.deleteByQuery("id:4 id:6");
			 * server.commit(true, true);
			 */
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 自动补全功能
	 * 
	 * @param word
	 * @return
	 */
	public List<String> suggest(String word) {

		List<String> wordList = new ArrayList<String>();

		SolrQuery query = new SolrQuery();
		query.set("q", "name_autocomplete:" + word);// 查询的词
		query.set("qt", "/suggest");// 请求到suggest中
		query.set("spellcheck.count", "10");// 返回数量
		QueryResponse rsp;
		try {
			rsp = server.query(query);
			SpellCheckResponse re = rsp.getSpellCheckResponse();// 获取拼写检查的结果集
			if (re != null) {
				for (Suggestion s : re.getSuggestions()) {
					List<String> list = s.getAlternatives();// 获取所有 的检索词
					for (String spellWord : list) {
						wordList.add(spellWord);
					}
					return wordList;// 建议词汇
				}
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String args[]){
		SolrClient client = new SolrClient();
		client.init();
		//client.remove();
		
		QueryParam queryParam = new QueryParam();
		queryParam.setPage(1);
		queryParam.setRows(100);
		//queryParam.setSiteId("0");
		queryParam.setKeyword("产能");
		JSONArray records = client.queryRecord(queryParam);
		System.out.println(records);
		JSON facets = client.queryFacet(queryParam);
		System.out.println(facets);
	}
	

}
