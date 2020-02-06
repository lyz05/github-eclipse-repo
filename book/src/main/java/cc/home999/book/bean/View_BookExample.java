package cc.home999.book.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class View_BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public View_BookExample() {
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

        public Criteria and图书编号IsNull() {
            addCriterion("图书编号 is null");
            return (Criteria) this;
        }

        public Criteria and图书编号IsNotNull() {
            addCriterion("图书编号 is not null");
            return (Criteria) this;
        }

        public Criteria and图书编号EqualTo(String value) {
            addCriterion("图书编号 =", value, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号NotEqualTo(String value) {
            addCriterion("图书编号 <>", value, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号GreaterThan(String value) {
            addCriterion("图书编号 >", value, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号GreaterThanOrEqualTo(String value) {
            addCriterion("图书编号 >=", value, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号LessThan(String value) {
            addCriterion("图书编号 <", value, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号LessThanOrEqualTo(String value) {
            addCriterion("图书编号 <=", value, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号Like(String value) {
            addCriterion("图书编号 like", value, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号NotLike(String value) {
            addCriterion("图书编号 not like", value, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号In(List<String> values) {
            addCriterion("图书编号 in", values, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号NotIn(List<String> values) {
            addCriterion("图书编号 not in", values, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号Between(String value1, String value2) {
            addCriterion("图书编号 between", value1, value2, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书编号NotBetween(String value1, String value2) {
            addCriterion("图书编号 not between", value1, value2, "图书编号");
            return (Criteria) this;
        }

        public Criteria and图书名称IsNull() {
            addCriterion("图书名称 is null");
            return (Criteria) this;
        }

        public Criteria and图书名称IsNotNull() {
            addCriterion("图书名称 is not null");
            return (Criteria) this;
        }

        public Criteria and图书名称EqualTo(String value) {
            addCriterion("图书名称 =", value, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称NotEqualTo(String value) {
            addCriterion("图书名称 <>", value, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称GreaterThan(String value) {
            addCriterion("图书名称 >", value, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称GreaterThanOrEqualTo(String value) {
            addCriterion("图书名称 >=", value, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称LessThan(String value) {
            addCriterion("图书名称 <", value, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称LessThanOrEqualTo(String value) {
            addCriterion("图书名称 <=", value, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称Like(String value) {
            addCriterion("图书名称 like", value, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称NotLike(String value) {
            addCriterion("图书名称 not like", value, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称In(List<String> values) {
            addCriterion("图书名称 in", values, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称NotIn(List<String> values) {
            addCriterion("图书名称 not in", values, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称Between(String value1, String value2) {
            addCriterion("图书名称 between", value1, value2, "图书名称");
            return (Criteria) this;
        }

        public Criteria and图书名称NotBetween(String value1, String value2) {
            addCriterion("图书名称 not between", value1, value2, "图书名称");
            return (Criteria) this;
        }

        public Criteria and作者IsNull() {
            addCriterion("作者 is null");
            return (Criteria) this;
        }

        public Criteria and作者IsNotNull() {
            addCriterion("作者 is not null");
            return (Criteria) this;
        }

        public Criteria and作者EqualTo(String value) {
            addCriterion("作者 =", value, "作者");
            return (Criteria) this;
        }

        public Criteria and作者NotEqualTo(String value) {
            addCriterion("作者 <>", value, "作者");
            return (Criteria) this;
        }

        public Criteria and作者GreaterThan(String value) {
            addCriterion("作者 >", value, "作者");
            return (Criteria) this;
        }

        public Criteria and作者GreaterThanOrEqualTo(String value) {
            addCriterion("作者 >=", value, "作者");
            return (Criteria) this;
        }

        public Criteria and作者LessThan(String value) {
            addCriterion("作者 <", value, "作者");
            return (Criteria) this;
        }

        public Criteria and作者LessThanOrEqualTo(String value) {
            addCriterion("作者 <=", value, "作者");
            return (Criteria) this;
        }

        public Criteria and作者Like(String value) {
            addCriterion("作者 like", value, "作者");
            return (Criteria) this;
        }

        public Criteria and作者NotLike(String value) {
            addCriterion("作者 not like", value, "作者");
            return (Criteria) this;
        }

        public Criteria and作者In(List<String> values) {
            addCriterion("作者 in", values, "作者");
            return (Criteria) this;
        }

        public Criteria and作者NotIn(List<String> values) {
            addCriterion("作者 not in", values, "作者");
            return (Criteria) this;
        }

        public Criteria and作者Between(String value1, String value2) {
            addCriterion("作者 between", value1, value2, "作者");
            return (Criteria) this;
        }

        public Criteria and作者NotBetween(String value1, String value2) {
            addCriterion("作者 not between", value1, value2, "作者");
            return (Criteria) this;
        }

        public Criteria and出版社IsNull() {
            addCriterion("出版社 is null");
            return (Criteria) this;
        }

        public Criteria and出版社IsNotNull() {
            addCriterion("出版社 is not null");
            return (Criteria) this;
        }

        public Criteria and出版社EqualTo(String value) {
            addCriterion("出版社 =", value, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社NotEqualTo(String value) {
            addCriterion("出版社 <>", value, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社GreaterThan(String value) {
            addCriterion("出版社 >", value, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社GreaterThanOrEqualTo(String value) {
            addCriterion("出版社 >=", value, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社LessThan(String value) {
            addCriterion("出版社 <", value, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社LessThanOrEqualTo(String value) {
            addCriterion("出版社 <=", value, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社Like(String value) {
            addCriterion("出版社 like", value, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社NotLike(String value) {
            addCriterion("出版社 not like", value, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社In(List<String> values) {
            addCriterion("出版社 in", values, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社NotIn(List<String> values) {
            addCriterion("出版社 not in", values, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社Between(String value1, String value2) {
            addCriterion("出版社 between", value1, value2, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版社NotBetween(String value1, String value2) {
            addCriterion("出版社 not between", value1, value2, "出版社");
            return (Criteria) this;
        }

        public Criteria and出版日期IsNull() {
            addCriterion("出版日期 is null");
            return (Criteria) this;
        }

        public Criteria and出版日期IsNotNull() {
            addCriterion("出版日期 is not null");
            return (Criteria) this;
        }

        public Criteria and出版日期EqualTo(Date value) {
            addCriterionForJDBCDate("出版日期 =", value, "出版日期");
            return (Criteria) this;
        }

        public Criteria and出版日期NotEqualTo(Date value) {
            addCriterionForJDBCDate("出版日期 <>", value, "出版日期");
            return (Criteria) this;
        }

        public Criteria and出版日期GreaterThan(Date value) {
            addCriterionForJDBCDate("出版日期 >", value, "出版日期");
            return (Criteria) this;
        }

        public Criteria and出版日期GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("出版日期 >=", value, "出版日期");
            return (Criteria) this;
        }

        public Criteria and出版日期LessThan(Date value) {
            addCriterionForJDBCDate("出版日期 <", value, "出版日期");
            return (Criteria) this;
        }

        public Criteria and出版日期LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("出版日期 <=", value, "出版日期");
            return (Criteria) this;
        }

        public Criteria and出版日期In(List<Date> values) {
            addCriterionForJDBCDate("出版日期 in", values, "出版日期");
            return (Criteria) this;
        }

        public Criteria and出版日期NotIn(List<Date> values) {
            addCriterionForJDBCDate("出版日期 not in", values, "出版日期");
            return (Criteria) this;
        }

        public Criteria and出版日期Between(Date value1, Date value2) {
            addCriterionForJDBCDate("出版日期 between", value1, value2, "出版日期");
            return (Criteria) this;
        }

        public Criteria and出版日期NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("出版日期 not between", value1, value2, "出版日期");
            return (Criteria) this;
        }

        public Criteria and入库数量IsNull() {
            addCriterion("入库数量 is null");
            return (Criteria) this;
        }

        public Criteria and入库数量IsNotNull() {
            addCriterion("入库数量 is not null");
            return (Criteria) this;
        }

        public Criteria and入库数量EqualTo(Integer value) {
            addCriterion("入库数量 =", value, "入库数量");
            return (Criteria) this;
        }

        public Criteria and入库数量NotEqualTo(Integer value) {
            addCriterion("入库数量 <>", value, "入库数量");
            return (Criteria) this;
        }

        public Criteria and入库数量GreaterThan(Integer value) {
            addCriterion("入库数量 >", value, "入库数量");
            return (Criteria) this;
        }

        public Criteria and入库数量GreaterThanOrEqualTo(Integer value) {
            addCriterion("入库数量 >=", value, "入库数量");
            return (Criteria) this;
        }

        public Criteria and入库数量LessThan(Integer value) {
            addCriterion("入库数量 <", value, "入库数量");
            return (Criteria) this;
        }

        public Criteria and入库数量LessThanOrEqualTo(Integer value) {
            addCriterion("入库数量 <=", value, "入库数量");
            return (Criteria) this;
        }

        public Criteria and入库数量In(List<Integer> values) {
            addCriterion("入库数量 in", values, "入库数量");
            return (Criteria) this;
        }

        public Criteria and入库数量NotIn(List<Integer> values) {
            addCriterion("入库数量 not in", values, "入库数量");
            return (Criteria) this;
        }

        public Criteria and入库数量Between(Integer value1, Integer value2) {
            addCriterion("入库数量 between", value1, value2, "入库数量");
            return (Criteria) this;
        }

        public Criteria and入库数量NotBetween(Integer value1, Integer value2) {
            addCriterion("入库数量 not between", value1, value2, "入库数量");
            return (Criteria) this;
        }

        public Criteria and在库数量IsNull() {
            addCriterion("在库数量 is null");
            return (Criteria) this;
        }

        public Criteria and在库数量IsNotNull() {
            addCriterion("在库数量 is not null");
            return (Criteria) this;
        }

        public Criteria and在库数量EqualTo(Long value) {
            addCriterion("在库数量 =", value, "在库数量");
            return (Criteria) this;
        }

        public Criteria and在库数量NotEqualTo(Long value) {
            addCriterion("在库数量 <>", value, "在库数量");
            return (Criteria) this;
        }

        public Criteria and在库数量GreaterThan(Long value) {
            addCriterion("在库数量 >", value, "在库数量");
            return (Criteria) this;
        }

        public Criteria and在库数量GreaterThanOrEqualTo(Long value) {
            addCriterion("在库数量 >=", value, "在库数量");
            return (Criteria) this;
        }

        public Criteria and在库数量LessThan(Long value) {
            addCriterion("在库数量 <", value, "在库数量");
            return (Criteria) this;
        }

        public Criteria and在库数量LessThanOrEqualTo(Long value) {
            addCriterion("在库数量 <=", value, "在库数量");
            return (Criteria) this;
        }

        public Criteria and在库数量In(List<Long> values) {
            addCriterion("在库数量 in", values, "在库数量");
            return (Criteria) this;
        }

        public Criteria and在库数量NotIn(List<Long> values) {
            addCriterion("在库数量 not in", values, "在库数量");
            return (Criteria) this;
        }

        public Criteria and在库数量Between(Long value1, Long value2) {
            addCriterion("在库数量 between", value1, value2, "在库数量");
            return (Criteria) this;
        }

        public Criteria and在库数量NotBetween(Long value1, Long value2) {
            addCriterion("在库数量 not between", value1, value2, "在库数量");
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