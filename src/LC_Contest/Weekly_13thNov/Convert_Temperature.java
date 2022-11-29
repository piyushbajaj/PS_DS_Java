package LC_Contest.Weekly_13thNov;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: LC_Contest.Weekly_13thNov
 * <p>
 * User: piyushbajaj
 * Date: 13/11/22
 * Time: 8:15 am
 */
public class Convert_Temperature {
    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;

        double fahrenheit = Math.round((celsius * 1.80 + 32.00) * 100000) / 100000;

//        String formatted = String.format("%.5f", kelvin);
//        System.out.println(formatted);
        kelvin = Double.parseDouble(String.format("%.5f", celsius + 273.15));

        return new double[] {kelvin, fahrenheit};
    }

    public static void main(String[] args) {
        Convert_Temperature convert_temperature = new Convert_Temperature();
        System.out.println(Arrays.toString(convert_temperature.convertTemperature(36.50)));
    }
}
