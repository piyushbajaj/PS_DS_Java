package BinaryTree.GeeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 13/09/17.
 */
public class sizeOfBT {
    Node root;

    public sizeOfBT() {
        root = null;
    }

    public sizeOfBT(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        sizeOfBT BT = new sizeOfBT(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        System.out.println(BT.size_recur(BT.root));

        System.out.println(BT.size_iterative(BT.root));

    }

    public int size_recur(Node key) {
        if (key == null) {
            return 0;
        }

        int lcount = size_recur(key.left);
        int rcount = size_recur(key.right);

        return lcount + rcount + 1;
    }

    public int size_iterative(Node key) {
        if (key == null) {
            return 0;
        }

        int count = 0;
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(key);
        count++;

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.left != null) {
                queue.add(temp.left);
                count++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                count++;
            }

        }
        return count;
    }

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
