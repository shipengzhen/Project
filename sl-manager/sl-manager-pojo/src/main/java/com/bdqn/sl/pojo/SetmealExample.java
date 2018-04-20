package com.bdqn.sl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SetmealExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    protected String columns;
    protected String limit;

    public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public SetmealExample() {
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

        public Criteria andSmidIsNull() {
            addCriterion("smId is null");
            return (Criteria) this;
        }

        public Criteria andSmidIsNotNull() {
            addCriterion("smId is not null");
            return (Criteria) this;
        }

        public Criteria andSmidEqualTo(Integer value) {
            addCriterion("smId =", value, "smid");
            return (Criteria) this;
        }

        public Criteria andSmidNotEqualTo(Integer value) {
            addCriterion("smId <>", value, "smid");
            return (Criteria) this;
        }

        public Criteria andSmidGreaterThan(Integer value) {
            addCriterion("smId >", value, "smid");
            return (Criteria) this;
        }

        public Criteria andSmidGreaterThanOrEqualTo(Integer value) {
            addCriterion("smId >=", value, "smid");
            return (Criteria) this;
        }

        public Criteria andSmidLessThan(Integer value) {
            addCriterion("smId <", value, "smid");
            return (Criteria) this;
        }

        public Criteria andSmidLessThanOrEqualTo(Integer value) {
            addCriterion("smId <=", value, "smid");
            return (Criteria) this;
        }

        public Criteria andSmidIn(List<Integer> values) {
            addCriterion("smId in", values, "smid");
            return (Criteria) this;
        }

        public Criteria andSmidNotIn(List<Integer> values) {
            addCriterion("smId not in", values, "smid");
            return (Criteria) this;
        }

        public Criteria andSmidBetween(Integer value1, Integer value2) {
            addCriterion("smId between", value1, value2, "smid");
            return (Criteria) this;
        }

        public Criteria andSmidNotBetween(Integer value1, Integer value2) {
            addCriterion("smId not between", value1, value2, "smid");
            return (Criteria) this;
        }

        public Criteria andSmnameIsNull() {
            addCriterion("smName is null");
            return (Criteria) this;
        }

        public Criteria andSmnameIsNotNull() {
            addCriterion("smName is not null");
            return (Criteria) this;
        }

        public Criteria andSmnameEqualTo(String value) {
            addCriterion("smName =", value, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameNotEqualTo(String value) {
            addCriterion("smName <>", value, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameGreaterThan(String value) {
            addCriterion("smName >", value, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameGreaterThanOrEqualTo(String value) {
            addCriterion("smName >=", value, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameLessThan(String value) {
            addCriterion("smName <", value, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameLessThanOrEqualTo(String value) {
            addCriterion("smName <=", value, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameLike(String value) {
            addCriterion("smName like", value, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameNotLike(String value) {
            addCriterion("smName not like", value, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameIn(List<String> values) {
            addCriterion("smName in", values, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameNotIn(List<String> values) {
            addCriterion("smName not in", values, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameBetween(String value1, String value2) {
            addCriterion("smName between", value1, value2, "smname");
            return (Criteria) this;
        }

        public Criteria andSmnameNotBetween(String value1, String value2) {
            addCriterion("smName not between", value1, value2, "smname");
            return (Criteria) this;
        }

        public Criteria andSmtypeidIsNull() {
            addCriterion("smTypeId is null");
            return (Criteria) this;
        }

        public Criteria andSmtypeidIsNotNull() {
            addCriterion("smTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andSmtypeidEqualTo(Integer value) {
            addCriterion("smTypeId =", value, "smtypeid");
            return (Criteria) this;
        }

        public Criteria andSmtypeidNotEqualTo(Integer value) {
            addCriterion("smTypeId <>", value, "smtypeid");
            return (Criteria) this;
        }

        public Criteria andSmtypeidGreaterThan(Integer value) {
            addCriterion("smTypeId >", value, "smtypeid");
            return (Criteria) this;
        }

        public Criteria andSmtypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("smTypeId >=", value, "smtypeid");
            return (Criteria) this;
        }

        public Criteria andSmtypeidLessThan(Integer value) {
            addCriterion("smTypeId <", value, "smtypeid");
            return (Criteria) this;
        }

        public Criteria andSmtypeidLessThanOrEqualTo(Integer value) {
            addCriterion("smTypeId <=", value, "smtypeid");
            return (Criteria) this;
        }

        public Criteria andSmtypeidIn(List<Integer> values) {
            addCriterion("smTypeId in", values, "smtypeid");
            return (Criteria) this;
        }

        public Criteria andSmtypeidNotIn(List<Integer> values) {
            addCriterion("smTypeId not in", values, "smtypeid");
            return (Criteria) this;
        }

        public Criteria andSmtypeidBetween(Integer value1, Integer value2) {
            addCriterion("smTypeId between", value1, value2, "smtypeid");
            return (Criteria) this;
        }

        public Criteria andSmtypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("smTypeId not between", value1, value2, "smtypeid");
            return (Criteria) this;
        }

        public Criteria andSmpriceIsNull() {
            addCriterion("smPrice is null");
            return (Criteria) this;
        }

        public Criteria andSmpriceIsNotNull() {
            addCriterion("smPrice is not null");
            return (Criteria) this;
        }

        public Criteria andSmpriceEqualTo(Float value) {
            addCriterion("smPrice =", value, "smprice");
            return (Criteria) this;
        }

        public Criteria andSmpriceNotEqualTo(Float value) {
            addCriterion("smPrice <>", value, "smprice");
            return (Criteria) this;
        }

        public Criteria andSmpriceGreaterThan(Float value) {
            addCriterion("smPrice >", value, "smprice");
            return (Criteria) this;
        }

        public Criteria andSmpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("smPrice >=", value, "smprice");
            return (Criteria) this;
        }

        public Criteria andSmpriceLessThan(Float value) {
            addCriterion("smPrice <", value, "smprice");
            return (Criteria) this;
        }

        public Criteria andSmpriceLessThanOrEqualTo(Float value) {
            addCriterion("smPrice <=", value, "smprice");
            return (Criteria) this;
        }

        public Criteria andSmpriceIn(List<Float> values) {
            addCriterion("smPrice in", values, "smprice");
            return (Criteria) this;
        }

        public Criteria andSmpriceNotIn(List<Float> values) {
            addCriterion("smPrice not in", values, "smprice");
            return (Criteria) this;
        }

        public Criteria andSmpriceBetween(Float value1, Float value2) {
            addCriterion("smPrice between", value1, value2, "smprice");
            return (Criteria) this;
        }

        public Criteria andSmpriceNotBetween(Float value1, Float value2) {
            addCriterion("smPrice not between", value1, value2, "smprice");
            return (Criteria) this;
        }

        public Criteria andSmstaticIsNull() {
            addCriterion("smStatic is null");
            return (Criteria) this;
        }

        public Criteria andSmstaticIsNotNull() {
            addCriterion("smStatic is not null");
            return (Criteria) this;
        }

        public Criteria andSmstaticEqualTo(Integer value) {
            addCriterion("smStatic =", value, "smstatic");
            return (Criteria) this;
        }

        public Criteria andSmstaticNotEqualTo(Integer value) {
            addCriterion("smStatic <>", value, "smstatic");
            return (Criteria) this;
        }

        public Criteria andSmstaticGreaterThan(Integer value) {
            addCriterion("smStatic >", value, "smstatic");
            return (Criteria) this;
        }

        public Criteria andSmstaticGreaterThanOrEqualTo(Integer value) {
            addCriterion("smStatic >=", value, "smstatic");
            return (Criteria) this;
        }

        public Criteria andSmstaticLessThan(Integer value) {
            addCriterion("smStatic <", value, "smstatic");
            return (Criteria) this;
        }

        public Criteria andSmstaticLessThanOrEqualTo(Integer value) {
            addCriterion("smStatic <=", value, "smstatic");
            return (Criteria) this;
        }

        public Criteria andSmstaticIn(List<Integer> values) {
            addCriterion("smStatic in", values, "smstatic");
            return (Criteria) this;
        }

        public Criteria andSmstaticNotIn(List<Integer> values) {
            addCriterion("smStatic not in", values, "smstatic");
            return (Criteria) this;
        }

        public Criteria andSmstaticBetween(Integer value1, Integer value2) {
            addCriterion("smStatic between", value1, value2, "smstatic");
            return (Criteria) this;
        }

        public Criteria andSmstaticNotBetween(Integer value1, Integer value2) {
            addCriterion("smStatic not between", value1, value2, "smstatic");
            return (Criteria) this;
        }

        public Criteria andSmnumberIsNull() {
            addCriterion("smNumber is null");
            return (Criteria) this;
        }

        public Criteria andSmnumberIsNotNull() {
            addCriterion("smNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSmnumberEqualTo(Integer value) {
            addCriterion("smNumber =", value, "smnumber");
            return (Criteria) this;
        }

        public Criteria andSmnumberNotEqualTo(Integer value) {
            addCriterion("smNumber <>", value, "smnumber");
            return (Criteria) this;
        }

        public Criteria andSmnumberGreaterThan(Integer value) {
            addCriterion("smNumber >", value, "smnumber");
            return (Criteria) this;
        }

        public Criteria andSmnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("smNumber >=", value, "smnumber");
            return (Criteria) this;
        }

        public Criteria andSmnumberLessThan(Integer value) {
            addCriterion("smNumber <", value, "smnumber");
            return (Criteria) this;
        }

        public Criteria andSmnumberLessThanOrEqualTo(Integer value) {
            addCriterion("smNumber <=", value, "smnumber");
            return (Criteria) this;
        }

        public Criteria andSmnumberIn(List<Integer> values) {
            addCriterion("smNumber in", values, "smnumber");
            return (Criteria) this;
        }

        public Criteria andSmnumberNotIn(List<Integer> values) {
            addCriterion("smNumber not in", values, "smnumber");
            return (Criteria) this;
        }

        public Criteria andSmnumberBetween(Integer value1, Integer value2) {
            addCriterion("smNumber between", value1, value2, "smnumber");
            return (Criteria) this;
        }

        public Criteria andSmnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("smNumber not between", value1, value2, "smnumber");
            return (Criteria) this;
        }

        public Criteria andSmdocIsNull() {
            addCriterion("smDoc is null");
            return (Criteria) this;
        }

        public Criteria andSmdocIsNotNull() {
            addCriterion("smDoc is not null");
            return (Criteria) this;
        }

        public Criteria andSmdocEqualTo(String value) {
            addCriterion("smDoc =", value, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocNotEqualTo(String value) {
            addCriterion("smDoc <>", value, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocGreaterThan(String value) {
            addCriterion("smDoc >", value, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocGreaterThanOrEqualTo(String value) {
            addCriterion("smDoc >=", value, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocLessThan(String value) {
            addCriterion("smDoc <", value, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocLessThanOrEqualTo(String value) {
            addCriterion("smDoc <=", value, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocLike(String value) {
            addCriterion("smDoc like", value, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocNotLike(String value) {
            addCriterion("smDoc not like", value, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocIn(List<String> values) {
            addCriterion("smDoc in", values, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocNotIn(List<String> values) {
            addCriterion("smDoc not in", values, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocBetween(String value1, String value2) {
            addCriterion("smDoc between", value1, value2, "smdoc");
            return (Criteria) this;
        }

        public Criteria andSmdocNotBetween(String value1, String value2) {
            addCriterion("smDoc not between", value1, value2, "smdoc");
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