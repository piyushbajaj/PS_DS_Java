package TechBoost_Old;

/**
 * Created by piyush.bajaj on 06/01/17.
 */
public class MinHeap {
    int capacity;
    int size;
    int arr[];

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    public static void main(String[] args) {
        MinHeap BT = new MinHeap(100);
        BT.insert(3);
        BT.insert(10);
        BT.insert(2);
        BT.insert(0);
        BT.insert(-10);
        BT.insert(20);
        BT.printMinHeap();

        //BT.arr = new int[]{1, 2, 3, 4, 5};

        BT.delete(3);
        BT.printMinHeap();

        System.out.println("Minimum value here is: " + BT.getMin());


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

    public int getMin() {
        if (this.size <= 0) {
            System.out.println("Heap underflow");
        }

        return arr[0];
    }

//    public void fixDownwards(int[] arr, int i){
//        while (i> 0 && arr[i] < arr[parent(i)]){
//            swap(i, parent(i), arr);
//            i = parent(i);
//        }
//    }

    public void fixDownwards(int i) {
        while (i > 0 && this.arr[i] < this.arr[parent(i)]) {
            swap(i, parent(i), arr);
            i = parent(i);
        }
    }

    public void insert(int data) {
        if (this.size >= this.capacity) {
            return;
        }

        this.arr[size++] = data;
        fixDownwards(this.size - 1);
    }

    public void printMinHeap() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void delete(int i) {
        this.arr[i] = Integer.MIN_VALUE;
        fixDownwards(i);
        extractMin();
    }

    public int extractMin() {
        if (this.size <= 0) {
            return -1;
        } else if (this.size == 1) {
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

        if (l < this.size && this.arr[l] < this.arr[large]) {
            large = l;
        }

        if (r < this.size && this.arr[r] < this.arr[large]) {
            large = r;
        }

        if (large != i) {
            swap(i, large, arr);
            heapify(large);
        }
    }
}
