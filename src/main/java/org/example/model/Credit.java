package org.example.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class Credit {
    public String type;
    public BigDecimal rest;
    public BigDecimal restOverdue;

    public Credit(String type, BigDecimal rest, BigDecimal restOverdue) {
        this.type = type;
        this.rest = rest;
        this.restOverdue = restOverdue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Objects.equals(type, credit.type) && Objects.equals(rest, credit.rest) && Objects.equals(restOverdue, credit.restOverdue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, rest, restOverdue);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Credit.class.getSimpleName() + "[", "]")
                .add("type='" + type + "'")
                .add("rest=" + rest)
                .add("restOverdue=" + restOverdue)
                .toString();
    }


    public static final class CreditBuilder {
        private String type;
        private BigDecimal rest;
        private BigDecimal restOverdue;

        private CreditBuilder() {
        }

        public static CreditBuilder aCredit() {
            return new CreditBuilder();
        }

        public CreditBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public CreditBuilder withRest(BigDecimal rest) {
            this.rest = rest;
            return this;
        }

        public CreditBuilder withRestOverdue(BigDecimal restOverdue) {
            this.restOverdue = restOverdue;
            return this;
        }

        public Credit build() {
            return new Credit(type, rest, restOverdue);
        }
    }
}
