package BinaryTreeExample;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 01/01/17.
 */
public class tripletInBST {
    Node root;
    Node head, tail;

    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public tripletInBST(){
        root = null;
    }

    public tripletInBST(int key){
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


    //This is done with Time Complexity: O(n), Space Complexity: O(n)
    public boolean istriplet(Node key, ArrayList<Integer> arr){
        for(int a: arr){
            int l =0;
            int r = arr.size()-1;
            while (l<r){
                if(a+arr.get(l) + arr.get(r) == 0)
                    return true;
                else if(a+arr.get(l) + arr.get(r) >0)
                    r--;
                else
                    l++;
            }

        }
        return false;
    }

    //The space complexity can be improved to O(logN) by using doubly linked list
    //Will again use InOrder Traversal



    public void convertBSTtoDLL(Node key, Node Nd1, Node Nd2){
        head = Nd1;
        tail = Nd2;

        if(key == null)
            return;

        if(key.left!=null)
            convertBSTtoDLL(key.left, head, tail);

        key.left = tail;

        if(tail!=null){
            tail.right = key;
        }
        else
            head = key;

        tail = key;

        if(key.right!=null)
            convertBSTtoDLL(key.right, head, tail);

    }


    public void printLL(Node key){
        if(key == null)
            return;
        while(key!=null){
            System.out.print(key.data + " ");
            key = key.right;
        }

    }


    public boolean istriplet_Improved(Node key){
        if(key == null)
            return false;

        head = null;
        tail = null;

        convertBSTtoDLL(key, head, tail);

        while (head.right!=tail && head.data < 0){
            if(isMatchingSum(head.right, tail, -1 * head.data))
                return true;
            else
                head = head.right;
        }

        return false;
    }

    public boolean isPairMatching_Improved(Node key, int data){
        if(key == null)
            return false;

        head = null;
        tail = null;

        convertBSTtoDLL(key, head, tail);

        while (head.right!=tail){
            if(isMatchingSum(head.right, tail, data))
                return true;
            else
                head = head.right;
        }

        return false;
    }


    // This function returns true if there is pair in DLL with sum equal to given sum.
    public boolean isMatchingSum(Node Nd1, Node Nd2, int sum){
        head = Nd1;
        tail = Nd2;

        while (head!=tail){
            int curr = head.data + tail.data;
            if(curr == sum)
                return true;
            else if(curr > sum)
                tail = tail.left;
            else
                head = head.right;
        }
        return false;
    }


    public static void main(String[] args) {
        tripletInBST BT = new tripletInBST(6);
        //BT.insert_BST(BT.root, );
        BT.insert_BST(BT.root, -13);
        BT.insert_BST(BT.root, 14);
        BT.insert_BST(BT.root, -8);
        BT.insert_BST(BT.root, 15);
        BT.insert_BST(BT.root, 13);
        BT.insert_BST(BT.root, 7);

        System.out.println(BT.inOrderTraversal(BT.root));

        System.out.println(BT.istriplet(BT.root, res));



        //System.out.println(BT.istriplet_Improved(BT.root));



        ///For checking Pairs Sum in BST
        System.out.println("Check if the sum of pair is equal to " + 28 + ": ");
        System.out.print(BT.isPairMatching_Improved(BT.root, 28));
    }
}
