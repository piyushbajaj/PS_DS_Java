package Leetcode.MustDoEasyQuestions;

import java.util.HashMap;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 30/12/22
 * Time: 9:38 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/roman-to-integer/?envType=list&id=o2ggyo4h">...</a>
 * <p>
 * Problem Type: HashMap, Maths
 */
public class P1_Roman_To_Integer {
    public int romanToInt(String s) {
        int n = s.length();
        int i = 0;
        int num = 0;
        while (i < n - 1) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                num += 4;
                i = i + 2;
            } else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                num += 9;
                i = i + 2;
            } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                num += 40;
                i = i + 2;
            } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                num += 90;
                i = i + 2;
            } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                num += 400;
                i = i + 2;
            } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                num += 900;
                i = i + 2;
            } else {
                if (s.charAt(i) == 'I') {
                    num += 1;
                    i++;
                } else if (s.charAt(i) == 'V') {
                    num += 5;
                    i++;
                } else if (s.charAt(i) == 'X') {
                    num += 10;
                    i++;
                } else if (s.charAt(i) == 'L') {
                    num += 50;
                    i++;
                } else if (s.charAt(i) == 'C') {
                    num += 100;
                    i++;
                } else if (s.charAt(i) == 'D') {
                    num += 500;
                    i++;
                } else if (s.charAt(i) == 'M') {
                    num += 1000;
                    i++;
                }
            }
        }

        if (i == n - 1) {
            if (s.charAt(i) == 'I') {
                num += 1;
            } else if (s.charAt(i) == 'V') {
                num += 5;
            } else if (s.charAt(i) == 'X') {
                num += 10;
            } else if (s.charAt(i) == 'L') {
                num += 50;
            } else if (s.charAt(i) == 'C') {
                num += 100;
            } else if (s.charAt(i) == 'D') {
                num += 500;
            } else if (s.charAt(i) == 'M') {
                num += 1000;
            }
        }

        return num;
    }


    public int romanToInt_better(String s) {
        int num = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        s = s.replace("IV", "IIII");
        s = s.replace("IX", "VIIII");
        s = s.replace("XL", "XXXX");
        s = s.replace("XC", "LXXXX");
        s = s.replace("CD", "CCCC");
        s = s.replace("CM", "DCCCC");

        for (int i = 0; i < s.length(); i++) {
            num += hashMap.getOrDefault(s.charAt(i), 0);
        }

        return num;
    }


    public static void main(String[] args) {
        P1_Roman_To_Integer p1_roman_to_integer = new P1_Roman_To_Integer();
        System.out.println(p1_roman_to_integer.romanToInt("MCMXCIV"));

        System.out.println(p1_roman_to_integer.romanToInt_better("MCMXCIV"));

    }
}
