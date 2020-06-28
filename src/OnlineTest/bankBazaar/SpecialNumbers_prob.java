package OnlineTest.bankBazaar;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 14/01/18.
 *
 * Special Numbers
 A special number is defined as a number where, in binary notation,

 a. has only set bits (OR)

 b. all set bits that are NOT separated by unset bits are followed by unset bits (OR)

 c. the sequence formed by count of the number of set bits separated by any number of unset bits is an increasing sequence.

 2, 3, 23 and 11271 are special numbers because their binary represenation is 10, 11, 10111 and 10110000000111 respectively.
 2 is a special number because of condition (b).

 3 is a special number because of condition (a).

 23 is a special number because of condition (c). The binary representation is 10111. Count is 1 and 3.

 11271 is a special number because its binary representation is 10110000000111 because of condition (c).
 The sequence of the count of number
 of set bits separated by a unset bits is 1, 2 and 3. This is clearly an increasing sequence.

 So, given two integers n and m where n <= m, find out the number of special numbers between n and m inclusive.

 Input Format:

 The first line of input contains an integer T where T is the number of LinkedList.test cases. Then T lines follow containing
 two space separated integers n and m where n <= m.

 Output Format:

 For each LinkedList.test case, output, in different lines, a single integer P where P is the number of special numbers between the range specified.

 Constraints:

 1 <= T <= 1000

 1 <= n <= 10^6

 1 <= m <= 10^6

 n <= m


 */
public class SpecialNumbers_prob {

    public static void main(String[] args) {

        //int a = 20, b = 30;

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int i = 0; i < n; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            checkSpecialNumber(a, b);
        }

    }

    public static void checkSpecialNumber(int a, int b){

        int count = 0;
        for(int i = a; i <= b; i++){

            String s = Integer.toBinaryString(i);
            if(checkOnes(s, i))
                count++;
            else if(checkLeadingZeroes(s,i))
                count++;
            else if(checkBitSequence(s,i))
                count++;
        }
        System.out.println(count);

//        String s = Integer.toBinaryString(23);
//        if(checkBitSequence(s, 23))
//            count++;
    }

    public static boolean checkOnes(String s, int a){
        int count = 0;
        while (a > 0){
            count+= a%2;
            a = a/2;
        }
        if(count == s.length())
            return true;
        else return false;
    }

    public static boolean checkLeadingZeroes(String s, int a){
        //int count = 0;
        boolean flag = false;
        if(s.charAt(0) == '0') return false;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '0')
                flag = true;
            if(flag == true && s.charAt(i) == '1') return false;
        }
        return true;
    }

    public static boolean checkBitSequence(String s, int a){
        boolean flag = false;
        int count1 = 0, max1 = 0;
        if(s.charAt(0) == '0') return false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count1++;
                flag = true;
            }
            else if(s.charAt(i) == '0' && flag) {
                if (count1 > max1) {
                    max1 = count1;
                    count1 = 0;
                    flag = false;
                } else
                    return false;

            }
        }
        if(count1 <= max1 && flag)
            return false;
        return true;
    }

}
