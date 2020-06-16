package hci.dky.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordTableExample() {
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

        public Criteria andRecorderIsNull() {
            addCriterion("recorder is null");
            return (Criteria) this;
        }

        public Criteria andRecorderIsNotNull() {
            addCriterion("recorder is not null");
            return (Criteria) this;
        }

        public Criteria andRecorderEqualTo(String value) {
            addCriterion("recorder =", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotEqualTo(String value) {
            addCriterion("recorder <>", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderGreaterThan(String value) {
            addCriterion("recorder >", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderGreaterThanOrEqualTo(String value) {
            addCriterion("recorder >=", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLessThan(String value) {
            addCriterion("recorder <", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLessThanOrEqualTo(String value) {
            addCriterion("recorder <=", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderLike(String value) {
            addCriterion("recorder like", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotLike(String value) {
            addCriterion("recorder not like", value, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderIn(List<String> values) {
            addCriterion("recorder in", values, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotIn(List<String> values) {
            addCriterion("recorder not in", values, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderBetween(String value1, String value2) {
            addCriterion("recorder between", value1, value2, "recorder");
            return (Criteria) this;
        }

        public Criteria andRecorderNotBetween(String value1, String value2) {
            addCriterion("recorder not between", value1, value2, "recorder");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterion("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterion("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterion("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterion("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterion("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterion("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterion("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andDayCountIsNull() {
            addCriterion("day_count is null");
            return (Criteria) this;
        }

        public Criteria andDayCountIsNotNull() {
            addCriterion("day_count is not null");
            return (Criteria) this;
        }

        public Criteria andDayCountEqualTo(Long value) {
            addCriterion("day_count =", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountNotEqualTo(Long value) {
            addCriterion("day_count <>", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountGreaterThan(Long value) {
            addCriterion("day_count >", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountGreaterThanOrEqualTo(Long value) {
            addCriterion("day_count >=", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountLessThan(Long value) {
            addCriterion("day_count <", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountLessThanOrEqualTo(Long value) {
            addCriterion("day_count <=", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountIn(List<Long> values) {
            addCriterion("day_count in", values, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountNotIn(List<Long> values) {
            addCriterion("day_count not in", values, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountBetween(Long value1, Long value2) {
            addCriterion("day_count between", value1, value2, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountNotBetween(Long value1, Long value2) {
            addCriterion("day_count not between", value1, value2, "dayCount");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodIsNull() {
            addCriterion("record_period is null");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodIsNotNull() {
            addCriterion("record_period is not null");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodEqualTo(String value) {
            addCriterion("record_period =", value, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodNotEqualTo(String value) {
            addCriterion("record_period <>", value, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodGreaterThan(String value) {
            addCriterion("record_period >", value, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("record_period >=", value, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodLessThan(String value) {
            addCriterion("record_period <", value, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodLessThanOrEqualTo(String value) {
            addCriterion("record_period <=", value, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodLike(String value) {
            addCriterion("record_period like", value, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodNotLike(String value) {
            addCriterion("record_period not like", value, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodIn(List<String> values) {
            addCriterion("record_period in", values, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodNotIn(List<String> values) {
            addCriterion("record_period not in", values, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodBetween(String value1, String value2) {
            addCriterion("record_period between", value1, value2, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andRecordPeriodNotBetween(String value1, String value2) {
            addCriterion("record_period not between", value1, value2, "recordPeriod");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownIsNull() {
            addCriterion("is_break_down is null");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownIsNotNull() {
            addCriterion("is_break_down is not null");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownEqualTo(Boolean value) {
            addCriterion("is_break_down =", value, "isBreakDown");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownNotEqualTo(Boolean value) {
            addCriterion("is_break_down <>", value, "isBreakDown");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownGreaterThan(Boolean value) {
            addCriterion("is_break_down >", value, "isBreakDown");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_break_down >=", value, "isBreakDown");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownLessThan(Boolean value) {
            addCriterion("is_break_down <", value, "isBreakDown");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownLessThanOrEqualTo(Boolean value) {
            addCriterion("is_break_down <=", value, "isBreakDown");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownIn(List<Boolean> values) {
            addCriterion("is_break_down in", values, "isBreakDown");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownNotIn(List<Boolean> values) {
            addCriterion("is_break_down not in", values, "isBreakDown");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownBetween(Boolean value1, Boolean value2) {
            addCriterion("is_break_down between", value1, value2, "isBreakDown");
            return (Criteria) this;
        }

        public Criteria andIsBreakDownNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_break_down not between", value1, value2, "isBreakDown");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountIsNull() {
            addCriterion("break_down_count is null");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountIsNotNull() {
            addCriterion("break_down_count is not null");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountEqualTo(Long value) {
            addCriterion("break_down_count =", value, "breakDownCount");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountNotEqualTo(Long value) {
            addCriterion("break_down_count <>", value, "breakDownCount");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountGreaterThan(Long value) {
            addCriterion("break_down_count >", value, "breakDownCount");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountGreaterThanOrEqualTo(Long value) {
            addCriterion("break_down_count >=", value, "breakDownCount");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountLessThan(Long value) {
            addCriterion("break_down_count <", value, "breakDownCount");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountLessThanOrEqualTo(Long value) {
            addCriterion("break_down_count <=", value, "breakDownCount");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountIn(List<Long> values) {
            addCriterion("break_down_count in", values, "breakDownCount");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountNotIn(List<Long> values) {
            addCriterion("break_down_count not in", values, "breakDownCount");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountBetween(Long value1, Long value2) {
            addCriterion("break_down_count between", value1, value2, "breakDownCount");
            return (Criteria) this;
        }

        public Criteria andBreakDownCountNotBetween(Long value1, Long value2) {
            addCriterion("break_down_count not between", value1, value2, "breakDownCount");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeIsNull() {
            addCriterion("breakdown_type is null");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeIsNotNull() {
            addCriterion("breakdown_type is not null");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeEqualTo(String value) {
            addCriterion("breakdown_type =", value, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeNotEqualTo(String value) {
            addCriterion("breakdown_type <>", value, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeGreaterThan(String value) {
            addCriterion("breakdown_type >", value, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeGreaterThanOrEqualTo(String value) {
            addCriterion("breakdown_type >=", value, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeLessThan(String value) {
            addCriterion("breakdown_type <", value, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeLessThanOrEqualTo(String value) {
            addCriterion("breakdown_type <=", value, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeLike(String value) {
            addCriterion("breakdown_type like", value, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeNotLike(String value) {
            addCriterion("breakdown_type not like", value, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeIn(List<String> values) {
            addCriterion("breakdown_type in", values, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeNotIn(List<String> values) {
            addCriterion("breakdown_type not in", values, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeBetween(String value1, String value2) {
            addCriterion("breakdown_type between", value1, value2, "breakdownType");
            return (Criteria) this;
        }

        public Criteria andBreakdownTypeNotBetween(String value1, String value2) {
            addCriterion("breakdown_type not between", value1, value2, "breakdownType");
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