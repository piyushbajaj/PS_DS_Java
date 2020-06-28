package TechBoost_Old;

/**
 * Created by piyush.bajaj on 07/04/18.
 */
public class maxHeap_prob {
    int capacity;
    int size;
    int arr[];

    public maxHeap_prob(int n){
        this.capacity = n;
        this.size = 0;
        this.arr = new int[n];
    }

    public int parent(int i){
        if(i == 0) return 0;

        return (i-1)/2;
    }

    public int leftChild(int i){
        return (2*i)+1;
    }

    public int rightChild(int i){
        return (2*i)+2;
    }

    public int extractMax(){
        if(this.size == 0)
            return -1;

        if(this.size == 1){
            this.size--;
            return this.arr[0];
        }

        int temp = this.arr[0];
        this.arr[0] = this.arr[this.size-1];
        this.size--;
        heapify(0);



        return temp;
    }


    /*
     This function makes sure that all the elements in the array follow Max Heap or Min Heap from end to end.
     */
    public void heapify(int i){
        int l = leftChild(i);
        int r = rightChild(i);
        int large = i;

        if (l < this.size &&  this.arr[l] > this.arr[large])
            large = l;

        if (r < this.size &&  this.arr[r] > this.arr[large])
            large = r;

        if (large!=i){
            swap(arr, large, i);
            heapify(large);
        }
    }

    public void heapify(int i, int n){
        int l = leftChild(i);
        int r = rightChild(i);
        int large = i;

        if (l < n &&  this.arr[l] > this.arr[large])
            large = l;

        if (r < n &&  this.arr[r] > this.arr[large])
            large = r;

        if (large!=i){
            swap(arr, large, i);
            heapify(large, n);
        }
    }

    /*
    This function is being used to make sure that the item we delete or insert, and replace with maximum value is
    present in the top.
     */
    public void fix_upwards(int i){
        while ( i > 0 && this.arr[i] > this.arr[parent(i)]){
            swap(arr, i, parent(i));
            i = parent(i);
        }
    }

    public void swap(int[] arr , int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean delete(int i){
        if(this.size <= 0)
            return false;

        this.arr[i] = Integer.MAX_VALUE;
        fix_upwards(i);
        extractMax();

        return true;
    }

    public void insert(int value){
        if(this.size >= this.capacity)
            return;

        this.arr[this.size++] = value;
        fix_upwards(this.size-1);
    }

    public void printArray(){
        for(int i = 0; i < this.size; i++){
            System.out.print(this.arr[i] + " ");
        }
    }

    public void heapSort(){
        int n = this.size;

        //re-arranging array
        for(int i = (n-1)/2; i >=0; i--){
            heapify(i);
        }

        //sort the elements from the last to the front one-by-one
        for (int i = n-1; i >= 0; i--){
            swap(arr, i, 0);
            heapify(0, i);
        }
    }



    public static void main(String[] args) {
        maxHeap_prob mh = new maxHeap_prob(9);
        mh.insert(2);
        mh.insert(4);
        mh.insert(6);
        mh.insert(7);
        mh.insert(3);
        mh.insert(8);
        mh.insert(1);
        mh.insert(5);
        mh.insert(9);
        System.out.println("Original Array: ");
        mh.printArray();
        System.out.println();

        System.out.println("Extract the maximum element from the heap: " + mh.extractMax());
        System.out.println("Current Array: ");
        mh.printArray();
        System.out.println();

        System.out.println("Extract the maximum element from the heap: " + mh.extractMax());
        System.out.println("Current Array: ");
        mh.printArray();
        System.out.println();


        System.out.println("Extract the maximum element from the heap: " + mh.extractMax());
        System.out.println("Current Array: ");
        mh.printArray();
        System.out.println();


        System.out.println("Deleting element in the index 5: " + mh.delete(5) );

        System.out.println("Current Array: ");
        mh.printArray();
        System.out.println();

        mh.heapSort();
        System.out.println("After applying Heap-Sort, now Array is: ");
        mh.printArray();
        System.out.println();


    }
}
