package TechboostJune2020.Sorting;

/**
 * Created by piyush.bajaj on 02/10/16.

 Few Descriptions about Insertion Sort:
 1. It is efficient for small data.
 2. It is STABLE, means it maintains relative order of input data if the keys are same.
 3. It is in-line, it sorts the list as it receives it.

 Complexities:

 Worst Case Time Complexity: O(n*n)
 Average Case Time Complexity: O(n*n)
 Best Case Time Complexity: O(n*n)

 Space Complexity: O(1)

 Algorithm:
 1. First iterate i from 1 to n-1.
 2. Second iterate j from 0 to i-1
 3. When a[j] > a[i], then swap

 */
public class InsertionSort {
    public static void main(String[] args) {
        int a[] = {5, 4, 1, 2, 10, 3, 2};
        //InsertionSortAlgo(a);
        //SelectionSortAlgo_Improved(a);

        //insertSort_prac(a);

        insertionSrt(a);

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

    }

    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void insertionSrt(int[] arr){
        int n = arr.length;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i])
                    swap(arr, i, j);
            }
        }
    }

    //Practice
    public static void insertSort_prac(int[] arr){
        int n = arr.length-1;
        int temp =0, j=0;
        for(int i = 1; i <= n; i++ ){
            temp = arr[i];
            j = i;

            while (arr[j-1] > temp && j >= 1){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }











    public static int[] InsertionSortAlgo(int a[]){
     int i, j, v;
        for(i=2; i < a.length; i++){
            v = a[i];
            j = i;
            while (j>=1 && a[j-1] > v){
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }
        return a;
    }
}
