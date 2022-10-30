package com.example.calculator.ui;

import com.example.calculator.model.Calculator;
import com.example.calculator.model.Operator;

import java.text.DecimalFormat;

public class CalculatorPresenter {

    private DecimalFormat formater = new DecimalFormat();
    private CalculatorView view;
    private Calculator calculator;

    private double argOne;

    private Double argTwo;

    private Operator selectOperator;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }


    public void onDigetPressed(int digit) {

        if (argOne == 0) {

            argOne = argOne * 10 + digit;

            showFormatted(argOne);

        } else {

            argTwo = argTwo * 10 + digit;

            showFormatted(argTwo);
        }
    }

    public void onOperatorPressed(Operator operator) {

        if (selectOperator != null) {


            argOne = calculator.perform(argOne, argTwo, selectOperator);

            showFormatted(argOne);

        }

        argTwo = 0.0;

        selectOperator = operator;
    }

    public void onDotPressed() {
    }

    private void showFormatted(double value){

        view.showResult(formater.format(value));
    }


}
