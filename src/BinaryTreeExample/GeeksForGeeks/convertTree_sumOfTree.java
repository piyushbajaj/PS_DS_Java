package BinaryTreeExample.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 23/09/17.
 *
 *
 */
public class convertTree_sumOfTree {
    Node root;

    static class Node{
        Node left, right;
        int data;
        boolean isThreaded;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    convertTree_sumOfTree(){
        root = null;
    }

    convertTree_sumOfTree(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }

//    public class sum{
//        int sum = 0;
//    }

    static int sum = 0;

    /*
Convert a given tree to its Sum Tree
Given a Binary Tree where each node has positive and negative values.
Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree.
The values of leaf nodes are changed to 0.
     */

    //Time Complexity: O(n*n)
    public void convert_to_sum(Node key){
        if(key == null)
            return;

        if(key.left==null && key.right == null) {
            key.data = 0;
            return;
        }

        //sum tot = new sum();
        sum = 0;
        int lSum = getSum(key.left);

        sum = 0;
        int rSum = getSum(key.right);
        key.data = lSum + rSum;

        convert_to_sum(key.left);
        convert_to_sum(key.right);


    }

    public int getSum(Node key){
        if(key == null)
            return 0;

        sum += key.data;
        getSum(key.left);
        getSum(key.right);

        return sum;
    }


    //Time Complexity: O(n)
    public int convert_to_sum_better(Node key){
        if(key == null)
            return 0;

        //Keeping old value
        int old_val = key.data;

        //Recursively go left and right
        key.data = convert_to_sum_better(key.left) + convert_to_sum_better(key.right);

        //return old_val + current key value
        return key.data + old_val;
    }



    /*
    Change a Binary Tree so that every node stores sum of all nodes in left subtree
    Given a Binary Tree, change the value in each node to sum of all the values in the nodes in the left subtree
    including its own.
     */


    public int convert_sum(Node key){
        if(key == null)
            return 0;

        if(key.left == null && key.right == null)
            return key.data;

        int lCount = convert_sum(key.left);
        int rCount = convert_sum(key.right);


        //Add left sum to current Node
        key.data += lCount;

        //Add right sum to current Node
        return key.data + rCount;


    }

    public void inOrder(Node key){
        if(key == null)
            return;

        inOrder(key.left);
        System.out.print(key.data + " ");
        inOrder(key.right);
    }

    public static void main(String[] args) {
        convertTree_sumOfTree BT = new convertTree_sumOfTree();

        BT.root = new Node(10);
        BT.root.left = new Node(-2);
        BT.root.left.left = new Node(8);
        BT.root.left.right = new Node(-4);
        BT.root.right = new Node(6);
        BT.root.right.left = new Node(7);
        BT.root.right.right = new Node(5);

        System.out.println("Tree: ");

        BT.inOrder(BT.root);

        System.out.println();

        //BT.convert_to_sum(BT.root);



        //BT.convert_to_sum_better(BT.root);


        System.out.println("After conversion of Tree: ");

        BT.convert_sum(BT.root);

        BT.inOrder(BT.root);




    }
}
