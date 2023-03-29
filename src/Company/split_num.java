package com.company;

/**
 * Created by piyush.bajaj on 12/03/16.
 */
public class split_num {
    public static void main(String args[]) {
        int number = 123;
        int length = String.valueOf(number).length();
        System.out.println(length);
        int[] a;
        while (number > 0) {
            System.out.print(number % 10 + "\n");
            number = number / 10;

        }
        System.out.println(1 % 3);
    }
}
