package com.gsccs.sme.plat.svg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.gsccs.sme.plat.bass.BaseExample;

public class ProjectTExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectTExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
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

        public Criteria andIntypeIsNull() {
            addCriterion("intype is null");
            return (Criteria) this;
        }

        public Criteria andIntypeIsNotNull() {
            addCriterion("intype is not null");
            return (Criteria) this;
        }

        public Criteria andIntypeEqualTo(String value) {
            addCriterion("intype =", value, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeNotEqualTo(String value) {
            addCriterion("intype <>", value, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeGreaterThan(String value) {
            addCriterion("intype >", value, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeGreaterThanOrEqualTo(String value) {
            addCriterion("intype >=", value, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeLessThan(String value) {
            addCriterion("intype <", value, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeLessThanOrEqualTo(String value) {
            addCriterion("intype <=", value, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeLike(String value) {
            addCriterion("intype like", value, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeNotLike(String value) {
            addCriterion("intype not like", value, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeIn(List<String> values) {
            addCriterion("intype in", values, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeNotIn(List<String> values) {
            addCriterion("intype not in", values, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeBetween(String value1, String value2) {
            addCriterion("intype between", value1, value2, "intype");
            return (Criteria) this;
        }

        public Criteria andIntypeNotBetween(String value1, String value2) {
            addCriterion("intype not between", value1, value2, "intype");
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
        
        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andCorpidNotEqualTo(String value) {
            addCriterion("corpid <>", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidGreaterThan(String value) {
            addCriterion("corpid >", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidGreaterThanOrEqualTo(String value) {
            addCriterion("corpid >=", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidLessThan(String value) {
            addCriterion("corpid <", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidLessThanOrEqualTo(String value) {
            addCriterion("corpid <=", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidLike(String value) {
            addCriterion("corpid like", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotLike(String value) {
            addCriterion("corpid not like", value, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidIn(List<String> values) {
            addCriterion("corpid in", values, "corpid");
            return (Criteria) this;
        }

        public Criteria andCorpidNotIn(List<String> values) {
            addCriterion("corpid not in", values, "corpid");
            return (Criteria) this;
        }


        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBackdropIsNull() {
            addCriterion("backdrop is null");
            return (Criteria) this;
        }

        public Criteria andBackdropIsNotNull() {
            addCriterion("backdrop is not null");
            return (Criteria) this;
        }

        public Criteria andBackdropEqualTo(String value) {
            addCriterion("backdrop =", value, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropNotEqualTo(String value) {
            addCriterion("backdrop <>", value, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropGreaterThan(String value) {
            addCriterion("backdrop >", value, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropGreaterThanOrEqualTo(String value) {
            addCriterion("backdrop >=", value, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropLessThan(String value) {
            addCriterion("backdrop <", value, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropLessThanOrEqualTo(String value) {
            addCriterion("backdrop <=", value, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropLike(String value) {
            addCriterion("backdrop like", value, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropNotLike(String value) {
            addCriterion("backdrop not like", value, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropIn(List<String> values) {
            addCriterion("backdrop in", values, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropNotIn(List<String> values) {
            addCriterion("backdrop not in", values, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropBetween(String value1, String value2) {
            addCriterion("backdrop between", value1, value2, "backdrop");
            return (Criteria) this;
        }

        public Criteria andBackdropNotBetween(String value1, String value2) {
            addCriterion("backdrop not between", value1, value2, "backdrop");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("starttime not between", value1, value2, "starttime");
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
            addCriterionForJDBCDate("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andInvestIsNull() {
            addCriterion("invest is null");
            return (Criteria) this;
        }

        public Criteria andInvestIsNotNull() {
            addCriterion("invest is not null");
            return (Criteria) this;
        }

        public Criteria andInvestEqualTo(String value) {
            addCriterion("invest =", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestNotEqualTo(String value) {
            addCriterion("invest <>", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestGreaterThan(String value) {
            addCriterion("invest >", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestGreaterThanOrEqualTo(String value) {
            addCriterion("invest >=", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestLessThan(String value) {
            addCriterion("invest <", value, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestLessThanOrEqualTo(String value) {
            addCriterion("invest <=", value, "invest");
            return (Criteria) this;
        }

        
        public Criteria andInvestBetween(String value1, String value2) {
            addCriterion("invest between", value1, value2, "invest");
            return (Criteria) this;
        }

        public Criteria andInvestNotBetween(String value1, String value2) {
            addCriterion("invest not between", value1, value2, "invest");
            return (Criteria) this;
        }

        public Criteria andMoneytypeIsNull() {
            addCriterion("moneyType is null");
            return (Criteria) this;
        }

        public Criteria andMoneytypeIsNotNull() {
            addCriterion("moneyType is not null");
            return (Criteria) this;
        }

        public Criteria andMoneytypeEqualTo(String value) {
            addCriterion("moneyType =", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeNotEqualTo(String value) {
            addCriterion("moneyType <>", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeGreaterThan(String value) {
            addCriterion("moneyType >", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeGreaterThanOrEqualTo(String value) {
            addCriterion("moneyType >=", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeLessThan(String value) {
            addCriterion("moneyType <", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeLessThanOrEqualTo(String value) {
            addCriterion("moneyType <=", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeLike(String value) {
            addCriterion("moneyType like", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeNotLike(String value) {
            addCriterion("moneyType not like", value, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeIn(List<String> values) {
            addCriterion("moneyType in", values, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeNotIn(List<String> values) {
            addCriterion("moneyType not in", values, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeBetween(String value1, String value2) {
            addCriterion("moneyType between", value1, value2, "moneytype");
            return (Criteria) this;
        }

        public Criteria andMoneytypeNotBetween(String value1, String value2) {
            addCriterion("moneyType not between", value1, value2, "moneytype");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
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