package com.gsccs.sme.plat.rtable.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gsccs.sme.plat.bass.BaseExample;

public class WaterMainExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaterMainExample() {
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

        public Criteria andMainidIsNull() {
            addCriterion("mainId is null");
            return (Criteria) this;
        }

        public Criteria andMainidIsNotNull() {
            addCriterion("mainId is not null");
            return (Criteria) this;
        }

        public Criteria andMainidEqualTo(String value) {
            addCriterion("mainId =", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidNotEqualTo(String value) {
            addCriterion("mainId <>", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidGreaterThan(String value) {
            addCriterion("mainId >", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidGreaterThanOrEqualTo(String value) {
            addCriterion("mainId >=", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidLessThan(String value) {
            addCriterion("mainId <", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidLessThanOrEqualTo(String value) {
            addCriterion("mainId <=", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidLike(String value) {
            addCriterion("mainId like", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidNotLike(String value) {
            addCriterion("mainId not like", value, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidIn(List<String> values) {
            addCriterion("mainId in", values, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidNotIn(List<String> values) {
            addCriterion("mainId not in", values, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidBetween(String value1, String value2) {
            addCriterion("mainId between", value1, value2, "mainid");
            return (Criteria) this;
        }

        public Criteria andMainidNotBetween(String value1, String value2) {
            addCriterion("mainId not between", value1, value2, "mainid");
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

        public Criteria andTxaddressIsNull() {
            addCriterion("txAddress is null");
            return (Criteria) this;
        }

        public Criteria andTxaddressIsNotNull() {
            addCriterion("txAddress is not null");
            return (Criteria) this;
        }

        public Criteria andTxaddressEqualTo(String value) {
            addCriterion("txAddress =", value, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressNotEqualTo(String value) {
            addCriterion("txAddress <>", value, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressGreaterThan(String value) {
            addCriterion("txAddress >", value, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressGreaterThanOrEqualTo(String value) {
            addCriterion("txAddress >=", value, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressLessThan(String value) {
            addCriterion("txAddress <", value, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressLessThanOrEqualTo(String value) {
            addCriterion("txAddress <=", value, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressLike(String value) {
            addCriterion("txAddress like", value, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressNotLike(String value) {
            addCriterion("txAddress not like", value, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressIn(List<String> values) {
            addCriterion("txAddress in", values, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressNotIn(List<String> values) {
            addCriterion("txAddress not in", values, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressBetween(String value1, String value2) {
            addCriterion("txAddress between", value1, value2, "txaddress");
            return (Criteria) this;
        }

        public Criteria andTxaddressNotBetween(String value1, String value2) {
            addCriterion("txAddress not between", value1, value2, "txaddress");
            return (Criteria) this;
        }

        public Criteria andYznumIsNull() {
            addCriterion("yzNum is null");
            return (Criteria) this;
        }

        public Criteria andYznumIsNotNull() {
            addCriterion("yzNum is not null");
            return (Criteria) this;
        }

        public Criteria andYznumEqualTo(String value) {
            addCriterion("yzNum =", value, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumNotEqualTo(String value) {
            addCriterion("yzNum <>", value, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumGreaterThan(String value) {
            addCriterion("yzNum >", value, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumGreaterThanOrEqualTo(String value) {
            addCriterion("yzNum >=", value, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumLessThan(String value) {
            addCriterion("yzNum <", value, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumLessThanOrEqualTo(String value) {
            addCriterion("yzNum <=", value, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumLike(String value) {
            addCriterion("yzNum like", value, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumNotLike(String value) {
            addCriterion("yzNum not like", value, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumIn(List<String> values) {
            addCriterion("yzNum in", values, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumNotIn(List<String> values) {
            addCriterion("yzNum not in", values, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumBetween(String value1, String value2) {
            addCriterion("yzNum between", value1, value2, "yznum");
            return (Criteria) this;
        }

        public Criteria andYznumNotBetween(String value1, String value2) {
            addCriterion("yzNum not between", value1, value2, "yznum");
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

        public Criteria andLinktelIsNull() {
            addCriterion("linktel is null");
            return (Criteria) this;
        }

        public Criteria andLinktelIsNotNull() {
            addCriterion("linktel is not null");
            return (Criteria) this;
        }

        public Criteria andLinktelEqualTo(String value) {
            addCriterion("linktel =", value, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelNotEqualTo(String value) {
            addCriterion("linktel <>", value, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelGreaterThan(String value) {
            addCriterion("linktel >", value, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelGreaterThanOrEqualTo(String value) {
            addCriterion("linktel >=", value, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelLessThan(String value) {
            addCriterion("linktel <", value, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelLessThanOrEqualTo(String value) {
            addCriterion("linktel <=", value, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelLike(String value) {
            addCriterion("linktel like", value, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelNotLike(String value) {
            addCriterion("linktel not like", value, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelIn(List<String> values) {
            addCriterion("linktel in", values, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelNotIn(List<String> values) {
            addCriterion("linktel not in", values, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelBetween(String value1, String value2) {
            addCriterion("linktel between", value1, value2, "linktel");
            return (Criteria) this;
        }

        public Criteria andLinktelNotBetween(String value1, String value2) {
            addCriterion("linktel not between", value1, value2, "linktel");
            return (Criteria) this;
        }

        public Criteria andCznumIsNull() {
            addCriterion("czNum is null");
            return (Criteria) this;
        }

        public Criteria andCznumIsNotNull() {
            addCriterion("czNum is not null");
            return (Criteria) this;
        }

        public Criteria andCznumEqualTo(String value) {
            addCriterion("czNum =", value, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumNotEqualTo(String value) {
            addCriterion("czNum <>", value, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumGreaterThan(String value) {
            addCriterion("czNum >", value, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumGreaterThanOrEqualTo(String value) {
            addCriterion("czNum >=", value, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumLessThan(String value) {
            addCriterion("czNum <", value, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumLessThanOrEqualTo(String value) {
            addCriterion("czNum <=", value, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumLike(String value) {
            addCriterion("czNum like", value, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumNotLike(String value) {
            addCriterion("czNum not like", value, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumIn(List<String> values) {
            addCriterion("czNum in", values, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumNotIn(List<String> values) {
            addCriterion("czNum not in", values, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumBetween(String value1, String value2) {
            addCriterion("czNum between", value1, value2, "cznum");
            return (Criteria) this;
        }

        public Criteria andCznumNotBetween(String value1, String value2) {
            addCriterion("czNum not between", value1, value2, "cznum");
            return (Criteria) this;
        }

        public Criteria andJynumIsNull() {
            addCriterion("jyNum is null");
            return (Criteria) this;
        }

        public Criteria andJynumIsNotNull() {
            addCriterion("jyNum is not null");
            return (Criteria) this;
        }

        public Criteria andJynumEqualTo(String value) {
            addCriterion("jyNum =", value, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumNotEqualTo(String value) {
            addCriterion("jyNum <>", value, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumGreaterThan(String value) {
            addCriterion("jyNum >", value, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumGreaterThanOrEqualTo(String value) {
            addCriterion("jyNum >=", value, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumLessThan(String value) {
            addCriterion("jyNum <", value, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumLessThanOrEqualTo(String value) {
            addCriterion("jyNum <=", value, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumLike(String value) {
            addCriterion("jyNum like", value, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumNotLike(String value) {
            addCriterion("jyNum not like", value, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumIn(List<String> values) {
            addCriterion("jyNum in", values, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumNotIn(List<String> values) {
            addCriterion("jyNum not in", values, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumBetween(String value1, String value2) {
            addCriterion("jyNum between", value1, value2, "jynum");
            return (Criteria) this;
        }

        public Criteria andJynumNotBetween(String value1, String value2) {
            addCriterion("jyNum not between", value1, value2, "jynum");
            return (Criteria) this;
        }

        public Criteria andTjdateIsNull() {
            addCriterion("tjdate is null");
            return (Criteria) this;
        }

        public Criteria andTjdateIsNotNull() {
            addCriterion("tjdate is not null");
            return (Criteria) this;
        }

        public Criteria andTjdateEqualTo(Date value) {
            addCriterion("tjdate =", value, "tjdate");
            return (Criteria) this;
        }

        public Criteria andTjdateNotEqualTo(Date value) {
            addCriterion("tjdate <>", value, "tjdate");
            return (Criteria) this;
        }

        public Criteria andTjdateGreaterThan(Date value) {
            addCriterion("tjdate >", value, "tjdate");
            return (Criteria) this;
        }

        public Criteria andTjdateGreaterThanOrEqualTo(Date value) {
            addCriterion("tjdate >=", value, "tjdate");
            return (Criteria) this;
        }

        public Criteria andTjdateLessThan(Date value) {
            addCriterion("tjdate <", value, "tjdate");
            return (Criteria) this;
        }

        public Criteria andTjdateLessThanOrEqualTo(Date value) {
            addCriterion("tjdate <=", value, "tjdate");
            return (Criteria) this;
        }

        public Criteria andTjdateIn(List<Date> values) {
            addCriterion("tjdate in", values, "tjdate");
            return (Criteria) this;
        }

        public Criteria andTjdateNotIn(List<Date> values) {
            addCriterion("tjdate not in", values, "tjdate");
            return (Criteria) this;
        }

        public Criteria andTjdateBetween(Date value1, Date value2) {
            addCriterion("tjdate between", value1, value2, "tjdate");
            return (Criteria) this;
        }

        public Criteria andTjdateNotBetween(Date value1, Date value2) {
            addCriterion("tjdate not between", value1, value2, "tjdate");
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