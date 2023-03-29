package BinaryTree;

/**
 * Created by piyush.bajaj on 23/07/17.
 * Given a binary tree, write a program to print all nodes of that tree which do not have sibling nodes. For example in the following tree, nodes 6, 8, 5, 7 are such nodes because for all of these nodes parent node has only one child.
 */
public class NoSibblingNodes {
    Node root;

    NoSibblingNodes(int data) {
        if (root == null) {
            root = new Node(data);
        }
    }

    public static void main(String[] args) {
        NoSibblingNodes SN = new NoSibblingNodes(0);
        SN.root.left = new Node(1);
        SN.root.right = new Node(2);
        SN.root.left.left = new Node(3);
        SN.root.left.right = new Node(4);
        SN.root.left.left.right = new Node(6);
        SN.root.left.left.right.right = new Node(8);
        SN.root.right.left = new Node(5);
        SN.root.right.left.right = new Node(7);

        SN.printTree(SN.root);
        System.out.println();

        SN.print_Sibblings(SN.root);

    }

    //InOrderTraversal
    public void printTree(Node key) {
        if (key == null) {
            return;
        }

        printTree(key.left);
        System.out.print(key.data + " ");
        printTree(key.right);
    }

    public void print_Sibblings(Node key) {
        if (key == null) {
            return;
        }

        if (key.left != null && key.right != null) {
            print_Sibblings(key.left);
            print_Sibblings(key.right);
        } else if (key.left == null && key.right != null) {
            System.out.print(key.right.data + " ");
            print_Sibblings(key.right);
        } else if (key.right == null && key.left != null) {
            System.out.print(key.left.data + " ");
            print_Sibblings(key.left);
        }
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
