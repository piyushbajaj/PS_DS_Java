package BinaryTree;

/**
 * Created by piyush.bajaj on 27/12/16.
 */
public class CovertingSortedArray {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public CovertingSortedArray(){
        root = null;
    }

    public CovertingSortedArray(int key){
        root = new Node(key);
    }


    //Here the array stores BT value in Level Order Traversal manner.
    //So for ith index left child: 2*i +1, 2*i +2...
    //Sorting means Inorder Traversal
    public void printSorted(int arr[], int start, int end){

        if(start> end)
            return;

        printSorted(arr, 2*start + 1, end);

        System.out.print(arr[start] + " ");

        printSorted(arr, 2 * start + 2, end);
    }


    public static void main(String[] args) {
        CovertingSortedArray CS = new CovertingSortedArray();

        int[] arr = {4, 2, 5, 1, 3};

        CS.printSorted(arr, 0, arr.length-1);

        System.out.println();

        int[] arr1 = {4, 5, 1, 1, 3};

        CS.printSorted(arr1, 0, arr1.length-1);
        System.out.println();

        int[] arr2 = {2, 4, 1, 3};

        CS.printSorted(arr, 0, arr2.length-1);
    }
}
