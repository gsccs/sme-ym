package com.gsccs.sme.plat.svg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gsccs.sme.plat.bass.BaseExample;

public class SitemTExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SitemTExample() {
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

        public Criteria andSvgidIsNull() {
            addCriterion("svgid is null");
            return (Criteria) this;
        }

        public Criteria andSvgidIsNotNull() {
            addCriterion("svgid is not null");
            return (Criteria) this;
        }

        public Criteria andSvgidEqualTo(Long value) {
            addCriterion("svgid =", value, "svgid");
            return (Criteria) this;
        }

        public Criteria andSvgidNotEqualTo(Long value) {
            addCriterion("svgid <>", value, "svgid");
            return (Criteria) this;
        }

        public Criteria andSvgidIn(List<Long> values) {
            addCriterion("svgid in", values, "svgid");
            return (Criteria) this;
        }

        public Criteria andSvgidNotIn(List<Long> values) {
            addCriterion("svgid not in", values, "svgid");
            return (Criteria) this;
        }

        public Criteria andSvgidBetween(Long value1, Long value2) {
            addCriterion("svgid between", value1, value2, "svgid");
            return (Criteria) this;
        }

        public Criteria andSvgidNotBetween(Long value1, Long value2) {
            addCriterion("svgid not between", value1, value2, "svgid");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("scode is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("scode is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Long value) {
            addCriterion("scode =", value, "scode");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Long value) {
            addCriterion("scode <>", value, "scode");
            return (Criteria) this;
        }

        

        public Criteria andCodeIn(List<Long> values) {
            addCriterion("scode in", values, "scode");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Long> values) {
            addCriterion("scode not in", values, "scode");
            return (Criteria) this;
        }


        public Criteria andSubcodeIsNull() {
            addCriterion("subscode is null");
            return (Criteria) this;
        }

        public Criteria andSubcodeIsNotNull() {
            addCriterion("subscode is not null");
            return (Criteria) this;
        }

        public Criteria andSubcodeEqualTo(Long value) {
            addCriterion("subscode =", value, "subscode");
            return (Criteria) this;
        }

        public Criteria andSubcodeNotEqualTo(Long value) {
            addCriterion("subscode <>", value, "subscode");
            return (Criteria) this;
        }

        public Criteria andSubcodeGreaterThan(Long value) {
            addCriterion("subscode >", value, "subscode");
            return (Criteria) this;
        }

        public Criteria andSubcodeGreaterThanOrEqualTo(Long value) {
            addCriterion("subscode >=", value, "subscode");
            return (Criteria) this;
        }

        public Criteria andSubcodeLessThan(Long value) {
            addCriterion("subscode <", value, "subscode");
            return (Criteria) this;
        }

        public Criteria andSubcodeLessThanOrEqualTo(Long value) {
            addCriterion("subscode <=", value, "subscode");
            return (Criteria) this;
        }

        public Criteria andSubcodeIn(List<Long> values) {
            addCriterion("subscode in", values, "subscode");
            return (Criteria) this;
        }

        public Criteria andSubcodeNotIn(List<Long> values) {
            addCriterion("subscode not in", values, "subscode");
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

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
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

       

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        
        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andClicknumIsNull() {
            addCriterion("clickNum is null");
            return (Criteria) this;
        }

        public Criteria andClicknumIsNotNull() {
            addCriterion("clickNum is not null");
            return (Criteria) this;
        }

        public Criteria andClicknumEqualTo(Integer value) {
            addCriterion("clickNum =", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumNotEqualTo(Integer value) {
            addCriterion("clickNum <>", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumGreaterThan(Integer value) {
            addCriterion("clickNum >", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("clickNum >=", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumLessThan(Integer value) {
            addCriterion("clickNum <", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumLessThanOrEqualTo(Integer value) {
            addCriterion("clickNum <=", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumIn(List<Integer> values) {
            addCriterion("clickNum in", values, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumNotIn(List<Integer> values) {
            addCriterion("clickNum not in", values, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumBetween(Integer value1, Integer value2) {
            addCriterion("clickNum between", value1, value2, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumNotBetween(Integer value1, Integer value2) {
            addCriterion("clickNum not between", value1, value2, "clicknum");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNull() {
            addCriterion("barcode is null");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNotNull() {
            addCriterion("barcode is not null");
            return (Criteria) this;
        }

        public Criteria andBarcodeEqualTo(String value) {
            addCriterion("barcode =", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotEqualTo(String value) {
            addCriterion("barcode <>", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThan(String value) {
            addCriterion("barcode >", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("barcode >=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThan(String value) {
            addCriterion("barcode <", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThanOrEqualTo(String value) {
            addCriterion("barcode <=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLike(String value) {
            addCriterion("barcode like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotLike(String value) {
            addCriterion("barcode not like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeIn(List<String> values) {
            addCriterion("barcode in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotIn(List<String> values) {
            addCriterion("barcode not in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeBetween(String value1, String value2) {
            addCriterion("barcode between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotBetween(String value1, String value2) {
            addCriterion("barcode not between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andSalenumIsNull() {
            addCriterion("salenum is null");
            return (Criteria) this;
        }

        public Criteria andSalenumIsNotNull() {
            addCriterion("salenum is not null");
            return (Criteria) this;
        }

        public Criteria andSalenumEqualTo(Integer value) {
            addCriterion("salenum =", value, "salenum");
            return (Criteria) this;
        }

        public Criteria andSalenumNotEqualTo(Integer value) {
            addCriterion("salenum <>", value, "salenum");
            return (Criteria) this;
        }

        public Criteria andSalenumGreaterThan(Integer value) {
            addCriterion("salenum >", value, "salenum");
            return (Criteria) this;
        }

        public Criteria andSalenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("salenum >=", value, "salenum");
            return (Criteria) this;
        }

        public Criteria andSalenumLessThan(Integer value) {
            addCriterion("salenum <", value, "salenum");
            return (Criteria) this;
        }

        public Criteria andSalenumLessThanOrEqualTo(Integer value) {
            addCriterion("salenum <=", value, "salenum");
            return (Criteria) this;
        }

        public Criteria andSalenumIn(List<Integer> values) {
            addCriterion("salenum in", values, "salenum");
            return (Criteria) this;
        }

        public Criteria andSalenumNotIn(List<Integer> values) {
            addCriterion("salenum not in", values, "salenum");
            return (Criteria) this;
        }

        public Criteria andSalenumBetween(Integer value1, Integer value2) {
            addCriterion("salenum between", value1, value2, "salenum");
            return (Criteria) this;
        }

        public Criteria andSalenumNotBetween(Integer value1, Integer value2) {
            addCriterion("salenum not between", value1, value2, "salenum");
            return (Criteria) this;
        }

        public Criteria andEvalnumIsNull() {
            addCriterion("evalnum is null");
            return (Criteria) this;
        }

        public Criteria andEvalnumIsNotNull() {
            addCriterion("evalnum is not null");
            return (Criteria) this;
        }

        public Criteria andEvalnumEqualTo(Integer value) {
            addCriterion("evalnum =", value, "evalnum");
            return (Criteria) this;
        }

        public Criteria andEvalnumNotEqualTo(Integer value) {
            addCriterion("evalnum <>", value, "evalnum");
            return (Criteria) this;
        }

        public Criteria andEvalnumGreaterThan(Integer value) {
            addCriterion("evalnum >", value, "evalnum");
            return (Criteria) this;
        }

        public Criteria andEvalnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("evalnum >=", value, "evalnum");
            return (Criteria) this;
        }

        public Criteria andEvalnumLessThan(Integer value) {
            addCriterion("evalnum <", value, "evalnum");
            return (Criteria) this;
        }

        public Criteria andEvalnumLessThanOrEqualTo(Integer value) {
            addCriterion("evalnum <=", value, "evalnum");
            return (Criteria) this;
        }

        public Criteria andEvalnumIn(List<Integer> values) {
            addCriterion("evalnum in", values, "evalnum");
            return (Criteria) this;
        }

        public Criteria andEvalnumNotIn(List<Integer> values) {
            addCriterion("evalnum not in", values, "evalnum");
            return (Criteria) this;
        }

        public Criteria andEvalnumBetween(Integer value1, Integer value2) {
            addCriterion("evalnum between", value1, value2, "evalnum");
            return (Criteria) this;
        }

        public Criteria andEvalnumNotBetween(Integer value1, Integer value2) {
            addCriterion("evalnum not between", value1, value2, "evalnum");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNull() {
            addCriterion("lasttime is null");
            return (Criteria) this;
        }

        public Criteria andLasttimeIsNotNull() {
            addCriterion("lasttime is not null");
            return (Criteria) this;
        }

        public Criteria andLasttimeEqualTo(Date value) {
            addCriterion("lasttime =", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotEqualTo(Date value) {
            addCriterion("lasttime <>", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThan(Date value) {
            addCriterion("lasttime >", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lasttime >=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThan(Date value) {
            addCriterion("lasttime <", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeLessThanOrEqualTo(Date value) {
            addCriterion("lasttime <=", value, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeIn(List<Date> values) {
            addCriterion("lasttime in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotIn(List<Date> values) {
            addCriterion("lasttime not in", values, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeBetween(Date value1, Date value2) {
            addCriterion("lasttime between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andLasttimeNotBetween(Date value1, Date value2) {
            addCriterion("lasttime not between", value1, value2, "lasttime");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeid is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeid is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Long value) {
            addCriterion("typeid =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Long value) {
            addCriterion("typeid <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Long value) {
            addCriterion("typeid >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Long value) {
            addCriterion("typeid >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Long value) {
            addCriterion("typeid <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Long value) {
            addCriterion("typeid <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Long> values) {
            addCriterion("typeid in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Long> values) {
            addCriterion("typeid not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Long value1, Long value2) {
            addCriterion("typeid between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Long value1, Long value2) {
            addCriterion("typeid not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andLinkerIsNull() {
            addCriterion("linker is null");
            return (Criteria) this;
        }

        public Criteria andLinkerIsNotNull() {
            addCriterion("linker is not null");
            return (Criteria) this;
        }

        public Criteria andLinkerEqualTo(String value) {
            addCriterion("linker =", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerNotEqualTo(String value) {
            addCriterion("linker <>", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerGreaterThan(String value) {
            addCriterion("linker >", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerGreaterThanOrEqualTo(String value) {
            addCriterion("linker >=", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerLessThan(String value) {
            addCriterion("linker <", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerLessThanOrEqualTo(String value) {
            addCriterion("linker <=", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerLike(String value) {
            addCriterion("linker like", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerNotLike(String value) {
            addCriterion("linker not like", value, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerIn(List<String> values) {
            addCriterion("linker in", values, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerNotIn(List<String> values) {
            addCriterion("linker not in", values, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerBetween(String value1, String value2) {
            addCriterion("linker between", value1, value2, "linker");
            return (Criteria) this;
        }

        public Criteria andLinkerNotBetween(String value1, String value2) {
            addCriterion("linker not between", value1, value2, "linker");
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andSprojectIsNull() {
            addCriterion("sproject is null");
            return (Criteria) this;
        }

        public Criteria andSprojectIsNotNull() {
            addCriterion("sproject is not null");
            return (Criteria) this;
        }

        public Criteria andSprojectEqualTo(String value) {
            addCriterion("sproject =", value, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectNotEqualTo(String value) {
            addCriterion("sproject <>", value, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectGreaterThan(String value) {
            addCriterion("sproject >", value, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectGreaterThanOrEqualTo(String value) {
            addCriterion("sproject >=", value, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectLessThan(String value) {
            addCriterion("sproject <", value, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectLessThanOrEqualTo(String value) {
            addCriterion("sproject <=", value, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectLike(String value) {
            addCriterion("sproject like", value, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectNotLike(String value) {
            addCriterion("sproject not like", value, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectIn(List<String> values) {
            addCriterion("sproject in", values, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectNotIn(List<String> values) {
            addCriterion("sproject not in", values, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectBetween(String value1, String value2) {
            addCriterion("sproject between", value1, value2, "sproject");
            return (Criteria) this;
        }

        public Criteria andSprojectNotBetween(String value1, String value2) {
            addCriterion("sproject not between", value1, value2, "sproject");
            return (Criteria) this;
        }

        public Criteria andSpatternIsNull() {
            addCriterion("spattern is null");
            return (Criteria) this;
        }

        public Criteria andSpatternIsNotNull() {
            addCriterion("spattern is not null");
            return (Criteria) this;
        }

        public Criteria andSpatternEqualTo(String value) {
            addCriterion("spattern =", value, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternNotEqualTo(String value) {
            addCriterion("spattern <>", value, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternGreaterThan(String value) {
            addCriterion("spattern >", value, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternGreaterThanOrEqualTo(String value) {
            addCriterion("spattern >=", value, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternLessThan(String value) {
            addCriterion("spattern <", value, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternLessThanOrEqualTo(String value) {
            addCriterion("spattern <=", value, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternLike(String value) {
            addCriterion("spattern like", value, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternNotLike(String value) {
            addCriterion("spattern not like", value, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternIn(List<String> values) {
            addCriterion("spattern in", values, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternNotIn(List<String> values) {
            addCriterion("spattern not in", values, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternBetween(String value1, String value2) {
            addCriterion("spattern between", value1, value2, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpatternNotBetween(String value1, String value2) {
            addCriterion("spattern not between", value1, value2, "spattern");
            return (Criteria) this;
        }

        public Criteria andSpayIsNull() {
            addCriterion("spay is null");
            return (Criteria) this;
        }

        public Criteria andSpayIsNotNull() {
            addCriterion("spay is not null");
            return (Criteria) this;
        }

        public Criteria andSpayEqualTo(String value) {
            addCriterion("spay =", value, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayNotEqualTo(String value) {
            addCriterion("spay <>", value, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayGreaterThan(String value) {
            addCriterion("spay >", value, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayGreaterThanOrEqualTo(String value) {
            addCriterion("spay >=", value, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayLessThan(String value) {
            addCriterion("spay <", value, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayLessThanOrEqualTo(String value) {
            addCriterion("spay <=", value, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayLike(String value) {
            addCriterion("spay like", value, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayNotLike(String value) {
            addCriterion("spay not like", value, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayIn(List<String> values) {
            addCriterion("spay in", values, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayNotIn(List<String> values) {
            addCriterion("spay not in", values, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayBetween(String value1, String value2) {
            addCriterion("spay between", value1, value2, "spay");
            return (Criteria) this;
        }

        public Criteria andSpayNotBetween(String value1, String value2) {
            addCriterion("spay not between", value1, value2, "spay");
            return (Criteria) this;
        }

        public Criteria andOtherpayIsNull() {
            addCriterion("otherpay is null");
            return (Criteria) this;
        }

        public Criteria andOtherpayIsNotNull() {
            addCriterion("otherpay is not null");
            return (Criteria) this;
        }

        public Criteria andOtherpayEqualTo(String value) {
            addCriterion("otherpay =", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayNotEqualTo(String value) {
            addCriterion("otherpay <>", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayGreaterThan(String value) {
            addCriterion("otherpay >", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayGreaterThanOrEqualTo(String value) {
            addCriterion("otherpay >=", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayLessThan(String value) {
            addCriterion("otherpay <", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayLessThanOrEqualTo(String value) {
            addCriterion("otherpay <=", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayLike(String value) {
            addCriterion("otherpay like", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayNotLike(String value) {
            addCriterion("otherpay not like", value, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayIn(List<String> values) {
            addCriterion("otherpay in", values, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayNotIn(List<String> values) {
            addCriterion("otherpay not in", values, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayBetween(String value1, String value2) {
            addCriterion("otherpay between", value1, value2, "otherpay");
            return (Criteria) this;
        }

        public Criteria andOtherpayNotBetween(String value1, String value2) {
            addCriterion("otherpay not between", value1, value2, "otherpay");
            return (Criteria) this;
        }

        public Criteria andScompanyIsNull() {
            addCriterion("scompany is null");
            return (Criteria) this;
        }

        public Criteria andScompanyIsNotNull() {
            addCriterion("scompany is not null");
            return (Criteria) this;
        }

        public Criteria andScompanyEqualTo(String value) {
            addCriterion("scompany =", value, "scompany");
            return (Criteria) this;
        }

        public Criteria andScompanyNotEqualTo(String value) {
            addCriterion("scompany <>", value, "scompany");
            return (Criteria) this;
        }

        public Criteria andAreacodesIn(String areacodes) {
            addCriterion("areacodes in ("+areacodes+")");
            return (Criteria) this;
        }

        public Criteria andScompanyNotIn(List<String> values) {
            addCriterion("scompany not in", values, "scompany");
            return (Criteria) this;
        }

        public Criteria andScompanyBetween(String value1, String value2) {
            addCriterion("scompany between", value1, value2, "scompany");
            return (Criteria) this;
        }

        public Criteria andScompanyNotBetween(String value1, String value2) {
            addCriterion("scompany not between", value1, value2, "scompany");
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

        public Criteria andQqIsNull() {
            addCriterion("QQ is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("QQ is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("QQ =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("QQ <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("QQ >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("QQ >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("QQ <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("QQ <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("QQ like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("QQ not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("QQ in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("QQ not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("QQ between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("QQ not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andSpayunitIsNull() {
            addCriterion("spayunit is null");
            return (Criteria) this;
        }

        public Criteria andSpayunitIsNotNull() {
            addCriterion("spayunit is not null");
            return (Criteria) this;
        }

        public Criteria andSpayunitEqualTo(String value) {
            addCriterion("spayunit =", value, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitNotEqualTo(String value) {
            addCriterion("spayunit <>", value, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitGreaterThan(String value) {
            addCriterion("spayunit >", value, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitGreaterThanOrEqualTo(String value) {
            addCriterion("spayunit >=", value, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitLessThan(String value) {
            addCriterion("spayunit <", value, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitLessThanOrEqualTo(String value) {
            addCriterion("spayunit <=", value, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitLike(String value) {
            addCriterion("spayunit like", value, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitNotLike(String value) {
            addCriterion("spayunit not like", value, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitIn(List<String> values) {
            addCriterion("spayunit in", values, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitNotIn(List<String> values) {
            addCriterion("spayunit not in", values, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitBetween(String value1, String value2) {
            addCriterion("spayunit between", value1, value2, "spayunit");
            return (Criteria) this;
        }

        public Criteria andSpayunitNotBetween(String value1, String value2) {
            addCriterion("spayunit not between", value1, value2, "spayunit");
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