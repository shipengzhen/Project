package com.bdqn.sl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysDictionaryExample {

	protected String groupByClause;

	public String getGroupByClause() {
		return groupByClause;
	}

	public void setGroupByClause(String groupByClause) {
		this.groupByClause = groupByClause;
	}

	protected String columns;

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SysDictionaryExample() {
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

		public Criteria andDictionaryidIsNull() {
			addCriterion("dictionaryId is null");
			return (Criteria) this;
		}

		public Criteria andDictionaryidIsNotNull() {
			addCriterion("dictionaryId is not null");
			return (Criteria) this;
		}

		public Criteria andDictionaryidEqualTo(Integer value) {
			addCriterion("dictionaryId =", value, "dictionaryid");
			return (Criteria) this;
		}

		public Criteria andDictionaryidNotEqualTo(Integer value) {
			addCriterion("dictionaryId <>", value, "dictionaryid");
			return (Criteria) this;
		}

		public Criteria andDictionaryidGreaterThan(Integer value) {
			addCriterion("dictionaryId >", value, "dictionaryid");
			return (Criteria) this;
		}

		public Criteria andDictionaryidGreaterThanOrEqualTo(Integer value) {
			addCriterion("dictionaryId >=", value, "dictionaryid");
			return (Criteria) this;
		}

		public Criteria andDictionaryidLessThan(Integer value) {
			addCriterion("dictionaryId <", value, "dictionaryid");
			return (Criteria) this;
		}

		public Criteria andDictionaryidLessThanOrEqualTo(Integer value) {
			addCriterion("dictionaryId <=", value, "dictionaryid");
			return (Criteria) this;
		}

		public Criteria andDictionaryidIn(List<Integer> values) {
			addCriterion("dictionaryId in", values, "dictionaryid");
			return (Criteria) this;
		}

		public Criteria andDictionaryidNotIn(List<Integer> values) {
			addCriterion("dictionaryId not in", values, "dictionaryid");
			return (Criteria) this;
		}

		public Criteria andDictionaryidBetween(Integer value1, Integer value2) {
			addCriterion("dictionaryId between", value1, value2, "dictionaryid");
			return (Criteria) this;
		}

		public Criteria andDictionaryidNotBetween(Integer value1, Integer value2) {
			addCriterion("dictionaryId not between", value1, value2, "dictionaryid");
			return (Criteria) this;
		}

		public Criteria andTypecodeIsNull() {
			addCriterion("typeCode is null");
			return (Criteria) this;
		}

		public Criteria andTypecodeIsNotNull() {
			addCriterion("typeCode is not null");
			return (Criteria) this;
		}

		public Criteria andTypecodeEqualTo(String value) {
			addCriterion("typeCode =", value, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeNotEqualTo(String value) {
			addCriterion("typeCode <>", value, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeGreaterThan(String value) {
			addCriterion("typeCode >", value, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeGreaterThanOrEqualTo(String value) {
			addCriterion("typeCode >=", value, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeLessThan(String value) {
			addCriterion("typeCode <", value, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeLessThanOrEqualTo(String value) {
			addCriterion("typeCode <=", value, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeLike(String value) {
			addCriterion("typeCode like", value, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeNotLike(String value) {
			addCriterion("typeCode not like", value, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeIn(List<String> values) {
			addCriterion("typeCode in", values, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeNotIn(List<String> values) {
			addCriterion("typeCode not in", values, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeBetween(String value1, String value2) {
			addCriterion("typeCode between", value1, value2, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypecodeNotBetween(String value1, String value2) {
			addCriterion("typeCode not between", value1, value2, "typecode");
			return (Criteria) this;
		}

		public Criteria andTypenameIsNull() {
			addCriterion("typeName is null");
			return (Criteria) this;
		}

		public Criteria andTypenameIsNotNull() {
			addCriterion("typeName is not null");
			return (Criteria) this;
		}

		public Criteria andTypenameEqualTo(String value) {
			addCriterion("typeName =", value, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameNotEqualTo(String value) {
			addCriterion("typeName <>", value, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameGreaterThan(String value) {
			addCriterion("typeName >", value, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameGreaterThanOrEqualTo(String value) {
			addCriterion("typeName >=", value, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameLessThan(String value) {
			addCriterion("typeName <", value, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameLessThanOrEqualTo(String value) {
			addCriterion("typeName <=", value, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameLike(String value) {
			addCriterion("typeName like", value, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameNotLike(String value) {
			addCriterion("typeName not like", value, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameIn(List<String> values) {
			addCriterion("typeName in", values, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameNotIn(List<String> values) {
			addCriterion("typeName not in", values, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameBetween(String value1, String value2) {
			addCriterion("typeName between", value1, value2, "typename");
			return (Criteria) this;
		}

		public Criteria andTypenameNotBetween(String value1, String value2) {
			addCriterion("typeName not between", value1, value2, "typename");
			return (Criteria) this;
		}

		public Criteria andValuenameIsNull() {
			addCriterion("valueName is null");
			return (Criteria) this;
		}

		public Criteria andValuenameIsNotNull() {
			addCriterion("valueName is not null");
			return (Criteria) this;
		}

		public Criteria andValuenameEqualTo(String value) {
			addCriterion("valueName =", value, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameNotEqualTo(String value) {
			addCriterion("valueName <>", value, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameGreaterThan(String value) {
			addCriterion("valueName >", value, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameGreaterThanOrEqualTo(String value) {
			addCriterion("valueName >=", value, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameLessThan(String value) {
			addCriterion("valueName <", value, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameLessThanOrEqualTo(String value) {
			addCriterion("valueName <=", value, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameLike(String value) {
			addCriterion("valueName like", value, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameNotLike(String value) {
			addCriterion("valueName not like", value, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameIn(List<String> values) {
			addCriterion("valueName in", values, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameNotIn(List<String> values) {
			addCriterion("valueName not in", values, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameBetween(String value1, String value2) {
			addCriterion("valueName between", value1, value2, "valuename");
			return (Criteria) this;
		}

		public Criteria andValuenameNotBetween(String value1, String value2) {
			addCriterion("valueName not between", value1, value2, "valuename");
			return (Criteria) this;
		}

		public Criteria andDescribedIsNull() {
			addCriterion("described is null");
			return (Criteria) this;
		}

		public Criteria andDescribedIsNotNull() {
			addCriterion("described is not null");
			return (Criteria) this;
		}

		public Criteria andDescribedEqualTo(String value) {
			addCriterion("described =", value, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedNotEqualTo(String value) {
			addCriterion("described <>", value, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedGreaterThan(String value) {
			addCriterion("described >", value, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedGreaterThanOrEqualTo(String value) {
			addCriterion("described >=", value, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedLessThan(String value) {
			addCriterion("described <", value, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedLessThanOrEqualTo(String value) {
			addCriterion("described <=", value, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedLike(String value) {
			addCriterion("described like", value, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedNotLike(String value) {
			addCriterion("described not like", value, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedIn(List<String> values) {
			addCriterion("described in", values, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedNotIn(List<String> values) {
			addCriterion("described not in", values, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedBetween(String value1, String value2) {
			addCriterion("described between", value1, value2, "described");
			return (Criteria) this;
		}

		public Criteria andDescribedNotBetween(String value1, String value2) {
			addCriterion("described not between", value1, value2, "described");
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