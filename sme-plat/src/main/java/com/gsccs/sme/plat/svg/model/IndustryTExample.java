package com.gsccs.sme.plat.svg.model;

import java.util.ArrayList;
import java.util.List;

import com.gsccs.sme.plat.bass.BaseExample;

public class IndustryTExample extends BaseExample {

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public IndustryTExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sme_industry
	 * 
	 * @mbggenerated Thu Mar 03 21:25:32 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sme_industry
	 * 
	 * @mbggenerated Thu Mar 03 21:25:32 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sme_industry
	 * 
	 * @mbggenerated Thu Mar 03 21:25:32 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sme_industry
	 * 
	 * @mbggenerated Thu Mar 03 21:25:32 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sme_industry
	 * 
	 * @mbggenerated Thu Mar 03 21:25:32 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sme_industry
	 * 
	 * @mbggenerated Thu Mar 03 21:25:32 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sme_industry
	 * 
	 * @mbggenerated Thu Mar 03 21:25:32 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table sme_industry
	 * 
	 * @mbggenerated Thu Mar 03 21:25:32 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table sme_industry
	 * 
	 * @mbggenerated Thu Mar 03 21:25:32 CST 2016
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andParidIsNull() {
			addCriterion("parid is null");
			return (Criteria) this;
		}

		public Criteria andParidIsNotNull() {
			addCriterion("parid is not null");
			return (Criteria) this;
		}

		public Criteria andParidEqualTo(Long value) {
			addCriterion("parid =", value, "parid");
			return (Criteria) this;
		}

		public Criteria andParidNotEqualTo(Long value) {
			addCriterion("parid <>", value, "parid");
			return (Criteria) this;
		}

		public Criteria andParidGreaterThan(Long value) {
			addCriterion("parid >", value, "parid");
			return (Criteria) this;
		}

		public Criteria andParidGreaterThanOrEqualTo(Long value) {
			addCriterion("parid >=", value, "parid");
			return (Criteria) this;
		}

		public Criteria andParidLessThan(Long value) {
			addCriterion("parid <", value, "parid");
			return (Criteria) this;
		}

		public Criteria andParidLessThanOrEqualTo(Long value) {
			addCriterion("parid <=", value, "parid");
			return (Criteria) this;
		}

		public Criteria andParidIn(List<Long> values) {
			addCriterion("parid in", values, "parid");
			return (Criteria) this;
		}

		public Criteria andParidNotIn(List<Long> values) {
			addCriterion("parid not in", values, "parid");
			return (Criteria) this;
		}

		public Criteria andParidBetween(Long value1, Long value2) {
			addCriterion("parid between", value1, value2, "parid");
			return (Criteria) this;
		}

