package Heap;

/**
 * Created by piyush.bajaj on 06/01/17.
 */
public class MaxHeap {
    int capacity;
    int size;
    int arr[];

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

    public int getMax() {
        if (this.size <= 0)
            System.out.println("Heap underflow");

        return arr[0];
    }

    public void fixUpwards(int i) {
        while (i > 0 && this.arr[i] > this.arr[parent(i)]) {
            swap(i, parent(i), arr);
            i = parent(i);
        }
    }

    public void insert(int data) {
        if (this.size >= this.capacity)
            return;

        this.arr[size++] = data;
        fixUpwards(this.size - 1);
    }

    public void printMaxHeap() {
        for (int i = 0; i < this.size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void delete(int i) {
        this.arr[i] = Integer.MAX_VALUE;
        fixUpwards(i);
        extractMax();
    }

    public int extractMax() {
        if (this.size <= 0)
            return -1;
        else if (this.size == 1) {
            this.size--;
            return this.arr[0];
        } else {
            int temp = this.arr[0];
            this.arr[0] = this.arr[this.size - 1];
            this.size--;

            heapify(0);

            return temp;
        }
    }

    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int large = i;

        if (l < this.size && this.arr[l] > this.arr[large])
            large = l;

        if (r < this.size && this.arr[r] > this.arr[large])
            large = r;

        if (large != i) {
            swap(i, large, arr);
            heapify(large);
        }
    }

    public int getKthLargestElement(int k) {
        while (k > 1) {
            delete(0);
            k--;
        }

        return this.arr[0];
    }


    public static void main(String[] args) {
        MaxHeap BT = new MaxHeap(6);
        BT.insert(3);
        BT.insert(10);
        BT.insert(2);
        BT.insert(0);
        BT.insert(-10);
        BT.insert(20);

        BT.printMaxHeap();

        System.out.println(BT.getKthLargestElement(2));


        //BT.arr = new int[]{1, 2, 3, 4, 5};

        BT.delete(3);
        BT.printMaxHeap();

        System.out.println("Maximun value here is: " + BT.getMax());


    }
}
