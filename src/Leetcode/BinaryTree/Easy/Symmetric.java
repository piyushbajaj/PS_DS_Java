package Leetcode.BinaryTree.Easy;

/*
https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
 */
public class Symmetric {
    Node root;

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Symmetric(int data) {
        root = new Node(data);
    }

    /*
    1. Check if root is not null
    2. If key1.data is equal to key2.data
    3. Need to ensure that for every NODE left subtree is matching with right subtree
    4. Also every NODE right subtree is matching with left subtree
    TC: O(N)
    SC: O(h)
     */
    public boolean isSymmetric(Node key1, Node key2) {
        if (key1 == null && key2 == null) {
            return true;
        }

        if (key1 != null && key2 != null && (key1.data == key2.data)) {
            return isSymmetric(key1.left, key2.right) && isSymmetric(key1.right, key2.left);
        }

        return false;
    }

    public static void main(String[] args) {
        Symmetric BT = new Symmetric(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(4);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(4);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        System.out.println(BT.isSymmetric(BT.root, BT.root));
    }
}
