package hci.dky.pojo;

import java.util.ArrayList;
import java.util.List;

public class ExpertObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpertObjectExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andObjectIsNull() {
            addCriterion("`object` is null");
            return (Criteria) this;
        }

        public Criteria andObjectIsNotNull() {
            addCriterion("`object` is not null");
            return (Criteria) this;
        }

        public Criteria andObjectEqualTo(String value) {
            addCriterion("`object` =", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectNotEqualTo(String value) {
            addCriterion("`object` <>", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectGreaterThan(String value) {
            addCriterion("`object` >", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectGreaterThanOrEqualTo(String value) {
            addCriterion("`object` >=", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectLessThan(String value) {
            addCriterion("`object` <", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectLessThanOrEqualTo(String value) {
            addCriterion("`object` <=", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectLike(String value) {
            addCriterion("`object` like", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectNotLike(String value) {
            addCriterion("`object` not like", value, "object");
            return (Criteria) this;
        }

        public Criteria andObjectIn(List<String> values) {
            addCriterion("`object` in", values, "object");
            return (Criteria) this;
        }

        public Criteria andObjectNotIn(List<String> values) {
            addCriterion("`object` not in", values, "object");
            return (Criteria) this;
        }

        public Criteria andObjectBetween(String value1, String value2) {
            addCriterion("`object` between", value1, value2, "object");
            return (Criteria) this;
        }

        public Criteria andObjectNotBetween(String value1, String value2) {
            addCriterion("`object` not between", value1, value2, "object");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberIsNull() {
            addCriterion("question_number is null");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberIsNotNull() {
            addCriterion("question_number is not null");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberEqualTo(Integer value) {
            addCriterion("question_number =", value, "question_number");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberNotEqualTo(Integer value) {
            addCriterion("question_number <>", value, "question_number");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberGreaterThan(Integer value) {
            addCriterion("question_number >", value, "question_number");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_number >=", value, "question_number");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberLessThan(Integer value) {
            addCriterion("question_number <", value, "question_number");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberLessThanOrEqualTo(Integer value) {
            addCriterion("question_number <=", value, "question_number");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberIn(List<Integer> values) {
            addCriterion("question_number in", values, "question_number");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberNotIn(List<Integer> values) {
            addCriterion("question_number not in", values, "question_number");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberBetween(Integer value1, Integer value2) {
            addCriterion("question_number between", value1, value2, "question_number");
            return (Criteria) this;
        }

        public Criteria andQuestion_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("question_number not between", value1, value2, "question_number");
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