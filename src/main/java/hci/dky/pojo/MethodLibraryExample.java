package hci.dky.pojo;

import java.util.ArrayList;
import java.util.List;

public class MethodLibraryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MethodLibraryExample() {
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

        public Criteria andMethodNameIsNull() {
            addCriterion("method_name is null");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNotNull() {
            addCriterion("method_name is not null");
            return (Criteria) this;
        }

        public Criteria andMethodNameEqualTo(String value) {
            addCriterion("method_name =", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotEqualTo(String value) {
            addCriterion("method_name <>", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThan(String value) {
            addCriterion("method_name >", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("method_name >=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThan(String value) {
            addCriterion("method_name <", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThanOrEqualTo(String value) {
            addCriterion("method_name <=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLike(String value) {
            addCriterion("method_name like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotLike(String value) {
            addCriterion("method_name not like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameIn(List<String> values) {
            addCriterion("method_name in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotIn(List<String> values) {
            addCriterion("method_name not in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameBetween(String value1, String value2) {
            addCriterion("method_name between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotBetween(String value1, String value2) {
            addCriterion("method_name not between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodTableIsNull() {
            addCriterion("method_table is null");
            return (Criteria) this;
        }

        public Criteria andMethodTableIsNotNull() {
            addCriterion("method_table is not null");
            return (Criteria) this;
        }

        public Criteria andMethodTableEqualTo(String value) {
            addCriterion("method_table =", value, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableNotEqualTo(String value) {
            addCriterion("method_table <>", value, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableGreaterThan(String value) {
            addCriterion("method_table >", value, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableGreaterThanOrEqualTo(String value) {
            addCriterion("method_table >=", value, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableLessThan(String value) {
            addCriterion("method_table <", value, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableLessThanOrEqualTo(String value) {
            addCriterion("method_table <=", value, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableLike(String value) {
            addCriterion("method_table like", value, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableNotLike(String value) {
            addCriterion("method_table not like", value, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableIn(List<String> values) {
            addCriterion("method_table in", values, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableNotIn(List<String> values) {
            addCriterion("method_table not in", values, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableBetween(String value1, String value2) {
            addCriterion("method_table between", value1, value2, "methodTable");
            return (Criteria) this;
        }

        public Criteria andMethodTableNotBetween(String value1, String value2) {
            addCriterion("method_table not between", value1, value2, "methodTable");
            return (Criteria) this;
        }

        public Criteria andDataFormIsNull() {
            addCriterion("data_form is null");
            return (Criteria) this;
        }

        public Criteria andDataFormIsNotNull() {
            addCriterion("data_form is not null");
            return (Criteria) this;
        }

        public Criteria andDataFormEqualTo(String value) {
            addCriterion("data_form =", value, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormNotEqualTo(String value) {
            addCriterion("data_form <>", value, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormGreaterThan(String value) {
            addCriterion("data_form >", value, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormGreaterThanOrEqualTo(String value) {
            addCriterion("data_form >=", value, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormLessThan(String value) {
            addCriterion("data_form <", value, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormLessThanOrEqualTo(String value) {
            addCriterion("data_form <=", value, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormLike(String value) {
            addCriterion("data_form like", value, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormNotLike(String value) {
            addCriterion("data_form not like", value, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormIn(List<String> values) {
            addCriterion("data_form in", values, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormNotIn(List<String> values) {
            addCriterion("data_form not in", values, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormBetween(String value1, String value2) {
            addCriterion("data_form between", value1, value2, "dataForm");
            return (Criteria) this;
        }

        public Criteria andDataFormNotBetween(String value1, String value2) {
            addCriterion("data_form not between", value1, value2, "dataForm");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleIsNull() {
            addCriterion("need_people is null");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleIsNotNull() {
            addCriterion("need_people is not null");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleEqualTo(String value) {
            addCriterion("need_people =", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleNotEqualTo(String value) {
            addCriterion("need_people <>", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleGreaterThan(String value) {
            addCriterion("need_people >", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("need_people >=", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleLessThan(String value) {
            addCriterion("need_people <", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleLessThanOrEqualTo(String value) {
            addCriterion("need_people <=", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleLike(String value) {
            addCriterion("need_people like", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleNotLike(String value) {
            addCriterion("need_people not like", value, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleIn(List<String> values) {
            addCriterion("need_people in", values, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleNotIn(List<String> values) {
            addCriterion("need_people not in", values, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleBetween(String value1, String value2) {
            addCriterion("need_people between", value1, value2, "needPeople");
            return (Criteria) this;
        }

        public Criteria andNeedPeopleNotBetween(String value1, String value2) {
            addCriterion("need_people not between", value1, value2, "needPeople");
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