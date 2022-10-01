package OnlineTest;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 29/03/17.
 */
public class lendingKart {

    public void mergeSortCalc(int[] arr, int l, int r){
        if(l < r){
            int mid = (l+r)/2;
            mergeSortCalc(arr, l, mid);
            mergeSortCalc(arr, mid + 1, r);
            merge_prac(arr, l, mid, r);
        }
    }

    public void merge_prac(int[] arr, int l, int mid, int r){
        int N1 = mid-l+1;
        int N2 = r - mid;

        int[] L = new int[N1];
        int[] R = new int[N2];

        for(int i = 0; i < N1; i++){
            L[i] = arr[l + i];
        }

        for(int j = 0; j < N2; j++){
            R[j] = arr[mid + 1 +j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < N1 && j < N2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
                k++;
            }
            else {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        while (i< N1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j< N2){
            arr[k] = R[j];
            j++;
            k++;
        }

    }


    public int computerMinimum(int[] arr, int n){
        mergeSortCalc(arr, 0, n-1);

        int diff = 0, min = Integer.MAX_VALUE;

        for(int i = 0; i < n-1; i++){
            diff = Math.abs(arr[i] - arr[i+1]);
            if(diff < min)
                min = diff;
        }

        return min;
    }

    public static void main(String[] args) {
        lendingKart lk = new lendingKart();
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }

        System.out.println(lk.computerMinimum(arr, n));

    }
}
