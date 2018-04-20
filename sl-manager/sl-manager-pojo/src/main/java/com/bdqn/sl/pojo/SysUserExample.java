package com.bdqn.sl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleId is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleId is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Integer value) {
            addCriterion("roleId =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Integer value) {
            addCriterion("roleId <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Integer value) {
            addCriterion("roleId >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roleId >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Integer value) {
            addCriterion("roleId <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Integer value) {
            addCriterion("roleId <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Integer> values) {
            addCriterion("roleId in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Integer> values) {
            addCriterion("roleId not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Integer value1, Integer value2) {
            addCriterion("roleId between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Integer value1, Integer value2) {
            addCriterion("roleId not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNull() {
            addCriterion("referee is null");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNotNull() {
            addCriterion("referee is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeEqualTo(Integer value) {
            addCriterion("referee =", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotEqualTo(Integer value) {
            addCriterion("referee <>", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThan(Integer value) {
            addCriterion("referee >", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThanOrEqualTo(Integer value) {
            addCriterion("referee >=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThan(Integer value) {
            addCriterion("referee <", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThanOrEqualTo(Integer value) {
            addCriterion("referee <=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeIn(List<Integer> values) {
            addCriterion("referee in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotIn(List<Integer> values) {
            addCriterion("referee not in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeBetween(Integer value1, Integer value2) {
            addCriterion("referee between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotBetween(Integer value1, Integer value2) {
            addCriterion("referee not between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andAssociatoridIsNull() {
            addCriterion("associatorId is null");
            return (Criteria) this;
        }

        public Criteria andAssociatoridIsNotNull() {
            addCriterion("associatorId is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatoridEqualTo(Integer value) {
            addCriterion("associatorId =", value, "associatorid");
            return (Criteria) this;
        }

        public Criteria andAssociatoridNotEqualTo(Integer value) {
            addCriterion("associatorId <>", value, "associatorid");
            return (Criteria) this;
        }

        public Criteria andAssociatoridGreaterThan(Integer value) {
            addCriterion("associatorId >", value, "associatorid");
            return (Criteria) this;
        }

        public Criteria andAssociatoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("associatorId >=", value, "associatorid");
            return (Criteria) this;
        }

        public Criteria andAssociatoridLessThan(Integer value) {
            addCriterion("associatorId <", value, "associatorid");
            return (Criteria) this;
        }

        public Criteria andAssociatoridLessThanOrEqualTo(Integer value) {
            addCriterion("associatorId <=", value, "associatorid");
            return (Criteria) this;
        }

        public Criteria andAssociatoridIn(List<Integer> values) {
            addCriterion("associatorId in", values, "associatorid");
            return (Criteria) this;
        }

        public Criteria andAssociatoridNotIn(List<Integer> values) {
            addCriterion("associatorId not in", values, "associatorid");
            return (Criteria) this;
        }

        public Criteria andAssociatoridBetween(Integer value1, Integer value2) {
            addCriterion("associatorId between", value1, value2, "associatorid");
            return (Criteria) this;
        }

        public Criteria andAssociatoridNotBetween(Integer value1, Integer value2) {
            addCriterion("associatorId not between", value1, value2, "associatorid");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNull() {
            addCriterion("loginName is null");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNotNull() {
            addCriterion("loginName is not null");
            return (Criteria) this;
        }

        public Criteria andLoginnameEqualTo(String value) {
            addCriterion("loginName =", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotEqualTo(String value) {
            addCriterion("loginName <>", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThan(String value) {
            addCriterion("loginName >", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("loginName >=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThan(String value) {
            addCriterion("loginName <", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThanOrEqualTo(String value) {
            addCriterion("loginName <=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLike(String value) {
            addCriterion("loginName like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotLike(String value) {
            addCriterion("loginName not like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameIn(List<String> values) {
            addCriterion("loginName in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotIn(List<String> values) {
            addCriterion("loginName not in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameBetween(String value1, String value2) {
            addCriterion("loginName between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotBetween(String value1, String value2) {
            addCriterion("loginName not between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIsNull() {
            addCriterion("loginPwd is null");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIsNotNull() {
            addCriterion("loginPwd is not null");
            return (Criteria) this;
        }

        public Criteria andLoginpwdEqualTo(String value) {
            addCriterion("loginPwd =", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotEqualTo(String value) {
            addCriterion("loginPwd <>", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdGreaterThan(String value) {
            addCriterion("loginPwd >", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdGreaterThanOrEqualTo(String value) {
            addCriterion("loginPwd >=", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLessThan(String value) {
            addCriterion("loginPwd <", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLessThanOrEqualTo(String value) {
            addCriterion("loginPwd <=", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLike(String value) {
            addCriterion("loginPwd like", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotLike(String value) {
            addCriterion("loginPwd not like", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIn(List<String> values) {
            addCriterion("loginPwd in", values, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotIn(List<String> values) {
            addCriterion("loginPwd not in", values, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdBetween(String value1, String value2) {
            addCriterion("loginPwd between", value1, value2, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotBetween(String value1, String value2) {
            addCriterion("loginPwd not between", value1, value2, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2IsNull() {
            addCriterion("loginPwd2 is null");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2IsNotNull() {
            addCriterion("loginPwd2 is not null");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2EqualTo(String value) {
            addCriterion("loginPwd2 =", value, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2NotEqualTo(String value) {
            addCriterion("loginPwd2 <>", value, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2GreaterThan(String value) {
            addCriterion("loginPwd2 >", value, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2GreaterThanOrEqualTo(String value) {
            addCriterion("loginPwd2 >=", value, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2LessThan(String value) {
            addCriterion("loginPwd2 <", value, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2LessThanOrEqualTo(String value) {
            addCriterion("loginPwd2 <=", value, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2Like(String value) {
            addCriterion("loginPwd2 like", value, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2NotLike(String value) {
            addCriterion("loginPwd2 not like", value, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2In(List<String> values) {
            addCriterion("loginPwd2 in", values, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2NotIn(List<String> values) {
            addCriterion("loginPwd2 not in", values, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2Between(String value1, String value2) {
            addCriterion("loginPwd2 between", value1, value2, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andLoginpwd2NotBetween(String value1, String value2) {
            addCriterion("loginPwd2 not between", value1, value2, "loginpwd2");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andCardtypeidIsNull() {
            addCriterion("cardTypeId is null");
            return (Criteria) this;
        }

        public Criteria andCardtypeidIsNotNull() {
            addCriterion("cardTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andCardtypeidEqualTo(Integer value) {
            addCriterion("cardTypeId =", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidNotEqualTo(Integer value) {
            addCriterion("cardTypeId <>", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidGreaterThan(Integer value) {
            addCriterion("cardTypeId >", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cardTypeId >=", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidLessThan(Integer value) {
            addCriterion("cardTypeId <", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidLessThanOrEqualTo(Integer value) {
            addCriterion("cardTypeId <=", value, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidIn(List<Integer> values) {
            addCriterion("cardTypeId in", values, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidNotIn(List<Integer> values) {
            addCriterion("cardTypeId not in", values, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidBetween(Integer value1, Integer value2) {
            addCriterion("cardTypeId between", value1, value2, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardtypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("cardTypeId not between", value1, value2, "cardtypeid");
            return (Criteria) this;
        }

        public Criteria andCardnumberIsNull() {
            addCriterion("cardnumber is null");
            return (Criteria) this;
        }

        public Criteria andCardnumberIsNotNull() {
            addCriterion("cardnumber is not null");
            return (Criteria) this;
        }

        public Criteria andCardnumberEqualTo(String value) {
            addCriterion("cardnumber =", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotEqualTo(String value) {
            addCriterion("cardnumber <>", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberGreaterThan(String value) {
            addCriterion("cardnumber >", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("cardnumber >=", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberLessThan(String value) {
            addCriterion("cardnumber <", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberLessThanOrEqualTo(String value) {
            addCriterion("cardnumber <=", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberLike(String value) {
            addCriterion("cardnumber like", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotLike(String value) {
            addCriterion("cardnumber not like", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberIn(List<String> values) {
            addCriterion("cardnumber in", values, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotIn(List<String> values) {
            addCriterion("cardnumber not in", values, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberBetween(String value1, String value2) {
            addCriterion("cardnumber between", value1, value2, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotBetween(String value1, String value2) {
            addCriterion("cardnumber not between", value1, value2, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardimgIsNull() {
            addCriterion("cardimg is null");
            return (Criteria) this;
        }

        public Criteria andCardimgIsNotNull() {
            addCriterion("cardimg is not null");
            return (Criteria) this;
        }

        public Criteria andCardimgEqualTo(String value) {
            addCriterion("cardimg =", value, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgNotEqualTo(String value) {
            addCriterion("cardimg <>", value, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgGreaterThan(String value) {
            addCriterion("cardimg >", value, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgGreaterThanOrEqualTo(String value) {
            addCriterion("cardimg >=", value, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgLessThan(String value) {
            addCriterion("cardimg <", value, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgLessThanOrEqualTo(String value) {
            addCriterion("cardimg <=", value, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgLike(String value) {
            addCriterion("cardimg like", value, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgNotLike(String value) {
            addCriterion("cardimg not like", value, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgIn(List<String> values) {
            addCriterion("cardimg in", values, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgNotIn(List<String> values) {
            addCriterion("cardimg not in", values, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgBetween(String value1, String value2) {
            addCriterion("cardimg between", value1, value2, "cardimg");
            return (Criteria) this;
        }

        public Criteria andCardimgNotBetween(String value1, String value2) {
            addCriterion("cardimg not between", value1, value2, "cardimg");
            return (Criteria) this;
        }

        public Criteria andYhimgIsNull() {
            addCriterion("yhimg is null");
            return (Criteria) this;
        }

        public Criteria andYhimgIsNotNull() {
            addCriterion("yhimg is not null");
            return (Criteria) this;
        }

        public Criteria andYhimgEqualTo(String value) {
            addCriterion("yhimg =", value, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgNotEqualTo(String value) {
            addCriterion("yhimg <>", value, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgGreaterThan(String value) {
            addCriterion("yhimg >", value, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgGreaterThanOrEqualTo(String value) {
            addCriterion("yhimg >=", value, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgLessThan(String value) {
            addCriterion("yhimg <", value, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgLessThanOrEqualTo(String value) {
            addCriterion("yhimg <=", value, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgLike(String value) {
            addCriterion("yhimg like", value, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgNotLike(String value) {
            addCriterion("yhimg not like", value, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgIn(List<String> values) {
            addCriterion("yhimg in", values, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgNotIn(List<String> values) {
            addCriterion("yhimg not in", values, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgBetween(String value1, String value2) {
            addCriterion("yhimg between", value1, value2, "yhimg");
            return (Criteria) this;
        }

        public Criteria andYhimgNotBetween(String value1, String value2) {
            addCriterion("yhimg not between", value1, value2, "yhimg");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPostalcodeIsNull() {
            addCriterion("postalcode is null");
            return (Criteria) this;
        }

        public Criteria andPostalcodeIsNotNull() {
            addCriterion("postalcode is not null");
            return (Criteria) this;
        }

        public Criteria andPostalcodeEqualTo(Integer value) {
            addCriterion("postalcode =", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotEqualTo(Integer value) {
            addCriterion("postalcode <>", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeGreaterThan(Integer value) {
            addCriterion("postalcode >", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("postalcode >=", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeLessThan(Integer value) {
            addCriterion("postalcode <", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeLessThanOrEqualTo(Integer value) {
            addCriterion("postalcode <=", value, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeIn(List<Integer> values) {
            addCriterion("postalcode in", values, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotIn(List<Integer> values) {
            addCriterion("postalcode not in", values, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeBetween(Integer value1, Integer value2) {
            addCriterion("postalcode between", value1, value2, "postalcode");
            return (Criteria) this;
        }

        public Criteria andPostalcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("postalcode not between", value1, value2, "postalcode");
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

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
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

        public Criteria andBanknameIsNull() {
            addCriterion("bankName is null");
            return (Criteria) this;
        }

        public Criteria andBanknameIsNotNull() {
            addCriterion("bankName is not null");
            return (Criteria) this;
        }

        public Criteria andBanknameEqualTo(String value) {
            addCriterion("bankName =", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotEqualTo(String value) {
            addCriterion("bankName <>", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameGreaterThan(String value) {
            addCriterion("bankName >", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameGreaterThanOrEqualTo(String value) {
            addCriterion("bankName >=", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLessThan(String value) {
            addCriterion("bankName <", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLessThanOrEqualTo(String value) {
            addCriterion("bankName <=", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLike(String value) {
            addCriterion("bankName like", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotLike(String value) {
            addCriterion("bankName not like", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameIn(List<String> values) {
            addCriterion("bankName in", values, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotIn(List<String> values) {
            addCriterion("bankName not in", values, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameBetween(String value1, String value2) {
            addCriterion("bankName between", value1, value2, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotBetween(String value1, String value2) {
            addCriterion("bankName not between", value1, value2, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknumberIsNull() {
            addCriterion("bankNumber is null");
            return (Criteria) this;
        }

        public Criteria andBanknumberIsNotNull() {
            addCriterion("bankNumber is not null");
            return (Criteria) this;
        }

        public Criteria andBanknumberEqualTo(String value) {
            addCriterion("bankNumber =", value, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberNotEqualTo(String value) {
            addCriterion("bankNumber <>", value, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberGreaterThan(String value) {
            addCriterion("bankNumber >", value, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberGreaterThanOrEqualTo(String value) {
            addCriterion("bankNumber >=", value, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberLessThan(String value) {
            addCriterion("bankNumber <", value, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberLessThanOrEqualTo(String value) {
            addCriterion("bankNumber <=", value, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberLike(String value) {
            addCriterion("bankNumber like", value, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberNotLike(String value) {
            addCriterion("bankNumber not like", value, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberIn(List<String> values) {
            addCriterion("bankNumber in", values, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberNotIn(List<String> values) {
            addCriterion("bankNumber not in", values, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberBetween(String value1, String value2) {
            addCriterion("bankNumber between", value1, value2, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBanknumberNotBetween(String value1, String value2) {
            addCriterion("bankNumber not between", value1, value2, "banknumber");
            return (Criteria) this;
        }

        public Criteria andBankunameIsNull() {
            addCriterion("bankUname is null");
            return (Criteria) this;
        }

        public Criteria andBankunameIsNotNull() {
            addCriterion("bankUname is not null");
            return (Criteria) this;
        }

        public Criteria andBankunameEqualTo(String value) {
            addCriterion("bankUname =", value, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameNotEqualTo(String value) {
            addCriterion("bankUname <>", value, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameGreaterThan(String value) {
            addCriterion("bankUname >", value, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameGreaterThanOrEqualTo(String value) {
            addCriterion("bankUname >=", value, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameLessThan(String value) {
            addCriterion("bankUname <", value, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameLessThanOrEqualTo(String value) {
            addCriterion("bankUname <=", value, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameLike(String value) {
            addCriterion("bankUname like", value, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameNotLike(String value) {
            addCriterion("bankUname not like", value, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameIn(List<String> values) {
            addCriterion("bankUname in", values, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameNotIn(List<String> values) {
            addCriterion("bankUname not in", values, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameBetween(String value1, String value2) {
            addCriterion("bankUname between", value1, value2, "bankuname");
            return (Criteria) this;
        }

        public Criteria andBankunameNotBetween(String value1, String value2) {
            addCriterion("bankUname not between", value1, value2, "bankuname");
            return (Criteria) this;
        }

        public Criteria andYmoneyIsNull() {
            addCriterion("yMoney is null");
            return (Criteria) this;
        }

        public Criteria andYmoneyIsNotNull() {
            addCriterion("yMoney is not null");
            return (Criteria) this;
        }

        public Criteria andYmoneyEqualTo(Float value) {
            addCriterion("yMoney =", value, "ymoney");
            return (Criteria) this;
        }

        public Criteria andYmoneyNotEqualTo(Float value) {
            addCriterion("yMoney <>", value, "ymoney");
            return (Criteria) this;
        }

        public Criteria andYmoneyGreaterThan(Float value) {
            addCriterion("yMoney >", value, "ymoney");
            return (Criteria) this;
        }

        public Criteria andYmoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("yMoney >=", value, "ymoney");
            return (Criteria) this;
        }

        public Criteria andYmoneyLessThan(Float value) {
            addCriterion("yMoney <", value, "ymoney");
            return (Criteria) this;
        }

        public Criteria andYmoneyLessThanOrEqualTo(Float value) {
            addCriterion("yMoney <=", value, "ymoney");
            return (Criteria) this;
        }

        public Criteria andYmoneyIn(List<Float> values) {
            addCriterion("yMoney in", values, "ymoney");
            return (Criteria) this;
        }

        public Criteria andYmoneyNotIn(List<Float> values) {
            addCriterion("yMoney not in", values, "ymoney");
            return (Criteria) this;
        }

        public Criteria andYmoneyBetween(Float value1, Float value2) {
            addCriterion("yMoney between", value1, value2, "ymoney");
            return (Criteria) this;
        }

        public Criteria andYmoneyNotBetween(Float value1, Float value2) {
            addCriterion("yMoney not between", value1, value2, "ymoney");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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