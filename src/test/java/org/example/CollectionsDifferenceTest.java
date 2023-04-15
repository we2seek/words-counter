package org.example;

import org.example.model.Credit;
import org.example.model.Statement;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CollectionsDifferenceTest {
    Statement a, b, c, d, d1;
    CollectionsDifference service;

    @Before
    public void setUp() {
        service = CollectionsDifference.getInstance();

        int id = (int) (System.currentTimeMillis() % 1000);
        Credit creditRest = Credit.CreditBuilder.aCredit()
                .withType("rest")
                .withRest(BigDecimal.ONE)
                .withRestOverdue(BigDecimal.ZERO)
                .build();

        Credit creditPercent = Credit.CreditBuilder.aCredit()
                .withType("percent")
                .withRest(BigDecimal.ZERO)
                .withRestOverdue(BigDecimal.ONE)
                .build();

        a = Statement.StatementBuilder.aStatement()
                .withId(id)
                .withAccount("a")
                .build();
        b = Statement.StatementBuilder.aStatement()
                .withId(id)
                .withAccount("b")
                .build();
        c = Statement.StatementBuilder.aStatement()
                .withId(id)
                .withAccount("a")
                .withCreditList(Arrays.asList(creditRest))
                .build();
        d = Statement.StatementBuilder.aStatement()
                .withId(id)
                .withAccount("a")
                .withCreditList(Arrays.asList(creditPercent))
                .build();
        d1 = Statement.StatementBuilder.aStatement()
                .withId(id)
                .withAccount("a")
                .withCreditList(Arrays.asList(creditPercent))
                .build();
    }

    @Test
    public void testFindDifference() {
        assertNotEquals(a, b);
        assertNotEquals(a, c);
        assertNotEquals(a, d);
        assertNotEquals(b, c);
        assertNotEquals(b, d);
        assertNotEquals(c, d);
        assertEquals(d, d1);

        // [a] and [a,b] -> b
        assertEquals(Arrays.asList(b), service.diff(Arrays.asList(a), Arrays.asList(a, b)));

        // [a] and [b]   -> [a, b]
        assertEquals(Arrays.asList(a, b), service.diff(Arrays.asList(a), Arrays.asList(b)));
        assertEquals(Arrays.asList(a, c), service.diff(Arrays.asList(a), Arrays.asList(c)));
        assertEquals(Arrays.asList(c, d), service.diff(Arrays.asList(c), Arrays.asList(d)));

        // [a] and [a]   -> []
        assertTrue(service.diff(Arrays.asList(a), Arrays.asList(a)).isEmpty());
        assertTrue(service.diff(Arrays.asList(d), Arrays.asList(d1)).isEmpty());
        assertTrue(service.diff(Arrays.asList(a, b, c), Arrays.asList(a, c, b)).isEmpty());
    }
}