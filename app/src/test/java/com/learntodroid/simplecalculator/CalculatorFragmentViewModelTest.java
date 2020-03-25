package com.learntodroid.simplecalculator;

import android.app.Application;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CalculatorFragmentViewModelTest {
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void test_appendNumber() {

        CalculatorFragmentViewModel calculatorFragmentViewModel = new CalculatorFragmentViewModel((Application) ApplicationProvider.getApplicationContext());

        calculatorFragmentViewModel.appendNumber(8);

//        int number
//        Log.i(CalculatorFragmentViewModel.class.getSimpleName(), "appendNumber " + number);
//        currentNumberMutableLiveData.getValue().appendNumber(number, overwriteMode.getValue());
//        currentNumberMutableLiveData.setValue(currentNumberMutableLiveData.getValue());
//        Log.i(CalculatorFragmentViewModel.class.getSimpleName(), "new value " + currentNumberMutableLiveData.getValue().getValue());
//        overwriteMode.setValue(false);
    }
}