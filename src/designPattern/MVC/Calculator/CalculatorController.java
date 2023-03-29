package designPattern.MVC.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by piyush.bajaj on 13/02/17.
 */
public class CalculatorController {
    private CalculatorView theView;
    private CalculatorModel theModel;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addCalculationListener(new CalculateListener());
    }

    public class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            int first, second = 0;

            try {
                first = theView.getFirstNumber();
                second = theView.getSecondNumber();

                theModel.addTwoNumber(first, second);

                theView.setCalcSoltion(theModel.getCalculationValue());
            } catch (NumberFormatException e) {
                theView.displayErrorMessage("You need to enter two integers");
            }
        }
    }
}
