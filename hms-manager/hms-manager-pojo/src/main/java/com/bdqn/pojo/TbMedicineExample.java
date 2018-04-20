package com.bdqn.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbMedicineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbMedicineExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andJpriceIsNull() {
            addCriterion("jprice is null");
            return (Criteria) this;
        }

        public Criteria andJpriceIsNotNull() {
            addCriterion("jprice is not null");
            return (Criteria) this;
        }

        public Criteria andJpriceEqualTo(BigDecimal value) {
            addCriterion("jprice =", value, "jprice");
            return (Criteria) this;
        }

        public Criteria andJpriceNotEqualTo(BigDecimal value) {
            addCriterion("jprice <>", value, "jprice");
            return (Criteria) this;
        }

        public Criteria andJpriceGreaterThan(BigDecimal value) {
            addCriterion("jprice >", value, "jprice");
            return (Criteria) this;
        }

        public Criteria andJpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jprice >=", value, "jprice");
            return (Criteria) this;
        }

        public Criteria andJpriceLessThan(BigDecimal value) {
            addCriterion("jprice <", value, "jprice");
            return (Criteria) this;
        }

        public Criteria andJpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("jprice <=", value, "jprice");
            return (Criteria) this;
        }

        public Criteria andJpriceIn(List<BigDecimal> values) {
            addCriterion("jprice in", values, "jprice");
            return (Criteria) this;
        }

        public Criteria andJpriceNotIn(List<BigDecimal> values) {
            addCriterion("jprice not in", values, "jprice");
            return (Criteria) this;
        }

        public Criteria andJpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jprice between", value1, value2, "jprice");
            return (Criteria) this;
        }

        public Criteria andJpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jprice not between", value1, value2, "jprice");
            return (Criteria) this;
        }

        public Criteria andSpriceIsNull() {
            addCriterion("sprice is null");
            return (Criteria) this;
        }

        public Criteria andSpriceIsNotNull() {
            addCriterion("sprice is not null");
            return (Criteria) this;
        }

        public Criteria andSpriceEqualTo(BigDecimal value) {
            addCriterion("sprice =", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceNotEqualTo(BigDecimal value) {
            addCriterion("sprice <>", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceGreaterThan(BigDecimal value) {
            addCriterion("sprice >", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sprice >=", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceLessThan(BigDecimal value) {
            addCriterion("sprice <", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sprice <=", value, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceIn(List<BigDecimal> values) {
            addCriterion("sprice in", values, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceNotIn(List<BigDecimal> values) {
            addCriterion("sprice not in", values, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sprice between", value1, value2, "sprice");
            return (Criteria) this;
        }

        public Criteria andSpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sprice not between", value1, value2, "sprice");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeIsNull() {
            addCriterion("medicineNmae is null");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeIsNotNull() {
            addCriterion("medicineNmae is not null");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeEqualTo(String value) {
            addCriterion("medicineNmae =", value, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeNotEqualTo(String value) {
            addCriterion("medicineNmae <>", value, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeGreaterThan(String value) {
            addCriterion("medicineNmae >", value, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeGreaterThanOrEqualTo(String value) {
            addCriterion("medicineNmae >=", value, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeLessThan(String value) {
            addCriterion("medicineNmae <", value, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeLessThanOrEqualTo(String value) {
            addCriterion("medicineNmae <=", value, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeLike(String value) {
            addCriterion("medicineNmae like", value, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeNotLike(String value) {
            addCriterion("medicineNmae not like", value, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeIn(List<String> values) {
            addCriterion("medicineNmae in", values, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeNotIn(List<String> values) {
            addCriterion("medicineNmae not in", values, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeBetween(String value1, String value2) {
            addCriterion("medicineNmae between", value1, value2, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinenmaeNotBetween(String value1, String value2) {
            addCriterion("medicineNmae not between", value1, value2, "medicinenmae");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeIsNull() {
            addCriterion("medicineType is null");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeIsNotNull() {
            addCriterion("medicineType is not null");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeEqualTo(String value) {
            addCriterion("medicineType =", value, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeNotEqualTo(String value) {
            addCriterion("medicineType <>", value, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeGreaterThan(String value) {
            addCriterion("medicineType >", value, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeGreaterThanOrEqualTo(String value) {
            addCriterion("medicineType >=", value, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeLessThan(String value) {
            addCriterion("medicineType <", value, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeLessThanOrEqualTo(String value) {
            addCriterion("medicineType <=", value, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeLike(String value) {
            addCriterion("medicineType like", value, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeNotLike(String value) {
            addCriterion("medicineType not like", value, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeIn(List<String> values) {
            addCriterion("medicineType in", values, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeNotIn(List<String> values) {
            addCriterion("medicineType not in", values, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeBetween(String value1, String value2) {
            addCriterion("medicineType between", value1, value2, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andMedicinetypeNotBetween(String value1, String value2) {
            addCriterion("medicineType not between", value1, value2, "medicinetype");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNull() {
            addCriterion("describe is null");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("describe is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("describe =", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("describe <>", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThan(String value) {
            addCriterion("describe >", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("describe >=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThan(String value) {
            addCriterion("describe <", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThanOrEqualTo(String value) {
            addCriterion("describe <=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLike(String value) {
            addCriterion("describe like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("describe not like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("describe in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("describe not in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("describe between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("describe not between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andQgpIsNull() {
            addCriterion("QGP is null");
            return (Criteria) this;
        }

        public Criteria andQgpIsNotNull() {
            addCriterion("QGP is not null");
            return (Criteria) this;
        }

        public Criteria andQgpEqualTo(String value) {
            addCriterion("QGP =", value, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpNotEqualTo(String value) {
            addCriterion("QGP <>", value, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpGreaterThan(String value) {
            addCriterion("QGP >", value, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpGreaterThanOrEqualTo(String value) {
            addCriterion("QGP >=", value, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpLessThan(String value) {
            addCriterion("QGP <", value, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpLessThanOrEqualTo(String value) {
            addCriterion("QGP <=", value, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpLike(String value) {
            addCriterion("QGP like", value, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpNotLike(String value) {
            addCriterion("QGP not like", value, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpIn(List<String> values) {
            addCriterion("QGP in", values, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpNotIn(List<String> values) {
            addCriterion("QGP not in", values, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpBetween(String value1, String value2) {
            addCriterion("QGP between", value1, value2, "qgp");
            return (Criteria) this;
        }

        public Criteria andQgpNotBetween(String value1, String value2) {
            addCriterion("QGP not between", value1, value2, "qgp");
            return (Criteria) this;
        }

        public Criteria andDocIsNull() {
            addCriterion("doc is null");
            return (Criteria) this;
        }

        public Criteria andDocIsNotNull() {
            addCriterion("doc is not null");
            return (Criteria) this;
        }

        public Criteria andDocEqualTo(String value) {
            addCriterion("doc =", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotEqualTo(String value) {
            addCriterion("doc <>", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocGreaterThan(String value) {
            addCriterion("doc >", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocGreaterThanOrEqualTo(String value) {
            addCriterion("doc >=", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocLessThan(String value) {
            addCriterion("doc <", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocLessThanOrEqualTo(String value) {
            addCriterion("doc <=", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocLike(String value) {
            addCriterion("doc like", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotLike(String value) {
            addCriterion("doc not like", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocIn(List<String> values) {
            addCriterion("doc in", values, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotIn(List<String> values) {
            addCriterion("doc not in", values, "doc");
            return (Criteria) this;
        }

        public Criteria andDocBetween(String value1, String value2) {
            addCriterion("doc between", value1, value2, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotBetween(String value1, String value2) {
            addCriterion("doc not between", value1, value2, "doc");
            return (Criteria) this;
        }

        public Criteria andFactoryIsNull() {
            addCriterion("factory is null");
            return (Criteria) this;
        }

        public Criteria andFactoryIsNotNull() {
            addCriterion("factory is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryEqualTo(String value) {
            addCriterion("factory =", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotEqualTo(String value) {
            addCriterion("factory <>", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryGreaterThan(String value) {
            addCriterion("factory >", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryGreaterThanOrEqualTo(String value) {
            addCriterion("factory >=", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLessThan(String value) {
            addCriterion("factory <", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLessThanOrEqualTo(String value) {
            addCriterion("factory <=", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryLike(String value) {
            addCriterion("factory like", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotLike(String value) {
            addCriterion("factory not like", value, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryIn(List<String> values) {
            addCriterion("factory in", values, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotIn(List<String> values) {
            addCriterion("factory not in", values, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryBetween(String value1, String value2) {
            addCriterion("factory between", value1, value2, "factory");
            return (Criteria) this;
        }

        public Criteria andFactoryNotBetween(String value1, String value2) {
            addCriterion("factory not between", value1, value2, "factory");
            return (Criteria) this;
        }

        public Criteria andEatdocIsNull() {
            addCriterion("eatdoc is null");
            return (Criteria) this;
        }

        public Criteria andEatdocIsNotNull() {
            addCriterion("eatdoc is not null");
            return (Criteria) this;
        }

        public Criteria andEatdocEqualTo(String value) {
            addCriterion("eatdoc =", value, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocNotEqualTo(String value) {
            addCriterion("eatdoc <>", value, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocGreaterThan(String value) {
            addCriterion("eatdoc >", value, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocGreaterThanOrEqualTo(String value) {
            addCriterion("eatdoc >=", value, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocLessThan(String value) {
            addCriterion("eatdoc <", value, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocLessThanOrEqualTo(String value) {
            addCriterion("eatdoc <=", value, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocLike(String value) {
            addCriterion("eatdoc like", value, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocNotLike(String value) {
            addCriterion("eatdoc not like", value, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocIn(List<String> values) {
            addCriterion("eatdoc in", values, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocNotIn(List<String> values) {
            addCriterion("eatdoc not in", values, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocBetween(String value1, String value2) {
            addCriterion("eatdoc between", value1, value2, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andEatdocNotBetween(String value1, String value2) {
            addCriterion("eatdoc not between", value1, value2, "eatdoc");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
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