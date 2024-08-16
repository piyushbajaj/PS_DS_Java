package Heap;

/**
 * Created by piyush.bajaj on 09/03/17.
 */
public class Prac_MaxHeap {
    int capacity = 0;
    int size = 0;
    int[] arr;

    Prac_MaxHeap(int cap) {
        this.capacity = cap;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    public static void main(String[] args) {
        int[] intArr = {12, 11, 13, 5, 6, 7};

        Prac_MaxHeap PM = new Prac_MaxHeap(5);
        PM.insert(10);
        PM.insert(50);
        PM.insert(-10);
        PM.insert(30);
        PM.insert(100);

        PM.printMaxHeap();

        //
        //System.out.println();
        System.out.println("After deleting element");
        PM.deleteMax(2);

        PM.printMaxHeap();


        System.out.println("After applying heap-sort: ");
        PM.heapSort(intArr);

        PM.printMaxHeap(intArr);

        //PM.printMaxHeap();
    }

    public int parent(int key) {
        if (key <= 0) {
            return -1;
        }
        return (key - 1) / 2;
    }

    public int left(int key) {
        return (2 * key + 1);
    }

    public int right(int key) {
        return (2 * key + 2);
    }

    public void insert(int value) {
        if (this.size >= this.capacity) {
            System.out.println("No space left in an array");
            return;
        }

        this.arr[this.size++] = value;
        fixUpwards(this.size - 1);

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void fixUpwards(int key) {
        while (key > 0 && this.arr[key] > this.arr[parent(key)]) {
            swap(arr, key, parent(key));
            key = parent(key);
        }
    }

    public void printMaxHeap() {
        int n = this.size;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printMaxHeap(int[] intArr) {
        int n = intArr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(intArr[i] + " ");
        }
        System.out.println();
    }

    public void deleteMax(int key) {
        if (this.size > this.capacity || this.size < 0) {
            System.out.println("Please re-check the size of an array");
            return;
        }

        this.arr[key - 1] = Integer.MAX_VALUE;
        fixUpwards(key - 1);
        extractMax();
    }

    public int extractMax() {
        if (this.size > this.capacity || this.size <= 0) {
            System.out.println("Please re-check the size of an array");
            return -1;
        }

        if (this.size == 1) {
            this.size--;
            return this.arr[0];
        }

        int temp = this.arr[0];
        this.arr[0] = this.arr[this.size - 1];
        this.size--;

        heapify(0);

        return temp;
    }

    public void heapify(int key) {
        int left = left(key);
        int right = right(key);
        int large = key;

        if (left < this.size && this.arr[left] > this.arr[large]) {
            large = left;
        }

        if (right < this.size && this.arr[right] > this.arr[large]) {
            large = right;
        }

        if (large != key) {
            swap(arr, large, key);
            heapify(large);
        }

    }

    public void heapify(int i, int n, int[] intArr) {
        int l = left(i);
        int r = right(i);
        int large = i;

        if (l < n && intArr[l] > intArr[large]) {
            large = l;
        }

        if (r < n && intArr[r] > intArr[large]) {
            large = r;
        }

        if (large != i) {
            swap(intArr, i, large);
            heapify(large, n, intArr);
        }
    }

    public void heapSort(int[] intArr) {
        int n = intArr.length;

        //heapifying
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(i, n, intArr);
        }

        //extract bigger element to the last
        for (int i = n - 1; i >= 0; i--) {
            swap(intArr, 0, i);
            heapify(0, i, intArr);
        }

    }
}
