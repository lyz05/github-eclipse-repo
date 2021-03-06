package cc.home999.book.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BorrowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andReadernoIsNull() {
            addCriterion("readerno is null");
            return (Criteria) this;
        }

        public Criteria andReadernoIsNotNull() {
            addCriterion("readerno is not null");
            return (Criteria) this;
        }

        public Criteria andReadernoEqualTo(String value) {
            addCriterion("readerno =", value, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoNotEqualTo(String value) {
            addCriterion("readerno <>", value, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoGreaterThan(String value) {
            addCriterion("readerno >", value, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoGreaterThanOrEqualTo(String value) {
            addCriterion("readerno >=", value, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoLessThan(String value) {
            addCriterion("readerno <", value, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoLessThanOrEqualTo(String value) {
            addCriterion("readerno <=", value, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoLike(String value) {
            addCriterion("readerno like", value, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoNotLike(String value) {
            addCriterion("readerno not like", value, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoIn(List<String> values) {
            addCriterion("readerno in", values, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoNotIn(List<String> values) {
            addCriterion("readerno not in", values, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoBetween(String value1, String value2) {
            addCriterion("readerno between", value1, value2, "readerno");
            return (Criteria) this;
        }

        public Criteria andReadernoNotBetween(String value1, String value2) {
            addCriterion("readerno not between", value1, value2, "readerno");
            return (Criteria) this;
        }

        public Criteria andBooknoIsNull() {
            addCriterion("bookno is null");
            return (Criteria) this;
        }

        public Criteria andBooknoIsNotNull() {
            addCriterion("bookno is not null");
            return (Criteria) this;
        }

        public Criteria andBooknoEqualTo(String value) {
            addCriterion("bookno =", value, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoNotEqualTo(String value) {
            addCriterion("bookno <>", value, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoGreaterThan(String value) {
            addCriterion("bookno >", value, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoGreaterThanOrEqualTo(String value) {
            addCriterion("bookno >=", value, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoLessThan(String value) {
            addCriterion("bookno <", value, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoLessThanOrEqualTo(String value) {
            addCriterion("bookno <=", value, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoLike(String value) {
            addCriterion("bookno like", value, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoNotLike(String value) {
            addCriterion("bookno not like", value, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoIn(List<String> values) {
            addCriterion("bookno in", values, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoNotIn(List<String> values) {
            addCriterion("bookno not in", values, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoBetween(String value1, String value2) {
            addCriterion("bookno between", value1, value2, "bookno");
            return (Criteria) this;
        }

        public Criteria andBooknoNotBetween(String value1, String value2) {
            addCriterion("bookno not between", value1, value2, "bookno");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIsNull() {
            addCriterion("borrowdate is null");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIsNotNull() {
            addCriterion("borrowdate is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowdateEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate =", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate <>", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateGreaterThan(Date value) {
            addCriterionForJDBCDate("borrowdate >", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate >=", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateLessThan(Date value) {
            addCriterionForJDBCDate("borrowdate <", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("borrowdate <=", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIn(List<Date> values) {
            addCriterionForJDBCDate("borrowdate in", values, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("borrowdate not in", values, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("borrowdate between", value1, value2, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("borrowdate not between", value1, value2, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andShoulddateIsNull() {
            addCriterion("shoulddate is null");
            return (Criteria) this;
        }

        public Criteria andShoulddateIsNotNull() {
            addCriterion("shoulddate is not null");
            return (Criteria) this;
        }

        public Criteria andShoulddateEqualTo(Date value) {
            addCriterionForJDBCDate("shoulddate =", value, "shoulddate");
            return (Criteria) this;
        }

        public Criteria andShoulddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("shoulddate <>", value, "shoulddate");
            return (Criteria) this;
        }

        public Criteria andShoulddateGreaterThan(Date value) {
            addCriterionForJDBCDate("shoulddate >", value, "shoulddate");
            return (Criteria) this;
        }

        public Criteria andShoulddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("shoulddate >=", value, "shoulddate");
            return (Criteria) this;
        }

        public Criteria andShoulddateLessThan(Date value) {
            addCriterionForJDBCDate("shoulddate <", value, "shoulddate");
            return (Criteria) this;
        }

        public Criteria andShoulddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("shoulddate <=", value, "shoulddate");
            return (Criteria) this;
        }

        public Criteria andShoulddateIn(List<Date> values) {
            addCriterionForJDBCDate("shoulddate in", values, "shoulddate");
            return (Criteria) this;
        }

        public Criteria andShoulddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("shoulddate not in", values, "shoulddate");
            return (Criteria) this;
        }

        public Criteria andShoulddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("shoulddate between", value1, value2, "shoulddate");
            return (Criteria) this;
        }

        public Criteria andShoulddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("shoulddate not between", value1, value2, "shoulddate");
            return (Criteria) this;
        }

        public Criteria andReturndateIsNull() {
            addCriterion("returndate is null");
            return (Criteria) this;
        }

        public Criteria andReturndateIsNotNull() {
            addCriterion("returndate is not null");
            return (Criteria) this;
        }

        public Criteria andReturndateEqualTo(Date value) {
            addCriterionForJDBCDate("returndate =", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateNotEqualTo(Date value) {
            addCriterionForJDBCDate("returndate <>", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateGreaterThan(Date value) {
            addCriterionForJDBCDate("returndate >", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("returndate >=", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateLessThan(Date value) {
            addCriterionForJDBCDate("returndate <", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("returndate <=", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateIn(List<Date> values) {
            addCriterionForJDBCDate("returndate in", values, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateNotIn(List<Date> values) {
            addCriterionForJDBCDate("returndate not in", values, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("returndate between", value1, value2, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("returndate not between", value1, value2, "returndate");
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