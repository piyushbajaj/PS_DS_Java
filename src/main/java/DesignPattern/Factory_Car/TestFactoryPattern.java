package DesignPattern.Factory_Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by piyush.bajaj on 27/11/16.
 */
public class TestFactoryPattern {

    public static void main(String[] args) throws IOException {
        CarFactory CF = new CarFactory();

        System.out.println("Enter the car type: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strType = br.readLine();

        Car c = CF.getCar(strType);
        c.construct();
    }
}
