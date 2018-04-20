package com.bdqn.sl.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrdersCSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersCSExample() {
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

        public Criteria andOcsOidIsNull() {
            addCriterion("ocs_oid is null");
            return (Criteria) this;
        }

        public Criteria andOcsOidIsNotNull() {
            addCriterion("ocs_oid is not null");
            return (Criteria) this;
        }

        public Criteria andOcsOidEqualTo(Integer value) {
            addCriterion("ocs_oid =", value, "ocsOid");
            return (Criteria) this;
        }

        public Criteria andOcsOidNotEqualTo(Integer value) {
            addCriterion("ocs_oid <>", value, "ocsOid");
            return (Criteria) this;
        }

        public Criteria andOcsOidGreaterThan(Integer value) {
            addCriterion("ocs_oid >", value, "ocsOid");
            return (Criteria) this;
        }

        public Criteria andOcsOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ocs_oid >=", value, "ocsOid");
            return (Criteria) this;
        }

        public Criteria andOcsOidLessThan(Integer value) {
            addCriterion("ocs_oid <", value, "ocsOid");
            return (Criteria) this;
        }

        public Criteria andOcsOidLessThanOrEqualTo(Integer value) {
            addCriterion("ocs_oid <=", value, "ocsOid");
            return (Criteria) this;
        }

        public Criteria andOcsOidIn(List<Integer> values) {
            addCriterion("ocs_oid in", values, "ocsOid");
            return (Criteria) this;
        }

        public Criteria andOcsOidNotIn(List<Integer> values) {
            addCriterion("ocs_oid not in", values, "ocsOid");
            return (Criteria) this;
        }

        public Criteria andOcsOidBetween(Integer value1, Integer value2) {
            addCriterion("ocs_oid between", value1, value2, "ocsOid");
            return (Criteria) this;
        }

        public Criteria andOcsOidNotBetween(Integer value1, Integer value2) {
            addCriterion("ocs_oid not between", value1, value2, "ocsOid");
            return (Criteria) this;
        }

        public Criteria andOcsCsidIsNull() {
            addCriterion("ocs_csid is null");
            return (Criteria) this;
        }

        public Criteria andOcsCsidIsNotNull() {
            addCriterion("ocs_csid is not null");
            return (Criteria) this;
        }

        public Criteria andOcsCsidEqualTo(Integer value) {
            addCriterion("ocs_csid =", value, "ocsCsid");
            return (Criteria) this;
        }

        public Criteria andOcsCsidNotEqualTo(Integer value) {
            addCriterion("ocs_csid <>", value, "ocsCsid");
            return (Criteria) this;
        }

        public Criteria andOcsCsidGreaterThan(Integer value) {
            addCriterion("ocs_csid >", value, "ocsCsid");
            return (Criteria) this;
        }

        public Criteria andOcsCsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ocs_csid >=", value, "ocsCsid");
            return (Criteria) this;
        }

        public Criteria andOcsCsidLessThan(Integer value) {
            addCriterion("ocs_csid <", value, "ocsCsid");
            return (Criteria) this;
        }

        public Criteria andOcsCsidLessThanOrEqualTo(Integer value) {
            addCriterion("ocs_csid <=", value, "ocsCsid");
            return (Criteria) this;
        }

        public Criteria andOcsCsidIn(List<Integer> values) {
            addCriterion("ocs_csid in", values, "ocsCsid");
            return (Criteria) this;
        }

        public Criteria andOcsCsidNotIn(List<Integer> values) {
            addCriterion("ocs_csid not in", values, "ocsCsid");
            return (Criteria) this;
        }

        public Criteria andOcsCsidBetween(Integer value1, Integer value2) {
            addCriterion("ocs_csid between", value1, value2, "ocsCsid");
            return (Criteria) this;
        }

        public Criteria andOcsCsidNotBetween(Integer value1, Integer value2) {
            addCriterion("ocs_csid not between", value1, value2, "ocsCsid");
            return (Criteria) this;
        }

        public Criteria andCstypeIsNull() {
            addCriterion("csType is null");
            return (Criteria) this;
        }

        public Criteria andCstypeIsNotNull() {
            addCriterion("csType is not null");
            return (Criteria) this;
        }

        public Criteria andCstypeEqualTo(Integer value) {
            addCriterion("csType =", value, "cstype");
            return (Criteria) this;
        }

        public Criteria andCstypeNotEqualTo(Integer value) {
            addCriterion("csType <>", value, "cstype");
            return (Criteria) this;
        }

        public Criteria andCstypeGreaterThan(Integer value) {
            addCriterion("csType >", value, "cstype");
            return (Criteria) this;
        }

        public Criteria andCstypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("csType >=", value, "cstype");
            return (Criteria) this;
        }

        public Criteria andCstypeLessThan(Integer value) {
            addCriterion("csType <", value, "cstype");
            return (Criteria) this;
        }

        public Criteria andCstypeLessThanOrEqualTo(Integer value) {
            addCriterion("csType <=", value, "cstype");
            return (Criteria) this;
        }

        public Criteria andCstypeIn(List<Integer> values) {
            addCriterion("csType in", values, "cstype");
            return (Criteria) this;
        }

        public Criteria andCstypeNotIn(List<Integer> values) {
            addCriterion("csType not in", values, "cstype");
            return (Criteria) this;
        }

        public Criteria andCstypeBetween(Integer value1, Integer value2) {
            addCriterion("csType between", value1, value2, "cstype");
            return (Criteria) this;
        }

        public Criteria andCstypeNotBetween(Integer value1, Integer value2) {
            addCriterion("csType not between", value1, value2, "cstype");
            return (Criteria) this;
        }

        public Criteria andOcsCnumIsNull() {
            addCriterion("ocs_cnum is null");
            return (Criteria) this;
        }

        public Criteria andOcsCnumIsNotNull() {
            addCriterion("ocs_cnum is not null");
            return (Criteria) this;
        }

        public Criteria andOcsCnumEqualTo(Integer value) {
            addCriterion("ocs_cnum =", value, "ocsCnum");
            return (Criteria) this;
        }

        public Criteria andOcsCnumNotEqualTo(Integer value) {
            addCriterion("ocs_cnum <>", value, "ocsCnum");
            return (Criteria) this;
        }

        public Criteria andOcsCnumGreaterThan(Integer value) {
            addCriterion("ocs_cnum >", value, "ocsCnum");
            return (Criteria) this;
        }

        public Criteria andOcsCnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ocs_cnum >=", value, "ocsCnum");
            return (Criteria) this;
        }

        public Criteria andOcsCnumLessThan(Integer value) {
            addCriterion("ocs_cnum <", value, "ocsCnum");
            return (Criteria) this;
        }

        public Criteria andOcsCnumLessThanOrEqualTo(Integer value) {
            addCriterion("ocs_cnum <=", value, "ocsCnum");
            return (Criteria) this;
        }

        public Criteria andOcsCnumIn(List<Integer> values) {
            addCriterion("ocs_cnum in", values, "ocsCnum");
            return (Criteria) this;
        }

        public Criteria andOcsCnumNotIn(List<Integer> values) {
            addCriterion("ocs_cnum not in", values, "ocsCnum");
            return (Criteria) this;
        }

        public Criteria andOcsCnumBetween(Integer value1, Integer value2) {
            addCriterion("ocs_cnum between", value1, value2, "ocsCnum");
            return (Criteria) this;
        }

        public Criteria andOcsCnumNotBetween(Integer value1, Integer value2) {
            addCriterion("ocs_cnum not between", value1, value2, "ocsCnum");
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