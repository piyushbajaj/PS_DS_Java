package Array.G4G.Rotations;

import java.util.Arrays;

public class ArrayRotation {

    /*
    TC: O(N)
    SC: O(d)
     */
    private static void rotate(int[] arr, int d, int n) {
        int[] diff = new int[d];
        int i;
        // Putting array values in new array which needs to be rotated
        for (i = 0; i < d; i++) {
            diff[i] = arr[i];
        }

        // Putting
        for (i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        for (i = 0; i < d; i++) {
            arr[(n - d) + i] = diff[i];
        }

        System.out.println(Arrays.toString(arr));
    }

    /*
    Here we will be using Juggling Algorithm to solve this question:
    1. We will have to find the GCD or HCF for d and n
    2. Then we will keep moving array blocks based on d, and gcd
    TC: O(N)
     */
    private static void leftRotate(int[] arr, int d, int n) {
        if (d <= 0) return;

        // If d is bigger than n
        d = d % n;
        int gcdVal = gcd(d, n);
        for (int p = 0; p < gcdVal; p++) {
            // store the ith value in temp variable, so it can be used later for swap
            int temp = arr[p];
            int q = p;

            while (true) {
                int r = q + d;
                if (r >= n) {
                    r = r - n;
                }
                if (r == p) break;

                arr[q] = arr[r];
                q = r;
            }
            arr[q] = temp;
        }
    }

    /*
    Reversal Algorithm:
    A -> arr[0..d-1]
    B -> arr[d..n-1]
    Reverse A to get ArB
    Reverse B to get ArBr
    Reverse all to get (ArBr) r -> BA
    TC: O(N)
    SC: O(1)
     */
    public static void leftRotateReverseArray(int[] arr, int d, int n) {
        if (d <= 0) return;

        // If d is bigger than n
        d = d % n;

        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void leftRotateOneByOne(int[] arr) {
        int n = arr.length;
        int temp = arr[n - 1];
        int i;
        for (i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        reverseArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

//        leftRotate(arr, 8, arr.length);

//        leftRotateReverseArray(arr, 2, arr.length);
        leftRotateOneByOne(arr);
        System.out.println(Arrays.toString(arr));
    }
}
