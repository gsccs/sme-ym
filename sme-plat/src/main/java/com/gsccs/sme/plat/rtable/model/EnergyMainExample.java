package com.gsccs.sme.plat.rtable.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gsccs.sme.plat.bass.BaseExample;

public class EnergyMainExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnergyMainExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMainIdIsNull() {
            addCriterion("main_id is null");
            return (Criteria) this;
        }

        public Criteria andMainIdIsNotNull() {
            addCriterion("main_id is not null");
            return (Criteria) this;
        }

        public Criteria andMainIdEqualTo(String value) {
            addCriterion("main_id =", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdNotEqualTo(String value) {
            addCriterion("main_id <>", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdGreaterThan(String value) {
            addCriterion("main_id >", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdGreaterThanOrEqualTo(String value) {
            addCriterion("main_id >=", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdLessThan(String value) {
            addCriterion("main_id <", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdLessThanOrEqualTo(String value) {
            addCriterion("main_id <=", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdLike(String value) {
            addCriterion("main_id like", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdNotLike(String value) {
            addCriterion("main_id not like", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdIn(List<String> values) {
            addCriterion("main_id in", values, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdNotIn(List<String> values) {
            addCriterion("main_id not in", values, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdBetween(String value1, String value2) {
            addCriterion("main_id between", value1, value2, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdNotBetween(String value1, String value2) {
            addCriterion("main_id not between", value1, value2, "mainId");
            return (Criteria) this;
        }

        public Criteria andCorpidIsNull() {
            addCriterion("corpid is null");
            return (Criteria) this;
        }

        public Criteria andCorpidIsNotNull() {
            addCriterion("corpid is not null");
            return (Criteria) this;
        }

        public Criteria andCorpidEqualTo(Long value) {
            addCriterion("corpid =", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotEqualTo(Long value) {
            addCriterion("corpid <>", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidGreaterThan(Long value) {
            addCriterion("corpid >", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidGreaterThanOrEqualTo(Long value) {
            addCriterion("corpid >=", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidLessThan(Long value) {
            addCriterion("corpid <", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidLessThanOrEqualTo(Long value) {
            addCriterion("corpid <=", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidIn(List<Long> values) {
            addCriterion("corpid in", values, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotIn(List<Long> values) {
            addCriterion("corpid not in", values, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidBetween(Long value1, Long value2) {
            addCriterion("corpid between", value1, value2, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotBetween(Long value1, Long value2) {
            addCriterion("corpid not between", value1, value2, "corpid");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNull() {
            addCriterion("startdate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startdate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(Date value) {
            addCriterion("startdate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(Date value) {
            addCriterion("startdate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(Date value) {
            addCriterion("startdate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("startdate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(Date value) {
            addCriterion("startdate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(Date value) {
            addCriterion("startdate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<Date> values) {
            addCriterion("startdate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<Date> values) {
            addCriterion("startdate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(Date value1, Date value2) {
            addCriterion("startdate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(Date value1, Date value2) {
            addCriterion("startdate not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andQyIndustryIsNull() {
            addCriterion("qy_industry is null");
            return (Criteria) this;
        }

        public Criteria andQyIndustryIsNotNull() {
            addCriterion("qy_industry is not null");
            return (Criteria) this;
        }

        public Criteria andQyIndustryEqualTo(String value) {
            addCriterion("qy_industry =", value, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryNotEqualTo(String value) {
            addCriterion("qy_industry <>", value, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryGreaterThan(String value) {
            addCriterion("qy_industry >", value, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("qy_industry >=", value, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryLessThan(String value) {
            addCriterion("qy_industry <", value, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryLessThanOrEqualTo(String value) {
            addCriterion("qy_industry <=", value, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryLike(String value) {
            addCriterion("qy_industry like", value, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryNotLike(String value) {
            addCriterion("qy_industry not like", value, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryIn(List<String> values) {
            addCriterion("qy_industry in", values, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryNotIn(List<String> values) {
            addCriterion("qy_industry not in", values, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryBetween(String value1, String value2) {
            addCriterion("qy_industry between", value1, value2, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andQyIndustryNotBetween(String value1, String value2) {
            addCriterion("qy_industry not between", value1, value2, "qyIndustry");
            return (Criteria) this;
        }

        public Criteria andIndustryAllIsNull() {
            addCriterion("industry_all is null");
            return (Criteria) this;
        }

        public Criteria andIndustryAllIsNotNull() {
            addCriterion("industry_all is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryAllEqualTo(String value) {
            addCriterion("industry_all =", value, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllNotEqualTo(String value) {
            addCriterion("industry_all <>", value, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllGreaterThan(String value) {
            addCriterion("industry_all >", value, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllGreaterThanOrEqualTo(String value) {
            addCriterion("industry_all >=", value, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllLessThan(String value) {
            addCriterion("industry_all <", value, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllLessThanOrEqualTo(String value) {
            addCriterion("industry_all <=", value, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllLike(String value) {
            addCriterion("industry_all like", value, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllNotLike(String value) {
            addCriterion("industry_all not like", value, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllIn(List<String> values) {
            addCriterion("industry_all in", values, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllNotIn(List<String> values) {
            addCriterion("industry_all not in", values, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllBetween(String value1, String value2) {
            addCriterion("industry_all between", value1, value2, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAllNotBetween(String value1, String value2) {
            addCriterion("industry_all not between", value1, value2, "industryAll");
            return (Criteria) this;
        }

        public Criteria andIndustryAddIsNull() {
            addCriterion("industry_add is null");
            return (Criteria) this;
        }

        public Criteria andIndustryAddIsNotNull() {
            addCriterion("industry_add is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryAddEqualTo(String value) {
            addCriterion("industry_add =", value, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddNotEqualTo(String value) {
            addCriterion("industry_add <>", value, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddGreaterThan(String value) {
            addCriterion("industry_add >", value, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddGreaterThanOrEqualTo(String value) {
            addCriterion("industry_add >=", value, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddLessThan(String value) {
            addCriterion("industry_add <", value, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddLessThanOrEqualTo(String value) {
            addCriterion("industry_add <=", value, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddLike(String value) {
            addCriterion("industry_add like", value, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddNotLike(String value) {
            addCriterion("industry_add not like", value, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddIn(List<String> values) {
            addCriterion("industry_add in", values, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddNotIn(List<String> values) {
            addCriterion("industry_add not in", values, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddBetween(String value1, String value2) {
            addCriterion("industry_add between", value1, value2, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andIndustryAddNotBetween(String value1, String value2) {
            addCriterion("industry_add not between", value1, value2, "industryAdd");
            return (Criteria) this;
        }

        public Criteria andAIsNull() {
            addCriterion("a is null");
            return (Criteria) this;
        }

        public Criteria andAIsNotNull() {
            addCriterion("a is not null");
            return (Criteria) this;
        }

        public Criteria andAEqualTo(String value) {
            addCriterion("a =", value, "a");
            return (Criteria) this;
        }

        public Criteria andANotEqualTo(String value) {
            addCriterion("a <>", value, "a");
            return (Criteria) this;
        }

        public Criteria andAGreaterThan(String value) {
            addCriterion("a >", value, "a");
            return (Criteria) this;
        }

        public Criteria andAGreaterThanOrEqualTo(String value) {
            addCriterion("a >=", value, "a");
            return (Criteria) this;
        }

        public Criteria andALessThan(String value) {
            addCriterion("a <", value, "a");
            return (Criteria) this;
        }

        public Criteria andALessThanOrEqualTo(String value) {
            addCriterion("a <=", value, "a");
            return (Criteria) this;
        }

        public Criteria andALike(String value) {
            addCriterion("a like", value, "a");
            return (Criteria) this;
        }

        public Criteria andANotLike(String value) {
            addCriterion("a not like", value, "a");
            return (Criteria) this;
        }

        public Criteria andAIn(List<String> values) {
            addCriterion("a in", values, "a");
            return (Criteria) this;
        }

        public Criteria andANotIn(List<String> values) {
            addCriterion("a not in", values, "a");
            return (Criteria) this;
        }

        public Criteria andABetween(String value1, String value2) {
            addCriterion("a between", value1, value2, "a");
            return (Criteria) this;
        }

        public Criteria andANotBetween(String value1, String value2) {
            addCriterion("a not between", value1, value2, "a");
            return (Criteria) this;
        }

        public Criteria andBIsNull() {
            addCriterion("b is null");
            return (Criteria) this;
        }

        public Criteria andBIsNotNull() {
            addCriterion("b is not null");
            return (Criteria) this;
        }

        public Criteria andBEqualTo(String value) {
            addCriterion("b =", value, "b");
            return (Criteria) this;
        }

        public Criteria andBNotEqualTo(String value) {
            addCriterion("b <>", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThan(String value) {
            addCriterion("b >", value, "b");
            return (Criteria) this;
        }

        public Criteria andBGreaterThanOrEqualTo(String value) {
            addCriterion("b >=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThan(String value) {
            addCriterion("b <", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLessThanOrEqualTo(String value) {
            addCriterion("b <=", value, "b");
            return (Criteria) this;
        }

        public Criteria andBLike(String value) {
            addCriterion("b like", value, "b");
            return (Criteria) this;
        }

        public Criteria andBNotLike(String value) {
            addCriterion("b not like", value, "b");
            return (Criteria) this;
        }

        public Criteria andBIn(List<String> values) {
            addCriterion("b in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBNotIn(List<String> values) {
            addCriterion("b not in", values, "b");
            return (Criteria) this;
        }

        public Criteria andBBetween(String value1, String value2) {
            addCriterion("b between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andBNotBetween(String value1, String value2) {
            addCriterion("b not between", value1, value2, "b");
            return (Criteria) this;
        }

        public Criteria andCIsNull() {
            addCriterion("c is null");
            return (Criteria) this;
        }

        public Criteria andCIsNotNull() {
            addCriterion("c is not null");
            return (Criteria) this;
        }

        public Criteria andCEqualTo(String value) {
            addCriterion("c =", value, "c");
            return (Criteria) this;
        }

        public Criteria andCNotEqualTo(String value) {
            addCriterion("c <>", value, "c");
            return (Criteria) this;
        }

        public Criteria andCGreaterThan(String value) {
            addCriterion("c >", value, "c");
            return (Criteria) this;
        }

        public Criteria andCGreaterThanOrEqualTo(String value) {
            addCriterion("c >=", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLessThan(String value) {
            addCriterion("c <", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLessThanOrEqualTo(String value) {
            addCriterion("c <=", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLike(String value) {
            addCriterion("c like", value, "c");
            return (Criteria) this;
        }

        public Criteria andCNotLike(String value) {
            addCriterion("c not like", value, "c");
            return (Criteria) this;
        }

        public Criteria andCIn(List<String> values) {
            addCriterion("c in", values, "c");
            return (Criteria) this;
        }

        public Criteria andCNotIn(List<String> values) {
            addCriterion("c not in", values, "c");
            return (Criteria) this;
        }

        public Criteria andCBetween(String value1, String value2) {
            addCriterion("c between", value1, value2, "c");
            return (Criteria) this;
        }

        public Criteria andCNotBetween(String value1, String value2) {
            addCriterion("c not between", value1, value2, "c");
            return (Criteria) this;
        }

        public Criteria andDIsNull() {
            addCriterion("d is null");
            return (Criteria) this;
        }

        public Criteria andDIsNotNull() {
            addCriterion("d is not null");
            return (Criteria) this;
        }

        public Criteria andDEqualTo(String value) {
            addCriterion("d =", value, "d");
            return (Criteria) this;
        }

        public Criteria andDNotEqualTo(String value) {
            addCriterion("d <>", value, "d");
            return (Criteria) this;
        }

        public Criteria andDGreaterThan(String value) {
            addCriterion("d >", value, "d");
            return (Criteria) this;
        }

        public Criteria andDGreaterThanOrEqualTo(String value) {
            addCriterion("d >=", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLessThan(String value) {
            addCriterion("d <", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLessThanOrEqualTo(String value) {
            addCriterion("d <=", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLike(String value) {
            addCriterion("d like", value, "d");
            return (Criteria) this;
        }

        public Criteria andDNotLike(String value) {
            addCriterion("d not like", value, "d");
            return (Criteria) this;
        }

        public Criteria andDIn(List<String> values) {
            addCriterion("d in", values, "d");
            return (Criteria) this;
        }

        public Criteria andDNotIn(List<String> values) {
            addCriterion("d not in", values, "d");
            return (Criteria) this;
        }

        public Criteria andDBetween(String value1, String value2) {
            addCriterion("d between", value1, value2, "d");
            return (Criteria) this;
        }

        public Criteria andDNotBetween(String value1, String value2) {
            addCriterion("d not between", value1, value2, "d");
            return (Criteria) this;
        }

        public Criteria andEIsNull() {
            addCriterion("e is null");
            return (Criteria) this;
        }

        public Criteria andEIsNotNull() {
            addCriterion("e is not null");
            return (Criteria) this;
        }

        public Criteria andEEqualTo(String value) {
            addCriterion("e =", value, "e");
            return (Criteria) this;
        }

        public Criteria andENotEqualTo(String value) {
            addCriterion("e <>", value, "e");
            return (Criteria) this;
        }

        public Criteria andEGreaterThan(String value) {
            addCriterion("e >", value, "e");
            return (Criteria) this;
        }

        public Criteria andEGreaterThanOrEqualTo(String value) {
            addCriterion("e >=", value, "e");
            return (Criteria) this;
        }

        public Criteria andELessThan(String value) {
            addCriterion("e <", value, "e");
            return (Criteria) this;
        }

        public Criteria andELessThanOrEqualTo(String value) {
            addCriterion("e <=", value, "e");
            return (Criteria) this;
        }

        public Criteria andELike(String value) {
            addCriterion("e like", value, "e");
            return (Criteria) this;
        }

        public Criteria andENotLike(String value) {
            addCriterion("e not like", value, "e");
            return (Criteria) this;
        }

        public Criteria andEIn(List<String> values) {
            addCriterion("e in", values, "e");
            return (Criteria) this;
        }

        public Criteria andENotIn(List<String> values) {
            addCriterion("e not in", values, "e");
            return (Criteria) this;
        }

        public Criteria andEBetween(String value1, String value2) {
            addCriterion("e between", value1, value2, "e");
            return (Criteria) this;
        }

        public Criteria andENotBetween(String value1, String value2) {
            addCriterion("e not between", value1, value2, "e");
            return (Criteria) this;
        }

        public Criteria andFIsNull() {
            addCriterion("f is null");
            return (Criteria) this;
        }

        public Criteria andFIsNotNull() {
            addCriterion("f is not null");
            return (Criteria) this;
        }

        public Criteria andFEqualTo(String value) {
            addCriterion("f =", value, "f");
            return (Criteria) this;
        }

        public Criteria andFNotEqualTo(String value) {
            addCriterion("f <>", value, "f");
            return (Criteria) this;
        }

        public Criteria andFGreaterThan(String value) {
            addCriterion("f >", value, "f");
            return (Criteria) this;
        }

        public Criteria andFGreaterThanOrEqualTo(String value) {
            addCriterion("f >=", value, "f");
            return (Criteria) this;
        }

        public Criteria andFLessThan(String value) {
            addCriterion("f <", value, "f");
            return (Criteria) this;
        }

        public Criteria andFLessThanOrEqualTo(String value) {
            addCriterion("f <=", value, "f");
            return (Criteria) this;
        }

        public Criteria andFLike(String value) {
            addCriterion("f like", value, "f");
            return (Criteria) this;
        }

        public Criteria andFNotLike(String value) {
            addCriterion("f not like", value, "f");
            return (Criteria) this;
        }

        public Criteria andFIn(List<String> values) {
            addCriterion("f in", values, "f");
            return (Criteria) this;
        }

        public Criteria andFNotIn(List<String> values) {
            addCriterion("f not in", values, "f");
            return (Criteria) this;
        }

        public Criteria andFBetween(String value1, String value2) {
            addCriterion("f between", value1, value2, "f");
            return (Criteria) this;
        }

        public Criteria andFNotBetween(String value1, String value2) {
            addCriterion("f not between", value1, value2, "f");
            return (Criteria) this;
        }

        public Criteria andGIsNull() {
            addCriterion("g is null");
            return (Criteria) this;
        }

        public Criteria andGIsNotNull() {
            addCriterion("g is not null");
            return (Criteria) this;
        }

        public Criteria andGEqualTo(String value) {
            addCriterion("g =", value, "g");
            return (Criteria) this;
        }

        public Criteria andGNotEqualTo(String value) {
            addCriterion("g <>", value, "g");
            return (Criteria) this;
        }

        public Criteria andGGreaterThan(String value) {
            addCriterion("g >", value, "g");
            return (Criteria) this;
        }

        public Criteria andGGreaterThanOrEqualTo(String value) {
            addCriterion("g >=", value, "g");
            return (Criteria) this;
        }

        public Criteria andGLessThan(String value) {
            addCriterion("g <", value, "g");
            return (Criteria) this;
        }

        public Criteria andGLessThanOrEqualTo(String value) {
            addCriterion("g <=", value, "g");
            return (Criteria) this;
        }

        public Criteria andGLike(String value) {
            addCriterion("g like", value, "g");
            return (Criteria) this;
        }

        public Criteria andGNotLike(String value) {
            addCriterion("g not like", value, "g");
            return (Criteria) this;
        }

        public Criteria andGIn(List<String> values) {
            addCriterion("g in", values, "g");
            return (Criteria) this;
        }

        public Criteria andGNotIn(List<String> values) {
            addCriterion("g not in", values, "g");
            return (Criteria) this;
        }

        public Criteria andGBetween(String value1, String value2) {
            addCriterion("g between", value1, value2, "g");
            return (Criteria) this;
        }

        public Criteria andGNotBetween(String value1, String value2) {
            addCriterion("g not between", value1, value2, "g");
            return (Criteria) this;
        }

        public Criteria andHIsNull() {
            addCriterion("h is null");
            return (Criteria) this;
        }

        public Criteria andHIsNotNull() {
            addCriterion("h is not null");
            return (Criteria) this;
        }

        public Criteria andHEqualTo(String value) {
            addCriterion("h =", value, "h");
            return (Criteria) this;
        }

        public Criteria andHNotEqualTo(String value) {
            addCriterion("h <>", value, "h");
            return (Criteria) this;
        }

        public Criteria andHGreaterThan(String value) {
            addCriterion("h >", value, "h");
            return (Criteria) this;
        }

        public Criteria andHGreaterThanOrEqualTo(String value) {
            addCriterion("h >=", value, "h");
            return (Criteria) this;
        }

        public Criteria andHLessThan(String value) {
            addCriterion("h <", value, "h");
            return (Criteria) this;
        }

        public Criteria andHLessThanOrEqualTo(String value) {
            addCriterion("h <=", value, "h");
            return (Criteria) this;
        }

        public Criteria andHLike(String value) {
            addCriterion("h like", value, "h");
            return (Criteria) this;
        }

        public Criteria andHNotLike(String value) {
            addCriterion("h not like", value, "h");
            return (Criteria) this;
        }

        public Criteria andHIn(List<String> values) {
            addCriterion("h in", values, "h");
            return (Criteria) this;
        }

        public Criteria andHNotIn(List<String> values) {
            addCriterion("h not in", values, "h");
            return (Criteria) this;
        }

        public Criteria andHBetween(String value1, String value2) {
            addCriterion("h between", value1, value2, "h");
            return (Criteria) this;
        }

        public Criteria andHNotBetween(String value1, String value2) {
            addCriterion("h not between", value1, value2, "h");
            return (Criteria) this;
        }

        public Criteria andIIsNull() {
            addCriterion("i is null");
            return (Criteria) this;
        }

        public Criteria andIIsNotNull() {
            addCriterion("i is not null");
            return (Criteria) this;
        }

        public Criteria andIEqualTo(String value) {
            addCriterion("i =", value, "i");
            return (Criteria) this;
        }

        public Criteria andINotEqualTo(String value) {
            addCriterion("i <>", value, "i");
            return (Criteria) this;
        }

        public Criteria andIGreaterThan(String value) {
            addCriterion("i >", value, "i");
            return (Criteria) this;
        }

        public Criteria andIGreaterThanOrEqualTo(String value) {
            addCriterion("i >=", value, "i");
            return (Criteria) this;
        }

        public Criteria andILessThan(String value) {
            addCriterion("i <", value, "i");
            return (Criteria) this;
        }

        public Criteria andILessThanOrEqualTo(String value) {
            addCriterion("i <=", value, "i");
            return (Criteria) this;
        }

        public Criteria andILike(String value) {
            addCriterion("i like", value, "i");
            return (Criteria) this;
        }

        public Criteria andINotLike(String value) {
            addCriterion("i not like", value, "i");
            return (Criteria) this;
        }

        public Criteria andIIn(List<String> values) {
            addCriterion("i in", values, "i");
            return (Criteria) this;
        }

        public Criteria andINotIn(List<String> values) {
            addCriterion("i not in", values, "i");
            return (Criteria) this;
        }

        public Criteria andIBetween(String value1, String value2) {
            addCriterion("i between", value1, value2, "i");
            return (Criteria) this;
        }

        public Criteria andINotBetween(String value1, String value2) {
            addCriterion("i not between", value1, value2, "i");
            return (Criteria) this;
        }

        public Criteria andHeaderIsNull() {
            addCriterion("header is null");
            return (Criteria) this;
        }

        public Criteria andHeaderIsNotNull() {
            addCriterion("header is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderEqualTo(String value) {
            addCriterion("header =", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotEqualTo(String value) {
            addCriterion("header <>", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderGreaterThan(String value) {
            addCriterion("header >", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("header >=", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLessThan(String value) {
            addCriterion("header <", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLessThanOrEqualTo(String value) {
            addCriterion("header <=", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLike(String value) {
            addCriterion("header like", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotLike(String value) {
            addCriterion("header not like", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderIn(List<String> values) {
            addCriterion("header in", values, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotIn(List<String> values) {
            addCriterion("header not in", values, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderBetween(String value1, String value2) {
            addCriterion("header between", value1, value2, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotBetween(String value1, String value2) {
            addCriterion("header not between", value1, value2, "header");
            return (Criteria) this;
        }

        public Criteria andWriterIsNull() {
            addCriterion("writer is null");
            return (Criteria) this;
        }

        public Criteria andWriterIsNotNull() {
            addCriterion("writer is not null");
            return (Criteria) this;
        }

        public Criteria andWriterEqualTo(String value) {
            addCriterion("writer =", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterNotEqualTo(String value) {
            addCriterion("writer <>", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterGreaterThan(String value) {
            addCriterion("writer >", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterGreaterThanOrEqualTo(String value) {
            addCriterion("writer >=", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterLessThan(String value) {
            addCriterion("writer <", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterLessThanOrEqualTo(String value) {
            addCriterion("writer <=", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterLike(String value) {
            addCriterion("writer like", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterNotLike(String value) {
            addCriterion("writer not like", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterIn(List<String> values) {
            addCriterion("writer in", values, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterNotIn(List<String> values) {
            addCriterion("writer not in", values, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterBetween(String value1, String value2) {
            addCriterion("writer between", value1, value2, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterNotBetween(String value1, String value2) {
            addCriterion("writer not between", value1, value2, "writer");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andBcTimeIsNull() {
            addCriterion("bc_time is null");
            return (Criteria) this;
        }

        public Criteria andBcTimeIsNotNull() {
            addCriterion("bc_time is not null");
            return (Criteria) this;
        }

        public Criteria andBcTimeEqualTo(Date value) {
            addCriterion("bc_time =", value, "bcTime");
            return (Criteria) this;
        }

        public Criteria andBcTimeNotEqualTo(Date value) {
            addCriterion("bc_time <>", value, "bcTime");
            return (Criteria) this;
        }

        public Criteria andBcTimeGreaterThan(Date value) {
            addCriterion("bc_time >", value, "bcTime");
            return (Criteria) this;
        }

        public Criteria andBcTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bc_time >=", value, "bcTime");
            return (Criteria) this;
        }

        public Criteria andBcTimeLessThan(Date value) {
            addCriterion("bc_time <", value, "bcTime");
            return (Criteria) this;
        }

        public Criteria andBcTimeLessThanOrEqualTo(Date value) {
            addCriterion("bc_time <=", value, "bcTime");
            return (Criteria) this;
        }

        public Criteria andBcTimeIn(List<Date> values) {
            addCriterion("bc_time in", values, "bcTime");
            return (Criteria) this;
        }

        public Criteria andBcTimeNotIn(List<Date> values) {
            addCriterion("bc_time not in", values, "bcTime");
            return (Criteria) this;
        }

        public Criteria andBcTimeBetween(Date value1, Date value2) {
            addCriterion("bc_time between", value1, value2, "bcTime");
            return (Criteria) this;
        }

        public Criteria andBcTimeNotBetween(Date value1, Date value2) {
            addCriterion("bc_time not between", value1, value2, "bcTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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