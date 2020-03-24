package com.learntodroid.simplecalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class CalculatorFragment extends Fragment {
    private CalculatorFragmentViewModel calculatorFragmentViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calculatorFragmentViewModel = ViewModelProviders.of(this).get(CalculatorFragmentViewModel.class);

        calculatorFragmentViewModel.getNumberMutableLiveData().observe(this, new Observer<Number>() {
            @Override
            public void onChanged(Number number) {
                Log.i(CalculatorFragment.class.getSimpleName(), "number: " + number.getValue());
                TextView textView = getView().findViewById(R.id.fragment_calculator_result);
                textView.setText(String.valueOf(number.getValue()));
            }
        });

        calculatorFragmentViewModel.getOperationLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String operation) {
                Log.i(CalculatorFragment.class.getSimpleName(), "operation: " + operation);
                TextView textView = getView().findViewById(R.id.fragment_calculator_operation);
                textView.setText(operation);
            }
        });

        calculatorFragmentViewModel.getStoredNumber().observe(this, new Observer<Number>() {
            @Override
            public void onChanged(Number number) {
                Log.i(CalculatorFragment.class.getSimpleName(), "stored number: " + number);
                TextView textView = getView().findViewById(R.id.fragment_calculator_stored);
                textView.setText(String.valueOf(number.getValue()));
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        view.findViewById(R.id.fragment_calculator_0).setOnClickListener(new NumberClickListener(calculatorFragmentViewModel, 0));
        view.findViewById(R.id.fragment_calculator_1).setOnClickListener(new NumberClickListener(calculatorFragmentViewModel, 1));
        view.findViewById(R.id.fragment_calculator_2).setOnClickListener(new NumberClickListener(calculatorFragmentViewModel, 2));
        view.findViewById(R.id.fragment_calculator_3).setOnClickListener(new NumberClickListener(calculatorFragmentViewModel, 3));
        view.findViewById(R.id.fragment_calculator_4).setOnClickListener(new NumberClickListener(calculatorFragmentViewModel, 4));
        view.findViewById(R.id.fragment_calculator_5).setOnClickListener(new NumberClickListener(calculatorFragmentViewModel, 5));
        view.findViewById(R.id.fragment_calculator_6).setOnClickListener(new NumberClickListener(calculatorFragmentViewModel, 6));
        view.findViewById(R.id.fragment_calculator_7).setOnClickListener(new NumberClickListener(calculatorFragmentViewModel, 7));
        view.findViewById(R.id.fragment_calculator_8).setOnClickListener(new NumberClickListener(calculatorFragmentViewModel, 8));
        view.findViewById(R.id.fragment_calculator_9).setOnClickListener(new NumberClickListener(calculatorFragmentViewModel, 9));

        view.findViewById(R.id.fragment_calculator_add).setOnClickListener(new OperationClickListener(calculatorFragmentViewModel, OperationClickListener.ADD));
        view.findViewById(R.id.fragment_calculator_subtract).setOnClickListener(new OperationClickListener(calculatorFragmentViewModel, OperationClickListener.SUBTRACT));
        view.findViewById(R.id.fragment_calculator_multiply).setOnClickListener(new OperationClickListener(calculatorFragmentViewModel, OperationClickListener.MULTIPLY));
        view.findViewById(R.id.fragment_calculator_divide).setOnClickListener(new OperationClickListener(calculatorFragmentViewModel, OperationClickListener.DIVIDE));

        view.findViewById(R.id.fragment_calculator_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorFragmentViewModel.calculateResult();
            }
        });

        view.findViewById(R.id.fragment_calculator_clearEntry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorFragmentViewModel.clearEntry();
            }
        });

        view.findViewById(R.id.fragment_calculator_clearAll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorFragmentViewModel.clearAll();
            }
        });

        view.findViewById(R.id.fragment_calculator_backSpace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorFragmentViewModel.backspace();
            }
        });

        return view;
    }
}
