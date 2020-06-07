package hci.dky.pojo;

import java.util.ArrayList;
import java.util.List;

public class ExpertTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpertTaskExample() {
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

        public Criteria andSystemNameIsNull() {
            addCriterion("system_name is null");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNotNull() {
            addCriterion("system_name is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNameEqualTo(String value) {
            addCriterion("system_name =", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotEqualTo(String value) {
            addCriterion("system_name <>", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThan(String value) {
            addCriterion("system_name >", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThanOrEqualTo(String value) {
            addCriterion("system_name >=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThan(String value) {
            addCriterion("system_name <", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThanOrEqualTo(String value) {
            addCriterion("system_name <=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLike(String value) {
            addCriterion("system_name like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotLike(String value) {
            addCriterion("system_name not like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameIn(List<String> values) {
            addCriterion("system_name in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotIn(List<String> values) {
            addCriterion("system_name not in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameBetween(String value1, String value2) {
            addCriterion("system_name between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotBetween(String value1, String value2) {
            addCriterion("system_name not between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andTaskNumIsNull() {
            addCriterion("task_num is null");
            return (Criteria) this;
        }

        public Criteria andTaskNumIsNotNull() {
            addCriterion("task_num is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNumEqualTo(Long value) {
            addCriterion("task_num =", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotEqualTo(Long value) {
            addCriterion("task_num <>", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumGreaterThan(Long value) {
            addCriterion("task_num >", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumGreaterThanOrEqualTo(Long value) {
            addCriterion("task_num >=", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumLessThan(Long value) {
            addCriterion("task_num <", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumLessThanOrEqualTo(Long value) {
            addCriterion("task_num <=", value, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumIn(List<Long> values) {
            addCriterion("task_num in", values, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotIn(List<Long> values) {
            addCriterion("task_num not in", values, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumBetween(Long value1, Long value2) {
            addCriterion("task_num between", value1, value2, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskNumNotBetween(Long value1, Long value2) {
            addCriterion("task_num not between", value1, value2, "taskNum");
            return (Criteria) this;
        }

        public Criteria andTaskDesIsNull() {
            addCriterion("task_des is null");
            return (Criteria) this;
        }

        public Criteria andTaskDesIsNotNull() {
            addCriterion("task_des is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDesEqualTo(String value) {
            addCriterion("task_des =", value, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesNotEqualTo(String value) {
            addCriterion("task_des <>", value, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesGreaterThan(String value) {
            addCriterion("task_des >", value, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesGreaterThanOrEqualTo(String value) {
            addCriterion("task_des >=", value, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesLessThan(String value) {
            addCriterion("task_des <", value, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesLessThanOrEqualTo(String value) {
            addCriterion("task_des <=", value, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesLike(String value) {
            addCriterion("task_des like", value, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesNotLike(String value) {
            addCriterion("task_des not like", value, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesIn(List<String> values) {
            addCriterion("task_des in", values, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesNotIn(List<String> values) {
            addCriterion("task_des not in", values, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesBetween(String value1, String value2) {
            addCriterion("task_des between", value1, value2, "taskDes");
            return (Criteria) this;
        }

        public Criteria andTaskDesNotBetween(String value1, String value2) {
            addCriterion("task_des not between", value1, value2, "taskDes");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdIsNull() {
            addCriterion("expert_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdIsNotNull() {
            addCriterion("expert_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdEqualTo(Long value) {
            addCriterion("expert_plan_id =", value, "expertPlanId");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdNotEqualTo(Long value) {
            addCriterion("expert_plan_id <>", value, "expertPlanId");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdGreaterThan(Long value) {
            addCriterion("expert_plan_id >", value, "expertPlanId");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("expert_plan_id >=", value, "expertPlanId");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdLessThan(Long value) {
            addCriterion("expert_plan_id <", value, "expertPlanId");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("expert_plan_id <=", value, "expertPlanId");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdIn(List<Long> values) {
            addCriterion("expert_plan_id in", values, "expertPlanId");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdNotIn(List<Long> values) {
            addCriterion("expert_plan_id not in", values, "expertPlanId");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdBetween(Long value1, Long value2) {
            addCriterion("expert_plan_id between", value1, value2, "expertPlanId");
            return (Criteria) this;
        }

        public Criteria andExpertPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("expert_plan_id not between", value1, value2, "expertPlanId");
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