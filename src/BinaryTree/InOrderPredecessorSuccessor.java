package BinaryTree;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 26/12/16.
 */
public class InOrderPredecessorSuccessor {
    static Node root;
    static Node pred;
    static Node succ;

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public InOrderPredecessorSuccessor() {
        root = null;
    }

    public InOrderPredecessorSuccessor(int key) {
        root = new Node(key);
    }


    // This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively

    public void findPreSuc(Node key, int data) {
        if (key == null) {
            return;
        }

        if (key.data == data) {
            if (key.left != null) {
                Node temp = key.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                pred = temp;
            }
            if (key.right != null) {
                Node temp = key.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                succ = temp;
            }
            return;
        }
        if (key.data < data) {
            pred = key;
            findPreSuc(key.right, data);
        } else {
            succ = key;
            findPreSuc(key.left, data);
        }
    }

    public ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> InOrderTraversal(Node key) {
        if (key == null) {
            return res;
        } else {

            InOrderTraversal(key.left);
            res.add(key.data);
            InOrderTraversal(key.right);
        }
        return res;

    }

    public static void main(String[] args) {
        InOrderPredecessorSuccessor BT = new InOrderPredecessorSuccessor(40);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(20);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(60);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(10);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(30);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(50);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(70);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        BT.findPreSuc(BT.root, 40);

        System.out.println("Predecessor: " + pred.data);

        System.out.println("Successor: " + succ.data);


        System.out.println(BT.InOrderTraversal(BT.root));

        int index = 10;

        ArrayList<Integer> res = BT.InOrderTraversal(BT.root);


        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) == index) {
                System.out.println("InOrder Successor is: " + res.get(i + 1));
                break;
            }
        }
    }
}
