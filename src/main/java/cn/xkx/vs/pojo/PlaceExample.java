package cn.xkx.vs.pojo;

import java.util.ArrayList;
import java.util.List;

public class PlaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlaceExample() {
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

        public Criteria andPlacenameIsNull() {
            addCriterion("placeName is null");
            return (Criteria) this;
        }

        public Criteria andPlacenameIsNotNull() {
            addCriterion("placeName is not null");
            return (Criteria) this;
        }

        public Criteria andPlacenameEqualTo(String value) {
            addCriterion("placeName =", value, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameNotEqualTo(String value) {
            addCriterion("placeName <>", value, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameGreaterThan(String value) {
            addCriterion("placeName >", value, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameGreaterThanOrEqualTo(String value) {
            addCriterion("placeName >=", value, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameLessThan(String value) {
            addCriterion("placeName <", value, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameLessThanOrEqualTo(String value) {
            addCriterion("placeName <=", value, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameLike(String value) {
            addCriterion("placeName like", value, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameNotLike(String value) {
            addCriterion("placeName not like", value, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameIn(List<String> values) {
            addCriterion("placeName in", values, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameNotIn(List<String> values) {
            addCriterion("placeName not in", values, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameBetween(String value1, String value2) {
            addCriterion("placeName between", value1, value2, "placename");
            return (Criteria) this;
        }

        public Criteria andPlacenameNotBetween(String value1, String value2) {
            addCriterion("placeName not between", value1, value2, "placename");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(Integer value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(Integer value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(Integer value) {
            addCriterion("capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(Integer value) {
            addCriterion("capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<Integer> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<Integer> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(Integer value1, Integer value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andUseIsNull() {
            addCriterion("use is null");
            return (Criteria) this;
        }

        public Criteria andUseIsNotNull() {
            addCriterion("use is not null");
            return (Criteria) this;
        }

        public Criteria andUseEqualTo(Integer value) {
            addCriterion("use =", value, "use");
            return (Criteria) this;
        }

        public Criteria andUseNotEqualTo(Integer value) {
            addCriterion("use <>", value, "use");
            return (Criteria) this;
        }

        public Criteria andUseGreaterThan(Integer value) {
            addCriterion("use >", value, "use");
            return (Criteria) this;
        }

        public Criteria andUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("use >=", value, "use");
            return (Criteria) this;
        }

        public Criteria andUseLessThan(Integer value) {
            addCriterion("use <", value, "use");
            return (Criteria) this;
        }

        public Criteria andUseLessThanOrEqualTo(Integer value) {
            addCriterion("use <=", value, "use");
            return (Criteria) this;
        }

        public Criteria andUseIn(List<Integer> values) {
            addCriterion("use in", values, "use");
            return (Criteria) this;
        }

        public Criteria andUseNotIn(List<Integer> values) {
            addCriterion("use not in", values, "use");
            return (Criteria) this;
        }

        public Criteria andUseBetween(Integer value1, Integer value2) {
            addCriterion("use between", value1, value2, "use");
            return (Criteria) this;
        }

        public Criteria andUseNotBetween(Integer value1, Integer value2) {
            addCriterion("use not between", value1, value2, "use");
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