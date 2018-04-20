package com.bdqn.sl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AfficheExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AfficheExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("gId is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gId is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gId =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gId <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gId >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gId >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gId <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gId <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gId in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gId not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gId between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gId not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGtitleIsNull() {
            addCriterion("gTitle is null");
            return (Criteria) this;
        }

        public Criteria andGtitleIsNotNull() {
            addCriterion("gTitle is not null");
            return (Criteria) this;
        }

        public Criteria andGtitleEqualTo(String value) {
            addCriterion("gTitle =", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleNotEqualTo(String value) {
            addCriterion("gTitle <>", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleGreaterThan(String value) {
            addCriterion("gTitle >", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleGreaterThanOrEqualTo(String value) {
            addCriterion("gTitle >=", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleLessThan(String value) {
            addCriterion("gTitle <", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleLessThanOrEqualTo(String value) {
            addCriterion("gTitle <=", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleLike(String value) {
            addCriterion("gTitle like", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleNotLike(String value) {
            addCriterion("gTitle not like", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleIn(List<String> values) {
            addCriterion("gTitle in", values, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleNotIn(List<String> values) {
            addCriterion("gTitle not in", values, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleBetween(String value1, String value2) {
            addCriterion("gTitle between", value1, value2, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleNotBetween(String value1, String value2) {
            addCriterion("gTitle not between", value1, value2, "gtitle");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNull() {
            addCriterion("beginDate is null");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNotNull() {
            addCriterion("beginDate is not null");
            return (Criteria) this;
        }

        public Criteria andBegindateEqualTo(Date value) {
            addCriterion("beginDate =", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotEqualTo(Date value) {
            addCriterion("beginDate <>", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThan(Date value) {
            addCriterion("beginDate >", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThanOrEqualTo(Date value) {
            addCriterion("beginDate >=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThan(Date value) {
            addCriterion("beginDate <", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThanOrEqualTo(Date value) {
            addCriterion("beginDate <=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateIn(List<Date> values) {
            addCriterion("beginDate in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotIn(List<Date> values) {
            addCriterion("beginDate not in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateBetween(Date value1, Date value2) {
            addCriterion("beginDate between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotBetween(Date value1, Date value2) {
            addCriterion("beginDate not between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("endDate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("endDate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("endDate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("endDate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("endDate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("endDate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("endDate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("endDate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("endDate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("endDate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andGdocIsNull() {
            addCriterion("gDoc is null");
            return (Criteria) this;
        }

        public Criteria andGdocIsNotNull() {
            addCriterion("gDoc is not null");
            return (Criteria) this;
        }

        public Criteria andGdocEqualTo(String value) {
            addCriterion("gDoc =", value, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocNotEqualTo(String value) {
            addCriterion("gDoc <>", value, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocGreaterThan(String value) {
            addCriterion("gDoc >", value, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocGreaterThanOrEqualTo(String value) {
            addCriterion("gDoc >=", value, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocLessThan(String value) {
            addCriterion("gDoc <", value, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocLessThanOrEqualTo(String value) {
            addCriterion("gDoc <=", value, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocLike(String value) {
            addCriterion("gDoc like", value, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocNotLike(String value) {
            addCriterion("gDoc not like", value, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocIn(List<String> values) {
            addCriterion("gDoc in", values, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocNotIn(List<String> values) {
            addCriterion("gDoc not in", values, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocBetween(String value1, String value2) {
            addCriterion("gDoc between", value1, value2, "gdoc");
            return (Criteria) this;
        }

        public Criteria andGdocNotBetween(String value1, String value2) {
            addCriterion("gDoc not between", value1, value2, "gdoc");
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