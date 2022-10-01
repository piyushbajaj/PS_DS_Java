package BinaryTree;

/**
 * Created by piyush.bajaj on 31/12/16.
 */
public class ExactlyOneChild_Class {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public ExactlyOneChild_Class(){
        root = null;
    }

    public ExactlyOneChild_Class(int key){
        root = new Node(key);
    }

    public boolean isHavingExactlyOneChild(int[] arr){
        int nextDiff=0;
        int lastDiff=0;
        int n = arr.length-1;
        for(int i = 0; i < n; i++){
            nextDiff = arr[i] - arr[i+1];
            lastDiff = arr[i] - arr[n];
            if(nextDiff*lastDiff < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ExactlyOneChild_Class BT = new ExactlyOneChild_Class();

        int[] pre = {20, 10, 11, 13, 12};

        System.out.println("Does it has exactly one child: " + BT.isHavingExactlyOneChild(pre));

    }
}
