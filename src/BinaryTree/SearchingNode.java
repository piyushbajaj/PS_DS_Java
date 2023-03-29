package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 17/12/16.
 */
public class SearchingNode {
    Node root;

    public SearchingNode() {
        root = null;
    }

    public SearchingNode(int key) {
        root = new Node(key);
    }

    public static void main(String[] args) {
        SearchingNode BT = new SearchingNode(1);
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

        System.out.println("Are you able to get this value " + 10 + " in the tree? " + BT.searchingANode(BT.root, 10));

        System.out.println("Are you able to get this value " + 5 + " in the tree using iterative approach? " +
            BT.searchingANode(BT.root, 5));

    }

    public boolean searchingANode(Node key, int data) {
        //boolean flag = false;
        if (key == null) {
            return false;
        }

        if (key.data == data) {
            return true;
        }

        return searchingANode(key.left, data) || searchingANode(key.right, data);
    }

    public boolean searchingANode_Iterative(Node key, int data) {
        if (key == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(key);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.data == data) {
                return true;
            }
            if (temp != null) {
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return false;
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
