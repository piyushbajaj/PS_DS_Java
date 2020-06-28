package com.company;

/**
 * Created by piyush.bajaj on 12/03/16.
 */
public class Armstrong {
    public static void main(String args[])
    {
        int number = 153;
        int c;
        c = number;
        int i;
        int sum=0;
        boolean flag = false;
        int len = (int) Math.log10(number) + 1;
        int[] a = new int[len];
        while(number>0){
            for (i=0; i< len ; i++)
            {
                a[i]=number%10;
                number=number/10;
                System.out.println(a[i]);
            }
        }
        for (i=0; i< len ; i++)
        {sum=sum + a[i] * a[i] * a[i];
        }
        if(sum == c) {
            flag = true;
        System.out.println(c + " is Armstrong Number");}
        else
            System.out.println(c + " is not Armstrong Number");
        }
    }

