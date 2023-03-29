package Heap;

/**
 * Created by piyush.bajaj on 03/01/17.
 */
public class MyHeap {
    public int[] array;
    public int count;       //Number of elements in Heap
    public int capacity;    //Size of the heap
    public int heap_type;   //Min Heap or Max Heap

    //Creating Heap: Time Complexity: O(1)
    public MyHeap(int capacity, int heap_type) {
        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    //Parent of a Node: Time Complexity: O(1)
    //For a node at ith location, its Parent Node will be at (i-1)/2 location

    public static void main(String[] args) {
        MyHeap BT_Max = new MyHeap(7, 1);
        MyHeap BT_Min = new MyHeap(7, 1);
        BT_Max.insert(1);
        BT_Max.insert(4);
        BT_Max.insert(2);
        BT_Max.insert(3);
        BT_Max.insert(13);
        BT_Max.insert(6);
        BT_Max.insert(17);
        BT_Max.insert(9);


        BT_Max.printArray();

        System.out.println();

        System.out.println(BT_Max.deleteMax());

        BT_Max.printArray();

    }

    //Children of a Node: Time Complexity: O(1)
    //For a node at ith location, its children are at (2*i + 1) & (2*i + 2)

    public int Parent(int i) {
        if (i <= 0 || i >= this.count) {
            return -1;
        }
        return (i - 1) / 2;
    }

    public int LeftChild(int i) {
        int left = 2 * i + 1;
        if (left >= this.count) {
            return -1;
        }
        return left;
    }

    //Maximum element in the Max heap will always be at root, it will be stored at array[0]
    //Time Complexity: O(1)

    public int RightChild(int i) {
        int right = 2 * i + 2;
        if (right >= this.count) {
            return -1;
        }
        return right;
    }

    //Heapifying the element at location i
    //Time Complexity is O(logn)

    public int GetMaximum() {
        if (this.count == 0) {
            return -1;
        }
        return this.array[0];
    }

    public void PercolateDown(int i) {
        int l, r, max, temp;
        l = LeftChild(i);
        r = RightChild(i);

        if (l != -1 && this.array[l] > this.array[i]) {
            max = l;
        } else {
            max = i;
        }

        if (r != -1 && this.array[r] > this.array[max]) {
            max = r;
        }

        //swap elements in array
        if (max != i) {
            temp = this.array[i];
            this.array[i] = this.array[max];
            this.array[max] = temp;
        }
        PercolateDown(max);
    }

    public int deleteMax() {
        if (this.count == 0) {
            return -1;
        }
        int tmp = this.array[0];
        this.array[0] = this.array[count - 1];
        this.count--;
        PercolateDown(0);
        return tmp;
    }

    //Time Complexity: O(logn)
    public void insert(int data) {
        int i;
        if (this.count == this.capacity) {
            resizeHeap();
        }
        this.count++;
        i = this.count - 1;
        while (i > 0 && data > this.array[(i - 1) / 2]) {
            this.array[i] = this.array[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        this.array[i] = data;
    }

    public void resizeHeap() {
        int[] array_old = this.array;
        this.array = new int[this.capacity * 2];
        if (this.array == null) {
            System.out.println("Memory Error");
            return;
        }
        if (this.capacity >= 0) {
            System.arraycopy(array_old, 0, this.array, 0, this.capacity);
        }

        this.capacity *= 2;
        array_old = null;
    }

    public void printArray() {
        for (int i = 0; i < this.count; i++) {
            System.out.print(this.array[i] + " ");
        }
    }

    public void DectroyHeap() {
        this.count = 0;
        this.array = null;
    }

}
