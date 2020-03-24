package com.learntodroid.simplecalculator;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import static com.learntodroid.simplecalculator.OperationClickListener.ADD;
import static com.learntodroid.simplecalculator.OperationClickListener.DIVIDE;
import static com.learntodroid.simplecalculator.OperationClickListener.MULTIPLY;
import static com.learntodroid.simplecalculator.OperationClickListener.SUBTRACT;

public class CalculatorFragmentViewModel extends AndroidViewModel {
    private MutableLiveData<Number> currentNumberMutableLiveData;
    private MutableLiveData<String> currentOperationLiveData;
    private MutableLiveData<Number> storedNumber;
    private MutableLiveData<Boolean> overwriteMode;

    public CalculatorFragmentViewModel(@NonNull Application application) {
        super(application);
        currentNumberMutableLiveData = new MutableLiveData<>();
        currentNumberMutableLiveData.setValue(new Number(0));
        currentOperationLiveData = new MutableLiveData<String>();
        storedNumber = new MutableLiveData<Number>();

        overwriteMode = new MutableLiveData<>();
        overwriteMode.setValue(false);
    }

    public void appendNumber(int number) {
        Log.i(CalculatorFragmentViewModel.class.getSimpleName(), "appendNumber " + number);
        currentNumberMutableLiveData.getValue().appendNumber(number, overwriteMode.getValue());
        currentNumberMutableLiveData.setValue(currentNumberMutableLiveData.getValue());
        Log.i(CalculatorFragmentViewModel.class.getSimpleName(), "new value " + currentNumberMutableLiveData.getValue().getValue());
        overwriteMode.setValue(false);
    }

    public MutableLiveData<Number> getNumberMutableLiveData() {
        return currentNumberMutableLiveData;
    }

    public void setOperation(String operation) {
        currentOperationLiveData.setValue(operation);
        storedNumber.setValue(currentNumberMutableLiveData.getValue());
        currentNumberMutableLiveData.setValue(new Number(0));
    }

    public void calculateResult() {
        overwriteMode.setValue(true);
//        Number result = currentNumberMutableLiveData.getValue();
        Number result = storedNumber.getValue();
        switch (currentOperationLiveData.getValue()) {
            case ADD:
                result.add(currentNumberMutableLiveData.getValue());
                currentNumberMutableLiveData.setValue(result);
                return;
            case SUBTRACT:
                result.subtract(currentNumberMutableLiveData.getValue());
                currentNumberMutableLiveData.setValue(result);
                return;
            case MULTIPLY:
                result.multiply(currentNumberMutableLiveData.getValue());
                currentNumberMutableLiveData.setValue(result);
                return;
            case DIVIDE:
                result.divide(currentNumberMutableLiveData.getValue());
                currentNumberMutableLiveData.setValue(result);
                return;
            default:
                Log.i(CalculatorFragmentViewModel.class.getSimpleName(), "OPERATOR MISSING");
                return;
        }
    }

    public void backspace() {
        currentNumberMutableLiveData.getValue().backspaceNumber();
        currentNumberMutableLiveData.setValue(currentNumberMutableLiveData.getValue());
    }

    public void clearEntry() {
        currentNumberMutableLiveData.setValue(new Number(0));
    }

    public void clearAll() {
        currentNumberMutableLiveData.setValue(new Number(0));
        storedNumber.setValue(new Number(0));
        currentOperationLiveData.setValue("");
    }

    public MutableLiveData<String> getOperationLiveData() {
        return currentOperationLiveData;
    }

    public MutableLiveData<Number> getStoredNumber() {
        return storedNumber;
    }
}
