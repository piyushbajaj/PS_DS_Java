package LinkedList;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 09/10/16.
 */
public class removeDuplicates {
    Node head; //head of the list

    /* Linked List LinkedList.Node*/
    static class Node
    {
        int data;
        Node next;

        //Constructor to create a new node
        //Next is by default initialized as null

        Node(int d){
            data = d;
            next = null;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    void removeDuplicates_Sorted(Node Nd){
        while (Nd!=null && Nd.next!=null){
            if(Nd.data == Nd.next.data){
                Nd.next = Nd.next.next;
            }
            else
                Nd = Nd.next;
        }
    }

    //Here the time complexity is O(n*n)
    void removeDuplicates_UnSorted(){
        Node Nd = head;
        Node temp, dup = null;
        while(Nd!=null && Nd.next!=null){
            temp = Nd;
            while (temp.next!=null){
                if(Nd.data == temp.next.data){
                    dup = temp.next;
                    temp.next = temp.next.next;
                }
                else{
                    temp = temp.next;
                }
            }
            Nd = Nd.next;
        }
    }

    void removeDuplicates_UnSorted_Hash(){
        Node Nd = head;
        if (head == null) return;

        HashMap<Integer, Boolean> hash = new HashMap<>();
        hash.put(Nd.data, true);
        while(Nd.next!=null){
            if(hash.containsKey(Nd.next.data)){
                Nd.next = Nd.next.next;
            }
            else
            {
                hash.put(Nd.next.data, true);
                Nd = Nd.next;
            }
        }
        return;


//        //LinkedList.ListNode curr = head;
//        HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
//        hash.put(Nd.data, true);
//        while (Nd.next != null) {
//            if (hash.containsKey(Nd.next.data)) {
//                Nd.next = Nd.next.next;
//            } else {
//                hash.put(Nd.next.data, true);
//                Nd = Nd.next;
//            }
//        }
//
//        return;
    }

    public void mergeSort(int[] arr, int l, int r){
        if(l<r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);

            mergeSort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }

    public void merge(int[] arr, int l, int m, int r){
        int N1 = m - l + 1;
        int N2 = r - m;

        int[] L = new int[N1];
        int[] R = new int[N2];

        for(int i = 0; i < N1; i++){
            L[i] = arr[l + i];
        }

        for(int j = 0; j < N2; j++){
            R[j] = arr[m + 1 + j];
        }

        int i =0 , j =0;
        int k = l;

        while(i < N1 && j < N2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
                k++;
            }
            else{
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        while(i<N1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j<N2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public int getCount(Node Nd){
        int count=0;
        while(Nd!=null){
            count++;
            Nd = Nd.next;
        }
        return count;
    }

    public static void main(String[] args) {
        removeDuplicates list = new removeDuplicates();
        list.head = new Node(12);
        list.head.next = new Node(12);
        list.head.next.next = new Node(12);
        list.head.next.next.next = new Node(8);
        list.head.next.next.next.next = new Node(9);
        System.out.println("Original Linked List is: ");
        list.printList(list.head);
        System.out.println("\n");
        //System.out.println("After removing duplicates from SORTED Linked List is: ");
        //list.removeDuplicates_Sorted(list.head);
        //list.printList(list.head);
        //System.out.println("\n");
        //System.out.println("After removing duplicates from UNSORTED Linked List is: ");
        //list.removeDuplicates_UnSorted();
        //list.printList(list.head);

        int count = list.getCount(list.head);
        Node Nd = list.head;
        Node temp = list.head;
        int a[] = new int[count];

        for(int i = 0; i < count && Nd!=null; i++){
            a[i] = Nd.data;
            Nd = Nd.next;
        }

        //int a[] = {5, 4, 1, 2, 10, 3, 2};

        //int a[] = {5, 4, 1};



        int l =0;
        int r = a.length -1;
        list.mergeSort(a, l, r);
        //SelectionSortAlgo_Improved(a);
        for(int i = 0; i < a.length && temp!=null; i++){
            temp.data = a[i];
            temp = temp.next;
        }

        //System.out.println("After removing duplicates from OPTIMISED UNSORTED Linked List is: ");
        // Here the complexity comes down to O(nlogn)
        list.removeDuplicates_Sorted(list.head);
        list.printList(list.head);

        System.out.println("After removing duplicates from Highly OPTIMISED UNSORTED Linked List is: ");

        list.removeDuplicates_UnSorted_Hash();
        list.printList(list.head);


    }
}
