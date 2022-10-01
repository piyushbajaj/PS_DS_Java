package com.company;

/**
 * Created by piyush.bajaj on 12/03/16.
 */
public class Palindrome {

    public static void main(String args[]){
        int i;
        int n=1222221;
        boolean flag = false;
        int len=(int) Math.log10(n) + 1;
        int[] a = new int[len];
        while (n > 0) {
            for(i=0;i<len;i++)
            {
                a[i] = n % 10;
                n = n / 10;
            }
        }
        for(i=0;i<=len-1;i++)
        {
            if (a[i] == a[len-1-i])
                flag = true;
            else
            {flag = false;
                break;}
        }
        if(flag==true)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}
