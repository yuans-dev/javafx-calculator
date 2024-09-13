package com.guiprog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

public class CalculatorController {

    @FXML
    private Label calcDisplay;

    private double firstOperand = 0;
    private double secondOperand = 0;
    private String operator = "";
    private boolean startNewInput = true;
    private boolean operatorPressed = false;
    private boolean dotPressed = false;

    @FXML
    public void handleCalcPad0(ActionEvent event) {
        handleNumberInput("0");
    }

    @FXML
    public void handleCalcPad1(ActionEvent event) {
        handleNumberInput("1");
    }

    @FXML
    public void handleCalcPad2(ActionEvent event) {
        handleNumberInput("2");
    }

    @FXML
    public void handleCalcPad3(ActionEvent event) {
        handleNumberInput("3");
    }

    @FXML
    public void handleCalcPad4(ActionEvent event) {
        handleNumberInput("4");
    }

    @FXML
    public void handleCalcPad5(ActionEvent event) {
        handleNumberInput("5");
    }

    @FXML
    public void handleCalcPad6(ActionEvent event) {
        handleNumberInput("6");
    }

    @FXML
    public void handleCalcPad7(ActionEvent event) {
        handleNumberInput("7");
    }

    @FXML
    public void handleCalcPad8(ActionEvent event) {
        handleNumberInput("8");
    }

    @FXML
    public void handleCalcPad9(ActionEvent event) {
        handleNumberInput("9");
    }

    @FXML
    public void handleCalcPadAdd(ActionEvent event) {
        handleOperatorInput("+");
    }

    @FXML
    public void handleCalcPadMinus(ActionEvent event) {
        handleOperatorInput("-");
    }

    @FXML
    public void handleCalcPadMultiply(ActionEvent event) {
        handleOperatorInput("*");
    }

    @FXML
    public void handleCalcPadDivide(ActionEvent event) {
        handleOperatorInput("/");
    }

    @FXML
    public void handleCalcPadEquals(ActionEvent event) {
        if (!operator.isEmpty()) {
            secondOperand = Double.parseDouble(calcDisplay.getText());
            double result = calculate(firstOperand, secondOperand, operator);
            calcDisplay.setText(String.valueOf(result));
            operator = "";
            startNewInput = true;
            dotPressed = false;
        }
    }

    @FXML
    public void handleCalcPadDot(ActionEvent event) {
        if (!dotPressed) {
            calcDisplay.setText(calcDisplay.getText() + ".");
            dotPressed = true;
            startNewInput = false;
        }
    }

    @FXML
    public void handleCalcPadClear(ActionEvent event) {
        calcDisplay.setText("0");
        startNewInput = true;
        dotPressed = false;
    }

    @FXML
    public void handleCalcPadCE(ActionEvent event) {
        firstOperand = 0;
        secondOperand = 0;
        operator = "";
        calcDisplay.setText("0");
        startNewInput = true;
        dotPressed = false;
        operatorPressed = false;
    }

    @FXML
    public void handleCalcPadDelete(ActionEvent event) {
        String currentText = calcDisplay.getText();
        if (currentText.length() > 0) {
            calcDisplay.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    @FXML
    public void handleCalcPadNegative(ActionEvent event) {
        String currentText = calcDisplay.getText();
        if (!currentText.equals("0")) {
            if (currentText.startsWith("-")) {
                calcDisplay.setText(currentText.substring(1));
            } else {
                calcDisplay.setText("-" + currentText);
            }
        }
    }

    private void handleNumberInput(String number) {
        if (startNewInput) {
            calcDisplay.setText(number);
            startNewInput = false;
        } else {
            calcDisplay.setText(calcDisplay.getText() + number);
        }

        operatorPressed = false;
    }

    private void handleOperatorInput(String newOperator) {
        if (!operatorPressed) {
            if (!operator.isEmpty()) {
                operator = newOperator; // Override operator without calculation
            } else {
                firstOperand = Double.parseDouble(calcDisplay.getText());
                operator = newOperator;
            }
            operatorPressed = true;
            startNewInput = true;
            dotPressed = false;
        } else {
            operator = newOperator; // Override operator directly
        }
    }

    private double calculate(double firstOperand, double secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return secondOperand != 0 ? firstOperand / secondOperand : 0;
            default:
                return 0;
        }
    }
}
