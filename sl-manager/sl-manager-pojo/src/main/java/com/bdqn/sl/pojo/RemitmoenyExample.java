package com.bdqn.sl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemitmoenyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RemitmoenyExample() {
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

        public Criteria andRmidIsNull() {
            addCriterion("rmId is null");
            return (Criteria) this;
        }

        public Criteria andRmidIsNotNull() {
            addCriterion("rmId is not null");
            return (Criteria) this;
        }

        public Criteria andRmidEqualTo(Integer value) {
            addCriterion("rmId =", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotEqualTo(Integer value) {
            addCriterion("rmId <>", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidGreaterThan(Integer value) {
            addCriterion("rmId >", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rmId >=", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLessThan(Integer value) {
            addCriterion("rmId <", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLessThanOrEqualTo(Integer value) {
            addCriterion("rmId <=", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidIn(List<Integer> values) {
            addCriterion("rmId in", values, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotIn(List<Integer> values) {
            addCriterion("rmId not in", values, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidBetween(Integer value1, Integer value2) {
            addCriterion("rmId between", value1, value2, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotBetween(Integer value1, Integer value2) {
            addCriterion("rmId not between", value1, value2, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmmoneyIsNull() {
            addCriterion("rmMoney is null");
            return (Criteria) this;
        }

        public Criteria andRmmoneyIsNotNull() {
            addCriterion("rmMoney is not null");
            return (Criteria) this;
        }

        public Criteria andRmmoneyEqualTo(Float value) {
            addCriterion("rmMoney =", value, "rmmoney");
            return (Criteria) this;
        }

        public Criteria andRmmoneyNotEqualTo(Float value) {
            addCriterion("rmMoney <>", value, "rmmoney");
            return (Criteria) this;
        }

        public Criteria andRmmoneyGreaterThan(Float value) {
            addCriterion("rmMoney >", value, "rmmoney");
            return (Criteria) this;
        }

        public Criteria andRmmoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("rmMoney >=", value, "rmmoney");
            return (Criteria) this;
        }

        public Criteria andRmmoneyLessThan(Float value) {
            addCriterion("rmMoney <", value, "rmmoney");
            return (Criteria) this;
        }

        public Criteria andRmmoneyLessThanOrEqualTo(Float value) {
            addCriterion("rmMoney <=", value, "rmmoney");
            return (Criteria) this;
        }

        public Criteria andRmmoneyIn(List<Float> values) {
            addCriterion("rmMoney in", values, "rmmoney");
            return (Criteria) this;
        }

        public Criteria andRmmoneyNotIn(List<Float> values) {
            addCriterion("rmMoney not in", values, "rmmoney");
            return (Criteria) this;
        }

        public Criteria andRmmoneyBetween(Float value1, Float value2) {
            addCriterion("rmMoney between", value1, value2, "rmmoney");
            return (Criteria) this;
        }

        public Criteria andRmmoneyNotBetween(Float value1, Float value2) {
            addCriterion("rmMoney not between", value1, value2, "rmmoney");
            return (Criteria) this;
        }

        public Criteria andRmtypeIsNull() {
            addCriterion("rmType is null");
            return (Criteria) this;
        }

        public Criteria andRmtypeIsNotNull() {
            addCriterion("rmType is not null");
            return (Criteria) this;
        }

        public Criteria andRmtypeEqualTo(Integer value) {
            addCriterion("rmType =", value, "rmtype");
            return (Criteria) this;
        }

        public Criteria andRmtypeNotEqualTo(Integer value) {
            addCriterion("rmType <>", value, "rmtype");
            return (Criteria) this;
        }

        public Criteria andRmtypeGreaterThan(Integer value) {
            addCriterion("rmType >", value, "rmtype");
            return (Criteria) this;
        }

        public Criteria andRmtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rmType >=", value, "rmtype");
            return (Criteria) this;
        }

        public Criteria andRmtypeLessThan(Integer value) {
            addCriterion("rmType <", value, "rmtype");
            return (Criteria) this;
        }

        public Criteria andRmtypeLessThanOrEqualTo(Integer value) {
            addCriterion("rmType <=", value, "rmtype");
            return (Criteria) this;
        }

        public Criteria andRmtypeIn(List<Integer> values) {
            addCriterion("rmType in", values, "rmtype");
            return (Criteria) this;
        }

        public Criteria andRmtypeNotIn(List<Integer> values) {
            addCriterion("rmType not in", values, "rmtype");
            return (Criteria) this;
        }

        public Criteria andRmtypeBetween(Integer value1, Integer value2) {
            addCriterion("rmType between", value1, value2, "rmtype");
            return (Criteria) this;
        }

        public Criteria andRmtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("rmType not between", value1, value2, "rmtype");
            return (Criteria) this;
        }

        public Criteria andRmdocIsNull() {
            addCriterion("rmDoc is null");
            return (Criteria) this;
        }

        public Criteria andRmdocIsNotNull() {
            addCriterion("rmDoc is not null");
            return (Criteria) this;
        }

        public Criteria andRmdocEqualTo(String value) {
            addCriterion("rmDoc =", value, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocNotEqualTo(String value) {
            addCriterion("rmDoc <>", value, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocGreaterThan(String value) {
            addCriterion("rmDoc >", value, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocGreaterThanOrEqualTo(String value) {
            addCriterion("rmDoc >=", value, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocLessThan(String value) {
            addCriterion("rmDoc <", value, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocLessThanOrEqualTo(String value) {
            addCriterion("rmDoc <=", value, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocLike(String value) {
            addCriterion("rmDoc like", value, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocNotLike(String value) {
            addCriterion("rmDoc not like", value, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocIn(List<String> values) {
            addCriterion("rmDoc in", values, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocNotIn(List<String> values) {
            addCriterion("rmDoc not in", values, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocBetween(String value1, String value2) {
            addCriterion("rmDoc between", value1, value2, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmdocNotBetween(String value1, String value2) {
            addCriterion("rmDoc not between", value1, value2, "rmdoc");
            return (Criteria) this;
        }

        public Criteria andRmnumIsNull() {
            addCriterion("rmNum is null");
            return (Criteria) this;
        }

        public Criteria andRmnumIsNotNull() {
            addCriterion("rmNum is not null");
            return (Criteria) this;
        }

        public Criteria andRmnumEqualTo(String value) {
            addCriterion("rmNum =", value, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumNotEqualTo(String value) {
            addCriterion("rmNum <>", value, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumGreaterThan(String value) {
            addCriterion("rmNum >", value, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumGreaterThanOrEqualTo(String value) {
            addCriterion("rmNum >=", value, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumLessThan(String value) {
            addCriterion("rmNum <", value, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumLessThanOrEqualTo(String value) {
            addCriterion("rmNum <=", value, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumLike(String value) {
            addCriterion("rmNum like", value, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumNotLike(String value) {
            addCriterion("rmNum not like", value, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumIn(List<String> values) {
            addCriterion("rmNum in", values, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumNotIn(List<String> values) {
            addCriterion("rmNum not in", values, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumBetween(String value1, String value2) {
            addCriterion("rmNum between", value1, value2, "rmnum");
            return (Criteria) this;
        }

        public Criteria andRmnumNotBetween(String value1, String value2) {
            addCriterion("rmNum not between", value1, value2, "rmnum");
            return (Criteria) this;
        }

        public Criteria andCreateuidIsNull() {
            addCriterion("createUid is null");
            return (Criteria) this;
        }

        public Criteria andCreateuidIsNotNull() {
            addCriterion("createUid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuidEqualTo(Integer value) {
            addCriterion("createUid =", value, "createuid");
            return (Criteria) this;
        }

        public Criteria andCreateuidNotEqualTo(Integer value) {
            addCriterion("createUid <>", value, "createuid");
            return (Criteria) this;
        }

        public Criteria andCreateuidGreaterThan(Integer value) {
            addCriterion("createUid >", value, "createuid");
            return (Criteria) this;
        }

        public Criteria andCreateuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("createUid >=", value, "createuid");
            return (Criteria) this;
        }

        public Criteria andCreateuidLessThan(Integer value) {
            addCriterion("createUid <", value, "createuid");
            return (Criteria) this;
        }

        public Criteria andCreateuidLessThanOrEqualTo(Integer value) {
            addCriterion("createUid <=", value, "createuid");
            return (Criteria) this;
        }

        public Criteria andCreateuidIn(List<Integer> values) {
            addCriterion("createUid in", values, "createuid");
            return (Criteria) this;
        }

        public Criteria andCreateuidNotIn(List<Integer> values) {
            addCriterion("createUid not in", values, "createuid");
            return (Criteria) this;
        }

        public Criteria andCreateuidBetween(Integer value1, Integer value2) {
            addCriterion("createUid between", value1, value2, "createuid");
            return (Criteria) this;
        }

        public Criteria andCreateuidNotBetween(Integer value1, Integer value2) {
            addCriterion("createUid not between", value1, value2, "createuid");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdateuidIsNull() {
            addCriterion("updateUid is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuidIsNotNull() {
            addCriterion("updateUid is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuidEqualTo(Integer value) {
            addCriterion("updateUid =", value, "updateuid");
            return (Criteria) this;
        }

        public Criteria andUpdateuidNotEqualTo(Integer value) {
            addCriterion("updateUid <>", value, "updateuid");
            return (Criteria) this;
        }

        public Criteria andUpdateuidGreaterThan(Integer value) {
            addCriterion("updateUid >", value, "updateuid");
            return (Criteria) this;
        }

        public Criteria andUpdateuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("updateUid >=", value, "updateuid");
            return (Criteria) this;
        }

        public Criteria andUpdateuidLessThan(Integer value) {
            addCriterion("updateUid <", value, "updateuid");
            return (Criteria) this;
        }

        public Criteria andUpdateuidLessThanOrEqualTo(Integer value) {
            addCriterion("updateUid <=", value, "updateuid");
            return (Criteria) this;
        }

        public Criteria andUpdateuidIn(List<Integer> values) {
            addCriterion("updateUid in", values, "updateuid");
            return (Criteria) this;
        }

        public Criteria andUpdateuidNotIn(List<Integer> values) {
            addCriterion("updateUid not in", values, "updateuid");
            return (Criteria) this;
        }

        public Criteria andUpdateuidBetween(Integer value1, Integer value2) {
            addCriterion("updateUid between", value1, value2, "updateuid");
            return (Criteria) this;
        }

        public Criteria andUpdateuidNotBetween(Integer value1, Integer value2) {
            addCriterion("updateUid not between", value1, value2, "updateuid");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
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