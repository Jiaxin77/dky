package hci.dky.pojo;

import java.util.ArrayList;
import java.util.List;

public class SurveyLibraryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SurveyLibraryExample() {
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

        public Criteria andSurveyTitleIsNull() {
            addCriterion("survey_title is null");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleIsNotNull() {
            addCriterion("survey_title is not null");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleEqualTo(String value) {
            addCriterion("survey_title =", value, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleNotEqualTo(String value) {
            addCriterion("survey_title <>", value, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleGreaterThan(String value) {
            addCriterion("survey_title >", value, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleGreaterThanOrEqualTo(String value) {
            addCriterion("survey_title >=", value, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleLessThan(String value) {
            addCriterion("survey_title <", value, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleLessThanOrEqualTo(String value) {
            addCriterion("survey_title <=", value, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleLike(String value) {
            addCriterion("survey_title like", value, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleNotLike(String value) {
            addCriterion("survey_title not like", value, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleIn(List<String> values) {
            addCriterion("survey_title in", values, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleNotIn(List<String> values) {
            addCriterion("survey_title not in", values, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleBetween(String value1, String value2) {
            addCriterion("survey_title between", value1, value2, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyTitleNotBetween(String value1, String value2) {
            addCriterion("survey_title not between", value1, value2, "surveyTitle");
            return (Criteria) this;
        }

        public Criteria andSurveyDesIsNull() {
            addCriterion("survey_des is null");
            return (Criteria) this;
        }

        public Criteria andSurveyDesIsNotNull() {
            addCriterion("survey_des is not null");
            return (Criteria) this;
        }

        public Criteria andSurveyDesEqualTo(String value) {
            addCriterion("survey_des =", value, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesNotEqualTo(String value) {
            addCriterion("survey_des <>", value, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesGreaterThan(String value) {
            addCriterion("survey_des >", value, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesGreaterThanOrEqualTo(String value) {
            addCriterion("survey_des >=", value, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesLessThan(String value) {
            addCriterion("survey_des <", value, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesLessThanOrEqualTo(String value) {
            addCriterion("survey_des <=", value, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesLike(String value) {
            addCriterion("survey_des like", value, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesNotLike(String value) {
            addCriterion("survey_des not like", value, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesIn(List<String> values) {
            addCriterion("survey_des in", values, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesNotIn(List<String> values) {
            addCriterion("survey_des not in", values, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesBetween(String value1, String value2) {
            addCriterion("survey_des between", value1, value2, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andSurveyDesNotBetween(String value1, String value2) {
            addCriterion("survey_des not between", value1, value2, "surveyDes");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumIsNull() {
            addCriterion("now_people_num is null");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumIsNotNull() {
            addCriterion("now_people_num is not null");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumEqualTo(Long value) {
            addCriterion("now_people_num =", value, "nowPeopleNum");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumNotEqualTo(Long value) {
            addCriterion("now_people_num <>", value, "nowPeopleNum");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumGreaterThan(Long value) {
            addCriterion("now_people_num >", value, "nowPeopleNum");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumGreaterThanOrEqualTo(Long value) {
            addCriterion("now_people_num >=", value, "nowPeopleNum");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumLessThan(Long value) {
            addCriterion("now_people_num <", value, "nowPeopleNum");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumLessThanOrEqualTo(Long value) {
            addCriterion("now_people_num <=", value, "nowPeopleNum");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumIn(List<Long> values) {
            addCriterion("now_people_num in", values, "nowPeopleNum");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumNotIn(List<Long> values) {
            addCriterion("now_people_num not in", values, "nowPeopleNum");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumBetween(Long value1, Long value2) {
            addCriterion("now_people_num between", value1, value2, "nowPeopleNum");
            return (Criteria) this;
        }

        public Criteria andNowPeopleNumNotBetween(Long value1, Long value2) {
            addCriterion("now_people_num not between", value1, value2, "nowPeopleNum");
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

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Long value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Long value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Long value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Long value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Long> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Long> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Long value1, Long value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
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