package hci.dky.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HardwareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HardwareExample() {
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

        public Criteria andHardwareIdIsNull() {
            addCriterion("hardware_id is null");
            return (Criteria) this;
        }

        public Criteria andHardwareIdIsNotNull() {
            addCriterion("hardware_id is not null");
            return (Criteria) this;
        }

        public Criteria andHardwareIdEqualTo(Long value) {
            addCriterion("hardware_id =", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdNotEqualTo(Long value) {
            addCriterion("hardware_id <>", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdGreaterThan(Long value) {
            addCriterion("hardware_id >", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hardware_id >=", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdLessThan(Long value) {
            addCriterion("hardware_id <", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdLessThanOrEqualTo(Long value) {
            addCriterion("hardware_id <=", value, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdIn(List<Long> values) {
            addCriterion("hardware_id in", values, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdNotIn(List<Long> values) {
            addCriterion("hardware_id not in", values, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdBetween(Long value1, Long value2) {
            addCriterion("hardware_id between", value1, value2, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andHardwareIdNotBetween(Long value1, Long value2) {
            addCriterion("hardware_id not between", value1, value2, "hardwareId");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameIsNull() {
            addCriterion("first_object_name is null");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameIsNotNull() {
            addCriterion("first_object_name is not null");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameEqualTo(String value) {
            addCriterion("first_object_name =", value, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameNotEqualTo(String value) {
            addCriterion("first_object_name <>", value, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameGreaterThan(String value) {
            addCriterion("first_object_name >", value, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("first_object_name >=", value, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameLessThan(String value) {
            addCriterion("first_object_name <", value, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameLessThanOrEqualTo(String value) {
            addCriterion("first_object_name <=", value, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameLike(String value) {
            addCriterion("first_object_name like", value, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameNotLike(String value) {
            addCriterion("first_object_name not like", value, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameIn(List<String> values) {
            addCriterion("first_object_name in", values, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameNotIn(List<String> values) {
            addCriterion("first_object_name not in", values, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameBetween(String value1, String value2) {
            addCriterion("first_object_name between", value1, value2, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstObjectNameNotBetween(String value1, String value2) {
            addCriterion("first_object_name not between", value1, value2, "firstObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameIsNull() {
            addCriterion("second_object_name is null");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameIsNotNull() {
            addCriterion("second_object_name is not null");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameEqualTo(String value) {
            addCriterion("second_object_name =", value, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameNotEqualTo(String value) {
            addCriterion("second_object_name <>", value, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameGreaterThan(String value) {
            addCriterion("second_object_name >", value, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("second_object_name >=", value, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameLessThan(String value) {
            addCriterion("second_object_name <", value, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameLessThanOrEqualTo(String value) {
            addCriterion("second_object_name <=", value, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameLike(String value) {
            addCriterion("second_object_name like", value, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameNotLike(String value) {
            addCriterion("second_object_name not like", value, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameIn(List<String> values) {
            addCriterion("second_object_name in", values, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameNotIn(List<String> values) {
            addCriterion("second_object_name not in", values, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameBetween(String value1, String value2) {
            addCriterion("second_object_name between", value1, value2, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andSecondObjectNameNotBetween(String value1, String value2) {
            addCriterion("second_object_name not between", value1, value2, "secondObjectName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameIsNull() {
            addCriterion("first_index_name is null");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameIsNotNull() {
            addCriterion("first_index_name is not null");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameEqualTo(String value) {
            addCriterion("first_index_name =", value, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameNotEqualTo(String value) {
            addCriterion("first_index_name <>", value, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameGreaterThan(String value) {
            addCriterion("first_index_name >", value, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameGreaterThanOrEqualTo(String value) {
            addCriterion("first_index_name >=", value, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameLessThan(String value) {
            addCriterion("first_index_name <", value, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameLessThanOrEqualTo(String value) {
            addCriterion("first_index_name <=", value, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameLike(String value) {
            addCriterion("first_index_name like", value, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameNotLike(String value) {
            addCriterion("first_index_name not like", value, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameIn(List<String> values) {
            addCriterion("first_index_name in", values, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameNotIn(List<String> values) {
            addCriterion("first_index_name not in", values, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameBetween(String value1, String value2) {
            addCriterion("first_index_name between", value1, value2, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andFirstIndexNameNotBetween(String value1, String value2) {
            addCriterion("first_index_name not between", value1, value2, "firstIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameIsNull() {
            addCriterion("second_index_name is null");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameIsNotNull() {
            addCriterion("second_index_name is not null");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameEqualTo(String value) {
            addCriterion("second_index_name =", value, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameNotEqualTo(String value) {
            addCriterion("second_index_name <>", value, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameGreaterThan(String value) {
            addCriterion("second_index_name >", value, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameGreaterThanOrEqualTo(String value) {
            addCriterion("second_index_name >=", value, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameLessThan(String value) {
            addCriterion("second_index_name <", value, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameLessThanOrEqualTo(String value) {
            addCriterion("second_index_name <=", value, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameLike(String value) {
            addCriterion("second_index_name like", value, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameNotLike(String value) {
            addCriterion("second_index_name not like", value, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameIn(List<String> values) {
            addCriterion("second_index_name in", values, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameNotIn(List<String> values) {
            addCriterion("second_index_name not in", values, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameBetween(String value1, String value2) {
            addCriterion("second_index_name between", value1, value2, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andSecondIndexNameNotBetween(String value1, String value2) {
            addCriterion("second_index_name not between", value1, value2, "secondIndexName");
            return (Criteria) this;
        }

        public Criteria andEvaConditionIsNull() {
            addCriterion("eva_condition is null");
            return (Criteria) this;
        }

        public Criteria andEvaConditionIsNotNull() {
            addCriterion("eva_condition is not null");
            return (Criteria) this;
        }

        public Criteria andEvaConditionEqualTo(String value) {
            addCriterion("eva_condition =", value, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionNotEqualTo(String value) {
            addCriterion("eva_condition <>", value, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionGreaterThan(String value) {
            addCriterion("eva_condition >", value, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionGreaterThanOrEqualTo(String value) {
            addCriterion("eva_condition >=", value, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionLessThan(String value) {
            addCriterion("eva_condition <", value, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionLessThanOrEqualTo(String value) {
            addCriterion("eva_condition <=", value, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionLike(String value) {
            addCriterion("eva_condition like", value, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionNotLike(String value) {
            addCriterion("eva_condition not like", value, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionIn(List<String> values) {
            addCriterion("eva_condition in", values, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionNotIn(List<String> values) {
            addCriterion("eva_condition not in", values, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionBetween(String value1, String value2) {
            addCriterion("eva_condition between", value1, value2, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andEvaConditionNotBetween(String value1, String value2) {
            addCriterion("eva_condition not between", value1, value2, "evaCondition");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerIsNull() {
            addCriterion("hardware_lower is null");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerIsNotNull() {
            addCriterion("hardware_lower is not null");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerEqualTo(BigDecimal value) {
            addCriterion("hardware_lower =", value, "hardwareLower");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerNotEqualTo(BigDecimal value) {
            addCriterion("hardware_lower <>", value, "hardwareLower");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerGreaterThan(BigDecimal value) {
            addCriterion("hardware_lower >", value, "hardwareLower");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hardware_lower >=", value, "hardwareLower");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerLessThan(BigDecimal value) {
            addCriterion("hardware_lower <", value, "hardwareLower");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hardware_lower <=", value, "hardwareLower");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerIn(List<BigDecimal> values) {
            addCriterion("hardware_lower in", values, "hardwareLower");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerNotIn(List<BigDecimal> values) {
            addCriterion("hardware_lower not in", values, "hardwareLower");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hardware_lower between", value1, value2, "hardwareLower");
            return (Criteria) this;
        }

        public Criteria andHardwareLowerNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hardware_lower not between", value1, value2, "hardwareLower");
            return (Criteria) this;
        }

        public Criteria andHardwareBestIsNull() {
            addCriterion("hardware_best is null");
            return (Criteria) this;
        }

        public Criteria andHardwareBestIsNotNull() {
            addCriterion("hardware_best is not null");
            return (Criteria) this;
        }

        public Criteria andHardwareBestEqualTo(BigDecimal value) {
            addCriterion("hardware_best =", value, "hardwareBest");
            return (Criteria) this;
        }

        public Criteria andHardwareBestNotEqualTo(BigDecimal value) {
            addCriterion("hardware_best <>", value, "hardwareBest");
            return (Criteria) this;
        }

        public Criteria andHardwareBestGreaterThan(BigDecimal value) {
            addCriterion("hardware_best >", value, "hardwareBest");
            return (Criteria) this;
        }

        public Criteria andHardwareBestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hardware_best >=", value, "hardwareBest");
            return (Criteria) this;
        }

        public Criteria andHardwareBestLessThan(BigDecimal value) {
            addCriterion("hardware_best <", value, "hardwareBest");
            return (Criteria) this;
        }

        public Criteria andHardwareBestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hardware_best <=", value, "hardwareBest");
            return (Criteria) this;
        }

        public Criteria andHardwareBestIn(List<BigDecimal> values) {
            addCriterion("hardware_best in", values, "hardwareBest");
            return (Criteria) this;
        }

        public Criteria andHardwareBestNotIn(List<BigDecimal> values) {
            addCriterion("hardware_best not in", values, "hardwareBest");
            return (Criteria) this;
        }

        public Criteria andHardwareBestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hardware_best between", value1, value2, "hardwareBest");
            return (Criteria) this;
        }

        public Criteria andHardwareBestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hardware_best not between", value1, value2, "hardwareBest");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperIsNull() {
            addCriterion("hardware_upper is null");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperIsNotNull() {
            addCriterion("hardware_upper is not null");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperEqualTo(BigDecimal value) {
            addCriterion("hardware_upper =", value, "hardwareUpper");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperNotEqualTo(BigDecimal value) {
            addCriterion("hardware_upper <>", value, "hardwareUpper");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperGreaterThan(BigDecimal value) {
            addCriterion("hardware_upper >", value, "hardwareUpper");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hardware_upper >=", value, "hardwareUpper");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperLessThan(BigDecimal value) {
            addCriterion("hardware_upper <", value, "hardwareUpper");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hardware_upper <=", value, "hardwareUpper");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperIn(List<BigDecimal> values) {
            addCriterion("hardware_upper in", values, "hardwareUpper");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperNotIn(List<BigDecimal> values) {
            addCriterion("hardware_upper not in", values, "hardwareUpper");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hardware_upper between", value1, value2, "hardwareUpper");
            return (Criteria) this;
        }

        public Criteria andHardwareUpperNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hardware_upper not between", value1, value2, "hardwareUpper");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitIsNull() {
            addCriterion("hardware_unit is null");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitIsNotNull() {
            addCriterion("hardware_unit is not null");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitEqualTo(String value) {
            addCriterion("hardware_unit =", value, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitNotEqualTo(String value) {
            addCriterion("hardware_unit <>", value, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitGreaterThan(String value) {
            addCriterion("hardware_unit >", value, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitGreaterThanOrEqualTo(String value) {
            addCriterion("hardware_unit >=", value, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitLessThan(String value) {
            addCriterion("hardware_unit <", value, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitLessThanOrEqualTo(String value) {
            addCriterion("hardware_unit <=", value, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitLike(String value) {
            addCriterion("hardware_unit like", value, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitNotLike(String value) {
            addCriterion("hardware_unit not like", value, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitIn(List<String> values) {
            addCriterion("hardware_unit in", values, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitNotIn(List<String> values) {
            addCriterion("hardware_unit not in", values, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitBetween(String value1, String value2) {
            addCriterion("hardware_unit between", value1, value2, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andHardwareUnitNotBetween(String value1, String value2) {
            addCriterion("hardware_unit not between", value1, value2, "hardwareUnit");
            return (Criteria) this;
        }

        public Criteria andOtherStandardIsNull() {
            addCriterion("other_standard is null");
            return (Criteria) this;
        }

        public Criteria andOtherStandardIsNotNull() {
            addCriterion("other_standard is not null");
            return (Criteria) this;
        }

        public Criteria andOtherStandardEqualTo(String value) {
            addCriterion("other_standard =", value, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardNotEqualTo(String value) {
            addCriterion("other_standard <>", value, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardGreaterThan(String value) {
            addCriterion("other_standard >", value, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardGreaterThanOrEqualTo(String value) {
            addCriterion("other_standard >=", value, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardLessThan(String value) {
            addCriterion("other_standard <", value, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardLessThanOrEqualTo(String value) {
            addCriterion("other_standard <=", value, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardLike(String value) {
            addCriterion("other_standard like", value, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardNotLike(String value) {
            addCriterion("other_standard not like", value, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardIn(List<String> values) {
            addCriterion("other_standard in", values, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardNotIn(List<String> values) {
            addCriterion("other_standard not in", values, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardBetween(String value1, String value2) {
            addCriterion("other_standard between", value1, value2, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andOtherStandardNotBetween(String value1, String value2) {
            addCriterion("other_standard not between", value1, value2, "otherStandard");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeIsNull() {
            addCriterion("serious_degree is null");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeIsNotNull() {
            addCriterion("serious_degree is not null");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeEqualTo(String value) {
            addCriterion("serious_degree =", value, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeNotEqualTo(String value) {
            addCriterion("serious_degree <>", value, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeGreaterThan(String value) {
            addCriterion("serious_degree >", value, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("serious_degree >=", value, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeLessThan(String value) {
            addCriterion("serious_degree <", value, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeLessThanOrEqualTo(String value) {
            addCriterion("serious_degree <=", value, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeLike(String value) {
            addCriterion("serious_degree like", value, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeNotLike(String value) {
            addCriterion("serious_degree not like", value, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeIn(List<String> values) {
            addCriterion("serious_degree in", values, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeNotIn(List<String> values) {
            addCriterion("serious_degree not in", values, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeBetween(String value1, String value2) {
            addCriterion("serious_degree between", value1, value2, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andSeriousDegreeNotBetween(String value1, String value2) {
            addCriterion("serious_degree not between", value1, value2, "seriousDegree");
            return (Criteria) this;
        }

        public Criteria andPicDesIsNull() {
            addCriterion("pic_des is null");
            return (Criteria) this;
        }

        public Criteria andPicDesIsNotNull() {
            addCriterion("pic_des is not null");
            return (Criteria) this;
        }

        public Criteria andPicDesEqualTo(String value) {
            addCriterion("pic_des =", value, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesNotEqualTo(String value) {
            addCriterion("pic_des <>", value, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesGreaterThan(String value) {
            addCriterion("pic_des >", value, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesGreaterThanOrEqualTo(String value) {
            addCriterion("pic_des >=", value, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesLessThan(String value) {
            addCriterion("pic_des <", value, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesLessThanOrEqualTo(String value) {
            addCriterion("pic_des <=", value, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesLike(String value) {
            addCriterion("pic_des like", value, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesNotLike(String value) {
            addCriterion("pic_des not like", value, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesIn(List<String> values) {
            addCriterion("pic_des in", values, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesNotIn(List<String> values) {
            addCriterion("pic_des not in", values, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesBetween(String value1, String value2) {
            addCriterion("pic_des between", value1, value2, "picDes");
            return (Criteria) this;
        }

        public Criteria andPicDesNotBetween(String value1, String value2) {
            addCriterion("pic_des not between", value1, value2, "picDes");
            return (Criteria) this;
        }

        public Criteria andIndexSourceIsNull() {
            addCriterion("index_source is null");
            return (Criteria) this;
        }

        public Criteria andIndexSourceIsNotNull() {
            addCriterion("index_source is not null");
            return (Criteria) this;
        }

        public Criteria andIndexSourceEqualTo(String value) {
            addCriterion("index_source =", value, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceNotEqualTo(String value) {
            addCriterion("index_source <>", value, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceGreaterThan(String value) {
            addCriterion("index_source >", value, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceGreaterThanOrEqualTo(String value) {
            addCriterion("index_source >=", value, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceLessThan(String value) {
            addCriterion("index_source <", value, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceLessThanOrEqualTo(String value) {
            addCriterion("index_source <=", value, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceLike(String value) {
            addCriterion("index_source like", value, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceNotLike(String value) {
            addCriterion("index_source not like", value, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceIn(List<String> values) {
            addCriterion("index_source in", values, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceNotIn(List<String> values) {
            addCriterion("index_source not in", values, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceBetween(String value1, String value2) {
            addCriterion("index_source between", value1, value2, "indexSource");
            return (Criteria) this;
        }

        public Criteria andIndexSourceNotBetween(String value1, String value2) {
            addCriterion("index_source not between", value1, value2, "indexSource");
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