		public Criteria andParidNotBetween(Long value1, Long value2) {
			addCriterion("parid not between", value1, value2, "parid");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andCodeIsNull() {
			addCriterion("code is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("code is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("code =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("code <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("code >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("code >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("code <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("code <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("code like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("code not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("code in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("code not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("code between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("code not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(String value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(String value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(String value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(String value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(String value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(String value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLike(String value) {
			addCriterion("state like", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotLike(String value) {
			addCriterion("state not like", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<String> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<String> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(String value1, String value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(String value1, String value2) {
			addCriterion("state not between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andClicknumIsNull() {
			addCriterion("clicknum is null");
			return (Criteria) this;
		}

		public Criteria andClicknumIsNotNull() {
			addCriterion("clicknum is not null");
			return (Criteria) this;
		}

		public Criteria andClicknumEqualTo(Integer value) {
			addCriterion("clicknum =", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumNotEqualTo(Integer value) {
			addCriterion("clicknum <>", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumGreaterThan(Integer value) {
			addCriterion("clicknum >", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumGreaterThanOrEqualTo(Integer value) {
			addCriterion("clicknum >=", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumLessThan(Integer value) {
			addCriterion("clicknum <", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumLessThanOrEqualTo(Integer value) {
			addCriterion("clicknum <=", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumIn(List<Integer> values) {
			addCriterion("clicknum in", values, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumNotIn(List<Integer> values) {
			addCriterion("clicknum not in", values, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumBetween(Integer value1, Integer value2) {
			addCriterion("clicknum between", value1, value2, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumNotBetween(Integer value1, Integer value2) {
			addCriterion("clicknum not between", value1, value2, "clicknum");
			return (Criteria) this;
		}

		public Criteria andPagemarkIsNull() {
			addCriterion("pagemark is null");
			return (Criteria) this;
		}

		public Criteria andPagemarkIsNotNull() {
			addCriterion("pagemark is not null");
			return (Criteria) this;
		}

		public Criteria andPagemarkEqualTo(String value) {
			addCriterion("pagemark =", value, "pagemark");
			return (Criteria) this;
		}

		public Criteria andPagemarkNotEqualTo(String value) {
			addCriterion("pagemark <>", value, "pagemark");
			return (Criteria) this;
		}

		public Criteria andPagemarkLike(String value) {
			addCriterion("pagemark like", value, "pagemark");
			return (Criteria) this;
		}

		public Criteria andPagemarkNotLike(String value) {
			addCriterion("pagemark not like", value, "pagemark");
			return (Criteria) this;
		}

		public Criteria andPagemarkIn(List<String> values) {
			addCriterion("pagemark in", values, "pagemark");
			return (Criteria) this;
		}

		public Criteria andPagemarkNotIn(List<String> values) {
			addCriterion("pagemark not in", values, "pagemark");
			return (Criteria) this;
		}

		public Criteria andPagemarkBetween(String value1, String value2) {
			addCriterion("pagemark between", value1, value2, "pagemark");
			return (Criteria) this;
		}

		public Criteria andPagemarkNotBetween(String value1, String value2) {
			addCriterion("pagemark not between", value1, value2, "pagemark");
			return (Criteria) this;
		}

		public Criteria andIndexnumIsNull() {
			addCriterion("indexnum is null");
			return (Criteria) this;
		}

		public Criteria andIndexnumIsNotNull() {
			addCriterion("indexnum is not null");
			return (Criteria) this;
		}

		public Criteria andIndexnumEqualTo(Integer value) {
			addCriterion("indexnum =", value, "indexnum");
			return (Criteria) this;
		}

		public Criteria andIndexnumNotEqualTo(Integer value) {
			addCriterion("indexnum <>", value, "indexnum");
			return (Criteria) this;
		}

		public Criteria andIndexnumGreaterThan(Integer value) {
			addCriterion("indexnum >", value, "indexnum");
			return (Criteria) this;
		}

		public Criteria andIndexnumGreaterThanOrEqualTo(Integer value) {
			addCriterion("indexnum >=", value, "indexnum");
			return (Criteria) this;
		}

		public Criteria andIndexnumLessThan(Integer value) {
			addCriterion("indexnum <", value, "indexnum");
			return (Criteria) this;
		}

		public Criteria andIndexnumLessThanOrEqualTo(Integer value) {
			addCriterion("indexnum <=", value, "indexnum");
			return (Criteria) this;
		}

		public Criteria andIndexnumIn(List<Integer> values) {
			addCriterion("indexnum in", values, "indexnum");
			return (Criteria) this;
		}

		public Criteria andIndexnumNotIn(List<Integer> values) {
			addCriterion("indexnum not in", values, "indexnum");
			return (Criteria) this;
		}

		public Criteria andIndexnumBetween(Integer value1, Integer value2) {
			addCriterion("indexnum between", value1, value2, "indexnum");
			return (Criteria) this;
		}

		public Criteria andIndexnumNotBetween(Integer value1, Integer value2) {
			addCriterion("indexnum not between", value1, value2, "indexnum");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table sme_industry
	 * 
	 * @mbggenerated do_not_delete_during_merge Thu Mar 03 21:25:32 CST 2016
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table sme_industry
	 * 
	 * @mbggenerated Thu Mar 03 21:25:32 CST 2016
	 */
	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}