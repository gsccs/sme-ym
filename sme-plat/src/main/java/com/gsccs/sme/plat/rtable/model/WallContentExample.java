package com.gsccs.sme.plat.rtable.model;

import java.util.ArrayList;
import java.util.List;

import com.gsccs.sme.plat.bass.BaseExample;

public class WallContentExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WallContentExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andJIsNull() {
            addCriterion("j is null");
            return (Criteria) this;
        }

        public Criteria andJIsNotNull() {
            addCriterion("j is not null");
            return (Criteria) this;
        }

        public Criteria andJEqualTo(String value) {
            addCriterion("j =", value, "j");
            return (Criteria) this;
        }

        public Criteria andJNotEqualTo(String value) {
            addCriterion("j <>", value, "j");
            return (Criteria) this;
        }

        public Criteria andJGreaterThan(String value) {
            addCriterion("j >", value, "j");
            return (Criteria) this;
        }

        public Criteria andJGreaterThanOrEqualTo(String value) {
            addCriterion("j >=", value, "j");
            return (Criteria) this;
        }

        public Criteria andJLessThan(String value) {
            addCriterion("j <", value, "j");
            return (Criteria) this;
        }

        public Criteria andJLessThanOrEqualTo(String value) {
            addCriterion("j <=", value, "j");
            return (Criteria) this;
        }

        public Criteria andJLike(String value) {
            addCriterion("j like", value, "j");
            return (Criteria) this;
        }

        public Criteria andJNotLike(String value) {
            addCriterion("j not like", value, "j");
            return (Criteria) this;
        }

        public Criteria andJIn(List<String> values) {
            addCriterion("j in", values, "j");
            return (Criteria) this;
        }

        public Criteria andJNotIn(List<String> values) {
            addCriterion("j not in", values, "j");
            return (Criteria) this;
        }

        public Criteria andJBetween(String value1, String value2) {
            addCriterion("j between", value1, value2, "j");
            return (Criteria) this;
        }

        public Criteria andJNotBetween(String value1, String value2) {
            addCriterion("j not between", value1, value2, "j");
            return (Criteria) this;
        }

        public Criteria andKIsNull() {
            addCriterion("k is null");
            return (Criteria) this;
        }

        public Criteria andKIsNotNull() {
            addCriterion("k is not null");
            return (Criteria) this;
        }

        public Criteria andKEqualTo(String value) {
            addCriterion("k =", value, "k");
            return (Criteria) this;
        }

        public Criteria andKNotEqualTo(String value) {
            addCriterion("k <>", value, "k");
            return (Criteria) this;
        }

        public Criteria andKGreaterThan(String value) {
            addCriterion("k >", value, "k");
            return (Criteria) this;
        }

        public Criteria andKGreaterThanOrEqualTo(String value) {
            addCriterion("k >=", value, "k");
            return (Criteria) this;
        }

        public Criteria andKLessThan(String value) {
            addCriterion("k <", value, "k");
            return (Criteria) this;
        }

        public Criteria andKLessThanOrEqualTo(String value) {
            addCriterion("k <=", value, "k");
            return (Criteria) this;
        }

        public Criteria andKLike(String value) {
            addCriterion("k like", value, "k");
            return (Criteria) this;
        }

        public Criteria andKNotLike(String value) {
            addCriterion("k not like", value, "k");
            return (Criteria) this;
        }

        public Criteria andKIn(List<String> values) {
            addCriterion("k in", values, "k");
            return (Criteria) this;
        }

        public Criteria andKNotIn(List<String> values) {
            addCriterion("k not in", values, "k");
            return (Criteria) this;
        }

        public Criteria andKBetween(String value1, String value2) {
            addCriterion("k between", value1, value2, "k");
            return (Criteria) this;
        }

        public Criteria andKNotBetween(String value1, String value2) {
            addCriterion("k not between", value1, value2, "k");
            return (Criteria) this;
        }

        public Criteria andLIsNull() {
            addCriterion("l is null");
            return (Criteria) this;
        }

        public Criteria andLIsNotNull() {
            addCriterion("l is not null");
            return (Criteria) this;
        }

        public Criteria andLEqualTo(String value) {
            addCriterion("l =", value, "l");
            return (Criteria) this;
        }

        public Criteria andLNotEqualTo(String value) {
            addCriterion("l <>", value, "l");
            return (Criteria) this;
        }

        public Criteria andLGreaterThan(String value) {
            addCriterion("l >", value, "l");
            return (Criteria) this;
        }

        public Criteria andLGreaterThanOrEqualTo(String value) {
            addCriterion("l >=", value, "l");
            return (Criteria) this;
        }

        public Criteria andLLessThan(String value) {
            addCriterion("l <", value, "l");
            return (Criteria) this;
        }

        public Criteria andLLessThanOrEqualTo(String value) {
            addCriterion("l <=", value, "l");
            return (Criteria) this;
        }

        public Criteria andLLike(String value) {
            addCriterion("l like", value, "l");
            return (Criteria) this;
        }

        public Criteria andLNotLike(String value) {
            addCriterion("l not like", value, "l");
            return (Criteria) this;
        }

        public Criteria andLIn(List<String> values) {
            addCriterion("l in", values, "l");
            return (Criteria) this;
        }

        public Criteria andLNotIn(List<String> values) {
            addCriterion("l not in", values, "l");
            return (Criteria) this;
        }

        public Criteria andLBetween(String value1, String value2) {
            addCriterion("l between", value1, value2, "l");
            return (Criteria) this;
        }

        public Criteria andLNotBetween(String value1, String value2) {
            addCriterion("l not between", value1, value2, "l");
            return (Criteria) this;
        }

        public Criteria andMIsNull() {
            addCriterion("m is null");
            return (Criteria) this;
        }

        public Criteria andMIsNotNull() {
            addCriterion("m is not null");
            return (Criteria) this;
        }

        public Criteria andMEqualTo(String value) {
            addCriterion("m =", value, "m");
            return (Criteria) this;
        }

        public Criteria andMNotEqualTo(String value) {
            addCriterion("m <>", value, "m");
            return (Criteria) this;
        }

        public Criteria andMGreaterThan(String value) {
            addCriterion("m >", value, "m");
            return (Criteria) this;
        }

        public Criteria andMGreaterThanOrEqualTo(String value) {
            addCriterion("m >=", value, "m");
            return (Criteria) this;
        }

        public Criteria andMLessThan(String value) {
            addCriterion("m <", value, "m");
            return (Criteria) this;
        }

        public Criteria andMLessThanOrEqualTo(String value) {
            addCriterion("m <=", value, "m");
            return (Criteria) this;
        }

        public Criteria andMLike(String value) {
            addCriterion("m like", value, "m");
            return (Criteria) this;
        }

        public Criteria andMNotLike(String value) {
            addCriterion("m not like", value, "m");
            return (Criteria) this;
        }

        public Criteria andMIn(List<String> values) {
            addCriterion("m in", values, "m");
            return (Criteria) this;
        }

        public Criteria andMNotIn(List<String> values) {
            addCriterion("m not in", values, "m");
            return (Criteria) this;
        }

        public Criteria andMBetween(String value1, String value2) {
            addCriterion("m between", value1, value2, "m");
            return (Criteria) this;
        }

        public Criteria andMNotBetween(String value1, String value2) {
            addCriterion("m not between", value1, value2, "m");
            return (Criteria) this;
        }

        public Criteria andNIsNull() {
            addCriterion("n is null");
            return (Criteria) this;
        }

        public Criteria andNIsNotNull() {
            addCriterion("n is not null");
            return (Criteria) this;
        }

        public Criteria andNEqualTo(String value) {
            addCriterion("n =", value, "n");
            return (Criteria) this;
        }

        public Criteria andNNotEqualTo(String value) {
            addCriterion("n <>", value, "n");
            return (Criteria) this;
        }

        public Criteria andNGreaterThan(String value) {
            addCriterion("n >", value, "n");
            return (Criteria) this;
        }

        public Criteria andNGreaterThanOrEqualTo(String value) {
            addCriterion("n >=", value, "n");
            return (Criteria) this;
        }

        public Criteria andNLessThan(String value) {
            addCriterion("n <", value, "n");
            return (Criteria) this;
        }

        public Criteria andNLessThanOrEqualTo(String value) {
            addCriterion("n <=", value, "n");
            return (Criteria) this;
        }

        public Criteria andNLike(String value) {
            addCriterion("n like", value, "n");
            return (Criteria) this;
        }

        public Criteria andNNotLike(String value) {
            addCriterion("n not like", value, "n");
            return (Criteria) this;
        }

        public Criteria andNIn(List<String> values) {
            addCriterion("n in", values, "n");
            return (Criteria) this;
        }

        public Criteria andNNotIn(List<String> values) {
            addCriterion("n not in", values, "n");
            return (Criteria) this;
        }

        public Criteria andNBetween(String value1, String value2) {
            addCriterion("n between", value1, value2, "n");
            return (Criteria) this;
        }

        public Criteria andNNotBetween(String value1, String value2) {
            addCriterion("n not between", value1, value2, "n");
            return (Criteria) this;
        }

        public Criteria andOIsNull() {
            addCriterion("o is null");
            return (Criteria) this;
        }

        public Criteria andOIsNotNull() {
            addCriterion("o is not null");
            return (Criteria) this;
        }

        public Criteria andOEqualTo(String value) {
            addCriterion("o =", value, "o");
            return (Criteria) this;
        }

        public Criteria andONotEqualTo(String value) {
            addCriterion("o <>", value, "o");
            return (Criteria) this;
        }

        public Criteria andOGreaterThan(String value) {
            addCriterion("o >", value, "o");
            return (Criteria) this;
        }

        public Criteria andOGreaterThanOrEqualTo(String value) {
            addCriterion("o >=", value, "o");
            return (Criteria) this;
        }

        public Criteria andOLessThan(String value) {
            addCriterion("o <", value, "o");
            return (Criteria) this;
        }

        public Criteria andOLessThanOrEqualTo(String value) {
            addCriterion("o <=", value, "o");
            return (Criteria) this;
        }

        public Criteria andOLike(String value) {
            addCriterion("o like", value, "o");
            return (Criteria) this;
        }

        public Criteria andONotLike(String value) {
            addCriterion("o not like", value, "o");
            return (Criteria) this;
        }

        public Criteria andOIn(List<String> values) {
            addCriterion("o in", values, "o");
            return (Criteria) this;
        }

        public Criteria andONotIn(List<String> values) {
            addCriterion("o not in", values, "o");
            return (Criteria) this;
        }

        public Criteria andOBetween(String value1, String value2) {
            addCriterion("o between", value1, value2, "o");
            return (Criteria) this;
        }

        public Criteria andONotBetween(String value1, String value2) {
            addCriterion("o not between", value1, value2, "o");
            return (Criteria) this;
        }

        public Criteria andPIsNull() {
            addCriterion("p is null");
            return (Criteria) this;
        }

        public Criteria andPIsNotNull() {
            addCriterion("p is not null");
            return (Criteria) this;
        }

        public Criteria andPEqualTo(String value) {
            addCriterion("p =", value, "p");
            return (Criteria) this;
        }

        public Criteria andPNotEqualTo(String value) {
            addCriterion("p <>", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThan(String value) {
            addCriterion("p >", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThanOrEqualTo(String value) {
            addCriterion("p >=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThan(String value) {
            addCriterion("p <", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThanOrEqualTo(String value) {
            addCriterion("p <=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLike(String value) {
            addCriterion("p like", value, "p");
            return (Criteria) this;
        }

        public Criteria andPNotLike(String value) {
            addCriterion("p not like", value, "p");
            return (Criteria) this;
        }

        public Criteria andPIn(List<String> values) {
            addCriterion("p in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPNotIn(List<String> values) {
            addCriterion("p not in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPBetween(String value1, String value2) {
            addCriterion("p between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andPNotBetween(String value1, String value2) {
            addCriterion("p not between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andQIsNull() {
            addCriterion("q is null");
            return (Criteria) this;
        }

        public Criteria andQIsNotNull() {
            addCriterion("q is not null");
            return (Criteria) this;
        }

        public Criteria andQEqualTo(String value) {
            addCriterion("q =", value, "q");
            return (Criteria) this;
        }

        public Criteria andQNotEqualTo(String value) {
            addCriterion("q <>", value, "q");
            return (Criteria) this;
        }

        public Criteria andQGreaterThan(String value) {
            addCriterion("q >", value, "q");
            return (Criteria) this;
        }

        public Criteria andQGreaterThanOrEqualTo(String value) {
            addCriterion("q >=", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLessThan(String value) {
            addCriterion("q <", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLessThanOrEqualTo(String value) {
            addCriterion("q <=", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLike(String value) {
            addCriterion("q like", value, "q");
            return (Criteria) this;
        }

        public Criteria andQNotLike(String value) {
            addCriterion("q not like", value, "q");
            return (Criteria) this;
        }

        public Criteria andQIn(List<String> values) {
            addCriterion("q in", values, "q");
            return (Criteria) this;
        }

        public Criteria andQNotIn(List<String> values) {
            addCriterion("q not in", values, "q");
            return (Criteria) this;
        }

        public Criteria andQBetween(String value1, String value2) {
            addCriterion("q between", value1, value2, "q");
            return (Criteria) this;
        }

        public Criteria andQNotBetween(String value1, String value2) {
            addCriterion("q not between", value1, value2, "q");
            return (Criteria) this;
        }

        public Criteria andRIsNull() {
            addCriterion("r is null");
            return (Criteria) this;
        }

        public Criteria andRIsNotNull() {
            addCriterion("r is not null");
            return (Criteria) this;
        }

        public Criteria andREqualTo(String value) {
            addCriterion("r =", value, "r");
            return (Criteria) this;
        }

        public Criteria andRNotEqualTo(String value) {
            addCriterion("r <>", value, "r");
            return (Criteria) this;
        }

        public Criteria andRGreaterThan(String value) {
            addCriterion("r >", value, "r");
            return (Criteria) this;
        }

        public Criteria andRGreaterThanOrEqualTo(String value) {
            addCriterion("r >=", value, "r");
            return (Criteria) this;
        }

        public Criteria andRLessThan(String value) {
            addCriterion("r <", value, "r");
            return (Criteria) this;
        }

        public Criteria andRLessThanOrEqualTo(String value) {
            addCriterion("r <=", value, "r");
            return (Criteria) this;
        }

        public Criteria andRLike(String value) {
            addCriterion("r like", value, "r");
            return (Criteria) this;
        }

        public Criteria andRNotLike(String value) {
            addCriterion("r not like", value, "r");
            return (Criteria) this;
        }

        public Criteria andRIn(List<String> values) {
            addCriterion("r in", values, "r");
            return (Criteria) this;
        }

        public Criteria andRNotIn(List<String> values) {
            addCriterion("r not in", values, "r");
            return (Criteria) this;
        }

        public Criteria andRBetween(String value1, String value2) {
            addCriterion("r between", value1, value2, "r");
            return (Criteria) this;
        }

        public Criteria andRNotBetween(String value1, String value2) {
            addCriterion("r not between", value1, value2, "r");
            return (Criteria) this;
        }

        public Criteria andSIsNull() {
            addCriterion("s is null");
            return (Criteria) this;
        }

        public Criteria andSIsNotNull() {
            addCriterion("s is not null");
            return (Criteria) this;
        }

        public Criteria andSEqualTo(String value) {
            addCriterion("s =", value, "s");
            return (Criteria) this;
        }

        public Criteria andSNotEqualTo(String value) {
            addCriterion("s <>", value, "s");
            return (Criteria) this;
        }

        public Criteria andSGreaterThan(String value) {
            addCriterion("s >", value, "s");
            return (Criteria) this;
        }

        public Criteria andSGreaterThanOrEqualTo(String value) {
            addCriterion("s >=", value, "s");
            return (Criteria) this;
        }

        public Criteria andSLessThan(String value) {
            addCriterion("s <", value, "s");
            return (Criteria) this;
        }

        public Criteria andSLessThanOrEqualTo(String value) {
            addCriterion("s <=", value, "s");
            return (Criteria) this;
        }

        public Criteria andSLike(String value) {
            addCriterion("s like", value, "s");
            return (Criteria) this;
        }

        public Criteria andSNotLike(String value) {
            addCriterion("s not like", value, "s");
            return (Criteria) this;
        }

        public Criteria andSIn(List<String> values) {
            addCriterion("s in", values, "s");
            return (Criteria) this;
        }

        public Criteria andSNotIn(List<String> values) {
            addCriterion("s not in", values, "s");
            return (Criteria) this;
        }

        public Criteria andSBetween(String value1, String value2) {
            addCriterion("s between", value1, value2, "s");
            return (Criteria) this;
        }

        public Criteria andSNotBetween(String value1, String value2) {
            addCriterion("s not between", value1, value2, "s");
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