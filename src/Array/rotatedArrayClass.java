package Array;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 02/12/16.
 */
public class rotatedArrayClass {
    public static void rotatedArray(int arr[], int key){
        int n = arr.length;
        int pivot =0;
        for(int i =0; i < n-1; i++){
            if(arr[i] > arr[i+1]){
                pivot = i;
                break;
            }
        }

        if(pivot==0){
            System.out.println("This is not a rotated array");
            binaryLook(arr, key, 0);
            return;
        }

        int[] subArr1 = new int[pivot + 1];
        int[] subArr2 = new int[n-(pivot+1)];

        for(int i = 0; i < pivot + 1; i++){
            subArr1[i] = arr[i];
        }

        for(int i = 0; i < n-(pivot+1); i++){
            subArr2[i] = arr[pivot + 1 + i];
        }

        if(key < subArr1[0])
            binaryLook(subArr2, key, (pivot + 1));
        else
            binaryLook(subArr1, key, 0);

    }



    public static void binaryLook(int[] arr, int key, int loc){
        int mid, first, last;
        first = 0;
        last = arr.length-1;
        mid = (first + last)/2;

        while (first<=last){
            if(arr[mid] < key){
                first = mid + 1;
            }
            else if(arr[mid] == key){
                System.out.println(key + " found at location " + (mid+ 1 + loc));
                return;
            }
            else {
                last = mid-1;
            }
            mid = (first + last)/2;
        }
    }

    public void rotateArrayByKey(int[] arr, int d, int n){
        int[] subArr1 = new int[d];
        int[] subArr2 = new int[n-d];
        int N1 = subArr1.length;
        int N2 = subArr2.length;

        for(int i = 0; i < N1; i++){
            subArr1[i] = arr[i];
        }

        for(int i = 0; i < N2; i++){
            subArr2[i] = arr[i+d];
        }

        for(int i = 0; i < N2; i++){
            arr[i] = subArr2[i];
        }

        for(int i = 0; i < d; i++){
            arr[N2] = subArr1[i];
            N2++;
        }
    }


    //Rotate one by one. This consume less space.
    public void leftRotate(int[] arr, int d, int n){
        for (int i = 0; i < d; i++)
            leftRotateByOne(arr, n);
    }

    public void rightRotate(int[] arr, int d, int n){
        for (int i = 0; i < d; i++)
            rightRotateByOne(arr, n);
    }

    public void leftRotateByOne(int[] arr, int n){
        int i;
        int temp = arr[0];
        for(i = 0; i < n-1; i++){
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
    }

    public void rightRotateByOne(int[] arr, int n){
        int i;
        int temp = arr[n-1];
        for(i = n-1; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[i] = temp;
    }

    public void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        rotatedArrayClass RA = new rotatedArrayClass();

        int[] a = {3, 4, 5, 1, 2};
        int key = 1;
        rotatedArray(a, key);


        Scanner s = new Scanner(System.in);


        System.out.println("Original Array is: ");

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        RA.printArray(arr);

        System.out.println("After rotating Array is: ");
        RA.rotateArrayByKey(arr, 6, arr.length);

        RA.printArray(arr);


        System.out.println("After left rotating Array using improved method is: ");
        RA.leftRotate(arr, 2, arr.length);
        RA.printArray(arr);



        System.out.println("After right rotating Array using improved method is: ");
        RA.rightRotate(arr, 2, arr.length);
        RA.printArray(arr);


    }
}
