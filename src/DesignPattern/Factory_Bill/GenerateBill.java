package DesignPattern.Factory_Bill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by piyush.bajaj on 27/11/16.
 */
public class GenerateBill {

    public static void main(String[] args) throws IOException {

        GetPlanFactory GP = new GetPlanFactory();

        System.out.println("Enter the plan name for which the bill will be generated: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strPlan = br.readLine();

        Plan pl = GP.getPlan(strPlan);

        System.out.println("Enter the number of units for the plan: " + strPlan + " = ");

        int i = Integer.parseInt(br.readLine());


        System.out.println("Hence the total bill is: ");

        pl.getRate();

        pl.calculateBill(i);


    }
}
