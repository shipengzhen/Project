package com.bdqn.sl.pojo;

import java.util.ArrayList;
import java.util.List;

public class SmCExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmCExample() {
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

        public Criteria andSmcSidIsNull() {
            addCriterion("smc_sid is null");
            return (Criteria) this;
        }

        public Criteria andSmcSidIsNotNull() {
            addCriterion("smc_sid is not null");
            return (Criteria) this;
        }

        public Criteria andSmcSidEqualTo(Integer value) {
            addCriterion("smc_sid =", value, "smcSid");
            return (Criteria) this;
        }

        public Criteria andSmcSidNotEqualTo(Integer value) {
            addCriterion("smc_sid <>", value, "smcSid");
            return (Criteria) this;
        }

        public Criteria andSmcSidGreaterThan(Integer value) {
            addCriterion("smc_sid >", value, "smcSid");
            return (Criteria) this;
        }

        public Criteria andSmcSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("smc_sid >=", value, "smcSid");
            return (Criteria) this;
        }

        public Criteria andSmcSidLessThan(Integer value) {
            addCriterion("smc_sid <", value, "smcSid");
            return (Criteria) this;
        }

        public Criteria andSmcSidLessThanOrEqualTo(Integer value) {
            addCriterion("smc_sid <=", value, "smcSid");
            return (Criteria) this;
        }

        public Criteria andSmcSidIn(List<Integer> values) {
            addCriterion("smc_sid in", values, "smcSid");
            return (Criteria) this;
        }

        public Criteria andSmcSidNotIn(List<Integer> values) {
            addCriterion("smc_sid not in", values, "smcSid");
            return (Criteria) this;
        }

        public Criteria andSmcSidBetween(Integer value1, Integer value2) {
            addCriterion("smc_sid between", value1, value2, "smcSid");
            return (Criteria) this;
        }

        public Criteria andSmcSidNotBetween(Integer value1, Integer value2) {
            addCriterion("smc_sid not between", value1, value2, "smcSid");
            return (Criteria) this;
        }

        public Criteria andSmcCidIsNull() {
            addCriterion("smc_cid is null");
            return (Criteria) this;
        }

        public Criteria andSmcCidIsNotNull() {
            addCriterion("smc_cid is not null");
            return (Criteria) this;
        }

        public Criteria andSmcCidEqualTo(Integer value) {
            addCriterion("smc_cid =", value, "smcCid");
            return (Criteria) this;
        }

        public Criteria andSmcCidNotEqualTo(Integer value) {
            addCriterion("smc_cid <>", value, "smcCid");
            return (Criteria) this;
        }

        public Criteria andSmcCidGreaterThan(Integer value) {
            addCriterion("smc_cid >", value, "smcCid");
            return (Criteria) this;
        }

        public Criteria andSmcCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("smc_cid >=", value, "smcCid");
            return (Criteria) this;
        }

        public Criteria andSmcCidLessThan(Integer value) {
            addCriterion("smc_cid <", value, "smcCid");
            return (Criteria) this;
        }

        public Criteria andSmcCidLessThanOrEqualTo(Integer value) {
            addCriterion("smc_cid <=", value, "smcCid");
            return (Criteria) this;
        }

        public Criteria andSmcCidIn(List<Integer> values) {
            addCriterion("smc_cid in", values, "smcCid");
            return (Criteria) this;
        }

        public Criteria andSmcCidNotIn(List<Integer> values) {
            addCriterion("smc_cid not in", values, "smcCid");
            return (Criteria) this;
        }

        public Criteria andSmcCidBetween(Integer value1, Integer value2) {
            addCriterion("smc_cid between", value1, value2, "smcCid");
            return (Criteria) this;
        }

        public Criteria andSmcCidNotBetween(Integer value1, Integer value2) {
            addCriterion("smc_cid not between", value1, value2, "smcCid");
            return (Criteria) this;
        }

        public Criteria andSmcCnumIsNull() {
            addCriterion("smc_cnum is null");
            return (Criteria) this;
        }

        public Criteria andSmcCnumIsNotNull() {
            addCriterion("smc_cnum is not null");
            return (Criteria) this;
        }

        public Criteria andSmcCnumEqualTo(Integer value) {
            addCriterion("smc_cnum =", value, "smcCnum");
            return (Criteria) this;
        }

        public Criteria andSmcCnumNotEqualTo(Integer value) {
            addCriterion("smc_cnum <>", value, "smcCnum");
            return (Criteria) this;
        }

        public Criteria andSmcCnumGreaterThan(Integer value) {
            addCriterion("smc_cnum >", value, "smcCnum");
            return (Criteria) this;
        }

        public Criteria andSmcCnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("smc_cnum >=", value, "smcCnum");
            return (Criteria) this;
        }

        public Criteria andSmcCnumLessThan(Integer value) {
            addCriterion("smc_cnum <", value, "smcCnum");
            return (Criteria) this;
        }

        public Criteria andSmcCnumLessThanOrEqualTo(Integer value) {
            addCriterion("smc_cnum <=", value, "smcCnum");
            return (Criteria) this;
        }

        public Criteria andSmcCnumIn(List<Integer> values) {
            addCriterion("smc_cnum in", values, "smcCnum");
            return (Criteria) this;
        }

        public Criteria andSmcCnumNotIn(List<Integer> values) {
            addCriterion("smc_cnum not in", values, "smcCnum");
            return (Criteria) this;
        }

        public Criteria andSmcCnumBetween(Integer value1, Integer value2) {
            addCriterion("smc_cnum between", value1, value2, "smcCnum");
            return (Criteria) this;
        }

        public Criteria andSmcCnumNotBetween(Integer value1, Integer value2) {
            addCriterion("smc_cnum not between", value1, value2, "smcCnum");
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