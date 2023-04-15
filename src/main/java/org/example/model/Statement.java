package org.example.model;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Statement {

    public int id;
    public String account;
    public List<Credit> creditList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return id == statement.id && Objects.equals(account, statement.account)
                && Objects.equals(creditList, statement.creditList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, creditList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Statement.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("account='" + account + "'")
                .add("creditList=" + creditList)
                .toString();
    }


    public static final class StatementBuilder {
        private int id;
        private String account;
        private List<Credit> creditList;

        private StatementBuilder() {
        }

        public static StatementBuilder aStatement() {
            return new StatementBuilder();
        }

        public StatementBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public StatementBuilder withAccount(String account) {
            this.account = account;
            return this;
        }

        public StatementBuilder withCreditList(List<Credit> creditList) {
            this.creditList = creditList;
            return this;
        }

        public Statement build() {
            Statement statement = new Statement();
            statement.id = this.id;
            statement.creditList = this.creditList;
            statement.account = this.account;
            return statement;
        }
    }
}

