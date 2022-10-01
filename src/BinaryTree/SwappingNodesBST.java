package BinaryTree;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 01/01/17.
 */
public class SwappingNodesBST {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public SwappingNodesBST(){
        root = null;
    }

    public SwappingNodesBST(int key){
        root = new Node(key);
    }

    public void insert_BST(Node key, int data){
        if(key==null)
            return;
        while (key!=null) {
            if (data < key.data) {
                if (key.left != null) {
                    key = key.left;
                }
                else {
                    key.left = new Node(data);
                    return;
                }
            }
            else {
                if (key.right != null) {
                    key = key.right;
                }
                else {
                    key.right = new Node(data);
                    return;
                }
            }
        }
    }

    public static ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> inOrderTraversal(Node key){
        if(key==null)
            return res;
        else {
            inOrderTraversal(key.left);
            res.add(key.data);
            inOrderTraversal(key.right);
        }
        return res;
    }

    //Using InOrder Traversal Technique here
    public void detectingTwoSwapNodes(Node key){
        Node first, middle, last;

        if(key == null )
            return;

        detectingTwoSwapNodes(key.left);

        if(prev!=null && prev.data > key.data){
            if(firstNode == null && secondNode == null){
                firstNode = prev;
                secondNode = key;
            }
            else
                secondNode = key;
        }
        prev = key;

        detectingTwoSwapNodes(key.right);
    }

    public void swap(Node first, Node second){
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }



    public static Node prev = null;
    public static Node firstNode = null;
    public static Node secondNode = null;

    static Node temp1 = null;
    static Node temp2 = null;
    public void restoreOrigNodes(Node key){
        if(key == null)
            return;

        restoreOrigNodes(key.left);
        restoreOrigNodes(key.right);

        if(key.left!=null && key.left.data > key.data)
            temp1 = key.left;


        if(key.right!=null && key.right.data < key.data)
            temp2 = key.right;



        if(temp1!=null && temp2!=null){
            int temp = temp1.data;
            temp1.data = temp2.data;
            temp2.data = temp;
        }

    }

    public static void main(String[] args) {
        SwappingNodesBST BT = new SwappingNodesBST(6);
        BT.insert_BST(BT.root, -13);
        BT.insert_BST(BT.root, 14);
        BT.insert_BST(BT.root, -8);
        BT.insert_BST(BT.root, 15);
        BT.insert_BST(BT.root, 13);
        BT.insert_BST(BT.root, 7);

        System.out.println(BT.inOrderTraversal(BT.root));

        System.out.println("After swapping two nodes: ");

        BT.root.left.data = 14;

        BT.root.right.data = -13;


        res.clear();

        System.out.println(BT.inOrderTraversal(BT.root));

//        BT.detectingTwoSwapNodes(BT.root);
//
//        BT.swap(firstNode, secondNode);
//
//        res.clear();

        System.out.println("After putting back the swapped nodes: ");

        //System.out.println(BT.inOrderTraversal(BT.root));

        res.clear();

        BT.restoreOrigNodes(BT.root);

        System.out.println(temp1.data + " " + temp2.data);



        System.out.println(BT.inOrderTraversal(BT.root));
    }
}
