package TechboostJune2020.Sorting;

/**
 * Created by piyush.bajaj on 07/01/17.
 *
 Few notes about Heap Sort are:
 1. Heap Sort is a comparison based sorting algorithm and is the part of selection sort family.
 2. Heap Sort is an in-place sorting algorithm.
 3. Heap Sort is not a stable algorithm, because operations on the heap can change the relative order of equal items.
 4. Partitioning is much faster than maintaining the Heap, due to which QuickSort is preferred over Heap Sort.
 5. Heap Sort basically useful in those scenarios when we need to find minimum or maximum value.
 6. Heap Sort is not a cache friendly algorithm.

 Complexities:
 Worst Case time Complexity: O(n*log(n))
 Average Case time Complexity: O(n*log(n))
 Best Case time Complexity: O(n*log(n))

 Space Complexity: O(1)

 Few constraints about Heap:
 1. The value of Node must be greater than or smaller than the value of its children.
 2. If height > 0, then all leaf nodes should be at h or h-1 level.
 3. Heap should always form complete Binary Tree.
 4. One benefit with heap is that, since its forming complete Binary Tree, so there will be no wastage of space.

 Algorithm:
 1. Construct int parent(int i) function, which will give me parent index for the given child node. (return (n-1)/2).
 2. Construct left child function, which gives 2*i +1, and right child gives 2*i+2.
 3. After inserting an element in an heap, it may not satisfy the property of heap, so we heapify it using max or min heap.
 4. Let we use max heap here, so what it does for heapify(int[] arr, int i, int n)
    a. l -> left(i), r -> right(i), large -> i
    b. if( l < n && arr[l] > arr[large]), then large = l;
    c. if( r < n && arr[r] > arr[large]), then large = r;
    d. if( large != i) then swap(arr, i , large) && heapify(arr, large, n);
 5. Now lets understand how heapSort works:
    a. int n = arr.length;
    b. Start heapifying the array from i = (n-1)/2 to i = 0 in logn time.
    c. Once the array is heapified, now start putting the biggest element in the last one by one.
    d. Loop from i = n-1 to i =1 and keep swapping swap(arr, 0, i) & heapify(arr, 0, i).

 */
public class HeapSort {
    int capacity;
    int size;
    //static int arr[];

//    public HeapSortAlgo(int capacity, int[] arr){
//        this.capacity = capacity;
//        this.size = 0;
//        this.arr = new int[this.capacity];
//        this.arr = arr;
//    }

    public void swap(int i, int j, int[] arr){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int left(int i){
        return 2*i + 1;
    }

    public int right(int i){
        return 2*i + 2;
    }


    // T.C.: o(logN)
    public void heapify(int i, int n, int[] arr){


        int l = left(i);
        int r = right(i);
        int large = i;

        if(l < n && arr[l] > arr[large])
            large = l;

        if(r < n && arr[r] > arr[large])
            large = r;

        if(large!=i ){
            swap(i, large, arr);
            heapify(large,n, arr);
        }
    }

    public void sort(int[] arr){
        //this.arr = intArr;
        int n = arr.length;

        //re-arranging array
        for(int i = (n-1)/2; i >=0; i--){

            heapify(i,n, arr);
        }

        // Array is completely arranged in Max Heap Pattern with Complete Binary Tree

        //one by one extract an element from the heap

        for(int i = n-1; i >0; i--){
            //Move root to end
            swap(0, i, arr);
            heapify(0,i, arr);
        }
    }

    public void printHeap(int[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        //arr = new int[5];
        //int[] intArr= {12, 11, 13, 5, 6, 7};

        int[] intArr = {5, 2, 1, 10, 6, 4, 3};

        HeapSort BT = new HeapSort();

        BT.sort(intArr);

        BT.printHeap(intArr);
    }
}
