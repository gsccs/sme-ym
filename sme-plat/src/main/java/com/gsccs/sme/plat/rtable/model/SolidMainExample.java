package com.gsccs.sme.plat.rtable.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gsccs.sme.plat.bass.BaseExample;

public class SolidMainExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SolidMainExample() {
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

        public Criteria andTbtimeIsNull() {
            addCriterion("tbTime is null");
            return (Criteria) this;
        }

        public Criteria andTbtimeIsNotNull() {
            addCriterion("tbTime is not null");
            return (Criteria) this;
        }

        public Criteria andTbtimeEqualTo(Date value) {
            addCriterion("tbTime =", value, "tbtime");
            return (Criteria) this;
        }

        public Criteria andTbtimeNotEqualTo(Date value) {
            addCriterion("tbTime <>", value, "tbtime");
            return (Criteria) this;
        }

        public Criteria andTbtimeGreaterThan(Date value) {
            addCriterion("tbTime >", value, "tbtime");
            return (Criteria) this;
        }

        public Criteria andTbtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tbTime >=", value, "tbtime");
            return (Criteria) this;
        }

        public Criteria andTbtimeLessThan(Date value) {
            addCriterion("tbTime <", value, "tbtime");
            return (Criteria) this;
        }

        public Criteria andTbtimeLessThanOrEqualTo(Date value) {
            addCriterion("tbTime <=", value, "tbtime");
            return (Criteria) this;
        }

        public Criteria andTbtimeIn(List<Date> values) {
            addCriterion("tbTime in", values, "tbtime");
            return (Criteria) this;
        }

        public Criteria andTbtimeNotIn(List<Date> values) {
            addCriterion("tbTime not in", values, "tbtime");
            return (Criteria) this;
        }

        public Criteria andTbtimeBetween(Date value1, Date value2) {
            addCriterion("tbTime between", value1, value2, "tbtime");
            return (Criteria) this;
        }

        public Criteria andTbtimeNotBetween(Date value1, Date value2) {
            addCriterion("tbTime not between", value1, value2, "tbtime");
            return (Criteria) this;
        }

        public Criteria andShleaderIsNull() {
            addCriterion("shLeader is null");
            return (Criteria) this;
        }

        public Criteria andShleaderIsNotNull() {
            addCriterion("shLeader is not null");
            return (Criteria) this;
        }

        public Criteria andShleaderEqualTo(String value) {
            addCriterion("shLeader =", value, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderNotEqualTo(String value) {
            addCriterion("shLeader <>", value, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderGreaterThan(String value) {
            addCriterion("shLeader >", value, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderGreaterThanOrEqualTo(String value) {
            addCriterion("shLeader >=", value, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderLessThan(String value) {
            addCriterion("shLeader <", value, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderLessThanOrEqualTo(String value) {
            addCriterion("shLeader <=", value, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderLike(String value) {
            addCriterion("shLeader like", value, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderNotLike(String value) {
            addCriterion("shLeader not like", value, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderIn(List<String> values) {
            addCriterion("shLeader in", values, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderNotIn(List<String> values) {
            addCriterion("shLeader not in", values, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderBetween(String value1, String value2) {
            addCriterion("shLeader between", value1, value2, "shleader");
            return (Criteria) this;
        }

        public Criteria andShleaderNotBetween(String value1, String value2) {
            addCriterion("shLeader not between", value1, value2, "shleader");
            return (Criteria) this;
        }

        public Criteria andTbnameIsNull() {
            addCriterion("tbName is null");
            return (Criteria) this;
        }

        public Criteria andTbnameIsNotNull() {
            addCriterion("tbName is not null");
            return (Criteria) this;
        }

        public Criteria andTbnameEqualTo(String value) {
            addCriterion("tbName =", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameNotEqualTo(String value) {
            addCriterion("tbName <>", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameGreaterThan(String value) {
            addCriterion("tbName >", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameGreaterThanOrEqualTo(String value) {
            addCriterion("tbName >=", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameLessThan(String value) {
            addCriterion("tbName <", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameLessThanOrEqualTo(String value) {
            addCriterion("tbName <=", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameLike(String value) {
            addCriterion("tbName like", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameNotLike(String value) {
            addCriterion("tbName not like", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameIn(List<String> values) {
            addCriterion("tbName in", values, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameNotIn(List<String> values) {
            addCriterion("tbName not in", values, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameBetween(String value1, String value2) {
            addCriterion("tbName between", value1, value2, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameNotBetween(String value1, String value2) {
            addCriterion("tbName not between", value1, value2, "tbname");
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