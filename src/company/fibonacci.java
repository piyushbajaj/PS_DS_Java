package com.company;

/**
 * Created by piyush.bajaj on 12/03/16.
 */
public class fibonacci {
    public static void main(String args[])
    {
        int temp1=0;
        int temp2=1;
        System.out.print(temp1 + " " + temp2);
        int n;
        for(n=2; n<=5; n++)
        {
            int c= temp1 + temp2;
            System.out.print(" " + c);
            temp1=temp2;
            temp2=c;
        }
    }
}
