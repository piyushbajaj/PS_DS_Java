package Array;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 17/01/17.
 */
public class reverseArray {
    public int[] reverseArr(int[] arr, int s, int e){
        int n = arr.length;

        if(n==0)
            return null;
        else if(n==1)
            return arr;
        else {

            for(int i = 0; i < n/2; i++) {
                s = i;
                swap(arr, s, e);
                e--;
            }
            return arr;
        }

    }

    //much better approach

    public void reverseArray_Improved(int[] arr, int s, int e){
        //int temp;
        while (s < e){
          swap(arr, s, e);
            s++;
            e--;
        }
    }

    public void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void swap(int[] arr, int s, int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }

//    public static void main(String[] args) {
////        reverseArray RA = new reverseArray();
////        int[] arr = {10, 14, 16, 5, 7, 50};
////
////        System.out.println("Original Array: ");
////        RA.printArray(arr);
////
//////        RA.reverseArr(arr, 0, arr.length - 1);
//////        RA.printArray(arr);
////
////        RA.reverseArray_Improved(arr, 0, arr.length - 1);
////        RA.printArray(arr);
//
//
////        Scanner s = new Scanner(System.in);
////        int n = s.nextInt();
////        int[] arr = new int[n];
////        for(int i = 0; i < n; i++){
////            arr[i] = s.nextInt();
////        }
////
////        for(int i = n-1; i >= 0; i--){
////            System.out.print((int)arr[i] + ' ');
////        }
//
//
//
//
//
//    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named LinkedList.Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        String str = s.next();

        int k = s.nextInt();

        cipher(str, n, k);
    }

    public static void cipher(String str, int n, int k){
        String s = "";
        for(int i = 0; i < n; i++){
            int ascii = 0;
            int diff = 0;
            if(((int)str.charAt(i) >= 97 && (int)str.charAt(i) <= 122)){
                if((int)str.charAt(i) + k> 122){
                    diff = (int)str.charAt(i) + k - 122;
                    if(diff > 26){
                        diff = diff%26;
                    }
                    if(diff == 0)
                        ascii = 122;
                    else
                        ascii = 96 + diff;
                }
                else
                    ascii = (int)str.charAt(i) + k;
                s+= Character.toString ((char) ascii);
            }
            else if(((int)str.charAt(i) >= 65 && (int)str.charAt(i) <= 90)){
                if((int)str.charAt(i) + k> 90){
                    diff = (int)str.charAt(i) + k - 90;
                    if(diff > 26){
                        diff = diff%26;
                    }
                    if(diff == 0)
                        ascii = 90;
                    else
                        ascii = 64 + diff;
                }
                else
                    ascii = (int)str.charAt(i) + k;
                s+= Character.toString ((char) ascii);
            }
            else
                s+= str.charAt(i);
        }
        System.out.println(s);
    }
}
