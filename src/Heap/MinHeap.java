package Heap;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 06/01/17.
 */
public class MinHeap {
    int capacity;
    int arr[];
    int size;
    Node heap[];

    public MinHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[this.capacity];
        this.size = 0;
        heap = new Node[capacity + 1];

        for (int i = 0; i < this.capacity; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
//        MinHeap BT = new MinHeap(5);
//        BT.insert(3);
//        BT.insert(10);
//        BT.insert(2);
//        BT.insert(0);
//        BT.insert(-10);
//
//
//        BT.printMinHeap();
//
//        BT.sort();
//
//        BT.printMinHeap();
//
//        System.out.println("Extract minimum value here is: " + BT.extractMin());
//
//        BT.printMinHeap();
//
//        BT.delete(3);
//        BT.printMinHeap();
//
//        System.out.println("Minimum value here is: " + BT.getMin());
//        BT.printMinHeap();
//
//        BT.decreaseKey(2, -1);
//        System.out.println("After decreasing key: ");
//        BT.printMinHeap();


        int n = 6;
        MinHeap BT = new MinHeap(n);

        Scanner s = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            BT.insert(s.nextInt());
            BT.sort();
            System.out.println("Median is: " + BT.getMedian(i));
        }

    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int getMin() {
        if (this.size <= 0) {
            System.out.println("Heap underflow");
        }

        return arr[0];
    }

    public void resizeHeap() {
        int[] array_old = this.arr;
        this.arr = new int[this.capacity * 2];
        if (this.arr == null) {
            System.out.println("Memory Error");
            return;
        }
        for (int i = 0; i < this.capacity; i++) {
            this.arr[i] = array_old[i];
        }

        this.capacity *= 2;
        array_old = null;
    }

    public void insert(int key) {
        if (this.capacity == this.size) {
            resizeHeap();
        }

        arr[this.size++] = key;
        fixUpwards(this.size - 1);
    }

    //Used for the insert function to revamp according to the increase order
    public void fixUpwards(int i) {
        while (i != 0 && this.arr[i] < this.arr[parent(i)]) {
            swap(i, parent(i), arr);
            i = parent(i);
        }
    }

    public void printMinHeap() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    //Here i is the key we are deleting
    public void delete(int i) {
        if (this.size <= 0) {
            System.out.println("Heap Underflow");
            return;
        }

        arr[i] = Integer.MIN_VALUE;
        fixUpwards(i);
        extractMin();
    }

    void decreaseKey(int i, int newKey) {
        arr[i] = newKey;
        fixUpwards(i);
    }

    //Now i want to remove the minimum value
    public int extractMin() {
        if (this.size <= 0) {
            System.out.println("Heap Underflow");
            return Integer.MAX_VALUE;
        } else if (this.size == 1) {
            this.size--;
            return arr[0];
        } else {
            int temp = this.arr[0];
            this.arr[0] = this.arr[this.size - 1];
            this.size--;
            this.capacity--;
            heapify(0);

//            int[] intArr = new int[this.size];
//
//            for(int i = 0; i < this.size; i++){
//                intArr[i] = this.arr[i];
//            }
//
//            this.arr = intArr;

            return temp; //returns min value
            //return 0;
        }
    }

    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (l < this.size && this.arr[l] < this.arr[smallest]) {
            smallest = l;
        }
        if (r < this.size && this.arr[r] < this.arr[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            swap(i, smallest, arr);
            heapify(smallest);
        }
    }

    public void heapify_max(int i, int n) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < n && this.arr[l] > this.arr[largest]) {
            largest = l;
        }
        if (r < n && this.arr[r] > this.arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(i, largest, arr);
            heapify_max(largest, n);
        }
    }

    public double getMedian(int i) {
        if ((i + 1) % 2 == 1) {
            return arr[(i + 1) / 2];
        } else if ((i + 1) % 2 == 0) {
            return (Double.valueOf(arr[(i) / 2]) + Double.valueOf(arr[(i + 1) / 2])) / 2;
        }

        return -1;
    }

    public void printHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public void sort() {
        if (this.size <= 0) {
            return;
        }

        int n = this.size;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify_max(i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(0, i, arr);
            heapify_max(0, i);
        }
    }

    //Node head;
    static class Node {
        int data;
        Node next;

        //Constructor to create a new node
        //Next is by default initialized as null

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
