package hci.dky.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssessLibraryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssessLibraryExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andAssessIdIsNull() {
            addCriterion("assess_id is null");
            return (Criteria) this;
        }

        public Criteria andAssessIdIsNotNull() {
            addCriterion("assess_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssessIdEqualTo(Long value) {
            addCriterion("assess_id =", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdNotEqualTo(Long value) {
            addCriterion("assess_id <>", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdGreaterThan(Long value) {
            addCriterion("assess_id >", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("assess_id >=", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdLessThan(Long value) {
            addCriterion("assess_id <", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdLessThanOrEqualTo(Long value) {
            addCriterion("assess_id <=", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdIn(List<Long> values) {
            addCriterion("assess_id in", values, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdNotIn(List<Long> values) {
            addCriterion("assess_id not in", values, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdBetween(Long value1, Long value2) {
            addCriterion("assess_id between", value1, value2, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdNotBetween(Long value1, Long value2) {
            addCriterion("assess_id not between", value1, value2, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessNameIsNull() {
            addCriterion("assess_name is null");
            return (Criteria) this;
        }

        public Criteria andAssessNameIsNotNull() {
            addCriterion("assess_name is not null");
            return (Criteria) this;
        }

        public Criteria andAssessNameEqualTo(String value) {
            addCriterion("assess_name =", value, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameNotEqualTo(String value) {
            addCriterion("assess_name <>", value, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameGreaterThan(String value) {
            addCriterion("assess_name >", value, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameGreaterThanOrEqualTo(String value) {
            addCriterion("assess_name >=", value, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameLessThan(String value) {
            addCriterion("assess_name <", value, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameLessThanOrEqualTo(String value) {
            addCriterion("assess_name <=", value, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameLike(String value) {
            addCriterion("assess_name like", value, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameNotLike(String value) {
            addCriterion("assess_name not like", value, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameIn(List<String> values) {
            addCriterion("assess_name in", values, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameNotIn(List<String> values) {
            addCriterion("assess_name not in", values, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameBetween(String value1, String value2) {
            addCriterion("assess_name between", value1, value2, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessNameNotBetween(String value1, String value2) {
            addCriterion("assess_name not between", value1, value2, "assessName");
            return (Criteria) this;
        }

        public Criteria andAssessDesIsNull() {
            addCriterion("assess_des is null");
            return (Criteria) this;
        }

        public Criteria andAssessDesIsNotNull() {
            addCriterion("assess_des is not null");
            return (Criteria) this;
        }

        public Criteria andAssessDesEqualTo(String value) {
            addCriterion("assess_des =", value, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesNotEqualTo(String value) {
            addCriterion("assess_des <>", value, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesGreaterThan(String value) {
            addCriterion("assess_des >", value, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesGreaterThanOrEqualTo(String value) {
            addCriterion("assess_des >=", value, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesLessThan(String value) {
            addCriterion("assess_des <", value, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesLessThanOrEqualTo(String value) {
            addCriterion("assess_des <=", value, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesLike(String value) {
            addCriterion("assess_des like", value, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesNotLike(String value) {
            addCriterion("assess_des not like", value, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesIn(List<String> values) {
            addCriterion("assess_des in", values, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesNotIn(List<String> values) {
            addCriterion("assess_des not in", values, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesBetween(String value1, String value2) {
            addCriterion("assess_des between", value1, value2, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessDesNotBetween(String value1, String value2) {
            addCriterion("assess_des not between", value1, value2, "assessDes");
            return (Criteria) this;
        }

        public Criteria andAssessObjectIsNull() {
            addCriterion("assess_object is null");
            return (Criteria) this;
        }

        public Criteria andAssessObjectIsNotNull() {
            addCriterion("assess_object is not null");
            return (Criteria) this;
        }

        public Criteria andAssessObjectEqualTo(String value) {
            addCriterion("assess_object =", value, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectNotEqualTo(String value) {
            addCriterion("assess_object <>", value, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectGreaterThan(String value) {
            addCriterion("assess_object >", value, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectGreaterThanOrEqualTo(String value) {
            addCriterion("assess_object >=", value, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectLessThan(String value) {
            addCriterion("assess_object <", value, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectLessThanOrEqualTo(String value) {
            addCriterion("assess_object <=", value, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectLike(String value) {
            addCriterion("assess_object like", value, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectNotLike(String value) {
            addCriterion("assess_object not like", value, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectIn(List<String> values) {
            addCriterion("assess_object in", values, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectNotIn(List<String> values) {
            addCriterion("assess_object not in", values, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectBetween(String value1, String value2) {
            addCriterion("assess_object between", value1, value2, "assessObject");
            return (Criteria) this;
        }

        public Criteria andAssessObjectNotBetween(String value1, String value2) {
            addCriterion("assess_object not between", value1, value2, "assessObject");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andAssessStateIsNull() {
            addCriterion("assess_state is null");
            return (Criteria) this;
        }

        public Criteria andAssessStateIsNotNull() {
            addCriterion("assess_state is not null");
            return (Criteria) this;
        }

        public Criteria andAssessStateEqualTo(String value) {
            addCriterion("assess_state =", value, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateNotEqualTo(String value) {
            addCriterion("assess_state <>", value, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateGreaterThan(String value) {
            addCriterion("assess_state >", value, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateGreaterThanOrEqualTo(String value) {
            addCriterion("assess_state >=", value, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateLessThan(String value) {
            addCriterion("assess_state <", value, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateLessThanOrEqualTo(String value) {
            addCriterion("assess_state <=", value, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateLike(String value) {
            addCriterion("assess_state like", value, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateNotLike(String value) {
            addCriterion("assess_state not like", value, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateIn(List<String> values) {
            addCriterion("assess_state in", values, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateNotIn(List<String> values) {
            addCriterion("assess_state not in", values, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateBetween(String value1, String value2) {
            addCriterion("assess_state between", value1, value2, "assessState");
            return (Criteria) this;
        }

        public Criteria andAssessStateNotBetween(String value1, String value2) {
            addCriterion("assess_state not between", value1, value2, "assessState");
            return (Criteria) this;
        }

        public Criteria andIsModelIsNull() {
            addCriterion("is_model is null");
            return (Criteria) this;
        }

        public Criteria andIsModelIsNotNull() {
            addCriterion("is_model is not null");
            return (Criteria) this;
        }

        public Criteria andIsModelEqualTo(Boolean value) {
            addCriterion("is_model =", value, "isModel");
            return (Criteria) this;
        }

        public Criteria andIsModelNotEqualTo(Boolean value) {
            addCriterion("is_model <>", value, "isModel");
            return (Criteria) this;
        }

        public Criteria andIsModelGreaterThan(Boolean value) {
            addCriterion("is_model >", value, "isModel");
            return (Criteria) this;
        }

        public Criteria andIsModelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_model >=", value, "isModel");
            return (Criteria) this;
        }

        public Criteria andIsModelLessThan(Boolean value) {
            addCriterion("is_model <", value, "isModel");
            return (Criteria) this;
        }

        public Criteria andIsModelLessThanOrEqualTo(Boolean value) {
            addCriterion("is_model <=", value, "isModel");
            return (Criteria) this;
        }

        public Criteria andIsModelIn(List<Boolean> values) {
            addCriterion("is_model in", values, "isModel");
            return (Criteria) this;
        }

        public Criteria andIsModelNotIn(List<Boolean> values) {
            addCriterion("is_model not in", values, "isModel");
            return (Criteria) this;
        }

        public Criteria andIsModelBetween(Boolean value1, Boolean value2) {
            addCriterion("is_model between", value1, value2, "isModel");
            return (Criteria) this;
        }

        public Criteria andIsModelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_model not between", value1, value2, "isModel");
            return (Criteria) this;
        }

        public Criteria andIndexListIsNull() {
            addCriterion("index_list is null");
            return (Criteria) this;
        }

        public Criteria andIndexListIsNotNull() {
            addCriterion("index_list is not null");
            return (Criteria) this;
        }

        public Criteria andIndexListEqualTo(String value) {
            addCriterion("index_list =", value, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListNotEqualTo(String value) {
            addCriterion("index_list <>", value, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListGreaterThan(String value) {
            addCriterion("index_list >", value, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListGreaterThanOrEqualTo(String value) {
            addCriterion("index_list >=", value, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListLessThan(String value) {
            addCriterion("index_list <", value, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListLessThanOrEqualTo(String value) {
            addCriterion("index_list <=", value, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListLike(String value) {
            addCriterion("index_list like", value, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListNotLike(String value) {
            addCriterion("index_list not like", value, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListIn(List<String> values) {
            addCriterion("index_list in", values, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListNotIn(List<String> values) {
            addCriterion("index_list not in", values, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListBetween(String value1, String value2) {
            addCriterion("index_list between", value1, value2, "indexList");
            return (Criteria) this;
        }

        public Criteria andIndexListNotBetween(String value1, String value2) {
            addCriterion("index_list not between", value1, value2, "indexList");
            return (Criteria) this;
        }

        public Criteria andIsExistIsNull() {
            addCriterion("is_exist is null");
            return (Criteria) this;
        }

        public Criteria andIsExistIsNotNull() {
            addCriterion("is_exist is not null");
            return (Criteria) this;
        }

        public Criteria andIsExistEqualTo(Boolean value) {
            addCriterion("is_exist =", value, "isExist");
            return (Criteria) this;
        }

        public Criteria andIsExistNotEqualTo(Boolean value) {
            addCriterion("is_exist <>", value, "isExist");
            return (Criteria) this;
        }

        public Criteria andIsExistGreaterThan(Boolean value) {
            addCriterion("is_exist >", value, "isExist");
            return (Criteria) this;
        }

        public Criteria andIsExistGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_exist >=", value, "isExist");
            return (Criteria) this;
        }

        public Criteria andIsExistLessThan(Boolean value) {
            addCriterion("is_exist <", value, "isExist");
            return (Criteria) this;
        }

        public Criteria andIsExistLessThanOrEqualTo(Boolean value) {
            addCriterion("is_exist <=", value, "isExist");
            return (Criteria) this;
        }

        public Criteria andIsExistIn(List<Boolean> values) {
            addCriterion("is_exist in", values, "isExist");
            return (Criteria) this;
        }

        public Criteria andIsExistNotIn(List<Boolean> values) {
            addCriterion("is_exist not in", values, "isExist");
            return (Criteria) this;
        }

        public Criteria andIsExistBetween(Boolean value1, Boolean value2) {
            addCriterion("is_exist between", value1, value2, "isExist");
            return (Criteria) this;
        }

        public Criteria andIsExistNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_exist not between", value1, value2, "isExist");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListIsNull() {
            addCriterion("index_method_list is null");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListIsNotNull() {
            addCriterion("index_method_list is not null");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListEqualTo(String value) {
            addCriterion("index_method_list =", value, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListNotEqualTo(String value) {
            addCriterion("index_method_list <>", value, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListGreaterThan(String value) {
            addCriterion("index_method_list >", value, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListGreaterThanOrEqualTo(String value) {
            addCriterion("index_method_list >=", value, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListLessThan(String value) {
            addCriterion("index_method_list <", value, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListLessThanOrEqualTo(String value) {
            addCriterion("index_method_list <=", value, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListLike(String value) {
            addCriterion("index_method_list like", value, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListNotLike(String value) {
            addCriterion("index_method_list not like", value, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListIn(List<String> values) {
            addCriterion("index_method_list in", values, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListNotIn(List<String> values) {
            addCriterion("index_method_list not in", values, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListBetween(String value1, String value2) {
            addCriterion("index_method_list between", value1, value2, "indexMethodList");
            return (Criteria) this;
        }

        public Criteria andIndexMethodListNotBetween(String value1, String value2) {
            addCriterion("index_method_list not between", value1, value2, "indexMethodList");
            return (Criteria) this;
        }
    }

    /**
     */
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