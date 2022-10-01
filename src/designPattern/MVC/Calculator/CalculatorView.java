package designPattern.MVC.Calculator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by piyush.bajaj on 13/02/17.
 */
public class CalculatorView extends JFrame {
    private JTextField first = new JTextField(10);
    private JLabel additionLabel = new JLabel("+");
    private JTextField second = new JTextField(10);
    private JButton calculateButton = new JButton("Calculate");
    private JTextField calcSol = new JTextField(10);

    public CalculatorView(){
        JPanel calcPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        calcPanel.add(first);
        calcPanel.add(additionLabel);
        calcPanel.add(second);
        calcPanel.add(calculateButton);
        calcPanel.add(calcSol);

        this.add(calcPanel);
    }

    public int getFirstNumber(){
        return Integer.parseInt(first.getText());
    }

    public int getSecondNumber(){
        return Integer.parseInt(second.getText());
    }

    public int getCalcSolution(){
        return Integer.parseInt(calcSol.getText());
    }

    public void setCalcSoltion(int solution){
        calcSol.setText(Integer.toString(solution));
    }

    public void addCalculationListener(ActionListener listenForCalcButton){
        calculateButton.addActionListener(listenForCalcButton);
    }

    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
