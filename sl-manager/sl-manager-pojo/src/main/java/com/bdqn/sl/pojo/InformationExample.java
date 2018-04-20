package com.bdqn.sl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InformationExample() {
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

        public Criteria andZidIsNull() {
            addCriterion("zId is null");
            return (Criteria) this;
        }

        public Criteria andZidIsNotNull() {
            addCriterion("zId is not null");
            return (Criteria) this;
        }

        public Criteria andZidEqualTo(Integer value) {
            addCriterion("zId =", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotEqualTo(Integer value) {
            addCriterion("zId <>", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidGreaterThan(Integer value) {
            addCriterion("zId >", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zId >=", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidLessThan(Integer value) {
            addCriterion("zId <", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidLessThanOrEqualTo(Integer value) {
            addCriterion("zId <=", value, "zid");
            return (Criteria) this;
        }

        public Criteria andZidIn(List<Integer> values) {
            addCriterion("zId in", values, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotIn(List<Integer> values) {
            addCriterion("zId not in", values, "zid");
            return (Criteria) this;
        }

        public Criteria andZidBetween(Integer value1, Integer value2) {
            addCriterion("zId between", value1, value2, "zid");
            return (Criteria) this;
        }

        public Criteria andZidNotBetween(Integer value1, Integer value2) {
            addCriterion("zId not between", value1, value2, "zid");
            return (Criteria) this;
        }

        public Criteria andZtitleIsNull() {
            addCriterion("zTitle is null");
            return (Criteria) this;
        }

        public Criteria andZtitleIsNotNull() {
            addCriterion("zTitle is not null");
            return (Criteria) this;
        }

        public Criteria andZtitleEqualTo(String value) {
            addCriterion("zTitle =", value, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleNotEqualTo(String value) {
            addCriterion("zTitle <>", value, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleGreaterThan(String value) {
            addCriterion("zTitle >", value, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleGreaterThanOrEqualTo(String value) {
            addCriterion("zTitle >=", value, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleLessThan(String value) {
            addCriterion("zTitle <", value, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleLessThanOrEqualTo(String value) {
            addCriterion("zTitle <=", value, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleLike(String value) {
            addCriterion("zTitle like", value, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleNotLike(String value) {
            addCriterion("zTitle not like", value, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleIn(List<String> values) {
            addCriterion("zTitle in", values, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleNotIn(List<String> values) {
            addCriterion("zTitle not in", values, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleBetween(String value1, String value2) {
            addCriterion("zTitle between", value1, value2, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtitleNotBetween(String value1, String value2) {
            addCriterion("zTitle not between", value1, value2, "ztitle");
            return (Criteria) this;
        }

        public Criteria andZtypeidIsNull() {
            addCriterion("zTypeid is null");
            return (Criteria) this;
        }

        public Criteria andZtypeidIsNotNull() {
            addCriterion("zTypeid is not null");
            return (Criteria) this;
        }

        public Criteria andZtypeidEqualTo(Integer value) {
            addCriterion("zTypeid =", value, "ztypeid");
            return (Criteria) this;
        }

        public Criteria andZtypeidNotEqualTo(Integer value) {
            addCriterion("zTypeid <>", value, "ztypeid");
            return (Criteria) this;
        }

        public Criteria andZtypeidGreaterThan(Integer value) {
            addCriterion("zTypeid >", value, "ztypeid");
            return (Criteria) this;
        }

        public Criteria andZtypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zTypeid >=", value, "ztypeid");
            return (Criteria) this;
        }

        public Criteria andZtypeidLessThan(Integer value) {
            addCriterion("zTypeid <", value, "ztypeid");
            return (Criteria) this;
        }

        public Criteria andZtypeidLessThanOrEqualTo(Integer value) {
            addCriterion("zTypeid <=", value, "ztypeid");
            return (Criteria) this;
        }

        public Criteria andZtypeidIn(List<Integer> values) {
            addCriterion("zTypeid in", values, "ztypeid");
            return (Criteria) this;
        }

        public Criteria andZtypeidNotIn(List<Integer> values) {
            addCriterion("zTypeid not in", values, "ztypeid");
            return (Criteria) this;
        }

        public Criteria andZtypeidBetween(Integer value1, Integer value2) {
            addCriterion("zTypeid between", value1, value2, "ztypeid");
            return (Criteria) this;
        }

        public Criteria andZtypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("zTypeid not between", value1, value2, "ztypeid");
            return (Criteria) this;
        }

        public Criteria andZfilesizeIsNull() {
            addCriterion("zFilesize is null");
            return (Criteria) this;
        }

        public Criteria andZfilesizeIsNotNull() {
            addCriterion("zFilesize is not null");
            return (Criteria) this;
        }

        public Criteria andZfilesizeEqualTo(String value) {
            addCriterion("zFilesize =", value, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeNotEqualTo(String value) {
            addCriterion("zFilesize <>", value, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeGreaterThan(String value) {
            addCriterion("zFilesize >", value, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeGreaterThanOrEqualTo(String value) {
            addCriterion("zFilesize >=", value, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeLessThan(String value) {
            addCriterion("zFilesize <", value, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeLessThanOrEqualTo(String value) {
            addCriterion("zFilesize <=", value, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeLike(String value) {
            addCriterion("zFilesize like", value, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeNotLike(String value) {
            addCriterion("zFilesize not like", value, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeIn(List<String> values) {
            addCriterion("zFilesize in", values, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeNotIn(List<String> values) {
            addCriterion("zFilesize not in", values, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeBetween(String value1, String value2) {
            addCriterion("zFilesize between", value1, value2, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andZfilesizeNotBetween(String value1, String value2) {
            addCriterion("zFilesize not between", value1, value2, "zfilesize");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("fileName is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("fileName is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("fileName =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("fileName <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("fileName >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("fileName >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("fileName <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("fileName <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("fileName like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("fileName not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("fileName in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("fileName not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("fileName between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("fileName not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andZfileIsNull() {
            addCriterion("zFile is null");
            return (Criteria) this;
        }

        public Criteria andZfileIsNotNull() {
            addCriterion("zFile is not null");
            return (Criteria) this;
        }

        public Criteria andZfileEqualTo(String value) {
            addCriterion("zFile =", value, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileNotEqualTo(String value) {
            addCriterion("zFile <>", value, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileGreaterThan(String value) {
            addCriterion("zFile >", value, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileGreaterThanOrEqualTo(String value) {
            addCriterion("zFile >=", value, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileLessThan(String value) {
            addCriterion("zFile <", value, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileLessThanOrEqualTo(String value) {
            addCriterion("zFile <=", value, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileLike(String value) {
            addCriterion("zFile like", value, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileNotLike(String value) {
            addCriterion("zFile not like", value, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileIn(List<String> values) {
            addCriterion("zFile in", values, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileNotIn(List<String> values) {
            addCriterion("zFile not in", values, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileBetween(String value1, String value2) {
            addCriterion("zFile between", value1, value2, "zfile");
            return (Criteria) this;
        }

        public Criteria andZfileNotBetween(String value1, String value2) {
            addCriterion("zFile not between", value1, value2, "zfile");
            return (Criteria) this;
        }

        public Criteria andZdocIsNull() {
            addCriterion("zDoc is null");
            return (Criteria) this;
        }

        public Criteria andZdocIsNotNull() {
            addCriterion("zDoc is not null");
            return (Criteria) this;
        }

        public Criteria andZdocEqualTo(String value) {
            addCriterion("zDoc =", value, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocNotEqualTo(String value) {
            addCriterion("zDoc <>", value, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocGreaterThan(String value) {
            addCriterion("zDoc >", value, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocGreaterThanOrEqualTo(String value) {
            addCriterion("zDoc >=", value, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocLessThan(String value) {
            addCriterion("zDoc <", value, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocLessThanOrEqualTo(String value) {
            addCriterion("zDoc <=", value, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocLike(String value) {
            addCriterion("zDoc like", value, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocNotLike(String value) {
            addCriterion("zDoc not like", value, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocIn(List<String> values) {
            addCriterion("zDoc in", values, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocNotIn(List<String> values) {
            addCriterion("zDoc not in", values, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocBetween(String value1, String value2) {
            addCriterion("zDoc between", value1, value2, "zdoc");
            return (Criteria) this;
        }

        public Criteria andZdocNotBetween(String value1, String value2) {
            addCriterion("zDoc not between", value1, value2, "zdoc");
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