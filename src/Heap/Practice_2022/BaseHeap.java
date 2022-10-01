package Heap.Practice_2022;

public class BaseHeap {
    public int[] array;
    public int count;   // Number of elements in the Heap
    public int capacity;    // Size of the Heap
    public int heap_type; // Min Heap or Max Heap

    public BaseHeap() {}

    public BaseHeap(int capacity, int heap_type) {
        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    // Building Heap from the int array
    public void buildHeap(BaseHeap heap, int[] arr) {
        int n = arr.length;
        if (heap == null) return;

        if (n > heap.capacity) {
            resizeHeap();
        }

        System.arraycopy(arr, 0, heap.array, 0, n);
        this.count = n;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            percolateDown(i);
        }
    }


    public int parent(int i) {
        if (i <= 0 || i >= this.count) {
            return -1;
        }

        return (i - 1) / 2;
    }

    public int leftChildren(int i) {
        int left = 2 * i + 1;
        if (left >= this.count) return -1;

        return left;
    }

    // Considering this is max Heap;

    public int getMaximum() {
        if (this.count <= 0) {
            return -1;
        }

        return this.array[0];
    }

    public int rightChildren(int i) {
        int right = 2 * i + 2;
        if (right >= this.count) return -1;

        return right;
    }

    /*
    When we delete the top element (in case of max heap/min heap), we have to use percolateDown() function which will
    heapify from elements from top to bottom.
    When we insert any element, it will be inserted in the last of the array, so we have to use percolateUp() function which will
    heapify elements from bottom to top.
     */

    // TC: O(logN): Because it goes till the height of the tree only
    public void percolateDown(int i) {
        int max;
        int left = leftChildren(i);
        int right = rightChildren(i);

        if (left != -1 && array[left] > array[i]) {
            max = left;
        } else {
            max = i;
        }

        if (right != -1 && array[right] > array[max]) {
            max = right;
        }

        if (max != i) {
            // swap
            int temp = array[max];
            array[max] = array[i];
            array[i] = temp;

            percolateDown(max);
        }
    }

    public void sort(int[] arr) {
        int n = arr.length;
        // Build heap
        buildHeap(new BaseHeap(n, 1), arr);

        // Now swap the elements from the array and heapify again
        for (int i = n - 1; i > 0; i--) {
            swap(i, n - 1);
            this.count--;
            percolateDown(0);
        }
    }

    public void swap(int a, int b) {
        int temp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = temp;
    }

    //TC: O(log(N))
    public int deleteMax() {
        if (this.count == 0) return -1;

        int max = array[0];

        array[0] = array[this.count - 1];
        this.count--;

        percolateDown(0);
        return max;
    }

    // always check from bottom while inserting in max heap
    public void insert(int data) {

        if (this.count == this.capacity) {
            resizeHeap();
        }

        this.count++;
        int i = this.count - 1;

        while (i > 0 && data > this.array[parent(i)]) {
            this.array[i] = this.array[parent(i)];
            i = (i - 1) / 2;
        }
        this.array[i] = data;
    }

    public void resizeHeap() {
        int[] array_old = new int[this.capacity];
        int oldCapacity = this.capacity;
        System.arraycopy(this.array, 0, array_old, 0, this.capacity);
        this.array = new int[this.capacity * 2];
        System.arraycopy(array_old, 0, this.array, 0, this.capacity);
        this.capacity = this.capacity * 2;
        System.out.println("Increasing the array size from " + oldCapacity + " to " + this.capacity);

    }

    public void printArray() {
        for (int i = 0; i < this.count; i++)
            System.out.print(this.array[i] + " ");
        System.out.println();
    }

    public void destroyHeap() {
        this.count = 0;
        this.array = null;
    }



    public static void main(String[] args) {
        BaseHeap baseHeap = new BaseHeap(5, 1);
        baseHeap.insert(10);
        baseHeap.insert(20);
        baseHeap.insert(30);
        baseHeap.insert(40);
        baseHeap.insert(50);
        baseHeap.printArray();
        baseHeap.insert(60);
        baseHeap.printArray();

        System.out.println("Maximum element deleted: " + baseHeap.deleteMax());

        System.out.println("Maximum element deleted: " + baseHeap.deleteMax());

        baseHeap.printArray();

//        baseHeap.destroyHeap();
//
//        baseHeap.printArray();

        baseHeap.sort(baseHeap.array);

        baseHeap.printArray();
    }

}
