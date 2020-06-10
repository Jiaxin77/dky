package hci.dky.pojo;

import java.util.ArrayList;
import java.util.List;

public class AssessAndPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssessAndPlanExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNull() {
            addCriterion("plan_type is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("plan_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(String value) {
            addCriterion("plan_type =", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(String value) {
            addCriterion("plan_type <>", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(String value) {
            addCriterion("plan_type >", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_type >=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(String value) {
            addCriterion("plan_type <", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(String value) {
            addCriterion("plan_type <=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLike(String value) {
            addCriterion("plan_type like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotLike(String value) {
            addCriterion("plan_type not like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<String> values) {
            addCriterion("plan_type in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<String> values) {
            addCriterion("plan_type not in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(String value1, String value2) {
            addCriterion("plan_type between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(String value1, String value2) {
            addCriterion("plan_type not between", value1, value2, "planType");
            return (Criteria) this;
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