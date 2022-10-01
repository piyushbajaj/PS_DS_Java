package designPattern.MVC.Calculator;

/**
 * Created by piyush.bajaj on 13/02/17.
 */
public class CalculatorModel {

    private int calculationValue;

    public void addTwoNumber(int first, int second){
        calculationValue = first + second;
    }

    public int getCalculationValue(){
        return calculationValue;
    }
}
