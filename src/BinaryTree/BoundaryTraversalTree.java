package BinaryTree;

import BinaryTree.Practice_2022.CommonUtils;

public class BoundaryTraversalTree extends CommonUtils {
    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    void printBoundaryLeft(Node node) {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node node) {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");

        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left);

        // Print all leaf nodes
        printLeaves(node.left);
        printLeaves(node.right);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.right);
    }

    void printLeaves(Node node) {
        if (node == null)
            return;

        printLeaves(node.left);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        BoundaryTraversalTree tree = new BoundaryTraversalTree();
//        tree.root = new Node(20);
//        tree.root.left = new Node(8);
//        tree.root.left.left = new Node(4);
//        tree.root.left.left.left = new Node(5);
//        tree.root.left.left.right = new Node(7);
//        tree.root.left.left.right.right = new Node(77);
//        tree.root.left.right = new Node(12);
//        tree.root.left.right.left = new Node(10);
//        tree.root.left.right.left.right = new Node(30);
//        tree.root.left.right.left.right.right = new Node(40);
//        tree.root.left.right.right = new Node(14);
//        tree.root.right = new Node(22);
//        tree.root.right.right = new Node(25);
//        tree.printBoundary(tree.root);

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.printBoundary(tree.root);

//        tree.insertInBT();
    }
}
