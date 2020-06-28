package Array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by piyush.bajaj on 29/07/17.
 */
public class WhatFix {

    public int kthFrequency(char[] arr, int k){
        int n = arr.length;
        int[] intArr = new int[26];
        ArrayList<Integer> intArr_new = new ArrayList<>();

        for(int j = 0; j < n; j++){
            char ch = arr[j];
//            intArr.add(Integer.valueOf(ch) - 97, Integer.getInteger());
//            intArr.a
            intArr[Integer.valueOf(ch) - 97]++;
        }

        for(int i = 0; i < 26; i++){
            intArr_new.add(intArr[i]);
        }

//        boolean flag = false;
////        for(int i = 0; i < 26; i++){
////            if( k == intArr[i]){
////                flag = true;
////                break;
////            }
////
////        }

        Collections.sort(intArr_new);

        //TreeS

        int foo = 0;
        k = k-1;
        int c = 0;
        for(int i = 25; i>=0; i--) {
            //if (flag) {
                if (i == 25 - k - c) {
//                    if(i!=25 && intArr_new.get(i - 1) == 0)
//                        return -1;
                    if (i == 25 || (intArr_new.get(i) != intArr_new.get(i + 1)) ) {
                        foo = intArr_new.get(i);
                        for (int m = 0; m < 26; m++) {
                            if (intArr[m] == foo)
                                return (m + 97);
                        }
                    } else c++;

                }
            }
        //}

//        for(int i = 0; i < 26; i++){
//            if(intArr[i] == k){
//                return i+97;
//            }
//        }


        return -1;
    }

    public int highestFrequency(char[] arr, int k){



        return -1;
    }

    public static void main(String[] args) {
        WhatFix WF = new WhatFix();
//        Scanner s = new Scanner(System.in);
//        //Ss =
//        String Str = s.next();
//        int k = s.nextInt();
//        char[] charArr2 = Str.toCharArray();
        //char[] charArr = {'a', 'a', 'b', 'c', 'd', 'a', 'b', 'c'};

        char[] charArr2 = {'z', 'z', 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'z', 'z'};
        //char[] charArr2 = {'a', 'b', 'c'};
        int k = 5;
        int result = WF.kthFrequency(charArr2, k);
        if(result == -1){
            System.out.println("Invalid Frequency");
        }
        else {
            char ch = (char) result;
            System.out.println(ch);
        }
    }
}
