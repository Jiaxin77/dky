package hci.dky.pojo;

import java.util.ArrayList;
import java.util.List;

public class SusScaleQuestionScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SusScaleQuestionScoreExample() {
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

        public Criteria andQuestionNumberIsNull() {
            addCriterion("question_number is null");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberIsNotNull() {
            addCriterion("question_number is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberEqualTo(Long value) {
            addCriterion("question_number =", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberNotEqualTo(Long value) {
            addCriterion("question_number <>", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberGreaterThan(Long value) {
            addCriterion("question_number >", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("question_number >=", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberLessThan(Long value) {
            addCriterion("question_number <", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberLessThanOrEqualTo(Long value) {
            addCriterion("question_number <=", value, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberIn(List<Long> values) {
            addCriterion("question_number in", values, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberNotIn(List<Long> values) {
            addCriterion("question_number not in", values, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberBetween(Long value1, Long value2) {
            addCriterion("question_number between", value1, value2, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andQuestionNumberNotBetween(Long value1, Long value2) {
            addCriterion("question_number not between", value1, value2, "questionNumber");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdIsNull() {
            addCriterion("sus_paper_id is null");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdIsNotNull() {
            addCriterion("sus_paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdEqualTo(Long value) {
            addCriterion("sus_paper_id =", value, "susPaperId");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdNotEqualTo(Long value) {
            addCriterion("sus_paper_id <>", value, "susPaperId");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdGreaterThan(Long value) {
            addCriterion("sus_paper_id >", value, "susPaperId");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sus_paper_id >=", value, "susPaperId");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdLessThan(Long value) {
            addCriterion("sus_paper_id <", value, "susPaperId");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdLessThanOrEqualTo(Long value) {
            addCriterion("sus_paper_id <=", value, "susPaperId");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdIn(List<Long> values) {
            addCriterion("sus_paper_id in", values, "susPaperId");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdNotIn(List<Long> values) {
            addCriterion("sus_paper_id not in", values, "susPaperId");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdBetween(Long value1, Long value2) {
            addCriterion("sus_paper_id between", value1, value2, "susPaperId");
            return (Criteria) this;
        }

        public Criteria andSusPaperIdNotBetween(Long value1, Long value2) {
            addCriterion("sus_paper_id not between", value1, value2, "susPaperId");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Long value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Long value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Long value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Long value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Long value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Long> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Long> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Long value1, Long value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Long value1, Long value2) {
            addCriterion("score not between", value1, value2, "score");
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