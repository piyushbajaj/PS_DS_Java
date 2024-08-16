package Heap;

/**
 * Created by piyush.bajaj on 07/01/17.
 */
public class HeapSortAlgo {
    int capacity;
    int size;
    //static int arr[];

//    public HeapSort(int capacity, int[] arr){
//        this.capacity = capacity;
//        this.size = 0;
//        this.arr = new int[this.capacity];
//        this.arr = arr;
//    }

    public static void main(String[] args) {

        //arr = new int[5];
        int[] intArr = {12, 11, 13, 5, 6, 7};

        HeapSortAlgo BT = new HeapSortAlgo();

        BT.sort(intArr);

        BT.printHeap(intArr);
    }

    public void swap(int i, int j, int[] arr) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void heapify(int i, int n, int[] arr) {
        int l = left(i);
        int r = right(i);
        int large = i;

        if (l < n && arr[l] > arr[large]) {
            large = l;
        }

        if (r < n && arr[r] > arr[large]) {
            large = r;
        }

        if (large != i) {
            swap(i, large, arr);
            heapify(large, n, arr);
        }
    }

    public void sort(int[] arr) {
        //this.arr = intArr;
        int n = arr.length;

        //re-arranging array
        for (int i = (n - 1) / 2; i >= 0; i--) {

            heapify(i, n, arr);
        }

        //one by one extract an element from the heap
        for (int i = n - 1; i > 0; i--) {
            //Move root to end
            swap(0, i, arr);
            heapify(0, i, arr);
        }
    }

    public void printHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
