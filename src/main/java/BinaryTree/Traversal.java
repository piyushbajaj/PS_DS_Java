package BinaryTree;

/**
 * Created by piyush.bajaj on 25/09/16.
 */
public class Traversal {
    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();
        BT.root = new Node(1);
        System.out.println("Root of a binary tree is: " + BT.root.data);

        BT.root.left = new Node(2);

        BT.root.right = new Node(3);

        System.out.println("Root->left of a binary tree is: " + BT.root.left.data);

        System.out.println("Root->right of a binary tree is: " + BT.root.right.data);

        BT.root.left.left = new Node(4);

        BT.root.left.right = new Node(5);

        System.out.println("Root->left->left of a binary tree is: " + BT.root.left.left.data);

        System.out.println("Root->left->right of a binary tree is: " + BT.root.left.right.data);

        System.out.println("\n");

        System.out.println("Traversal in Post order is: ");

        BT.printPostorder(BT.root);

        System.out.println("\n");

        System.out.println("Traversal in Pre order is: ");

        BT.printPreOrder(BT.root);

        System.out.println("\n");

        System.out.println("Traversal in In order is: ");

        BT.printInOrder(BT.root);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

//    public void BTreeTraversal(String[] arr){
//        BinaryTree BTree = new BinaryTree();
//        BTree.root = new Node(arr[0]);
//    }

    static class BinaryTree {
        Node root;

        BinaryTree(int key) {
            root = new Node(key);
        }

        BinaryTree() {
            root = null;
        }


        void printPostorder(Node node) {
            if (node == null) {
                return;
            }

            printPostorder(node.left);

            printPostorder(node.right);

            System.out.print(node.data + " ");

        }

        void printPreOrder(Node node) {
            if (node == null) {
                return;
            }

            System.out.print(node.data + " ");

            printPreOrder(node.left);

            printPreOrder(node.right);

        }

        void printInOrder(Node node) {
            if (node == null) {
                return;
            }

            printInOrder(node.left);

            System.out.print(node.data + " ");

            printInOrder(node.right);

        }

    }

}
