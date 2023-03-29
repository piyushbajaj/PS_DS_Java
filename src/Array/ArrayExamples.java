package Array;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 04/09/16.
 */
public class ArrayExamples {
    public static void main(String[] args) {

//        int k = Integer.valueOf('a');
//
//        Scanner sc = new Scanner(System.in);
//        String abc = sc.nextLine();
//
//        int t = 1%2;
//        int c = 2%1;
//        //Arrays.sort
//        //Math.max(1,2,3);
//        double a = (double) 1/2;
//        long a1 = 1/2;
//        float a2 = 1/2;
//
//        String str = "07:05:45PM";
//        str.concat(abc);
//
//        System.out.println(str + abc);
//
//        //str.le
//
//        int hour = Integer.valueOf(str.substring(0,2));
//
//        //double b1 = 0.5;
//
//        double result = (double) 890 / 1400;
//
//        double a3 = (double)Math.pow(100, 2);
//
//        //Arrays.s
//        //String str = " ";
//        //str.con
//
//        NumberFormat format = new DecimalFormat("#.####");
//        System.out.println(format.format(a));
//
//        double roundOff = Math.round(a * 100.00) / 100.00;
        System.out.println("enter the length of Array: ");
        Scanner n = new Scanner(System.in);
        int length = n.nextInt();
        int[] number = new int[length];
        int count = 0;

        System.out.println("Enter the number one by one: ");
        for (int i = 0; i < length; i++) {
            number[i] = n.nextInt();
        }

//        float val = 3/6;
//        DecimalFormat df=new DecimalFormat("0.00");
//        String formate = df.format(val);
//        double finalVal = (double)df.parse(formate);

        //String a = String.format(0.2f, (3/6));
        //Math.round((3/6)*1000000)/1000000;

        System.out.println("Enter the number to cross-check the sum: ");
        int z = n.nextInt();

        boolean b = checkPairSum(number, z, length);

        System.out.println("Is the sum of two numbers in array is equal to " + z + ": " + b);
    }

    public static boolean checkPairSum(int[] A, int x, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (A[i] + A[j] == x) {
                    return true;
                }
            }
        }
        return false;
    }
}
