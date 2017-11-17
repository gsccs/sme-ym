package com.gsccs.sme.plat.rtable.model;

import java.util.ArrayList;
import java.util.List;

import com.gsccs.sme.plat.bass.BaseExample;

public class WaterTakeExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaterTakeExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andWaterdbIsNull() {
            addCriterion("waterDb is null");
            return (Criteria) this;
        }

        public Criteria andWaterdbIsNotNull() {
            addCriterion("waterDb is not null");
            return (Criteria) this;
        }

        public Criteria andWaterdbEqualTo(String value) {
            addCriterion("waterDb =", value, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbNotEqualTo(String value) {
            addCriterion("waterDb <>", value, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbGreaterThan(String value) {
            addCriterion("waterDb >", value, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbGreaterThanOrEqualTo(String value) {
            addCriterion("waterDb >=", value, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbLessThan(String value) {
            addCriterion("waterDb <", value, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbLessThanOrEqualTo(String value) {
            addCriterion("waterDb <=", value, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbLike(String value) {
            addCriterion("waterDb like", value, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbNotLike(String value) {
            addCriterion("waterDb not like", value, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbIn(List<String> values) {
            addCriterion("waterDb in", values, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbNotIn(List<String> values) {
            addCriterion("waterDb not in", values, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbBetween(String value1, String value2) {
            addCriterion("waterDb between", value1, value2, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdbNotBetween(String value1, String value2) {
            addCriterion("waterDb not between", value1, value2, "waterdb");
            return (Criteria) this;
        }

        public Criteria andWaterdxIsNull() {
            addCriterion("waterDx is null");
            return (Criteria) this;
        }

        public Criteria andWaterdxIsNotNull() {
            addCriterion("waterDx is not null");
            return (Criteria) this;
        }

        public Criteria andWaterdxEqualTo(String value) {
            addCriterion("waterDx =", value, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxNotEqualTo(String value) {
            addCriterion("waterDx <>", value, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxGreaterThan(String value) {
            addCriterion("waterDx >", value, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxGreaterThanOrEqualTo(String value) {
            addCriterion("waterDx >=", value, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxLessThan(String value) {
            addCriterion("waterDx <", value, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxLessThanOrEqualTo(String value) {
            addCriterion("waterDx <=", value, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxLike(String value) {
            addCriterion("waterDx like", value, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxNotLike(String value) {
            addCriterion("waterDx not like", value, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxIn(List<String> values) {
            addCriterion("waterDx in", values, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxNotIn(List<String> values) {
            addCriterion("waterDx not in", values, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxBetween(String value1, String value2) {
            addCriterion("waterDx between", value1, value2, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterdxNotBetween(String value1, String value2) {
            addCriterion("waterDx not between", value1, value2, "waterdx");
            return (Criteria) this;
        }

        public Criteria andWaterzlIsNull() {
            addCriterion("waterZl is null");
            return (Criteria) this;
        }

        public Criteria andWaterzlIsNotNull() {
            addCriterion("waterZl is not null");
            return (Criteria) this;
        }

        public Criteria andWaterzlEqualTo(String value) {
            addCriterion("waterZl =", value, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlNotEqualTo(String value) {
            addCriterion("waterZl <>", value, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlGreaterThan(String value) {
            addCriterion("waterZl >", value, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlGreaterThanOrEqualTo(String value) {
            addCriterion("waterZl >=", value, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlLessThan(String value) {
            addCriterion("waterZl <", value, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlLessThanOrEqualTo(String value) {
            addCriterion("waterZl <=", value, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlLike(String value) {
            addCriterion("waterZl like", value, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlNotLike(String value) {
            addCriterion("waterZl not like", value, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlIn(List<String> values) {
            addCriterion("waterZl in", values, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlNotIn(List<String> values) {
            addCriterion("waterZl not in", values, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlBetween(String value1, String value2) {
            addCriterion("waterZl between", value1, value2, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterzlNotBetween(String value1, String value2) {
            addCriterion("waterZl not between", value1, value2, "waterzl");
            return (Criteria) this;
        }

        public Criteria andWaterqtIsNull() {
            addCriterion("waterQt is null");
            return (Criteria) this;
        }

        public Criteria andWaterqtIsNotNull() {
            addCriterion("waterQt is not null");
            return (Criteria) this;
        }

        public Criteria andWaterqtEqualTo(String value) {
            addCriterion("waterQt =", value, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtNotEqualTo(String value) {
            addCriterion("waterQt <>", value, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtGreaterThan(String value) {
            addCriterion("waterQt >", value, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtGreaterThanOrEqualTo(String value) {
            addCriterion("waterQt >=", value, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtLessThan(String value) {
            addCriterion("waterQt <", value, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtLessThanOrEqualTo(String value) {
            addCriterion("waterQt <=", value, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtLike(String value) {
            addCriterion("waterQt like", value, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtNotLike(String value) {
            addCriterion("waterQt not like", value, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtIn(List<String> values) {
            addCriterion("waterQt in", values, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtNotIn(List<String> values) {
            addCriterion("waterQt not in", values, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtBetween(String value1, String value2) {
            addCriterion("waterQt between", value1, value2, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterqtNotBetween(String value1, String value2) {
            addCriterion("waterQt not between", value1, value2, "waterqt");
            return (Criteria) this;
        }

        public Criteria andWaterallIsNull() {
            addCriterion("waterAll is null");
            return (Criteria) this;
        }

        public Criteria andWaterallIsNotNull() {
            addCriterion("waterAll is not null");
            return (Criteria) this;
        }

        public Criteria andWaterallEqualTo(String value) {
            addCriterion("waterAll =", value, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallNotEqualTo(String value) {
            addCriterion("waterAll <>", value, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallGreaterThan(String value) {
            addCriterion("waterAll >", value, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallGreaterThanOrEqualTo(String value) {
            addCriterion("waterAll >=", value, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallLessThan(String value) {
            addCriterion("waterAll <", value, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallLessThanOrEqualTo(String value) {
            addCriterion("waterAll <=", value, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallLike(String value) {
            addCriterion("waterAll like", value, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallNotLike(String value) {
            addCriterion("waterAll not like", value, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallIn(List<String> values) {
            addCriterion("waterAll in", values, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallNotIn(List<String> values) {
            addCriterion("waterAll not in", values, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallBetween(String value1, String value2) {
            addCriterion("waterAll between", value1, value2, "waterall");
            return (Criteria) this;
        }

        public Criteria andWaterallNotBetween(String value1, String value2) {
            addCriterion("waterAll not between", value1, value2, "waterall");
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