package hci.dky.pojo;

import java.util.ArrayList;
import java.util.List;

public class ExpertQuestionScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpertQuestionScoreExample() {
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

        public Criteria andConformanceScoreIsNull() {
            addCriterion("conformance_score is null");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreIsNotNull() {
            addCriterion("conformance_score is not null");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreEqualTo(Double value) {
            addCriterion("conformance_score =", value, "conformanceScore");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreNotEqualTo(Double value) {
            addCriterion("conformance_score <>", value, "conformanceScore");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreGreaterThan(Double value) {
            addCriterion("conformance_score >", value, "conformanceScore");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("conformance_score >=", value, "conformanceScore");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreLessThan(Double value) {
            addCriterion("conformance_score <", value, "conformanceScore");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreLessThanOrEqualTo(Double value) {
            addCriterion("conformance_score <=", value, "conformanceScore");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreIn(List<Double> values) {
            addCriterion("conformance_score in", values, "conformanceScore");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreNotIn(List<Double> values) {
            addCriterion("conformance_score not in", values, "conformanceScore");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreBetween(Double value1, Double value2) {
            addCriterion("conformance_score between", value1, value2, "conformanceScore");
            return (Criteria) this;
        }

        public Criteria andConformanceScoreNotBetween(Double value1, Double value2) {
            addCriterion("conformance_score not between", value1, value2, "conformanceScore");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreIsNull() {
            addCriterion("importance_score is null");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreIsNotNull() {
            addCriterion("importance_score is not null");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreEqualTo(Double value) {
            addCriterion("importance_score =", value, "importanceScore");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreNotEqualTo(Double value) {
            addCriterion("importance_score <>", value, "importanceScore");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreGreaterThan(Double value) {
            addCriterion("importance_score >", value, "importanceScore");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("importance_score >=", value, "importanceScore");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreLessThan(Double value) {
            addCriterion("importance_score <", value, "importanceScore");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreLessThanOrEqualTo(Double value) {
            addCriterion("importance_score <=", value, "importanceScore");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreIn(List<Double> values) {
            addCriterion("importance_score in", values, "importanceScore");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreNotIn(List<Double> values) {
            addCriterion("importance_score not in", values, "importanceScore");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreBetween(Double value1, Double value2) {
            addCriterion("importance_score between", value1, value2, "importanceScore");
            return (Criteria) this;
        }

        public Criteria andImportanceScoreNotBetween(Double value1, Double value2) {
            addCriterion("importance_score not between", value1, value2, "importanceScore");
            return (Criteria) this;
        }

        public Criteria andQuestionDesIsNull() {
            addCriterion("question_des is null");
            return (Criteria) this;
        }

        public Criteria andQuestionDesIsNotNull() {
            addCriterion("question_des is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionDesEqualTo(String value) {
            addCriterion("question_des =", value, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesNotEqualTo(String value) {
            addCriterion("question_des <>", value, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesGreaterThan(String value) {
            addCriterion("question_des >", value, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesGreaterThanOrEqualTo(String value) {
            addCriterion("question_des >=", value, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesLessThan(String value) {
            addCriterion("question_des <", value, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesLessThanOrEqualTo(String value) {
            addCriterion("question_des <=", value, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesLike(String value) {
            addCriterion("question_des like", value, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesNotLike(String value) {
            addCriterion("question_des not like", value, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesIn(List<String> values) {
            addCriterion("question_des in", values, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesNotIn(List<String> values) {
            addCriterion("question_des not in", values, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesBetween(String value1, String value2) {
            addCriterion("question_des between", value1, value2, "questionDes");
            return (Criteria) this;
        }

        public Criteria andQuestionDesNotBetween(String value1, String value2) {
            addCriterion("question_des not between", value1, value2, "questionDes");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNull() {
            addCriterion("paper_id is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(Long value) {
            addCriterion("paper_id =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(Long value) {
            addCriterion("paper_id <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(Long value) {
            addCriterion("paper_id >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("paper_id >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(Long value) {
            addCriterion("paper_id <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(Long value) {
            addCriterion("paper_id <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<Long> values) {
            addCriterion("paper_id in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<Long> values) {
            addCriterion("paper_id not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(Long value1, Long value2) {
            addCriterion("paper_id between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(Long value1, Long value2) {
            addCriterion("paper_id not between", value1, value2, "paperId");
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