package BinaryTree.GeeksForGeeks;

/**
 * Created by piyush.bajaj on 05/09/17.
 *
 * Algorithm:
 * This involves a three step process:
 * 1. Print the left subtree from top to bottom
 * 2. Print only leaf nodes from left to right
 * 3. Print the right subtree from bottom to top
 *
 * Time Complexity: O(n)
 */
public class boundaryTraversal {
    Node root;

    static class Node{
        Node left, right;
        int data;
        boolean visited;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
            this.visited = false;
        }
    }

    boundaryTraversal(){
        root = null;
    }

    boundaryTraversal(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }

    public void checkBoundary(Node key){
        if(key == null)
            return;

        System.out.print(key.data + " ");

        printBoundaryLeft(key.left);

        printLeaf(key.left);

        printLeaf(key.right);

        printBoundaryRight(key.right);

    }

    public void printBoundaryLeft(Node key){
        if(key.left!=null){
            System.out.print(key.data + " ");
            printBoundaryLeft(key.left);
        }
        else if(key.right!=null){
            System.out.print(key.data + " ");
            printBoundaryLeft(key.right);

        }
    }

    public void printLeaf(Node key){
        if(key == null)
            return;

        printLeaf(key.left);
        printLeaf(key.right);

        if(key.left == null && key.right == null){
            System.out.print(key.data + " ");
        }

    }

    public void printBoundaryRight(Node key){
        if(key == null)
            return;

        if(key.right!=null){
            printBoundaryRight(key.right);
            System.out.print(key.data + " ");
        }
        else if(key.left!=null){
            printBoundaryRight(key.left);
            System.out.print(key.data + " ");
        }

    }

    public static void main(String[] args) {
//        boundaryTraversal bt = new boundaryTraversal(20);
//        bt.root.left = new Node(8);
//        bt.root.left.left = new Node(4);
//        bt.root.left.right = new Node(12);
//        bt.root.left.right.left = new Node(10);
//        bt.root.left.right.right = new Node(14);
//        bt.root.right = new Node(22);
//        bt.root.right.right = new Node(25);

        boundaryTraversal bt = new boundaryTraversal(4);
        bt.root.left = new Node(2);
        bt.root.left.left = new Node(1);
        bt.root.left.right = new Node(3);
        bt.root.right = new Node(6);
        bt.root.right.left = new Node(5);
        bt.root.right.right = new Node(7);
        bt.checkBoundary(bt.root);
    }
}
