package cc.home999.book.bean;

import java.util.ArrayList;
import java.util.List;

public class View_ReaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public View_ReaderExample() {
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

        public Criteria and读者编号IsNull() {
            addCriterion("读者编号 is null");
            return (Criteria) this;
        }

        public Criteria and读者编号IsNotNull() {
            addCriterion("读者编号 is not null");
            return (Criteria) this;
        }

        public Criteria and读者编号EqualTo(String value) {
            addCriterion("读者编号 =", value, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号NotEqualTo(String value) {
            addCriterion("读者编号 <>", value, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号GreaterThan(String value) {
            addCriterion("读者编号 >", value, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号GreaterThanOrEqualTo(String value) {
            addCriterion("读者编号 >=", value, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号LessThan(String value) {
            addCriterion("读者编号 <", value, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号LessThanOrEqualTo(String value) {
            addCriterion("读者编号 <=", value, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号Like(String value) {
            addCriterion("读者编号 like", value, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号NotLike(String value) {
            addCriterion("读者编号 not like", value, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号In(List<String> values) {
            addCriterion("读者编号 in", values, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号NotIn(List<String> values) {
            addCriterion("读者编号 not in", values, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号Between(String value1, String value2) {
            addCriterion("读者编号 between", value1, value2, "读者编号");
            return (Criteria) this;
        }

        public Criteria and读者编号NotBetween(String value1, String value2) {
            addCriterion("读者编号 not between", value1, value2, "读者编号");
            return (Criteria) this;
        }

        public Criteria and姓名IsNull() {
            addCriterion("姓名 is null");
            return (Criteria) this;
        }

        public Criteria and姓名IsNotNull() {
            addCriterion("姓名 is not null");
            return (Criteria) this;
        }

        public Criteria and姓名EqualTo(String value) {
            addCriterion("姓名 =", value, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名NotEqualTo(String value) {
            addCriterion("姓名 <>", value, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名GreaterThan(String value) {
            addCriterion("姓名 >", value, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名GreaterThanOrEqualTo(String value) {
            addCriterion("姓名 >=", value, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名LessThan(String value) {
            addCriterion("姓名 <", value, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名LessThanOrEqualTo(String value) {
            addCriterion("姓名 <=", value, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名Like(String value) {
            addCriterion("姓名 like", value, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名NotLike(String value) {
            addCriterion("姓名 not like", value, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名In(List<String> values) {
            addCriterion("姓名 in", values, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名NotIn(List<String> values) {
            addCriterion("姓名 not in", values, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名Between(String value1, String value2) {
            addCriterion("姓名 between", value1, value2, "姓名");
            return (Criteria) this;
        }

        public Criteria and姓名NotBetween(String value1, String value2) {
            addCriterion("姓名 not between", value1, value2, "姓名");
            return (Criteria) this;
        }

        public Criteria and性别IsNull() {
            addCriterion("性别 is null");
            return (Criteria) this;
        }

        public Criteria and性别IsNotNull() {
            addCriterion("性别 is not null");
            return (Criteria) this;
        }

        public Criteria and性别EqualTo(String value) {
            addCriterion("性别 =", value, "性别");
            return (Criteria) this;
        }

        public Criteria and性别NotEqualTo(String value) {
            addCriterion("性别 <>", value, "性别");
            return (Criteria) this;
        }

        public Criteria and性别GreaterThan(String value) {
            addCriterion("性别 >", value, "性别");
            return (Criteria) this;
        }

        public Criteria and性别GreaterThanOrEqualTo(String value) {
            addCriterion("性别 >=", value, "性别");
            return (Criteria) this;
        }

        public Criteria and性别LessThan(String value) {
            addCriterion("性别 <", value, "性别");
            return (Criteria) this;
        }

        public Criteria and性别LessThanOrEqualTo(String value) {
            addCriterion("性别 <=", value, "性别");
            return (Criteria) this;
        }

        public Criteria and性别Like(String value) {
            addCriterion("性别 like", value, "性别");
            return (Criteria) this;
        }

        public Criteria and性别NotLike(String value) {
            addCriterion("性别 not like", value, "性别");
            return (Criteria) this;
        }

        public Criteria and性别In(List<String> values) {
            addCriterion("性别 in", values, "性别");
            return (Criteria) this;
        }

        public Criteria and性别NotIn(List<String> values) {
            addCriterion("性别 not in", values, "性别");
            return (Criteria) this;
        }

        public Criteria and性别Between(String value1, String value2) {
            addCriterion("性别 between", value1, value2, "性别");
            return (Criteria) this;
        }

        public Criteria and性别NotBetween(String value1, String value2) {
            addCriterion("性别 not between", value1, value2, "性别");
            return (Criteria) this;
        }

        public Criteria and身份证号IsNull() {
            addCriterion("身份证号 is null");
            return (Criteria) this;
        }

        public Criteria and身份证号IsNotNull() {
            addCriterion("身份证号 is not null");
            return (Criteria) this;
        }

        public Criteria and身份证号EqualTo(String value) {
            addCriterion("身份证号 =", value, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号NotEqualTo(String value) {
            addCriterion("身份证号 <>", value, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号GreaterThan(String value) {
            addCriterion("身份证号 >", value, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号GreaterThanOrEqualTo(String value) {
            addCriterion("身份证号 >=", value, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号LessThan(String value) {
            addCriterion("身份证号 <", value, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号LessThanOrEqualTo(String value) {
            addCriterion("身份证号 <=", value, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号Like(String value) {
            addCriterion("身份证号 like", value, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号NotLike(String value) {
            addCriterion("身份证号 not like", value, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号In(List<String> values) {
            addCriterion("身份证号 in", values, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号NotIn(List<String> values) {
            addCriterion("身份证号 not in", values, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号Between(String value1, String value2) {
            addCriterion("身份证号 between", value1, value2, "身份证号");
            return (Criteria) this;
        }

        public Criteria and身份证号NotBetween(String value1, String value2) {
            addCriterion("身份证号 not between", value1, value2, "身份证号");
            return (Criteria) this;
        }

        public Criteria and工作单位IsNull() {
            addCriterion("工作单位 is null");
            return (Criteria) this;
        }

        public Criteria and工作单位IsNotNull() {
            addCriterion("工作单位 is not null");
            return (Criteria) this;
        }

        public Criteria and工作单位EqualTo(String value) {
            addCriterion("工作单位 =", value, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位NotEqualTo(String value) {
            addCriterion("工作单位 <>", value, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位GreaterThan(String value) {
            addCriterion("工作单位 >", value, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位GreaterThanOrEqualTo(String value) {
            addCriterion("工作单位 >=", value, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位LessThan(String value) {
            addCriterion("工作单位 <", value, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位LessThanOrEqualTo(String value) {
            addCriterion("工作单位 <=", value, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位Like(String value) {
            addCriterion("工作单位 like", value, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位NotLike(String value) {
            addCriterion("工作单位 not like", value, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位In(List<String> values) {
            addCriterion("工作单位 in", values, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位NotIn(List<String> values) {
            addCriterion("工作单位 not in", values, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位Between(String value1, String value2) {
            addCriterion("工作单位 between", value1, value2, "工作单位");
            return (Criteria) this;
        }

        public Criteria and工作单位NotBetween(String value1, String value2) {
            addCriterion("工作单位 not between", value1, value2, "工作单位");
            return (Criteria) this;
        }

        public Criteria and总借书数量IsNull() {
            addCriterion("总借书数量 is null");
            return (Criteria) this;
        }

        public Criteria and总借书数量IsNotNull() {
            addCriterion("总借书数量 is not null");
            return (Criteria) this;
        }

        public Criteria and总借书数量EqualTo(Long value) {
            addCriterion("总借书数量 =", value, "总借书数量");
            return (Criteria) this;
        }

        public Criteria and总借书数量NotEqualTo(Long value) {
            addCriterion("总借书数量 <>", value, "总借书数量");
            return (Criteria) this;
        }

        public Criteria and总借书数量GreaterThan(Long value) {
            addCriterion("总借书数量 >", value, "总借书数量");
            return (Criteria) this;
        }

        public Criteria and总借书数量GreaterThanOrEqualTo(Long value) {
            addCriterion("总借书数量 >=", value, "总借书数量");
            return (Criteria) this;
        }

        public Criteria and总借书数量LessThan(Long value) {
            addCriterion("总借书数量 <", value, "总借书数量");
            return (Criteria) this;
        }

        public Criteria and总借书数量LessThanOrEqualTo(Long value) {
            addCriterion("总借书数量 <=", value, "总借书数量");
            return (Criteria) this;
        }

        public Criteria and总借书数量In(List<Long> values) {
            addCriterion("总借书数量 in", values, "总借书数量");
            return (Criteria) this;
        }

        public Criteria and总借书数量NotIn(List<Long> values) {
            addCriterion("总借书数量 not in", values, "总借书数量");
            return (Criteria) this;
        }

        public Criteria and总借书数量Between(Long value1, Long value2) {
            addCriterion("总借书数量 between", value1, value2, "总借书数量");
            return (Criteria) this;
        }

        public Criteria and总借书数量NotBetween(Long value1, Long value2) {
            addCriterion("总借书数量 not between", value1, value2, "总借书数量");
            return (Criteria) this;
        }

        public Criteria and未归还数量IsNull() {
            addCriterion("未归还数量 is null");
            return (Criteria) this;
        }

        public Criteria and未归还数量IsNotNull() {
            addCriterion("未归还数量 is not null");
            return (Criteria) this;
        }

        public Criteria and未归还数量EqualTo(Long value) {
            addCriterion("未归还数量 =", value, "未归还数量");
            return (Criteria) this;
        }

        public Criteria and未归还数量NotEqualTo(Long value) {
            addCriterion("未归还数量 <>", value, "未归还数量");
            return (Criteria) this;
        }

        public Criteria and未归还数量GreaterThan(Long value) {
            addCriterion("未归还数量 >", value, "未归还数量");
            return (Criteria) this;
        }

        public Criteria and未归还数量GreaterThanOrEqualTo(Long value) {
            addCriterion("未归还数量 >=", value, "未归还数量");
            return (Criteria) this;
        }

        public Criteria and未归还数量LessThan(Long value) {
            addCriterion("未归还数量 <", value, "未归还数量");
            return (Criteria) this;
        }

        public Criteria and未归还数量LessThanOrEqualTo(Long value) {
            addCriterion("未归还数量 <=", value, "未归还数量");
            return (Criteria) this;
        }

        public Criteria and未归还数量In(List<Long> values) {
            addCriterion("未归还数量 in", values, "未归还数量");
            return (Criteria) this;
        }

        public Criteria and未归还数量NotIn(List<Long> values) {
            addCriterion("未归还数量 not in", values, "未归还数量");
            return (Criteria) this;
        }

        public Criteria and未归还数量Between(Long value1, Long value2) {
            addCriterion("未归还数量 between", value1, value2, "未归还数量");
            return (Criteria) this;
        }

        public Criteria and未归还数量NotBetween(Long value1, Long value2) {
            addCriterion("未归还数量 not between", value1, value2, "未归还数量");
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