package com.learntodroid.simplecalculator;

public class Number {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public void appendNumber(int number, Boolean overwriteMode) {
        if (this.value == 0) {
            this.value = number;
        } else if (overwriteMode) {
            this.value = number;
        } else {
            String valueAsString = String.valueOf(this.value) + number;
            this.value = Integer.parseInt(valueAsString);
        }
    }

    public void add(Number number) {
        this.value += number.value;
    }

    public void subtract(Number number) {
        this.value -= number.value;
    }

    public void multiply(Number number) {
        this.value *= number.value;
    }

    public void divide(Number number) {
        this.value /= number.value;
    }

    public int getValue() {
        return value;
    }

    public void backspaceNumber() {
        if (this.value == 0) {
            this.value = 0;
        } else {
            String valueAsString = String.valueOf(this.value);
            if (valueAsString.length() <= 1) {
                this.value = 0;
            } else {
                String result = valueAsString.substring(0, valueAsString.length() - 1);
                this.value = Integer.parseInt(result);
            }
        }
    }
}
