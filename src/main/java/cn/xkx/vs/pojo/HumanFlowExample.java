package cn.xkx.vs.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HumanFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HumanFlowExample() {
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

        public Criteria andCurrenttimeIsNull() {
            addCriterion("currentTime is null");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeIsNotNull() {
            addCriterion("currentTime is not null");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeEqualTo(Date value) {
            addCriterion("currentTime =", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeNotEqualTo(Date value) {
            addCriterion("currentTime <>", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeGreaterThan(Date value) {
            addCriterion("currentTime >", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("currentTime >=", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeLessThan(Date value) {
            addCriterion("currentTime <", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeLessThanOrEqualTo(Date value) {
            addCriterion("currentTime <=", value, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeIn(List<Date> values) {
            addCriterion("currentTime in", values, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeNotIn(List<Date> values) {
            addCriterion("currentTime not in", values, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeBetween(Date value1, Date value2) {
            addCriterion("currentTime between", value1, value2, "currenttime");
            return (Criteria) this;
        }

        public Criteria andCurrenttimeNotBetween(Date value1, Date value2) {
            addCriterion("currentTime not between", value1, value2, "currenttime");
            return (Criteria) this;
        }

        public Criteria andInnumIsNull() {
            addCriterion("inNum is null");
            return (Criteria) this;
        }

        public Criteria andInnumIsNotNull() {
            addCriterion("inNum is not null");
            return (Criteria) this;
        }

        public Criteria andInnumEqualTo(Integer value) {
            addCriterion("inNum =", value, "innum");
            return (Criteria) this;
        }

        public Criteria andInnumNotEqualTo(Integer value) {
            addCriterion("inNum <>", value, "innum");
            return (Criteria) this;
        }

        public Criteria andInnumGreaterThan(Integer value) {
            addCriterion("inNum >", value, "innum");
            return (Criteria) this;
        }

        public Criteria andInnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("inNum >=", value, "innum");
            return (Criteria) this;
        }

        public Criteria andInnumLessThan(Integer value) {
            addCriterion("inNum <", value, "innum");
            return (Criteria) this;
        }

        public Criteria andInnumLessThanOrEqualTo(Integer value) {
            addCriterion("inNum <=", value, "innum");
            return (Criteria) this;
        }

        public Criteria andInnumIn(List<Integer> values) {
            addCriterion("inNum in", values, "innum");
            return (Criteria) this;
        }

        public Criteria andInnumNotIn(List<Integer> values) {
            addCriterion("inNum not in", values, "innum");
            return (Criteria) this;
        }

        public Criteria andInnumBetween(Integer value1, Integer value2) {
            addCriterion("inNum between", value1, value2, "innum");
            return (Criteria) this;
        }

        public Criteria andInnumNotBetween(Integer value1, Integer value2) {
            addCriterion("inNum not between", value1, value2, "innum");
            return (Criteria) this;
        }

        public Criteria andOutnumIsNull() {
            addCriterion("outNum is null");
            return (Criteria) this;
        }

        public Criteria andOutnumIsNotNull() {
            addCriterion("outNum is not null");
            return (Criteria) this;
        }

        public Criteria andOutnumEqualTo(Integer value) {
            addCriterion("outNum =", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumNotEqualTo(Integer value) {
            addCriterion("outNum <>", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumGreaterThan(Integer value) {
            addCriterion("outNum >", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("outNum >=", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumLessThan(Integer value) {
            addCriterion("outNum <", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumLessThanOrEqualTo(Integer value) {
            addCriterion("outNum <=", value, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumIn(List<Integer> values) {
            addCriterion("outNum in", values, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumNotIn(List<Integer> values) {
            addCriterion("outNum not in", values, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumBetween(Integer value1, Integer value2) {
            addCriterion("outNum between", value1, value2, "outnum");
            return (Criteria) this;
        }

        public Criteria andOutnumNotBetween(Integer value1, Integer value2) {
            addCriterion("outNum not between", value1, value2, "outnum");
            return (Criteria) this;
        }

        public Criteria andPlaceidIsNull() {
            addCriterion("placeId is null");
            return (Criteria) this;
        }

        public Criteria andPlaceidIsNotNull() {
            addCriterion("placeId is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceidEqualTo(Integer value) {
            addCriterion("placeId =", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidNotEqualTo(Integer value) {
            addCriterion("placeId <>", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidGreaterThan(Integer value) {
            addCriterion("placeId >", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("placeId >=", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidLessThan(Integer value) {
            addCriterion("placeId <", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidLessThanOrEqualTo(Integer value) {
            addCriterion("placeId <=", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidIn(List<Integer> values) {
            addCriterion("placeId in", values, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidNotIn(List<Integer> values) {
            addCriterion("placeId not in", values, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidBetween(Integer value1, Integer value2) {
            addCriterion("placeId between", value1, value2, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidNotBetween(Integer value1, Integer value2) {
            addCriterion("placeId not between", value1, value2, "placeid");
            return (Criteria) this;
        }

        public Criteria andCurnumIsNull() {
            addCriterion("curNum is null");
            return (Criteria) this;
        }

        public Criteria andCurnumIsNotNull() {
            addCriterion("curNum is not null");
            return (Criteria) this;
        }

        public Criteria andCurnumEqualTo(Integer value) {
            addCriterion("curNum =", value, "curnum");
            return (Criteria) this;
        }

        public Criteria andCurnumNotEqualTo(Integer value) {
            addCriterion("curNum <>", value, "curnum");
            return (Criteria) this;
        }

        public Criteria andCurnumGreaterThan(Integer value) {
            addCriterion("curNum >", value, "curnum");
            return (Criteria) this;
        }

        public Criteria andCurnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("curNum >=", value, "curnum");
            return (Criteria) this;
        }

        public Criteria andCurnumLessThan(Integer value) {
            addCriterion("curNum <", value, "curnum");
            return (Criteria) this;
        }

        public Criteria andCurnumLessThanOrEqualTo(Integer value) {
            addCriterion("curNum <=", value, "curnum");
            return (Criteria) this;
        }

        public Criteria andCurnumIn(List<Integer> values) {
            addCriterion("curNum in", values, "curnum");
            return (Criteria) this;
        }

        public Criteria andCurnumNotIn(List<Integer> values) {
            addCriterion("curNum not in", values, "curnum");
            return (Criteria) this;
        }

        public Criteria andCurnumBetween(Integer value1, Integer value2) {
            addCriterion("curNum between", value1, value2, "curnum");
            return (Criteria) this;
        }

        public Criteria andCurnumNotBetween(Integer value1, Integer value2) {
            addCriterion("curNum not between", value1, value2, "curnum");
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