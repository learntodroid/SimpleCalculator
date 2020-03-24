package com.learntodroid.simplecalculator;

import android.view.View;

public class OperationClickListener implements View.OnClickListener {
    public static final String ADD = "ADD";
    public static final String SUBTRACT = "SUBTRACT";
    public static final String MULTIPLY = "MULTIPLY";
    public static final String DIVIDE = "DIVIDE";

    private CalculatorFragmentViewModel calculatorFragmentViewModel;
    private String operation;

    public OperationClickListener(CalculatorFragmentViewModel calculatorFragmentViewModel, String operation) {
        this.calculatorFragmentViewModel = calculatorFragmentViewModel;
        this.operation = operation;
    }

    @Override
    public void onClick(View v) {
        calculatorFragmentViewModel.setOperation(operation);
    }
}
