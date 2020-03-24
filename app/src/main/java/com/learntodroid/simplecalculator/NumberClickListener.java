package com.learntodroid.simplecalculator;

import android.view.View;

public class NumberClickListener implements View.OnClickListener {
    private CalculatorFragmentViewModel calculatorFragmentViewModel;
    private int number;

    public NumberClickListener(CalculatorFragmentViewModel calculatorFragmentViewModel, int number) {
        this.calculatorFragmentViewModel = calculatorFragmentViewModel;
        this.number = number;
    }

    @Override
    public void onClick(View v) {
        calculatorFragmentViewModel.appendNumber(number);
    }
}
