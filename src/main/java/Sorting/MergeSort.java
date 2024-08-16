package Sorting;

/**
 * Created by piyush.bajaj on 06/10/16.
 * <p>
 * Few descriptions about Merge Sort are:
 * 1. Merge Sort is also an example of Divide and Conquer.
 * 2. Merging is the process of combining two sorted files to make one bigger sorted file.
 * 3. Selection is the process of dividing a file into two parts: k smallest elements and n-k largest elements.
 * a. Selection splits a list into two lists.
 * b. Merging joins two files to make one file.
 * 4. Merge Sort access the data in sequential manner.
 * 5. Merge sort is used in sorting a linked list. This is because of following reasons
 * a. In Linked list, we can insert an item in the middle in O(1) time and O(1) extra space.
 * b. In Merge Sort data access are done mostly sequentially, that's why Linked list is much preferred here.
 * <p>
 * Complexities:
 * Worst Case Time Complexity: O(n*log(n))
 * Average Case Time Complexity: O(n*log(n))
 * Best Case Time Complexity: O(n*log(n))
 * <p>
 * Space Complexity: O(n)
 * <p>
 * Algorithm:
 * 1. First create merge(int[] arr, int l , int m, int r) which does following things:
 * a. N1 = m-l+1;
 * b. N2 = r-m;
 * c. Collect all N1 elements in L[]
 * d. Collect all N2 elements in R[]
 * e. i = j = k = 0;
 * f. loop for i < N1 and j < N2, and whenever L[i] <= R[j], put it in arr[k] and vice-versa.
 * g. put all the remaining elements in arr[k].
 * 2. Second create a recursive function mergeSort(int[] arr, int l, int r), which does following things:
 * a. every time it will check l < r
 * b. mid = (l+r)/2;
 * c. call mergeSort(arr, l, mid); && call mergeSort(arr, mid+1, r);
 * d. Call merge function in the end, merge(arr, l, mid, r).
 */
public class MergeSort {

    Node head; //head of the list

    public static void MergeSortAlgo(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSortAlgo(arr, left, mid);
            MergeSortAlgo(arr, mid + 1, right);
            Merge(arr, left, mid, right);
        }
    }

    public static void Merge(int arr[], int left, int mid, int right) {
        //will create two temporary arrays, so taking out the size for them

        int N1 = mid - left + 1;
        int N2 = right - mid;

        int[] L = new int[N1];
        int[] R = new int[N2];

        for (int i = 0; i < N1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < N2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        //Now compare and push values to the original array
        int i = 0;
        int j = 0;
        int k = left;

        while (i < N1 && j < N2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                k++;
            } else {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        while (i < N1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < N2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {

        MergeSort list = new MergeSort();
        list.head = new Node(12);
        list.head.next = new Node(6);
        list.head.next.next = new Node(12);
        list.head.next.next.next = new Node(8);
        list.head.next.next.next.next = new Node(9);
        int count = list.getCount(list.head);
        Node Nd = list.head;
        Node temp = list.head;
//        int a[] = new int[count];
//
//        for(int i = 0; i < count && Nd!=null; i++){
//            a[i] = Nd.data;
//            Nd = Nd.next;
//        }

        int a[] = {8, 2, 4, 1, 3, 5, 6, 9};

        //int a[] = {5, 4, 1};
        int l = 0;
        int r = a.length - 1;
        //MergeSortAlgo(a, l, r);
        mergeSortCalc_prac(a, l, r);
        //SelectionSortAlgo_Improved(a);
        for (int i = 0; i < a.length && temp != null; i++) {
            temp.data = a[i];
            temp = temp.next;
        }
        list.printList(list.head);
    }

    //practice
    public static void mergeSortCalc_prac(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSortCalc_prac(arr, l, mid);
            mergeSortCalc_prac(arr, mid + 1, r);
            merge_prac(arr, l, mid, r);
        }
    }

    public static void merge_prac(int[] arr, int l, int mid, int r) {
        int N1 = mid - l + 1;
        int N2 = r - mid;

        int[] L = new int[N1];
        int[] R = new int[N2];

        for (int i = 0; i < N1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < N2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < N1 && j < N2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                k++;
            } else {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        while (i < N1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < N2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public static void mergeSortPrac(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSortPrac(arr, l, m);
            mergeSortPrac(arr, m + 1, r);
            mergeSortPracAlgo(arr, l, m, r);
        }
    }

    public static void mergeSortPracAlgo(int[] arr, int l, int m, int r) {

    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public int getCount(Node Nd) {
        int count = 0;
        while (Nd != null) {
            count++;
            Nd = Nd.next;
        }
        return count;
    }

    /* Linked List Node*/
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
