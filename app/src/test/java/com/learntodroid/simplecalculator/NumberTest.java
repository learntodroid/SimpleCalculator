package com.learntodroid.simplecalculator;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class NumberTest {
    @Test
    public void add_two_numbers() {
        Number number = new Number(3);
        number.add(new Number(19));
        Assert.assertEquals(22, number.getValue());
    }

    @Test
    public void add_two_zeros() {
        Number number = new Number(0);
        number.add(new Number(0));
        Assert.assertEquals(0, number.getValue());
    }

    @Test
    public void add_negative() {
        Number number = new Number(-10);
        number.add(new Number(-25));
        Assert.assertEquals(-35, number.getValue());
    }

    @Test
    public void add_positive() {
        Number number = new Number(1);
        number.add(new Number(2));
        Assert.assertEquals(3, number.getValue());
    }

    @Test
    public void subtract_negative() {
        Number number = new Number(1);
        number.subtract(new Number(2));
        Assert.assertEquals(-1, number.getValue());
    }

    @Test
    public void subtract_positive() {
        Number number = new Number(28);
        number.subtract(new Number(12));
        Assert.assertEquals(16, number.getValue());
    }

    @Test
    public void multiply() {
        Number number = new Number(12);
        number.multiply(new Number(9));
        Assert.assertEquals(108, number.getValue());
    }

    @Test
    public void multiply_hamcrest() {
        Number number = new Number(12);
        number.multiply(new Number(9));
        Assert.assertThat(number.getValue(), is(equalTo(108)));
    }

    @Test
    public void divide() {
        Number number = new Number(100);
        number.divide(new Number(10));
        Assert.assertEquals(10, number.getValue());
    }

    @Test
    public void appendNumber_append_to_zero() {
        Number number = new Number(0);
        number.appendNumber(1, false);
        Assert.assertEquals(1, number.getValue());
    }

    @Test
    public void appendNumber_append() {
        Number number = new Number(956);
        number.appendNumber(9, false);
        Assert.assertEquals(9569, number.getValue());
    }

    @Test
    public void backspaceNumber() {
        Number number = new Number(72733);
        number.backspaceNumber();
        Assert.assertEquals(7273, number.getValue());
    }

    @Test
    public void backspaceNumber_twice() {
        Number number = new Number(193723);
        number.backspaceNumber();
        number.backspaceNumber();
        Assert.assertEquals(1937, number.getValue());
    }
}