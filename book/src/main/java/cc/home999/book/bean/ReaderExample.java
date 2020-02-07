package cc.home999.book.bean;

import java.util.ArrayList;
import java.util.List;

public class ReaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReaderExample() {
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

        public Criteria andReadernameIsNull() {
            addCriterion("readername is null");
            return (Criteria) this;
        }

        public Criteria andReadernameIsNotNull() {
            addCriterion("readername is not null");
            return (Criteria) this;
        }

        public Criteria andReadernameEqualTo(String value) {
            addCriterion("readername =", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameNotEqualTo(String value) {
            addCriterion("readername <>", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameGreaterThan(String value) {
            addCriterion("readername >", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameGreaterThanOrEqualTo(String value) {
            addCriterion("readername >=", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameLessThan(String value) {
            addCriterion("readername <", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameLessThanOrEqualTo(String value) {
            addCriterion("readername <=", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameLike(String value) {
            addCriterion("readername like", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameNotLike(String value) {
            addCriterion("readername not like", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameIn(List<String> values) {
            addCriterion("readername in", values, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameNotIn(List<String> values) {
            addCriterion("readername not in", values, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameBetween(String value1, String value2) {
            addCriterion("readername between", value1, value2, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameNotBetween(String value1, String value2) {
            addCriterion("readername not between", value1, value2, "readername");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andIdentitycardIsNull() {
            addCriterion("identitycard is null");
            return (Criteria) this;
        }

        public Criteria andIdentitycardIsNotNull() {
            addCriterion("identitycard is not null");
            return (Criteria) this;
        }

        public Criteria andIdentitycardEqualTo(String value) {
            addCriterion("identitycard =", value, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardNotEqualTo(String value) {
            addCriterion("identitycard <>", value, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardGreaterThan(String value) {
            addCriterion("identitycard >", value, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardGreaterThanOrEqualTo(String value) {
            addCriterion("identitycard >=", value, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardLessThan(String value) {
            addCriterion("identitycard <", value, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardLessThanOrEqualTo(String value) {
            addCriterion("identitycard <=", value, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardLike(String value) {
            addCriterion("identitycard like", value, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardNotLike(String value) {
            addCriterion("identitycard not like", value, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardIn(List<String> values) {
            addCriterion("identitycard in", values, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardNotIn(List<String> values) {
            addCriterion("identitycard not in", values, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardBetween(String value1, String value2) {
            addCriterion("identitycard between", value1, value2, "identitycard");
            return (Criteria) this;
        }

        public Criteria andIdentitycardNotBetween(String value1, String value2) {
            addCriterion("identitycard not between", value1, value2, "identitycard");
            return (Criteria) this;
        }

        public Criteria andWorkunitIsNull() {
            addCriterion("workunit is null");
            return (Criteria) this;
        }

        public Criteria andWorkunitIsNotNull() {
            addCriterion("workunit is not null");
            return (Criteria) this;
        }

        public Criteria andWorkunitEqualTo(String value) {
            addCriterion("workunit =", value, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitNotEqualTo(String value) {
            addCriterion("workunit <>", value, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitGreaterThan(String value) {
            addCriterion("workunit >", value, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitGreaterThanOrEqualTo(String value) {
            addCriterion("workunit >=", value, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitLessThan(String value) {
            addCriterion("workunit <", value, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitLessThanOrEqualTo(String value) {
            addCriterion("workunit <=", value, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitLike(String value) {
            addCriterion("workunit like", value, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitNotLike(String value) {
            addCriterion("workunit not like", value, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitIn(List<String> values) {
            addCriterion("workunit in", values, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitNotIn(List<String> values) {
            addCriterion("workunit not in", values, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitBetween(String value1, String value2) {
            addCriterion("workunit between", value1, value2, "workunit");
            return (Criteria) this;
        }

        public Criteria andWorkunitNotBetween(String value1, String value2) {
            addCriterion("workunit not between", value1, value2, "workunit");
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