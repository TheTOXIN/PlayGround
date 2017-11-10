package com.toxin.play.JUnit;

import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorTest {
    int a, b, expResult;

    public CalculatorTest(int a, int b, int expResult) {
        this.a = a;
        this.b = b;
        this.expResult = expResult;
    }

    @Rule
    public TestRule timeout = new Timeout(100);

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{{1,2,3},{2,3,5},{3,4,7}});
    }

    @Before
    public void setUp() {
        System.out.format("BEFORE a = %d b = %d \n", a, b);
    }

    @After
    public void tearDown() {
        System.out.format("AFTER expRes = %d \n", expResult);
    }

    @Test
    public void add() throws Exception {
        Calculator calculator = new Calculator();
        calculator.add(a, b);
        Assert.assertEquals(expResult, calculator.getResult());
    }

    @Ignore
    @Test(expected = ArithmeticException.class)
    public void dev() throws Exception {
        Calculator calculator = new Calculator();
        calculator.dev(1, 1);
        Assert.assertEquals(1, calculator.getResult());
    }
}